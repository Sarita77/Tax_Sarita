package com.example.tax_sarita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtsalary;
    private Button btnCalculate;
    private TextView txtOutput;
    float salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
    }

    private void initiate() {
        txtsalary = findViewById(R.id.etInput);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtOutput = findViewById(R.id.tvOutput);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtOutput.setText("The tax for your salary is:" + calculate());
            }
        });
    }

    private float calculate() {
        salary = Float.parseFloat(txtsalary.getText().toString());
        float tax;
        SalaryModel sm = new SalaryModel(salary * 12);
        if (sm.getSalary() >= 1 && sm.getSalary() <= 200000) {
            tax = sm.getSalary() / 100;
        } else if (sm.getSalary() > 200000 && sm.getSalary() <= 350000) {
            tax = (sm.getSalary() - 200000) * (15f / 100) + (200000f / 100);
        } else {
            tax = (sm.getSalary() - 350000) * (25f / 100) + (150000 * 15f) / 100 + (200000f / 100);
        }
        return tax;
    }
}
