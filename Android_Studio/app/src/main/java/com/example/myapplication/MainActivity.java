package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bplus,bminus,bmul,bdiv,bdot,bdel;
    TextView t1;
    final char Add = '+';
    final char Sub = '-';
    final char Multiply = '*';
    final char Divide = '/';
    final char Equal = '=';
    char action;
    double n1=Double.NaN;
    double n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 =  findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 =  findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);

        bplus = findViewById(R.id.plus);
        bminus = findViewById(R.id.sub);
        bmul = findViewById(R.id.mul);
        bdiv = findViewById(R.id.div);
        bdot = findViewById(R.id.dot);
        bdel = findViewById(R.id.del);

        t1 =  findViewById(R.id.text);
    }
    /* Display Numbers */

    public void number1(View view) {
        t1.setText(t1.getText() + "1");
    }
    public void number2(View view) {
        t1.setText(t1.getText() + "2");
    }

    public void number3(View view) {
        t1.setText(t1.getText() + "3");
    }

    public void number4(View view) {
        t1.setText(t1.getText() + "4");
    }

    public void number5(View view) {
        t1.setText(t1.getText() + "5");
    }

    public void number6(View view) {
        t1.setText(t1.getText() + "6");
    }

    public void number7(View view) {
        t1.setText(t1.getText() + "7");
    }

    public void number8(View view) {
        t1.setText(t1.getText() + "8");
    }

    public void number9(View view) {
        t1.setText(t1.getText() + "9");
    }

    public void number0(View view) {
        t1.setText(t1.getText() + "0");
    }

    /* Add,Sub,Mul,Div */

    public void add(View view) {
        calculate();
        action=Add;
        t1.setText(null);
    }
    public void minus(View view) {
        calculate();
        action=Sub;
        t1.setText(null);
    }
    public void multiply(View view) {
        calculate();
        action=Multiply;
        t1.setText(null);
    }
    public void divide(View view) {
        calculate();
        action=Divide;
        t1.setText(null);
    }

    /* Equal */

    public void res(View view) {
        calculate();
        action=Equal;
        t1.setText(String.valueOf(n1));
    }

    /* Reset */

    public void reset(View view) {
        n1 = Double.NaN;
        t1.setText(null);
    }

    /* Calculation */

    public void calculate(){
        if (!Double.isNaN(n1)) {
            n2= Double.parseDouble(t1.getText().toString());
            switch(action){
                case Add:
                    n1=n1+n2;
                    break;
                case Sub:
                    n1=n1-n2;
                    break;
                case Multiply:
                    n1=n1*n2;
                    break;
                case Divide:
                    n1=n1/n2;
                    break;
                case Equal:
                    break;
            }
        }
        else{
            n1=Double.parseDouble(t1.getText().toString());
        }
    }
}
