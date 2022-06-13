package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Components
        EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        EditText editVal1 = (EditText) findViewById(R.id.editTextValue1);
        EditText editVal2 = (EditText) findViewById(R.id.editTextValue2);


        Button buttonLogin = (Button) findViewById(R.id.btnLogin);
        Button buttonAdd = (Button) findViewById(R.id.btnAdd);
        Button buttonSubtract = (Button) findViewById(R.id.btnSubtract);

        TextView textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        TextView textViewPassword = (TextView) findViewById(R.id.textViewPassword);
        TextView textViewSum = (TextView) findViewById(R.id.textViewSum);
        TextView textViewDiff = (TextView) findViewById(R.id.textViewDiff);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                Log.i("INFO: ", email);
                Log.i("INFO: ", password);

                textViewEmail.setText(email);
                textViewPassword.setText(password);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    int val1 = Integer.parseInt(editVal1.getText().toString());
                    int val2 = Integer.parseInt(editVal2.getText().toString());

                    int sum = add(val1, val2);

                    Log.i("INFO: ", String.valueOf(val1));
                    Log.i("INFO: ", String.valueOf(val2));
                    Log.i("INFO: ", String.valueOf(sum));

                    textViewSum.setText(String.valueOf(sum));

                } catch (Exception e){
                    Log.i("ERROR", e.getMessage().toString());
                    textViewSum.setText(e.getMessage().toString());
                }
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    int val1 = Integer.parseInt(editVal1.getText().toString());
                    int val2 = Integer.parseInt(editVal2.getText().toString());

                    int sub = subtract(val1, val2);

                    Log.i("INFO: ", String.valueOf(val1));
                    Log.i("INFO: ", String.valueOf(val2));
                    Log.i("INFO: ", String.valueOf(sub));

                    textViewDiff.setText(String.valueOf(sub));

                } catch (Exception e){
                    Log.i("ERROR", e.getMessage().toString());
                    textViewDiff.setText(e.getMessage().toString());
                }

            }
        });

    }

    private int add(int val1, int val2){
        return val1 + val2;
    }

    private int subtract(int val1, int val2){
        return val1 - val2;
    }
}