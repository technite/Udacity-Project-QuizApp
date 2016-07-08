package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hide keyboard when launching the app
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void grade (View view){

        //Question 1
        RadioGroup radiogroup1 = (RadioGroup) findViewById(R.id.Question1);
        RadioButton ques1ans = (RadioButton) findViewById(radiogroup1.getCheckedRadioButtonId());

        //Question 2
        RadioGroup radiogroup2 = (RadioGroup) findViewById(R.id.Question2);
        RadioButton ques2ans = (RadioButton) findViewById(radiogroup2.getCheckedRadioButtonId());

        //Question 3
        CheckBox ques3ans1 = (CheckBox) findViewById(R.id.ques3ans1);
        CheckBox ques3ans2 = (CheckBox) findViewById(R.id.ques3ans2);
        CheckBox ques3ans3 = (CheckBox) findViewById(R.id.ques3ans3);
        CheckBox ques3ans4 = (CheckBox) findViewById(R.id.ques3ans4);

        //Question 4
        EditText ques4ans = (EditText) findViewById(R.id.question4);

        //Check that the user answered all of the questions.
        if((ques1ans== null) || (ques2ans== null) || (ques4ans.getText().toString().equals(""))) {
            Toast.makeText(this, "Please answer ALL of the questions", Toast.LENGTH_SHORT).show();
        }
        else {
            int results = calculateScore(ques1ans.getText().toString(), ques2ans.getText().toString(), ques3ans1.isChecked(), ques3ans2.isChecked(), ques3ans3.isChecked(), ques3ans4.isChecked(), ques4ans.getText().toString());
            Toast.makeText(this, "You answered " + results + " out of 4 questions correctly.", Toast.LENGTH_SHORT).show();
        }
    }

    public static int calculateScore(String ques1,
                                     String ques2,
                                     boolean checkbox1,
                                     boolean checkbox2,
                                     boolean checkbox3,
                                     boolean checkbox4,
                                     String ques4)
    {
        int score = 0;

        //Answer to Question 1: 1776
        if(ques1.equals("1776")) {
            score += 1;
        }

        //Answer to Question 2: Financial
        if(ques2.equals("Financial")) {
            score += 1;
        }

        //Answer to Question 3: George Washington, Andrew Jackson, and Zachary Taylor
        if((checkbox1 && checkbox2 && checkbox3) && !checkbox4){
            score += 1;
        }

        //Answer to Question 4: Washington DC / Washington D.C.
        if((ques4.equals("Washington DC")) || ques4.equals("Washington D.C.")) {
            score +=1;
        }

        return score;
    }

}

