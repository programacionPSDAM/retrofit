package com.example.psp.userretrofit.data.remote;

import com.example.psp.userretrofit.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by psp on 18/01/18.
 */

public interface APIService {

    @POST("/users")
    Call<User> savePost(@Body User user);

    @GET("users/{email}")
    //obtenemos una lista de User, si el tamaño es cero, no existe el User
    //si recibimos un User y este no existe, dicho User sería null
    //mas díficil de manipular
    Call<List<User>> listUsers(@Path("email") String email);

}
