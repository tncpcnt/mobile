package com.example.assingment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Deposit> depositArrayList;

    public HistoryAdapter(Context context, ArrayList<Deposit> depositArrayList) {
        this.context = context;
        this.depositArrayList = depositArrayList;
    }

    public int getCount() {
        return depositArrayList.size();
    }

    public Deposit getItem(int position) {
        return depositArrayList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            view = mInflater.inflate(R.layout.list_history, parent, false);

        TextView edt1 = (TextView) view.findViewById(R.id.textView4);
        edt1.setText(String.valueOf(depositArrayList.get(position).getDeposit()));

        TextView edt2 = (TextView) view.findViewById(R.id.textView5);
        edt2.setText(String.valueOf(depositArrayList.get(position).getRate()));

        TextView edt3 = (TextView) view.findViewById(R.id.textView6);
        edt3.setText(String.valueOf(depositArrayList.get(position).getMonth()));

        TextView edt4 = (TextView) view.findViewById(R.id.textView7);
        edt4.setText(String.valueOf(depositArrayList.get(position).getSumRate()));

        return view;
    }
}
