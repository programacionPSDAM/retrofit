package com.example.psp.userretrofit.data.remote;

import com.example.psp.userretrofit.data.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by psp on 18/01/18.
 */

public interface APIService {
    @POST("/users")
    Call<User> savePost(@Body User user);
}
