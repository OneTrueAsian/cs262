package jjf25.cs262.calvin.edu.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText firstValue;
    private EditText secondValue;
    private TextView result;
    private Spinner spinner;
    private int first;
    private int second;
    private double answer;
    private String resultText;
    private String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstValue = findViewById(R.id.FirstVInput);
        secondValue = findViewById(R.id.SecondVInput);
        result = findViewById(R.id.resultBox);
        spinner = findViewById(R.id.spinner);

    }

    public void calculate(View view) {
        first = Integer.parseInt(firstValue.getText().toString());
        second = Integer.parseInt(secondValue.getText().toString());
        op = spinner.getSelectedItem().toString();

        switch (op){
            case "+":
                answer = first + second;
                break;
            case "-":
                answer = first - second;
                break;
            case "*":
                answer = first * second;
                break;
            case "/":
                answer = first/second;
                break;
        }

        resultText = Double.toString(answer);
        result.setText(resultText);
    }
}
