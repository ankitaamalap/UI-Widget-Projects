package com.example.autocompletetextviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    /*//for first method
    //String array
    private static final String[] COUNTRIES = new String[]{
            "Afghanistan", "Albania", "Algeria", "Andorra", "Angola"
    };
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*      // for first method
        AutoCompleteTextView editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, COUNTRIES);
        editText.setAdapter(adapter);
*/

        //for second we pass countries name through string.xml file
        String[] countries = getResources().getStringArray(R.array.countries);

        AutoCompleteTextView editText = findViewById(R.id.actv);
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);

        //for custom list view
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_list_item, R.id.text_view_list_item,countries);
        editText.setAdapter(adapter);

      /*  //we can set xml setting here like below
        editText.setThreshold(1);*/


    }
}
