package com.example.assingment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText edt1;
    private EditText edt2;
    private EditText edt3;
    private EditText edt4;
    private EditText edt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        if (isNight()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setImageResource(R.drawable.history);

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    calculate();
                }
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HistoryActivity.class));
            }
        });
    }

    private void setView() {
        edt1 = (EditText) findViewById(R.id.editText1);
        edt2 = (EditText) findViewById(R.id.editText2);
        edt3 = (EditText) findViewById(R.id.editText3);
        edt4 = (EditText) findViewById(R.id.editText4);
        edt5 = (EditText) findViewById(R.id.editText5);
    }

    private void calculate() {
        Float deposit = Float.parseFloat(edt1.getText().toString());
        float rate = Float.parseFloat(edt2.getText().toString());
        int month = Integer.parseInt(edt3.getText().toString());

        Float sumrate = rate / 100;
        Float f = ((deposit * sumrate) / month) * month;

        edt4.setText(String.valueOf(f));
        edt5.setText(String.valueOf(f + deposit));

        Deposit depositData = new Deposit();
        depositData.setDeposit(deposit);
        depositData.setRate(rate);
        depositData.setMonth(month);
        depositData.setSumRate(sumrate);
        new DataManager(this).save(depositData);
    }

    private Boolean isNight() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        return hour < 6 || hour > 18;
    }

    private Boolean validate() {
        boolean isValid = true;
        if (edt1.getText().toString().isEmpty()) {
            edt1.setError(getString(R.string.error_input) + getString(R.string.txt1));
            isValid = false;
        }

        if (edt2.getText().toString().isEmpty()) {
            edt2.setError(getString(R.string.error_input) + getString(R.string.txt2));
            isValid = false;
        }

        if (edt3.getText().toString().isEmpty()) {
            edt3.setError(getString(R.string.error_input) + getString(R.string.txt3));
            isValid = false;
        }

        return isValid;
    }

}
