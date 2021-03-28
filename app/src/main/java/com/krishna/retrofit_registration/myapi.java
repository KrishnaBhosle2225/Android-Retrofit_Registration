package com.krishna.retrofit_registration;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface myapi {

    @FormUrlEncoded
    @POST("Retrofit_Registration.php")
    Call<Model> addData(@Field("firstname") String firstname,@Field("lastname") String lastname,@Field("address") String address,@Field("mobile") String mobile, @Field("email") String email,@Field("password") String password);
}
