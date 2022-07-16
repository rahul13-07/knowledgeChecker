package com.example.knowledgechecker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
    private String questions[] = {"1. Python is an interpreted high-level general-purpose programming language.", "2. Python is an Object-oriented programming language.",
            "3. trim() method can be used to remove any whitespace from both the beginning and the end of a string?",
            "4. List collection is ordered, changeable, and allows duplicate members?", "5. return statement is used to stop a loop?"
            ,"6. .py is the correct file extension for Python files?","7. In Python, 'Hello', is the same as \"Hello\"."};
    private boolean answers[] = {true, true, false, true, false, true,true};
    private int score = 0;
    private int index = 0;
    TextView question;
    Button yes;
    Button no;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.button);
        no = findViewById(R.id.button2);
        question = findViewById(R.id.question);
        question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index <= questions.length-1) {
                    if (answers[index]) {
                        score++;
                        //yes.setBackgroundColor(Color.rgb(52,216,58));
                    }
//                    else{
//                        yes.setBackgroundColor(Color.rgb(52,0,0));
//                    }
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "Your Score is " + score + "/"+questions.length, Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "RESTART to play again", Toast.LENGTH_LONG).show();
                }
                //yes.setBackgroundColor(Color.rgb(0,188,212));
                }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index <= questions.length-1) {
                    if (!answers[index]) {
                        score++;
                        //no.setBackgroundColor(Color.rgb(52,216,58));
                    }
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "Your Score is " + score + "/"+questions.length, Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "RESTART to play again", Toast.LENGTH_LONG).show();
                }
                //no.setBackgroundColor(Color.rgb(0,188,212));
                }
        });
    }
}