package com.example.customautocompleteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CountryItem> countryItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillCountryList();

        AutoCompleteTextView editText = findViewById(R.id.actv);
        AutoCompleteCountryAdapter adapter = new AutoCompleteCountryAdapter(this, countryItemList);
        editText.setAdapter(adapter);
    }

    private void fillCountryList() {
        countryItemList = new ArrayList<>();
        countryItemList.add(new CountryItem("Afghanistan", R.drawable.ic_launcher_background));
        countryItemList.add(new CountryItem("Albania", R.drawable.ic_launcher_background));
        countryItemList.add(new CountryItem("Andorra", R.drawable.ic_launcher_background));
        countryItemList.add(new CountryItem("Algeria", R.drawable.ic_launcher_background));
        countryItemList.add(new CountryItem("Angola", R.drawable.ic_launcher_background));
        countryItemList.add(new CountryItem("Abc", R.drawable.ic_launcher_background));


    }
}
