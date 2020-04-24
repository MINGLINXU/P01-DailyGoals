package com.myapplicationdev.android.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.prefs.PreferenceChangeEvent;

public class MainActivity extends AppCompatActivity {

    TextView tvQ1, tvQ2, tvQ3;
    EditText etRJ;

    RadioGroup rg1, rg2, rg3;
    RadioButton rb1, rb2, rb3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_ok = (Button) findViewById(R.id.buttonOk);
        tvQ1 = findViewById(R.id.TextViewQ1);
        tvQ2 = findViewById(R.id.TextViewQ2);
        tvQ3 =  findViewById(R.id.TextViewQ3);
        etRJ = findViewById(R.id.editTextRJ);

        tvQ1.setText("Read up on materials before class");
        tvQ2.setText("Arrive on time so as not to miss important part of the lesson");
        tvQ3.setText("Attempt the problem my self");


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                rg1 = findViewById(R.id.radioGroup1);
                int selectedBtn1 = rg1.getCheckedRadioButtonId();
                rb1 =  findViewById(selectedBtn1);

                rg2 =  findViewById(R.id.radioGroup2);
                int selectedBtn2 = rg2.getCheckedRadioButtonId();
                rb2 =  findViewById(selectedBtn2);

                rg3 =  findViewById(R.id.radioGroup3);
                int selectedBtn3 = rg1.getCheckedRadioButtonId();
                rb3 =  findViewById(selectedBtn3);
                String[] info = {tvQ1.getText().toString(),rb1.getText().toString(),tvQ2.getText().toString(),rb2.getText().toString(),tvQ3.getText().toString(),rb3.getText().toString(), etRJ.getText().toString()};

                Intent i = new Intent(MainActivity.this, Summary.class);

                i.putExtra("info",info);

                startActivity(i);
            }
        });

    }

    //Advanced Enhancement
    @Override
    protected void onPause() {
        super.onPause();

        String strRJ = etRJ.getText().toString();
        boolean checkedRB1 = rb1.isChecked();
        boolean checkedRB2 = rb2.isChecked();
        boolean checkedRB3 = rb3.isChecked();


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("RJ", strRJ);
        prefEdit.putBoolean("Rb1",checkedRB1);
        prefEdit.putBoolean("Rb2",checkedRB2);
        prefEdit.putBoolean("Rb3",checkedRB3);



        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this
        );

        String newRJ = prefs.getString("RJ","");
        boolean NewRb1 = prefs.getBoolean("Rb1",false);
        boolean NewRb2 = prefs.getBoolean("Rb2",false);
        boolean NewRb3 = prefs.getBoolean("Rb3",false);





        etRJ.setText(newRJ);







    }
}
