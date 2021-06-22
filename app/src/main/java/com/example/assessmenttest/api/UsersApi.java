package com.example.assessmenttest.api;

import com.example.assessmenttest.model.userList.UserList;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsersApi {
    @GET("experts")
    Flowable<UserList> getUserList(
            @Query("page") int page
    );
}
