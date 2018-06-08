package com.bignerdranch.android.geoquiz;

public class QuizModel {
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };

    private int mCurrentIndex = 0;

    public boolean checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        boolean messageResId;

        if (userPressedTrue == answerIsTrue){
            messageResId= true;
        } else {
            messageResId = false;
        }

        return messageResId;
    }

    public int getCurrentQuestion() {
        return mQuestionBank[mCurrentIndex].getTextResId();
    }

    public void nextQuestion() {
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
    }

    public void previousQuestion() {
        if(mCurrentIndex!=0) {
            mCurrentIndex = mCurrentIndex - 1;
        }
        else {
            mCurrentIndex = mQuestionBank.length - 1;
        }
    }


}
