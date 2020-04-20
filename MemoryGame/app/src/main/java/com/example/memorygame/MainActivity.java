package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OpeningDialog.OpeningDialogListener {

    TextView countdownText;
    CountDownTimer countDownTimer;
    GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridview = findViewById(R.id.gridview);
        gridview.setAdapter(new NumberAdapter(this));

        countdownText = findViewById(R.id.countdown_text);
        countDownTimer = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countdownText.setText(millisUntilFinished/1000 + " sec left");
            }

            @Override
            public void onFinish() {

                countdownText.setText("Time's Up !");
                //GridView gridview = (GridView) findViewById(R.id.gridview);
                gridview.setAdapter(new NumberTestAdapter(getApplicationContext()));

                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        view.setBackgroundColor(Color.rgb(0, 204, 68));
                        Log.i("pos", String.valueOf(position));
                    }
                });
            }
        };

        OpeningDialog openingDialog = new OpeningDialog();
        openingDialog.show(getSupportFragmentManager(), "Opening Dialog");
    }

    @Override
    public void onOkClicked() {
        countDownTimer.start();
    }
}
