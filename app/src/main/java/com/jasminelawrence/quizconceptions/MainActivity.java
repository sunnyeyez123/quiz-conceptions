package com.jasminelawrence.quizconceptions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    int questionNumber = 0;
    String theTruth;
    private boolean choice;
    private boolean realAnswer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView question = (TextView) findViewById(R.id.question_text_view);
        question.setText(getQuestion(questionNumber));
    }



    public void chooseTrue(View view) {

        choice = true;
        choiceActions();


    }

    public void chooseFalse(View view) {

        choice = false;
        choiceActions();

    }

    private void choiceActions() {
        TextView answer = (TextView) findViewById(R.id.answer_text_view);
        TextView result = (TextView) findViewById(R.id.result_text_view);

        TextView trueButton = (TextView) findViewById(R.id.true_button);
        TextView falseButton = (TextView) findViewById(R.id.false_button);

        trueButton.setEnabled(false);
        falseButton.setEnabled(false);

        result.setText(isCorrect(choice));
        answer.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
    }


    public void nextQuestion(View view) {

        TextView answer = (TextView) findViewById(R.id.answer_text_view);
        TextView result = (TextView) findViewById(R.id.result_text_view);
        TextView question = (TextView) findViewById(R.id.question_text_view);

        TextView trueButton = (TextView) findViewById(R.id.true_button);
        TextView falseButton = (TextView) findViewById(R.id.false_button);

        trueButton.setEnabled(true);
        falseButton.setEnabled(true);

        answer.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);

        if (questionNumber <= 9) {
            questionNumber += 1;

        } else {
            questionNumber = 0;
        }
        question.setText(getQuestion(questionNumber));


    }

    private String isCorrect(boolean choice) {
        String truth;


        if (choice == realAnswer) {
            truth = "You were correct! The answer was: " + realAnswer + "\n\n" + theTruth;
        } else {
            truth = "You were wrong! The answer was: " + realAnswer + "\n\n" + theTruth;
        }

        return truth;
    }


    private String getQuestion(int questionNumber) {
        String theQuestion;

        switch (questionNumber) {
            case 0:
                theQuestion = "Twinkies last forever.";
                realAnswer = false;
                theTruth = "Twinkies have a shelf life of approximately 45 days —far shorter than the common myth that Twinkies are edible for decades or longer.They generally remain on a store shelf for only 7 to 10 days";
                break;
            case 1:
                theQuestion = "January";
                realAnswer = false;
                break;
            case 2:
                theQuestion = "February";
                realAnswer = true;
                break;
            case 3:
                theQuestion = "March";
                realAnswer = false;
                break;
            case 4:
                theQuestion = "April";
                realAnswer = true;
                break;
            case 5:
                theQuestion = "May";
                realAnswer = true;
                break;
            case 6:
                theQuestion = "June";
                realAnswer = false;
                break;
            case 7:
                theQuestion = "July";
                realAnswer = true;
                break;
            case 8:
                theQuestion = "August";
                realAnswer = true;
                break;
            case 9:
                theQuestion = "September";
                realAnswer = false;
                break;
            default:
                theQuestion = "Invalid question";
                break;
        }


        return theQuestion;

    }

}
