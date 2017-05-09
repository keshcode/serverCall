package com.skeleton.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.activity.ShowUserPosts;
import com.skeleton.constant.AppConstant;
import com.skeleton.model.UserDetail;

/**
 * Created by keshav on 9/5/17.
 */

public class UserDetailsFragment extends Fragment {
    private TextView tvId, tvName, tvUsername, tvEmail, tvStreet, tvSuite, tvCity, tvZipcode;
    private TextView tvLat, tvLng, tvPhone, tvWebsite, tvCompanyName, tvCompanyCatchPhrase, tvBs;
    private Button btnGetPost;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final Bundle mBundle = getArguments();
        final UserDetail userDetail = mBundle.getParcelable(AppConstant.KEY_OBJ);
        View view = inflater.inflate(R.layout.view_holder_user_details, container, false);
        init(view);
        Log.d("debug", String.valueOf(mBundle.getInt(AppConstant.KEY_ID)));
        tvId.setText(String.valueOf(mBundle.getInt(AppConstant.KEY_ID)));
        tvName.setText(userDetail.getName());
        tvEmail.setText(userDetail.getEmail());
        tvUsername.setText(userDetail.getUsername());
        tvStreet.setText(userDetail.getAddress().getStreet());
        tvSuite.setText(userDetail.getAddress().getSuite());
        tvCity.setText(userDetail.getAddress().getCity());
        tvZipcode.setText(userDetail.getAddress().getZipcode());
        tvLat.setText(userDetail.getAddress().getGeo().getLat());
        tvLng.setText(userDetail.getAddress().getGeo().getLng());
        tvPhone.setText(userDetail.getPhone());
        tvWebsite.setText(userDetail.getWebsite());
        tvCompanyName.setText(userDetail.getCompany().getName());
        tvCompanyCatchPhrase.setText(userDetail.getCompany().getCatchPhrase());
        tvBs.setText(userDetail.getCompany().getBs());

        btnGetPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(getContext(), ShowUserPosts.class);
                intent.putExtra(AppConstant.KEY_ID, mBundle.getInt(AppConstant.KEY_ID));
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }

    /**
     * intilize the all variables
     *
     * @param view refernce to viewd
     */
    public void init(final View view) {
        tvId = (TextView) view.findViewById(R.id.tvId);
        tvName = (TextView) view.findViewById(R.id.tvName);
        tvUsername = (TextView) view.findViewById(R.id.tvUsername);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvStreet = (TextView) view.findViewById(R.id.tvStreet);
        tvSuite = (TextView) view.findViewById(R.id.tvSuite);
        tvCity = (TextView) view.findViewById(R.id.tvCity);
        tvZipcode = (TextView) view.findViewById(R.id.tvZipcode);
        tvLat = (TextView) view.findViewById(R.id.tvLat);
        tvLng = (TextView) view.findViewById(R.id.tvLng);
        tvPhone = (TextView) view.findViewById(R.id.tvPhone);
        tvWebsite = (TextView) view.findViewById(R.id.tvWebsite);
        tvCompanyName = (TextView) view.findViewById(R.id.tvCompanyName);
        tvCompanyCatchPhrase = (TextView) view.findViewById(R.id.tvCompanyCatchPhrase);
        tvBs = (TextView) view.findViewById(R.id.tvBs);
        btnGetPost = (Button) view.findViewById(R.id.btnGetPost);

    }


}
