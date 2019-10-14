package com.example.assingment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(new HistoryAdapter(this, new DataManager(this).getHistory()));
    }
}
