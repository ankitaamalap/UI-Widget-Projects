package com.example.openafragmentwithananimationcommunicatewithactivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TEXT = "text";

    // TODO: Rename and change types of parameters
    private String mText;

    private OnFragmentInteractionListener listener;
    private EditText editTextFragment;
    private Button buttonFragment;

    public BlankFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String text) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    // its required method( onAttach() & onDetach() )
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mText = getArguments().getString(TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        buttonFragment = view.findViewById(R.id.button_fragment);
        editTextFragment = view.findViewById(R.id.editText_fragment);
        editTextFragment.setText(mText);
        editTextFragment.requestFocus();

        buttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendBackText = editTextFragment.getText().toString();
                sendBack(sendBackText);
            }
        });
        return view;
    }

    public void sendBack(String sendBackText) {
        if (listener != null) {
            listener.onFragmentInteraction(sendBackText);
        }

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String sendBackText);
    }

    // its required method
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
