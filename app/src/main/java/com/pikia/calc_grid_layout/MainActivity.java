package com.pikia.calc_grid_layout;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.widget.Button;
import android.widget.TextView;

import android.view.View;


public class MainActivity extends AppCompatActivity {

    private TextView result;
    private Button zero, period, one, two, three, four, five, six, seven, eight, nine;
    private Button clear, equals, plus, minus, multiply, divide, negative;

    private List<Double> entries = new ArrayList<>();
    private List<Integer> action = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView ID
        result = (TextView) findViewById(R.id.textView);

        //Numerical ID's
        zero = (Button) findViewById(R.id.zero);
        period = (Button) findViewById(R.id.period);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);

        //Plus,minus, etc ID's
        equals = (Button) findViewById(R.id.equals);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        clear = (Button) findViewById(R.id.clear);
        multiply = (Button) findViewById(R.id.multiplication);
        divide = (Button) findViewById(R.id.divide);
        negative = (Button) findViewById(R.id.negative);

        ////////////////// Numerical ClickListener ////////////////////////
        zero.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        result.append("0");
                    }
                }

        );

        period.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        result.append(".");
                    }
                }

        );

        one.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        result.append("1");
                    }
                }

        );

        two.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        result.append("2");
                    }
                }

        );

        three.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        result.append("3");
                    }
                }

        );

        four.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        result.append("4");
                    }
                }

        );

        five.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        result.append("5");
                    }
                }

        );

        six.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        result.append("6");
                    }
                }

        );

        seven.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        result.append("7");
                    }
                }

        );

        eight.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        result.append("8");
                    }
                }

        );

        nine.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        result.append("9");
                    }
                }

        );
        ////////////////// End of Numerical ClickListener ////////////////////////



        ////////////// Plus,Minus etc ClickListener ///////////////////////

        plus.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        entries.add(Double.parseDouble(result.getText().toString()));
                        action.add(0);
                        result.setText("");
                    }
                }
        );

        minus.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        entries.add(Double.parseDouble(result.getText().toString()));
                        action.add(1);
                        result.setText("");
                    }
                }
        );

        multiply.setOnClickListener(
            new Button.OnClickListener(){
                public void onClick(View v){
                    entries.add(Double.parseDouble(result.getText().toString()));
                    action.add(2);
                    result.setText("");
                }
            }
        );

        divide.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        entries.add(Double.parseDouble(result.getText().toString()));
                        action.add(3);
                        result.setText("");
                    }
                }
        );

        negative.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        result.setText("-" + result.getText());
                    }
                }
        );

        equals.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        entries.add(Double.parseDouble(result.getText().toString())); // adding the final input to entries
                        Double total = entries.get(0); //Using Double in order to convert to string.

                        total = doOperations(action,entries,total);

                        entries.clear();
                        action.clear();
                        result.setText(total.toString());

                    }
                }
        );

        clear.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        result.setText("");
                        action.clear();
                        entries.clear();
                    }
                }
        );
    }
    ////////////// End of Plus,Minus etc ClickListener ///////////////////////


    public double doOperations(List<Integer> action, List<Double> entries, Double total){
        int operatorLocation = 0;

        for (int i = 0; i < entries.size() - 1; i++) {
            double num = entries.get(i+1);
            int op = action.get(operatorLocation);
            if (op == 0 /*addition*/) {
                total += num;
            }
            if (op == 1 /*subtraction*/) {
                total -= num;
            }

            if(op == 2 /*multiplication*/){
                total *=  num;
            }

            if(op == 3 /*multiplication*/){
                total /= num;
            }

            operatorLocation++;
        }

        operatorLocation = 0;
        return total;
    }
}
