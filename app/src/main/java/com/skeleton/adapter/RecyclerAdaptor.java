package com.skeleton.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.activity.ShowUserDetails;
import com.skeleton.constant.AppConstant;
import com.skeleton.fragment.UserDetailsFragment;
import com.skeleton.model.UserDetail;
import com.skeleton.model.UserPosts;

import java.util.List;

/**
 * Created by keshav on 4/5/17.
 */

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.ViewHolder> {
    private int mMode, id = -1;
    private List<UserDetail> mUserDetails;
    private Bundle mBundle = new Bundle();
    private FrameLayout fmDisplay;
    private Context mContext;
    private List<UserPosts> mUserPosts;

    /**
     * @param mMode        mode of adaptor to be used
     * @param mUserDetails list of user details
     * @param fmDisplay    frame to be replaced
     * @param mContext     context to the activty
     */
    public RecyclerAdaptor(final int mMode, final List<UserDetail> mUserDetails, final FrameLayout fmDisplay,
                           final Context mContext) {
        this.mMode = mMode;
        this.mUserDetails = mUserDetails;
        this.fmDisplay = fmDisplay;
        this.mContext = mContext;
    }

    /**
     * @param mMode      mode of adaptor
     * @param mUserPosts list user details
     * @param mContext   context to the activity;
     */

    public RecyclerAdaptor(final int mMode, final List<UserPosts> mUserPosts, final Context mContext) {
        this.mMode = mMode;
        this.mUserPosts = mUserPosts;
        this.mContext = mContext;
    }

    @Override
    public RecyclerAdaptor.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        if (mMode != AppConstant.MODE_POST) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_users, parent, false);
            return new ViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdaptor.ViewHolder holder, final int position) {
        if (mMode != AppConstant.MODE_POST) {
            UserDetail mUserDetail = mUserDetails.get(position);
            holder.tvName.setText(mUserDetail.getName());
            holder.tvId.setText(String.valueOf(mUserDetail.getId()));
        } else {
            UserPosts mUserPost = mUserPosts.get(position);
            holder.tvTitle.setText(mUserPost.getTitle());
            holder.tvBody.setText(mUserPost.getBody());
            holder.tvPostId.setText(String.valueOf(mUserPost.getId()));
        }
    }

    @Override
    public int getItemCount() {
        if (mMode != AppConstant.MODE_POST) {
            return mUserDetails.size();
        }
        return mUserPosts.size();
    }

    /**
     * inner viewHolder class contians the view to be inflated
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId, tvName, tvTitle, tvBody, tvPostId;

        /**
         * @param itemView reference of the view to be inflated
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            if (mMode != AppConstant.MODE_POST) {
                tvId = (TextView) itemView.findViewById(R.id.tvId);
                tvName = (TextView) itemView.findViewById(R.id.tvName);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        id = getAdapterPosition();
                        mBundle.putInt(AppConstant.KEY_ID, id);
                        mBundle.putParcelable(AppConstant.KEY_OBJ, mUserDetails.get(id));
                        FragmentManager fragmentManager = ((ShowUserDetails) mContext).getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        final UserDetailsFragment userDetailsFragment = new UserDetailsFragment();
                        userDetailsFragment.setArguments(mBundle);
                        fragmentTransaction.replace(R.id.fmDetailsDisplay, userDetailsFragment);
                        fragmentTransaction.commit();
                        Log.d("debug", "value sent");

                    }
                });
            } else {
                tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
                tvBody = (TextView) itemView.findViewById(R.id.tvBody);
                tvPostId = (TextView) itemView.findViewById(R.id.tvPostId);
            }

        }
    }
}