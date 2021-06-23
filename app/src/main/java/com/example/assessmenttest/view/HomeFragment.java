package com.example.assessmenttest.view;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assessmenttest.R;
import com.example.assessmenttest.adapter.UserListAdapter;
import com.example.assessmenttest.databinding.FragmentHomeBinding;
import com.example.assessmenttest.viewmodel.ListViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    FragmentHomeBinding homeBinding;
    private ListViewModel viewModel;
    private UserListAdapter userListAdapter;
    RecyclerView rvUserList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);


   /*     Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView mTitle = (TextView) getActivity().findViewById(R.id.toolbar_title);
        mTitle.setText("abc");*/



        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);

        userListAdapter = new UserListAdapter(new ArrayList<>(), getContext());
        rvUserList = homeBinding.userList;

        viewModel.refresh();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvUserList.setLayoutManager(layoutManager);
        rvUserList.setAdapter(userListAdapter);

        observerViewModel();

        return homeBinding.getRoot();
    }

    private void observerViewModel() {
        viewModel.users.observe(
                getViewLifecycleOwner(),
                userList -> {
                    userListAdapter.updateUserList(userList.getData());
                });
        viewModel.usersLoadError.observe(
                getViewLifecycleOwner(), isError -> {
                    if (isError != null) {
                        if (isError)
                            homeBinding.listError.setVisibility(View.VISIBLE);
                        else
                            homeBinding.listError.setVisibility(View.GONE);
                    }

                }
        );

        viewModel.loading.observe(
                getViewLifecycleOwner(),
                isLoading -> {
                    if (isLoading != null) {
                        if (isLoading)
                            homeBinding.progressBar.setVisibility(View.VISIBLE);
                        else
                            homeBinding.progressBar.setVisibility(View.GONE);
                    }

                });

    }
}