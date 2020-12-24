package com.example.lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    private Button nrOne, nrTwo, nrThree, nrFour, nrFive, nrSix, nrSeven, nrEight, nrNine, nrZero,
            values, Equal, Plus, Minus, Div, Multi, exponent,Sqrt,
            C, CE,  Dot;
    private TextView CalculatorResult;
    private EditText ed1;
    private String Res1="", Res2;
    boolean plus, minus, multi, div, expo,BackSPC,clearResult,sqrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nrOne = (Button) findViewById(R.id.nrOne);
        nrTwo = (Button) findViewById(R.id.nrTwo);
        nrThree = (Button) findViewById(R.id.nrThree);
        nrFour = (Button) findViewById(R.id.nrFour);
        nrFive = (Button) findViewById(R.id.nrFive);
        nrSix = (Button) findViewById(R.id.nrSix);
        nrSeven = (Button) findViewById(R.id.nrSeven);
        nrEight = (Button) findViewById(R.id.nrEight);
        nrNine = (Button) findViewById(R.id.nrNine);
        nrZero = (Button) findViewById(R.id.nrZero);
        values = (Button) findViewById(R.id.values);
        Equal = (Button) findViewById(R.id.Equal);
        Plus = (Button) findViewById(R.id.Plus);
        Minus = (Button) findViewById(R.id.Minus);
        Div = (Button) findViewById(R.id.Div);
        Multi = (Button) findViewById(R.id.Multi);
        exponent = (Button) findViewById(R.id.exponent);
        C = (Button) findViewById(R.id.C);
        CE = (Button) findViewById(R.id.CE);
        //BackSPC = (Button) findViewById(R.id.BackSPC);
        Dot = (Button) findViewById(R.id.Dot);
        ed1 = (EditText) findViewById(R.id.CalculatorScreen);
        CalculatorResult = (TextView) findViewById(R.id.CalculatorResult);
        Sqrt = (Button) findViewById(R.id.Sqrt);

    }

    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "C":
                Res1 = "";
                break;
            case "Res2":
                clearResult=false;
                Res1 += Res2;
                break;
            case "x":
                clearResult=false;
                Solve();
                Res1 += "*";
                break;
            case "^":
                clearResult=false;
                Solve();
                Res1 += "^";
                break;
            case "√":
                clearResult=false;
                Solve();
                Res1 += "√";
                break;
            case "=":
                clearResult=true;
                Solve();
                Res2 = Res1;
                break;
            case "⬅":
                if (Res1.length() > 0) {
                    clearResult=false;
                   // BackSPC = false;

                    String newText = Res1.substring(0, Res1.length() - 1);
                    Res1 = newText;

                }
                break;
            default:
                if (Res1 == null) {
                    Res1 = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")|| data.equals("*")) { // || data.equals("*")
                    clearResult=false;
                    Solve();
                } else if (clearResult == true) {
                    Res1 = "";
                    clearResult = false;
                }

                Res1 += data;
        }


        CalculatorResult.setText(Res1);
    }


    public void Solve () {
        if (Res1.split("\\*").length == 2) {
            String number[] = Res1.split("\\*");
            try {
                double Multi = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                Res1 = Multi+"";
            }
            catch (Exception e){

            }
        }

        else if (Res1.split("/").length == 2) {
            String number[] = Res1.split("/");
            try {
                double Div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                Res1 = Div+"";
            }
            catch (Exception e){

            }
        }
        else if (Res1.split("\\^").length == 2) {
            String number[] = Res1.split("\\^");
            try {
                double exponent = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                Res1 = exponent + "";
            } catch (Exception e) {

            }
        }
        else if(Res1.split("\\√").length==2){
            String number [] = Res1.split("\\√");
            try{
                double sqrt = Math.sqrt(Double.parseDouble(number[0]));
                Res1 = sqrt + "";

            } catch (Exception e){

            }

        }

        else if (Res1.split("\\+").length == 2) {
            String number[] = Res1.split("\\+");
            try {
                double Plus = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                Res1 = Plus+"";
            }
            catch (Exception e){

            }
        }


        else if (Res1.split("\\-").length>1) {
            String number[] = Res1.split("\\-");
            if(number[0]=="" && number.length==2){
                number[0]=0+"";
            }
            try {
                double Minus=0;
                if(number.length==2) {
                    Minus = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if(number.length==3){
                    Minus = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }

                Res1 = Minus+"";
            }
            catch (Exception e){

            }
        }

//        else if (Res1.split("+/-").length>1){
//            if (!Res2.getText().toString().isEmpty() || !Res1.getText().toString().isEmpty()) {
//                values = Double.parseDouble(Res1.getText().toString());
//
//                Res1.setText("-" + Res1.getText().toString());
//                Res1.setText("");
//            } else {
//                Res2.setText("Error");
//            }
//            }





        String n[]=Res1.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                Res1=n[0];
            }
        }
        CalculatorResult.setText(Res1);
    }
    }



