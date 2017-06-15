package com.android.yt.ehouse.app.presenter;


import android.content.Context;

import com.android.yt.ehouse.app.application.EHouseApplication;
import com.android.yt.ehouse.app.component.ApiService;
import com.android.yt.ehouse.app.interfaces.IPresentListener;
import com.android.yt.ehouse.app.ui.activity.BaseActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

import java.lang.ref.SoftReference;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by feng on 2016/8/1.
 */

public class BasePresenter {

    protected SoftReference<IPresentListener> iPresentListener;
    protected SoftReference<Context> mContext;
    protected SoftReference<LroidBaseFragment> baseFragment;

    @Inject
    ApiService apiService;

    public BasePresenter() {
        EHouseApplication.getAppComponent().inject(this);
    }

    protected boolean checkNullPresent() {
        return iPresentListener != null;
    }

    protected boolean checkNullContext() {
        return mContext != null;
    }

    protected boolean checkNullFragment() {
        return baseFragment != null;
    }

    public void setPresentListener(IPresentListener iPresentListener) {
        this.iPresentListener = new SoftReference<IPresentListener>(iPresentListener);
    }

    public void setContext(Context mContext) {
        this.mContext = new SoftReference<Context>(mContext);
        this.iPresentListener = new SoftReference<IPresentListener>(((BaseActivity) mContext));
    }

    public void setFragment(LroidBaseFragment baseFragment) {
        this.baseFragment = new SoftReference<LroidBaseFragment>(baseFragment);
        iPresentListener = new SoftReference<IPresentListener>(baseFragment);
        mContext = new SoftReference<Context>(baseFragment.getContext());
    }

    public Context getContext() {
        return mContext != null ? mContext.get() : null;
    }

    public LroidBaseFragment getBaseFragment() {
        return baseFragment != null ? baseFragment.get() : null;
    }

    protected IPresentListener getPresentListener() {
        return iPresentListener != null ? iPresentListener.get() : null;
    }

    @SafeVarargs
    public final <T, R> void doSomethingWithRxJavaMap(final int requestId, T... t) {
        Observable.just(t).map(new Func1<T[], R>() {
            @Override
            public R call(T[] ts) {
                return doSomething(requestId, ts);
            }
        }).subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (checkNullPresent()) {
                            iPresentListener.get().onRequestStart(requestId);
                        }
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<R>() {
                    @Override
                    public void onCompleted() {
                        if (checkNullPresent()) {
                            iPresentListener.get().onRequestEnd(requestId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (checkNullPresent()) {
                            iPresentListener.get().onRequestEnd(requestId);
                            iPresentListener.get().onRequestFail(requestId, e);
                        }
                    }

                    @Override
                    public void onNext(R r) {
                        if (checkNullPresent()) {
                            iPresentListener.get().onRequestSuccess(requestId, r);
                        }
                    }
                });
    }


    protected <T, R> R doSomething(int requestID, T[] ts) {
        return null;
    }

}
