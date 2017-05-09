package com.skeleton.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.skeleton.R;
import com.skeleton.adapter.RecyclerAdaptor;
import com.skeleton.constant.AppConstant;
import com.skeleton.model.UserPosts;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;

import java.util.List;

/**
 * shows users details
 */
public class ShowUserPosts extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_posts);
        int userId = getIntent().getIntExtra(AppConstant.KEY_ID, 0);
        RestClient.getApiInterface().getUserPosts(userId).enqueue(new ResponseResolver<List<UserPosts>>(this, true) {
            @Override
            public void success(final List<UserPosts> mPostsList) {
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvCommon);
                RecyclerAdaptor recyclerAdaptor = new RecyclerAdaptor(AppConstant.MODE_POST, mPostsList, ShowUserPosts.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(ShowUserPosts.this));
                recyclerView.setAdapter(recyclerAdaptor);
            }

            @Override
            public void failure(final APIError error) {

            }
        });
    }
}
