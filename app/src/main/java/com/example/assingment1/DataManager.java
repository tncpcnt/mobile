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

    public DataManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
    }

    // Ref: https://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
    public void save(Deposit deposit) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        ArrayList<Deposit> historyArrayList = getHistory();
        historyArrayList.add(deposit);
        String history = new Gson().toJson(historyArrayList);
        editor.putString("history", history);
        editor.apply();
    }

    //Ref : https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
    public ArrayList<Deposit> getHistory() {
        String historyString = this.sharedPreferences.getString("history", "");
        if (historyString == null || historyString.equalsIgnoreCase("")) {
            return new ArrayList<>();
        }
        return new Gson().fromJson(historyString, new TypeToken<ArrayList<Deposit>>() {
        }.getType());
    }
}
