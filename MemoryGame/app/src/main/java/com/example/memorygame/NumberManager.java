package com.example.memorygame;

import android.util.Log;

import java.util.Arrays;
import java.util.Random;

public class NumberManager {
    private int numbersArray[] =  new int[9];
    private int shuffledNumbersArray[] =  new int[9];
    public NumberManager(){

    }
    private void generateNumberArray(){

    }
    public int[] getNumbersArray(){
        return numbersArray;
    }
    public int[] getShuffledNumbersArray(){
        this.shuffleNumberArray();
        return shuffledNumbersArray;
    }

    private void shuffleNumberArray(){

    }

    private void populateNumberArray(){
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
}
