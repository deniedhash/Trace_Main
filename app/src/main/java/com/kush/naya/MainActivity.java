package com.kush.naya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public  static  final String EXTRA_TEXT = "com.kush.naya.EXTRA_TEXT";

    public TextView textview;
    public Button searchButton;
    public TextView errortext;


    public void btnClick1(View view) {

        EditText searchText1 = (EditText) findViewById(R.id.searchText1);
        String searchTextData1 = searchText1.getText().toString();
        if (searchTextData1.length() <= 0) {
            Toast.makeText(MainActivity.this, "Please add something to search.", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Searching.....", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra(EXTRA_TEXT, searchTextData1);
            startActivity(intent);
        }
    }

    public Spinner spinnerCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView) findViewById(R.id.searchText1);
        searchButton = (Button) findViewById(R.id.btnSearch1);

//        View.OnClickListener sear = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String search = textview.getText().toString();
//                new Main2Activity(search);
//
//            }
//        };
//        searchButton.setOnClickListener(sear);

        final String[]arrayCat=getResources().getStringArray(R.array.Categories);
        spinnerCat=findViewById(R.id.spinnerCat);
        spinnerCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+arrayCat[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
