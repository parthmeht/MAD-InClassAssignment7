package com.parth.android.inclassassignment7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MyProfileFragment.MyProfileFragmentListener,SelectAvatarFragment.SelectAvatarFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .add(R.id.container, new MyProfileFragment(), "MyProfileFragment")
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentInteraction() {

    }

    @Override
    public void goToSelectAvatar() {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new SelectAvatarFragment(), "SelectAvatarFragment")
                .addToBackStack(null)
                .commit();
    }
}
