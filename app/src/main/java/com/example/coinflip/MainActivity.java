package com.example.coinflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button headsBtn;
    private Button tailsBtn;
    private ImageView coin;
    private TextView flipsTxtView;
    private TextView winTxtView;
    private TextView loseTxtView;
    private int flips;
    private int win;
    private int lose;
    /**
     * guess
     * true : heads
     * false : tails
     */
    private boolean guess;
    Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        headsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess = true;
                flip();
            }
        });

        tailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess = false;
                flip();
            }
        });
    }

    private void flip() {
        flips++;
        boolean result = rnd.nextBoolean();
        if (result) {
            coin.setImageResource(R.drawable.heads);
        } else {
            coin.setImageResource(R.drawable.tails);
        }
        if (result == guess) {
            win++;
            Toast.makeText(this, "Győzött!", Toast.LENGTH_SHORT).show();
        } else {
            lose++;
            Toast.makeText(this, "Vesztett!", Toast.LENGTH_SHORT).show();
        }
        jatekVege();
        updateTextViews();
    }

    private void jatekVege(){
        if (flips == 5){

        }
    }

    private void updateTextViews() {
        flipsTxtView.setText(flipsTxtView.getText() + String.valueOf(flips));
        winTxtView.setText(winTxtView.getText() + String.valueOf(win));
        loseTxtView.setText(loseTxtView.getText() + String.valueOf(lose));
    }

    private void init() {
        headsBtn = findViewById(R.id.btnHeads);
        tailsBtn = findViewById(R.id.btnTails);
        coin = findViewById(R.id.coin);
        flipsTxtView = findViewById(R.id.flips);
        winTxtView = findViewById(R.id.winTxtView);
        loseTxtView = findViewById(R.id.loseTxtView);
        win = 0;
        lose = 0;
        flips = 0;
        updateTextViews();
    }
}