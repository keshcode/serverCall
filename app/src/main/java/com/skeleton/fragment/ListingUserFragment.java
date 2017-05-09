package com.skeleton.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.skeleton.R;
import com.skeleton.adapter.RecyclerAdaptor;
import com.skeleton.constant.AppConstant;
import com.skeleton.model.UserDetail;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;

import java.util.List;

/**
 * Created by keshav on 5/5/17.
 */

public class ListingUserFragment extends Fragment {
    private List<UserDetail> userDetail;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_listing_user, container, false);
        final FrameLayout fmDisplay = (FrameLayout) view.findViewById(R.id.fmDisplay);

        RestClient.getApiInterface().getUserDetail().enqueue(new ResponseResolver<List<UserDetail>>(getContext(), true) {
            @Override
            public void success(final List<UserDetail> userDetails) {
                userDetail = userDetails;
                RecyclerAdaptor recyclerAdaptor = new RecyclerAdaptor(AppConstant.MODE_USER, userDetails, fmDisplay, getContext());
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvCommon);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(recyclerAdaptor);

            }

            @Override
            public void failure(final APIError error) {

            }
        });
        return view;
    }


}
