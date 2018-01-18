package com.example.psp.userretrofit.data.remote;

/**
 * Created by psp on 18/01/18.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://192.168.16.124:3000/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
