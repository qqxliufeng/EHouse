package com.android.yt.ehouse.app.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;


/**
 * Created by degsin on 2016/6/27.
 */
public class MethodUtils {

    public static ApiParams getEncodeRequestParams(Map<String,Object> unCodeParam){
        ApiParams params = new ApiParams();
        params.with("data", URLEncoder.encode(EncodeUtils.getCode(unCodeParam, Constants.encodeType)));
        return params;
    }

    public static String getCodeRequestParams(Map<String,Object> unCodeParam){
        return EncodeUtils.getCode(unCodeParam, Constants.encodeType);
    }

    public static String getCodeRequestParams(String content){
        return EncodeUtils.getCode(content, Constants.encodeType);
    }

    /**
     * 解析PHP消息
     * @param content
     * @return
     * @throws Exception
     */
    public static Map<String,Object> getDataContent(String content) throws Exception{
        Map<String, Object> result = EncodeUtils.getData(content, Constants.encodeType);
        return (Map<String, Object>) result.get("__data");
    }


    public static Map<String,Object> getContent(String content) throws Exception{
        return EncodeUtils.getData(content, Constants.encodeType);
    }

    public static Map<String,Object> getListContent(String content) throws Exception{
        Map<String,Object> dataMap = getDataContent(content);
        Map<String,Object> listMap = (Map<String, Object>) dataMap.get("list");
        return listMap;
    }

    public static <T> T jsonToBean(String json,Class<T> clazz){
        return new Gson().fromJson(json,clazz);
    }


    public static String hashKeyForDisk(String key) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(key.getBytes());
            cacheKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(key.hashCode());
        }
        return cacheKey;
    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    public static void openAPPSystemSetting(Context context){
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivity(intent);
    }

    public static int[] bubbleSort(int[] a) {
        if (a!=null) {
            int n = a.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (a[j] > a[j + 1]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }
                }
            }
            return a;
        }
        return null;
    }

    public static int[] stringArrayToIntArray(String[] array){
        if (array!=null && array.length>0) {
            int[] intArray = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                intArray[i] = (Integer.parseInt(array[i]));
            }
            return intArray;
        }
        return null;
    }

    public static int[] sortKeys(Set<String> keys){
        if (keys!=null){
            String[] arrayKeys = new String[keys.size()];
            return bubbleSort(stringArrayToIntArray(keys.toArray(arrayKeys)));
        }
        return null;
    }

    public static String parseDate(long date,String format){
        if (TextUtils.isEmpty(format)){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.CHINA);
        return dateFormat.format(new Date(date));
    }


//    public static boolean isNet(Context context){
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        return networkInfo!=null && networkInfo.isAvailable() &&  networkInfo.isConnected();
//    }


}
