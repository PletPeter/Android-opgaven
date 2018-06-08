package com.bignerdranch.android.geoquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPreviousButton;
    private TextView mQuestionTextView;


    private QuizModel model = new QuizModel();

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = findViewById(R.id.question_text_view);
        updateQuestion();

        mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(model.checkAnswer(true)){
                    makeToast(R.string.correct_toast);
                    makeIntent("Goed");
                }
                else {
                    makeToast(R.string.incorrect_toast);
                    makeIntent("Fout");
                }
            }
        });
        mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(model.checkAnswer(false)){
                    makeToast(R.string.correct_toast);
                    makeIntent("Goed");
                }
                else {
                    makeToast(R.string.incorrect_toast);
                    makeIntent("Fout");
                }
            }
        });

        mNextButton = findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.nextQuestion();
                updateQuestion();
            }
        });

        mPreviousButton = findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex>0) {
                    mCurrentIndex = (mCurrentIndex - 1);
                    updateQuestion();
                }
                else{
                    model.previousQuestion();
                    updateQuestion();
                }
            }
        });

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.nextQuestion();
                updateQuestion();
            }
        });

        updateQuestion();
    }

    private void updateQuestion() {
        Question question = model.getCurrentQuestion();
        mQuestionTextView.setText(question.getTextResId());
    }

    private void makeToast(int text) {
        Toast toast = Toast.makeText(QuizActivity.this,
                text,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 120);
        toast.show();
    }

    private void makeIntent(String result){
        Intent intent = Answer.newIntent(QuizActivity.this, result);
        startActivity(intent);
    }
}
