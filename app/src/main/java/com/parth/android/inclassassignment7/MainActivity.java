package com.parth.android.inclassassignment7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements MyProfileFragment.MyProfileFragmentListener,SelectAvatarFragment.SelectAvatarFragmentListener,DisplayProfileFragment.DisplayProfileFragmentListener {

    private int selectedProfile;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
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
    public void goToSelectAvatar() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new SelectAvatarFragment(), "SelectAvatarFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public int getImageId() {
        return selectedProfile;
    }

    @Override
    public void goToDisplayAvatar(User user) {
        this.user = user;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new DisplayProfileFragment(), "DisplayProfileFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToMyProfile(int id) {
        selectedProfile = id;
        Log.d("Demo","Selected id = "+selectedProfile);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MyProfileFragment(), "MyProfileFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public User getUserObject() {
        return user;
    }
}
