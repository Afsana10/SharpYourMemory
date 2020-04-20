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
import java.util.Random;

public class NumberAdapter extends BaseAdapter {
    private Context context;
    private int numbersArray[] =  new int[9];

    public NumberAdapter(Context context){
        this.context = context;
        this.populateNumberArray();
    }

    public int[] getNewNumbersArray(){
        this.populateNumberArray();
        return numbersArray;
    }

    public void populateNumberArray(){
        int count = 0;
        while(true){
            Random rand = new Random();
            int randNum = rand.nextInt(100);
            if (!numberAlreadyExistInArray(numbersArray, randNum)){
                numbersArray[count] = randNum;
                count += 1;
            }
            if (count == 9){
                break;
            }
        }

        Log.i("array : ", Arrays.toString(numbersArray));
    }


    private boolean numberAlreadyExistInArray(int[] arr, int toCheckValue){
        boolean flag = false;
        for (int element : arr) {
            if (element == toCheckValue) {
                flag = true;
            }
        }
        return flag;
    }


    @Override
    public int getCount() {
        return this.numbersArray.length;
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
        Log.i("array : ", Arrays.toString(numbersArray));
        textView.setText(String.valueOf(numbersArray[position]));
        return textView;
    }

    public interface NumberTestListener{
        void populateTestArray();
    }
}
