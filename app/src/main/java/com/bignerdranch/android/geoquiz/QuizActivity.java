package com.bignerdranch.android.geoquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                maakToast(R.string.correct_toast);
            }
        });
        mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                maakToast(R.string.incorrect_toast);
            }
        });

    }

    private void maakToast(int text) {
        Toast toast = Toast.makeText(QuizActivity.this,
                text,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 120);
        toast.show();
    }
}
