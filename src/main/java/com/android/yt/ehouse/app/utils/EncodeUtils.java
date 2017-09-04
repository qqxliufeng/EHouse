package com.android.yt.ehouse.app.utils;

import android.util.Base64;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by feng on 2016/7/19.
 */

public class EncodeUtils {

    public static String getCode(Map<String, Object> data, String encodeType) {
        if (Constants.INSTANCE.apiKey == null) {
            return null;
        }
        Map<String, Object> mapCode = encodeMap(data);
        String dataJson = jsonEncode(mapCode);
        String dataCode = "";
        if (encodeType.equals("xor")) {
            try {
                byte[] apiKey = Constants.INSTANCE.apiKey.getBytes();
                byte[] dataBytes = dataJson.getBytes();
                byte[] dataJsonByte = xorEnc(dataBytes, apiKey);
                dataCode = new String(base64encode(dataJsonByte), Constants.INSTANCE.charset);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            dataCode = base64encode(dataJson);
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("dataCode", dataCode);
        params.put("verify", getVerify(dataCode));
        String result = jsonEncode(params);
        result = result.replace("\"", "$");
        return result;
    }

    public static String getCode(String data, String encodeType) {
        if (Constants.INSTANCE.apiKey == null) {
            return null;
        }
        String dataJson = base64encode(data);
        String dataCode = "";
        if (encodeType.equals("xor")) {
            try {
                byte[] apiKey = Constants.INSTANCE.apiKey.getBytes();
                byte[] dataBytes = dataJson.getBytes();
                byte[] dataJsonByte = xorEnc(dataBytes, apiKey);
                dataCode = new String(base64encode(dataJsonByte), Constants.INSTANCE.charset);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            dataCode = base64encode(dataJson);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("dataCode", dataCode);
        params.put("verify", getVerify(dataCode));
        String result = jsonEncode(params);
        result = result.replace("\"", "$");
        return result;
    }

    public static Map<String, Object> getData(String code, String encodeType) {
        if (Constants.INSTANCE.apiKey == null) {
            return null;
        }
        code = code.replace("$", "\"");
        String dataCode = "";
        String verify = "";
        if (code == null || code.equals("")) {
            return null;
        }
        Map<String, Object> params = jsonDecode(code);
        try {
            dataCode = (String) params.get("dataCode");
            verify = (String) params.get("verify");
        } catch (Exception e) {
        }
        verify = verify.toUpperCase();
        Map<String, Object> result = null;
        if (verify.equals(getVerify(dataCode))) {
            String dataJson = "";
            if (encodeType.equals("xor")) {
                try {
                    byte[] apiKey = Constants.INSTANCE.apiKey.getBytes();
                    byte[] dataCodeByte = dataCode.getBytes();
                    byte[] dataJsonByte = xorEnc(base64decode(dataCodeByte), apiKey);
                    dataJson = new String(dataJsonByte, Constants.INSTANCE.charset);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                dataJson = base64decode(dataCode);
            }
            Map<String, Object> mapCode = jsonDecode(dataJson);
            result = decodeMap(mapCode);
        }
        return result;
    }

    public static Map<String, Object> encodeMap(Map<String, Object> data) {
        Map<String, Object> result = new HashMap<>();
        if (data == null) {
            return result;
        }
        Map<String, Object> tmpMap = null;
        String tmpStr = null;
        Object tmp = null;
        try {
            Set<String> keys = data.keySet();
            Iterator<String> iter = keys.iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                tmp = data.get(key);
                if (tmp == null) {
                    result.put(key, base64encode("null"));
                } else if (tmp.getClass().getName().equals("java.util.HashMap") || tmp instanceof HashMap) {
                    tmpMap = (Map<String, Object>) tmp;
                    result.put(key, encodeMap(tmpMap));
                } else if (tmp.getClass().getName().equals("java.lang.String")) {
                    tmpStr = base64encode(tmp.toString());
                    result.put(key, tmpStr);
                } else if (tmp.getClass().getName().equals("java.lang.Integer")) {
                    tmpStr = base64encode(tmp.toString());
                    result.put(key, tmpStr);
                } else if (tmp.getClass().getName().equals("java.lang.Long")) {
                    tmpStr = base64encode(tmp.toString());
                    result.put(key, tmpStr);
                } else if (tmp.getClass().getName().equals("java.lang.Double")) {
                    tmpStr = base64encode(tmp.toString());
                    result.put(key, tmpStr);
                } else if (tmp.getClass().getName().equals(Boolean.class.getName())) {
                    if ((boolean) tmp) {
                        result.put(key, "_TRUE_");
                    } else {
                        result.put(key, "_FALSE_");
                    }
                } else {
                    throw new Exception("Can not encode: " + tmp.getClass().getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String base64encode(String str) {
        return new String(Base64.encode(str.getBytes(), Base64.DEFAULT));
    }

    public static byte[] base64encode(byte[] str) {
        return Base64.encode(str, Base64.DEFAULT);
    }

    public static byte[] base64decode(byte[] str) {
        return Base64.decode(str, Base64.DEFAULT);
    }

    public static String base64decode(String str) {
        return new String(Base64.decode(str.getBytes(), Base64.DEFAULT));
    }

    public static String jsonEncode(Map<String, Object> data) {
        JSONObject jsonObject = mapToJsonObj(data);
        String result = jsonObject.toString();
        return result;
    }

    public static JSONObject mapToJsonObj(Map<String, Object> data) {
        Set<String> keys = data.keySet();
        Iterator<String> iter = keys.iterator();
        String key = null;
        Object tmp = null;
        Map<String, Object> tmpMap = null;
        JSONObject jsonObject = new JSONObject();
        try {
            while (iter.hasNext()) {
                key = iter.next();
                tmp = data.get(key);
                if (tmp.getClass().getName().equals("java.util.HashMap")) {
                    tmpMap = (Map<String, Object>) tmp;
                    jsonObject.put(key, mapToJsonObj(tmpMap));
                } else if (tmp.getClass().getName().equals("java.lang.String")) {
                    jsonObject.put(key, tmp.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static byte[] xorEnc(byte[] str, byte[] apiKey) {
        int len = str.length;
        int keylen = apiKey.length;
        int t = 0;
        int strByte = 0;
        int apiKeyByte = 0;
        byte[] byteResult = new byte[len];
        Integer intTmp = 0;
        for (int i = 0; i < len; i++) {
            t = i % keylen;
            strByte = str[i];
            apiKeyByte = apiKey[t];
            intTmp = strByte ^ apiKeyByte;
            byteResult[i] = intTmp.byteValue();
        }
        return byteResult;
    }

    public static String getVerify(String dataCode) {
        String apiKey = Constants.INSTANCE.apiKey;
        return md5(apiKey + dataCode);
    }

    public static String md5(String str) {
        byte[] input = str.getBytes();
        return bytesToMD5(input);
    }

    public static String bytesToMD5(byte[] input) {
        String md5str = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buff = md.digest(input);
            md5str = bytesToHex(buff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];
            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }

    public static Map<String, Object> jsonDecode(String code) {
        try {
            JSONObject jsonObject = new JSONObject(code);
            Map<String, Object> result = jsonObjToMap(jsonObject);
            return result;
        } catch (JSONException e) {
            System.out.print(e.getMessage());
            //e.printStackTrace();
            return null;
        }
    }

    private static Map<String, Object> jsonObjToMap(Object data) {
        String key = null;
        Object value = null;
        JSONObject tmpJsonObj = null;
        JSONArray tempJsonArry = null;
        JSONObject dataObj = null;
        JSONArray dataArray = null;
        try {
            Map<String, Object> result = new HashMap<String, Object>();
            if (data.getClass().getName().equals("org.json.JSONObject")) {
                dataObj = (JSONObject) data;
                Iterator iter = dataObj.keys();
                while (iter.hasNext()) {
                    key = (String) iter.next();
                    value = dataObj.opt(key);
                    if (value.getClass().getName().equals("org.json.JSONObject")) {
                        tmpJsonObj = (JSONObject) value;
                        result.put(key, jsonObjToMap(tmpJsonObj));
                    } else if (value.getClass().getName().equals("org.json.JSONArray")) {
                        tempJsonArry = (JSONArray) value;
                        result.put(key, jsonObjToMap(tempJsonArry));
                    } else if (value.getClass().getName().equals("java.lang.String")) {
                        result.put(key, value);
                    } else {
                        Log.e("TAG", "name is ->  " + value.getClass().getName());
                    }
                }
            } else if (data.getClass().getName().equals("org.json.JSONArray")) {
                dataArray = (JSONArray) data;
                for (int i = 0; i < dataArray.length(); i++) {
                    value = dataArray.get(i);
                    if (value.getClass().getName().equals("org.json.JSONObject")) {
                        tmpJsonObj = (JSONObject) value;
                        result.put(i + "", jsonObjToMap(tmpJsonObj));
                    } else if (value.getClass().getName().equals("org.json.JSONArray")) {
                        tempJsonArry = (JSONArray) value;
                        result.put(i + "", jsonObjToMap(tempJsonArry));
                    } else if (value.getClass().getName().equals("java.lang.String")) {
                        result.put(i + "", value);
                    } else {
                        Log.e("TAG", "name is ->  " + value.getClass().getName());
                    }
                }
            } else {
                Log.e("Err", "name is ->  " + data.getClass().getName());
            }
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> decodeMap(Map<String, Object> code) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (code == null) {
            return result;
        }
        Map<String, Object> tmpMap = null;
        String tmpStr = null;
        Object tmp = null;
        try {
            Set<String> keys = code.keySet();
            Iterator<String> iter = keys.iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                tmp = code.get(key);
                if (tmp.getClass().getName().equals("java.util.HashMap")) {
                    tmpMap = (Map<String, Object>) tmp;
                    result.put(key, decodeMap(tmpMap));
                } else if (tmp.getClass().getName().equals("java.lang.String")) {
                    if (tmp.toString().equals("_TRUE_")){
                        result.put(key, true);
                    }else if (tmp.toString().equals("_FALSE_")){
                        result.put(key, false);
                    }else {
                        tmpStr = base64decode(tmp.toString());
                        result.put(key, tmpStr);
                    }
                } else {
                    throw new Exception("Can not decode: " + tmp.getClass().getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
