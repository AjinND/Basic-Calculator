package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b00, bpercent, bplus, bminus, bmul, bdiv, bdot, bdel, backspace;
    TextView t1, t2;
    String n1 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        b00 = findViewById(R.id.twozero);

        bplus = findViewById(R.id.plus);
        bminus = findViewById(R.id.sub);
        bmul = findViewById(R.id.mul);
        bdiv = findViewById(R.id.div);
        bpercent = findViewById(R.id.percent);
        bdot = findViewById(R.id.dot);
        bdel = findViewById(R.id.del);
        backspace = findViewById(R.id.backspace);

        t1 = findViewById(R.id.inputTtext);
        t2 = findViewById(R.id.resText);
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

    public void doubleZero(View view) {
        t1.setText(t1.getText() + "00");
    }

    public void decimal(View view) {
        t1.setText(t1.getText() + ".");
    }

    /* Display Operators */
    public void add(View view) { t1.setText(t1.getText() + "+"); }

    public void minus(View view) { t1.setText(t1.getText() + "-"); }

    public void multiply(View view) { t1.setText(t1.getText() + "×"); }

    public void divide(View view) { t1.setText(t1.getText() + "÷"); }

    public void percent(View view) { t1.setText(t1.getText() + "%"); }

    /* Reset Screen */
    public void reset(View view) {
        t1.setText(null);
        t2.setText(null);
    }

    /* Delete one Character */
    public void backspace(View view) {
        int len = t1.getText().length();
        t1.setText(t1.getText().toString().substring(0, len - 1));
    }

    /* Calculate Result */
    public void res(View view) {
        n1 = t1.getText().toString();
        n1 = n1.replaceAll("×","*");
        n1 = n1.replaceAll("%","/100");
        n1 = n1.replaceAll("÷","/");

        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);

        String finalRes = "";
        try{
            Scriptable scriptable=rhino.initStandardObjects();
            finalRes = rhino.evaluateString(scriptable,n1,"javascript",1,null).toString();
        }catch(Exception e){
            finalRes = "0";
        }
        t2.setText(finalRes);
    }

}
