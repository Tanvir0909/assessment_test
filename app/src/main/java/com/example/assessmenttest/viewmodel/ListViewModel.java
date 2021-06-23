package com.example.assessmenttest.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.assessmenttest.api.NetworkService;
import com.example.assessmenttest.model.CountryModel;
import com.example.assessmenttest.model.userList.UserList;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class ListViewModel extends ViewModel {


    /**
     * only exposes immutable UserList LiveData objects to observe users
     */
    public MutableLiveData<UserList> users = new MutableLiveData<UserList>();

    /**
     * only exposes immutable Boolen LiveData objects to observe usersLoadError
     */
    public MutableLiveData<Boolean> usersLoadError = new MutableLiveData<Boolean>();

    /**
     * only exposes immutable Boolen LiveData objects to observe loading
     */
    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();

    /**
     * Call network service
     */
    private NetworkService networkService = NetworkService.getInstance();

    private CompositeDisposable disposable = new CompositeDisposable();


    /**
     * Use this method to fetch data from API
     *
     * @param pageNumber Parameter 1.
     */

    public void refresh(int pageNumber) {
        fatchUsers(pageNumber);
    }

    private void fatchUsers(int pageNumber) {
        loading.setValue(true);
        disposable.add(
                networkService.getUserList(pageNumber)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<UserList>() {
                            @Override
                            public void onSuccess(@NonNull UserList userList) {
                                users.setValue(userList);
                                usersLoadError.setValue(false);
                                loading.setValue(false);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                usersLoadError.setValue(true);
                                loading.setValue(false);
                            }
                        })

        );
    }


    /**
     * Using clear CompositeDisposable, but can accept new disposable
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
