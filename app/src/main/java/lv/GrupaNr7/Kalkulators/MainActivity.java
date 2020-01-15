package lv.GrupaNr7.Kalkulators;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import lv.GrupaNr7.Kalkulators.R;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    TextView txtResult;

    public static final String mypreference = "mypref";

    Button btnNumber0;
    Button btnNumber1;
    Button btnNumber2;
    Button btnNumber3;
    Button btnNumber4;
    Button btnNumber5;
    Button btnNumber6;
    Button btnNumber7;
    Button btnNumber8;
    Button btnNumber9;

    EditText edtInput;


    Button btnC;
    Button btnDelete;

    Button btnAdd;
    Button btnSub;
    Button btnMul;
    Button btnDiv;

    Button btnDot;
    Button btnResult;

    double val1=Double.NaN;
    double val2;
    String ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNumber0 = (Button) findViewById(R.id.btnNumber0);
        btnNumber1 = (Button) findViewById(R.id.btnNumber1);
        btnNumber2 = (Button) findViewById(R.id.btnNumber2);
        btnNumber3 = (Button) findViewById(R.id.btnNumber3);
        btnNumber4 = (Button) findViewById(R.id.btnNumber4);
        btnNumber5 = (Button) findViewById(R.id.btnNumber5);
        btnNumber6 = (Button) findViewById(R.id.btnNumber6);
        btnNumber7 = (Button) findViewById(R.id.btnNumber7);
        btnNumber8 = (Button) findViewById(R.id.btnNumber8);
        btnNumber9 = (Button) findViewById(R.id.btnNumber9);
        Button btn_MS = findViewById(R.id.btn_MS);
        Button btn_MR = findViewById(R.id.btn_MR);
        Button btn_MC = findViewById(R.id.btn_MC);


        txtResult = (TextView) findViewById(R.id.txtResult);

        edtInput = (EditText) findViewById(R.id.edtInput);


        btnC = (Button) findViewById(R.id.btnC);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        btnAdd = (Button) findViewById(R.id.btnNumberAdd);
        btnSub = (Button) findViewById(R.id.btnNumberSub);
        btnMul = (Button) findViewById(R.id.btnNumberMul);
        btnDiv = (Button) findViewById(R.id.btnNumberDiv);

        btnDot = (Button) findViewById(R.id.btnDot);
        btnResult = (Button) findViewById(R.id.btnResult);



        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.NaN;
                txtResult.setText(null);
                edtInput.setText(null);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = edtInput.getText().toString();
                if(number != null && number.length() > 0){
                    number = number.substring(0, number.length() - 1);
                }
                edtInput.setText(number);
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "+";
                if(!Double.isNaN(val1)){
                    val2 = Double.parseDouble(edtInput.getText().toString());
                    val1 = val1 + val2;
                } else {
                    val1 = Double.parseDouble(edtInput.getText().toString());
                }

                txtResult.setText(val1 + " + ");
                edtInput.setText(null);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "-";
                if(!Double.isNaN(val1)){
                    val2 = Double.parseDouble(edtInput.getText().toString());
                    val1 = val1 - val2;
                } else {
                    val1 = Double.parseDouble(edtInput.getText().toString());
                }

                txtResult.setText(val1 + " - ");
                edtInput.setText(null);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "*";
                if(!Double.isNaN(val1)){
                    val2 = Double.parseDouble(edtInput.getText().toString());
                    val1 = val1 * val2;
                } else {
                    val1 = Double.parseDouble(edtInput.getText().toString());
                }

                txtResult.setText(val1 + " * ");
                edtInput.setText(null);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "/";
                if(!Double.isNaN(val1)){
                    val2 = Double.parseDouble(edtInput.getText().toString());
                    val1 = val1/val2;
                } else {
                    val1 = Double.parseDouble(edtInput.getText().toString());
                }

                txtResult.setText(val1 + " / ");
                edtInput.setText(null);
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ACTION != null && ACTION.equals("+")){
                    double result = val1 + Double.parseDouble(edtInput.getText().toString());
                    txtResult.setText(null);
                    edtInput.setText(String.valueOf(result));
                } else if(ACTION != null && ACTION.equals("-")){
                    double result = val1 - Double.parseDouble(edtInput.getText().toString());
                    txtResult.setText(null);
                    edtInput.setText(String.valueOf(result));
                } else if(ACTION != null && ACTION.equals("*")){
                    double result = val1 * Double.parseDouble(edtInput.getText().toString());
                    txtResult.setText(null);
                    edtInput.setText(String.valueOf(result));
                } else if(ACTION != null && ACTION.equals("/")){
                    double result = val1 / Double.parseDouble(edtInput.getText().toString());
                    txtResult.setText(null);
                    edtInput.setText(String.valueOf(result));
                }

                ACTION = null;
                val1 = Double.NaN;
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "0");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "1");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "2");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "3");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "4");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "5");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "6");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "7");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "8");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "9");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + ".");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btn_MS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("ievads",edtInput.getText().toString());
                editor.commit();

                Toast toast = Toast.makeText(MainActivity.this, "Jūs saglabajat!.", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        btn_MR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
                edtInput.setText(sharedpreferences.getString("ievads", ""));

                Toast toast = Toast.makeText(MainActivity.this, "Teksts tika iekopets!.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        btn_MC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                getSharedPreferences(mypreference, Context.MODE_PRIVATE).edit().clear().apply();

                edtInput.setText(null);

                Toast toast = Toast.makeText(MainActivity.this, "Teksts tika izdzests!.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });



    }
}