package com.parth.android.inclassassignment7;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;


public class MyProfileFragment extends Fragment {


    private MyProfileFragmentListener mListener;
    private Button buttonSave;
    private EditText firstName, lastName, studentId;
    private RadioGroup departmentGroup;
    private ImageView avatarImage;
    private Integer avatarImageValue;
    private User user;

    public MyProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        buttonSave = view.findViewById(R.id.buttonSave);
        firstName = view.findViewById(R.id.editTextFirstName);
        lastName = view.findViewById(R.id.editTextLastName);
        studentId = view.findViewById(R.id.editTextStudentId);
        departmentGroup = view.findViewById(R.id.radioGroupDepartment);
        avatarImage = view.findViewById(R.id.imageView);
        avatarImage.setImageResource(R.drawable.select_image);
        avatarImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToSelectAvatar();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Bitmap bmap = ((BitmapDrawable) avatarImage.getDrawable()).getBitmap();
                Drawable myDrawable = getResources().getDrawable(R.drawable.select_image);
                final Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();

                if (bmap.sameAs(myLogo)) {
                    Toast.makeText(departmentGroup.getContext(), "Select a Profile Image", Toast.LENGTH_LONG).show();
                } else if (firstName.getText().toString() == null || firstName.getText().toString().matches("")) {
                    firstName.setError("Enter the First Name");
                } else if (lastName.getText().toString() == null || lastName.getText().toString().matches("")) {
                    lastName.setError("Enter the Last Name");
                } else if (studentId.getText().toString() == null || studentId.getText().toString().matches("")) {
                    studentId.setError("Enter the Student Id");
                } else if (departmentGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(departmentGroup.getContext(), "Select a radio button", Toast.LENGTH_LONG).show();
                } else {
                    int radioButtonID = departmentGroup.getCheckedRadioButtonId();
                    RadioButton radioButton = departmentGroup.findViewById(radioButtonID);
                    Log.d("Radio", "radioButton.getText().toString()" + radioButton.getText().toString());
                    user = new User(firstName.getText().toString(), lastName.getText().toString(), Integer.parseInt(studentId.getText().toString()), avatarImageValue, radioButton.getText().toString());
                    Log.d("Demo",user.toString());
                    mListener.goToDisplayAvatar(user);
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (MyProfileFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement MyProfileFragmentListener interface");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mListener.getImageId()!=0){
            avatarImage.setImageResource(mListener.getImageId());
            avatarImageValue = mListener.getImageId();
        }
    }

    public interface MyProfileFragmentListener {
        void goToSelectAvatar();
        int getImageId();
        void goToDisplayAvatar(User user);
    }
}
