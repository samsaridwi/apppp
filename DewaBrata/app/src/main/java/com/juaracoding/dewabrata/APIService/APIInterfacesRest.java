package com.juaracoding.dewabrata.APIService;

/**
 * Created by user on 1/10/2018.
 */




import com.juaracoding.dewabrata.model.biodata.ModelBiodata;
import com.juaracoding.dewabrata.model.post.ModelPost;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface APIInterfacesRest {

 @GET
 Call<ModelBiodata> getBiodata(@Url String url, @Query("api-key") String apikey);

 @FormUrlEncoded
 @POST("api/juara_textjalan/add")
 Call<ModelPost> setData(@Field("id") String id,
                         @Field("dari") String dari,
                         @Field("text") String text,
                         @Field("time") String time,
                         @Field("status") String status);




}

