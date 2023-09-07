package com.example.openafragmentwithananimationcommunicatewithactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    private FrameLayout frameContainer;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameContainer = findViewById(R.id.fragment_container);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                openFragment(text);
            }
        });
    }

    public void openFragment(String text) {
        //creating instance of fragment
        BlankFragment fragment = BlankFragment.newInstance(text);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);

        //when we click back button it will close activity completely but we want just fragment to be close so for that add below line (here we can pass name instead of null)
        transaction.addToBackStack(null);
        transaction.add(R.id.fragment_container, fragment, "BLANK_FRAGMENT").commit();
    }

    @Override
    public void onFragmentInteraction(String sendBackText) {
        editText.setText(sendBackText);

        //fragment will automatically get close coz of below line
        onBackPressed();
    }
}
