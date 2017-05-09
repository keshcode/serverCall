package com.skeleton.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.skeleton.R;
import com.skeleton.fragment.ListingUserFragment;

/**
 * ShowUserDetails
 */
public class ShowUserDetails extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_details);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ListingUserFragment listingUserFragment = new ListingUserFragment();
        fragmentTransaction.replace(R.id.fmDisplay, listingUserFragment);
        fragmentTransaction.commit();
    }
}
