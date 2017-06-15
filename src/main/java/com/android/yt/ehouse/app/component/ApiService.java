package com.android.yt.ehouse.app.component;


import com.android.yt.ehouse.app.utils.Constants;

import java.util.HashMap;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by feng on 2016/8/19.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST(Constants.BASE_IP_POSTFIX)
    Observable<String> getData(@FieldMap HashMap<String, String> params, @Query("__CLIENT_TYPE__") String type, @Query("PHPSESSID") String session);


//    @Multipart
//    @POST(Constants.BASE_IP_POSTFIX)
//    Observable<String> uploadImages(@FieldMap HashMap<String, String> params, @Part("description") String description, @PartMap HashMap<String, RequestBody> images, @Query("__CLIENT_TYPE__") String type, @Query("PHPSESSID") String session);
//
//    @Multipart
//    @POST(Constants.BASE_IP_POSTFIX)
//    Observable<String> uploadImages(@Query("mod")String mod,@Query("act")String act,@Query("groupid")String groupid,@Query("filename")String filename,@Query("verify")String verify, @Part("description") String description, @PartMap HashMap<String, RequestBody> images, @Query("__CLIENT_TYPE__") String type, @Query("PHPSESSID") String session);

}
