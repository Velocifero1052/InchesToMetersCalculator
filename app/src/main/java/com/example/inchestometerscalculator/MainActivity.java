package com.example.inchestometerscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    EditText inches;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setButtonClickListener();
    }

    private void findViews() {
        resultText = findViewById(R.id.text_view_result);
        inches = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.calculate_button);
    }

    private void setButtonClickListener() {
        calculateButton
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        double inch_ = Double.parseDouble(inches.getText().toString());
                        double res = calculateMeters(inch_);
                        displayResult(res);
                    }
                });
    }

    private double calculateMeters(double inches_) {
        return inches_ * 0.0254;
    }

    private void displayResult(double res) {
        DecimalFormat formatter = new DecimalFormat("##.##");
        formatter.setRoundingMode(RoundingMode.DOWN);
        String metersText = formatter.format(res);
        String answerText = inches.getText().toString() + " inches = " + metersText + " meters";
        resultText.setText(answerText);
    }

}