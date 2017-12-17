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

        if (questionNumber < 4) {
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
                theQuestion = getString(R.string.Twinkie_statement);
                realAnswer = false;
                theTruth = getString(R.string.Twinkie_fact);
                break;
            case 1:
                theQuestion = getString(R.string.missing_person_statement);;
                realAnswer = false;
                theTruth = getString(R.string.missing_person_fact);
                break;
            case 2:
                theQuestion = getString(R.string.chicken_statement);
                realAnswer = true;
                theTruth = getString(R.string.chicken_fact);
                break;
            case 3:
                theQuestion = getString(R.string.washington_statement);
                realAnswer = false;
                theTruth = getString(R.string.washington_fact);
                break;
            case 4:
                theQuestion = getString(R.string.camel_statement);
                realAnswer = true;
                theTruth = getString(R.string.camel_fact);
                break;
//            case 5:
//                theQuestion = "May";
//                realAnswer = true;
//                break;
//            case 6:
//                theQuestion = "June";
//                realAnswer = false;
//                break;
//            case 7:
//                theQuestion = "July";
//                realAnswer = true;
//                break;
//            case 8:
//                theQuestion = "August";
//                realAnswer = true;
//                break;
//            case 9:
//                theQuestion = "September";
//                realAnswer = false;
//                break;
            default:
                theQuestion = "Invalid question";
                theTruth = "Invalid fact";
                break;
        }


        return theQuestion;

    }

}
