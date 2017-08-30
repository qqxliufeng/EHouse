package com.android.yt.ehouse.app.presenter;

import android.text.TextUtils;

import com.android.yt.ehouse.app.data.bean.KtUserInfo;
import com.android.yt.ehouse.app.utils.MethodUtils;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by feng on 2016/10/13.
 */

public class GetDataFromNetPresenter extends BasePresenter {

    private static final String HEADER = "__header";
    private static final String DATA = "__data";

    protected Observable<String> observable;

    public void getData(final int requestId, HashMap<String, Object> params) {
        if (params == null) {
            throw new NullPointerException("params must not be null");
        }
        observable = apiService.getData(MethodUtils.getEncodeRequestParams(params), "android", KtUserInfo.INSTANCE.getSession_id());
        observable.map(new Func1<String, Map<String, Object>>() {
            @Override
            public Map<String, Object> call(String s) {
                try {
                    return MethodUtils.getContent(s);
                } catch (Exception e) {
                    return null;
                }
            }
        }).map(new Func1<Map<String,Object>, Map<String,Object>>() {

            @Override
            public Map<String, Object> call(Map<String, Object> stringObjectMap) {
                HashMap<String,Object> _header = (HashMap<String, Object>) stringObjectMap.get(HEADER);
                if (_header!=null && !_header.isEmpty()){
                    HashMap<String,Object> firstMap = (HashMap<String, Object>) _header.get("0");
                    if (firstMap!=null && !firstMap.isEmpty()){
                        String name = (String) firstMap.get("name");
                        if ("_Exception_".equals(name)){
                            HashMap<String,Object> dataMap = (HashMap<String, Object>) stringObjectMap.get(DATA);
                            String errorMsg = (String) dataMap.get("msg");
                            if (TextUtils.isEmpty(errorMsg)){
                                errorMsg = "暂无数据";
                            }
                            throw new IllegalStateException(errorMsg);
                        }else {
                            return (Map<String, Object>) stringObjectMap.get(DATA);
                        }
                    }else {
                        return (Map<String, Object>) stringObjectMap.get(DATA);
                    }
                }else {
                    return (Map<String, Object>) stringObjectMap.get(DATA);
                }
            }
        }).subscribeOn(Schedulers.io()).doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (checkNullPresent()) {
                            getPresentListener().onRequestStart(requestId);
                        }
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Map<String, Object>>() {
            @Override
            public void onCompleted() {
                if (checkNullPresent()) {
                    getPresentListener().onRequestEnd(requestId);
                }
            }

            @Override
            public void onError(Throwable e) {
                if (checkNullPresent()) {
                    getPresentListener().onRequestEnd(requestId);
                    getPresentListener().onRequestFail(requestId, e);
                }
            }

            @Override
            public void onNext(Map<String, Object> s) {
                if (checkNullPresent()) {
                    getPresentListener().onRequestEnd(requestId);
                    getPresentListener().onRequestSuccess(requestId, s);
                }
            }
        });
    }

    public void unSubscribeOn() {
        if (observable != null) {
            observable.unsubscribeOn(Schedulers.io());
        }
    }
}
