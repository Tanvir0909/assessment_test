package com.example.assessmenttest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assessmenttest.R;
import com.example.assessmenttest.databinding.ItemShowAllUserBinding;
import com.example.assessmenttest.model.CountryModel;
import com.example.assessmenttest.model.userList.Datum;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private List<Datum> users;
    Context context;

    public UserListAdapter(List<Datum> users, Context context) {
        this.users = users;
        this.context = context;
    }

    public void updateUserList(List<Datum> users) {
        this.users.clear();
        this.users.addAll(users);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShowAllUserBinding userListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_show_all_user, parent, false);
        return new ViewHolder(userListBinding.getRoot(), userListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum userList = users.get(position);
        holder.bind(userList);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemShowAllUserBinding userListBinding;

        public ViewHolder(@NonNull View itemView, ItemShowAllUserBinding userListBinding) {
            super(itemView);
            this.userListBinding = userListBinding;
        }

        public void bind(Datum userList) {
            userListBinding.setUser(userList);
            userListBinding.executePendingBindings();
        }
    }
}
