package com.parth.android.inclassassignment7;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SelectAvatarFragment extends android.app.Fragment {

    private SelectAvatarFragmentListener mListener;

    public SelectAvatarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_avatar, container, false);
    }


    public interface SelectAvatarFragmentListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }
}
