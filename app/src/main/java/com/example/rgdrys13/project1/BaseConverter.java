package com.example.rgdrys13.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BaseConverter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_converter);
    }

    private EditText integerInput, baseInput, baseOutInput;
    private TextView convertedInteger;
    private String answer;

    public void buttonOnClick(View view){
        Button button = (Button) view;
        // get references to views
        integerInput = (EditText) findViewById(R.id.integer_input_edittext_id);
        baseInput = (EditText) findViewById(R.id.base_input_edittext_id);
        baseOutInput = (EditText) findViewById(R.id.base_out_input_edittext_id);
        convertedInteger = (TextView) findViewById(R.id.answer_id);
        button.setBackgroundResource(R.color.button);

        //get values from input views
        String intIn = integerInput.getText().toString();
        int baseIn = Integer.parseInt(baseInput.getText().toString());
        int baseOut = Integer.parseInt(baseOutInput.getText().toString());

        try {
            answer = Integer.toString(Integer.parseInt(intIn, baseIn), baseOut);
        } catch (NumberFormatException numberFormatException) {
            answer = "\t\t";
            button.setBackgroundResource(R.color.errorColor);
            Toast.makeText(BaseConverter.this, numberFormatException.getMessage(), Toast.LENGTH_LONG).show();
        }

        // set text to answer
        convertedInteger.setText(answer);
    }
}
