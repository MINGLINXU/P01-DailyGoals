package com.myapplicationdev.android.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent i = getIntent();

        String[] info = i.getStringArrayExtra("info");

        TextView tvSummary = findViewById(R.id.textViewSummary);

        tvSummary.setText(info[0] + ":" + info[1] +"\n\n" + info[2] + ":" + info[3] +"\n\n" + info[4] + ":" + info[5] +"\n\n" + "Refection: " + info[6] );

        //Intermediate Enhancement
        Button btnClose = (Button) findViewById(R.id.buttonClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Summary.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



}
