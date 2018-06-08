package com.bignerdranch.android.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Answer extends AppCompatActivity {
    private static final String EXTRA_RESULT = "com.bignerdranch.android.geoquiz.result";

    private TextView mResultTextView;
    private Button mBackButton;
    private String result;

    public static Intent newIntent(Context packageContext, String result){
        Intent intent = new Intent(packageContext, Answer.class);
        intent.putExtra(EXTRA_RESULT, result);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        result = getIntent().getStringExtra(EXTRA_RESULT);

        mResultTextView = findViewById(R.id.result_text_view);
        mResultTextView.setText(result);

        mBackButton = findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }



}
