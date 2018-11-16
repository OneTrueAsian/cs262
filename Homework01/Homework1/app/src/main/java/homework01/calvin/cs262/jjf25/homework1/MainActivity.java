package homework01.calvin.cs262.jjf25.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText arg1, arg2;
    private Spinner operator;
    private TextView output;
    private String operatorSelection;

    /**
     * OnCreate method for handling the calculator values and inputs
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arg1 = findViewById(R.id.value1);
        arg2 = findViewById(R.id.value2);
        output = findViewById(R.id.output_text);

        operator = findViewById(R.id.operation_spinner);
        operator.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operation_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operator.setAdapter(adapter);
    }

    /**
     * Actual method that will end up doing the calculations.
     * A switch loop for the operations that will be selected
     * @param view
     **/
    public void calculate(View view) {
        if (arg1.getText() != null && arg2.getText() != null) {
            int arg1Value = Integer.parseInt(arg1.getText().toString());
            int arg2Value = Integer.parseInt(arg2.getText().toString());

            if (operatorSelection != null && arg1Value != 0 && arg2Value != 0) {
                switch (operatorSelection) {
                    case "+": String addResult = Integer.toString(arg1Value + arg2Value);
                        output.setText(addResult);
                        break;
                    case "-": String subResult = Integer.toString(arg1Value - arg2Value);
                        output.setText(subResult);
                        break;
                    case "*": String multResult = Integer.toString(arg1Value * arg2Value);
                        output.setText(multResult);
                        break;
                    case "/": String divResult = Integer.toString(arg1Value / arg2Value);
                        output.setText(divResult);
                        break;
                    case "%": String modResult = Integer.toString(arg1Value % arg2Value);
                        output.setText(modResult);
                        break;
                }
            }
        }
    }

    /**
     * Created to detect if operator was selected
     * @param parent
     * @param view
     * @param position
     * @param id
     **/
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        operatorSelection = parent.getItemAtPosition(position).toString();
    }

    /**
     * Detect when operator is not selected
     * @param parent
     **/
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        operatorSelection = null;
    }
}
