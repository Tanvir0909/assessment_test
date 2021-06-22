package com.example.assessmenttest.api;

import com.example.assessmenttest.model.userList.UserList;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static final String BASE_URL = "https://talenttorrent.com/api/v1/";

    private static NetworkService instance;

    private UsersApi api = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(UsersApi.class);


    private NetworkService() {
    }

    public static NetworkService getInstance() {
        if (instance == null) {
            instance = new NetworkService();
        }
        return instance;
    }

    public Single<UserList> getUserList(){
        return api.getUserList();
    }
}
