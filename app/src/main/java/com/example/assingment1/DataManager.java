package com.example.assingment1;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class DataManager {

    private static final String PREFS_NAME = "MyPrefsFile";
    private SharedPreferences sharedPreferences;

    DataManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
    }

    public void save(Deposit deposit) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        ArrayList<Deposit> historyArrayList = getHistory();
        historyArrayList.add(deposit);
        String history = new Gson().toJson(historyArrayList);
        editor.putString("history", history);
        editor.apply();
    }

    public ArrayList<Deposit> getHistory() {
        String historyString = this.sharedPreferences.getString("history", "");
        return new Gson().fromJson(historyString, new TypeToken<ArrayList<Deposit>>() {
        }.getType());
    }
}
