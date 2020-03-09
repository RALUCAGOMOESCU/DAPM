package com.example.adrian.lab3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity3 extends MainActivity2{
    public static final int MAX_NUMBER = 10;
    public static final Random RANDOM = new Random();
    private TextView msgTv;
    private EditText numberEnteredEt;
    private Button validate;
    private int numberToFind, numberTries;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail3);
        msgTv = (TextView) findViewById(R.id.msg);
        numberEnteredEt = (EditText) findViewById(R.id.numberEnteredEt);
        validate = (Button) findViewById(R.id.validate);
        validate.setOnClickListener((View.OnClickListener) this);

        newGame();
    }

    public void onClick(View view) {
        if (view == validate) {
            validate();
        }
    }

    private void validate() {
        int n = Integer.parseInt(numberEnteredEt.getText().toString());
        numberTries++;

        if (n == numberToFind) {
            Toast.makeText(this, "Congratulations ! You found the number " + numberToFind +
                    " in " + numberTries + " tries", Toast.LENGTH_SHORT).show();
            newGame();
        } else if (n > numberToFind) {
            msgTv.setText("too_high");
        } else if (n < numberToFind) {
            msgTv.setText("too_low");
        }
    }

    private void newGame() {
        numberToFind = RANDOM.nextInt(MAX_NUMBER) + 1;
        msgTv.setText("start");
        numberEnteredEt.setText("");
        numberTries = 0;
    }
}