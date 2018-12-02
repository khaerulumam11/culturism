package com.example.khaerulumam.culturism.interfaces;

import com.example.khaerulumam.culturism.config.Config;
import com.example.khaerulumam.culturism.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterfaces {
    @FormUrlEncoded
    @POST(Config.API_LOGIN)
    Call<User> login(
            @Field("email") String email,
            @Field("pass") String password);
}
