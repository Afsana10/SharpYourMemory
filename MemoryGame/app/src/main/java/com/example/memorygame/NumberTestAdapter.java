package com.example.memorygame;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Arrays;

public class NumberTestAdapter extends BaseAdapter {

    private Context context;
    private int numbersTestArray[] =  new int[9];

    public NumberTestAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.numbersTestArray.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;

        for (int count=0; count<9; count++) {
            numbersTestArray[count]=1;
        }

        if (convertView == null) {
            textView = new TextView(this.context);
            textView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 200));
            textView.setPadding(8, 8, 8, 8);
            //textView.setBackgroundColor(getResources().getColor(R.color.violet));
            textView.setBackgroundResource(R.color.violet);
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(context.getResources().getColor(R.color.white));
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD);

        }
        else
        {
            textView = (TextView) convertView;
        }
        //Log.i("array : ", Arrays.toString(numbersArray));
        textView.setText(String.valueOf(numbersTestArray[position]));
        return textView;
    }
}
