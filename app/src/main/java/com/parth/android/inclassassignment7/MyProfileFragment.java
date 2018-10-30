package com.parth.android.inclassassignment7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyProfileFragment extends android.app.Fragment {


    private MyProfileFragmentListener mListener;

    public MyProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_profile, container, false);
        view.findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToSelectAvatar();
            }
        });
        return view;
    }


    public interface MyProfileFragmentListener {
        void onFragmentInteraction();
        void goToSelectAvatar();
    }
}
