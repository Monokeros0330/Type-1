package com.example.android_studio_1_btnswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.btn1);
        button.setOnClickListener(the_bmi);
    }
    private View.OnClickListener the_bmi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DecimalFormat nf = new DecimalFormat("0.00");
            EditText findheight = (EditText)findViewById(R.id.edit1);
            EditText findweight = (EditText)findViewById(R.id.edit2);
            //height
            double height = Double.parseDouble(findheight.getText().toString())/100;
            //weight
            double weight = Double.parseDouble(findweight.getText().toString());
            // computing bmi
            double bmi = weight / (height * height);
            //answer
            TextView findsuggest = (TextView)findViewById(R.id.textV3);
            findsuggest.setText(getText(R.string.bmi_result)
                    + nf.format(bmi));//格式化輸出BMI
            //p.s
            TextView findps = (TextView)findViewById(R.id.textV4);
            if (bmi < 18)
                findps.setText(R.string.advice_light);
            else if (bmi > 24)
                findps.setText(R.string.advice_heavy);
            else
                findps.setText(R.string.advice_average);
        }
    };
}