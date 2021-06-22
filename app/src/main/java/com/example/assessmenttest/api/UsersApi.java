package com.example.assessmenttest.api;

import com.example.assessmenttest.model.userList.UserList;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsersApi {
    @GET("experts")
    Single<UserList> getUserList(
          //  @Query("page") int page
    );
}
