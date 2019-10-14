package com.example.assingment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt1 = (EditText) findViewById(R.id.editText1);
        final EditText edt2 = (EditText) findViewById(R.id.editText2);
        final EditText edt3 = (EditText) findViewById(R.id.editText3);
        final EditText edt4 = (EditText) findViewById(R.id.editText4);
        final EditText edt5 = (EditText) findViewById(R.id.editText5);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);

        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setImageResource(R.drawable.history);

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float deposit = Float.parseFloat(edt1.getText().toString());
                Float rate = Float.parseFloat(edt2.getText().toString());
                int month = Integer.parseInt(edt3.getText().toString());

                Float sumrate = rate / 100;
                Float f = ((deposit*sumrate)/month)*month;

                edt4.setText(String.valueOf(f));
                edt5.setText(String.valueOf(f+deposit));



            }
        });
    }
}
