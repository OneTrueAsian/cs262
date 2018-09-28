package edu.calvin.cs262.jjf25.homework01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  Spinner Operator_Spinner;
    ArrayAdapter<CharSequence> adapter;
    private TextView Value1;
    private  TextView Value2;
    private  TextView Result;
    private int Var1;
    private  int Var2;
    private  int Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.operator_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.operator));
        spinner.setAdapter(adapter);

        Value1 = findViewById(R.id.Value_one);
        Value2 = findViewById(R.id.Value_two);
        Result = findViewById(R.id.Result_calc);

    }

    public void Calculate(View view) {
        Var1 = Integer.parseInt(Value1.getText().toString());
        Var2 = Integer.parseInt(Value2.getText().toString());
    }

}
