package com.example.project_taxi_rate_calculation;

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

        Button button = (Button)findViewById(R.id.count);
        button.setOnClickListener(texi_rate);
    }
    private View.OnClickListener texi_rate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DecimalFormat nf = new DecimalFormat("0");
            EditText instance = (EditText)findViewById(R.id.input_instance);
            EditText set_instance = (EditText)findViewById(R.id.set_instance_rate);
            EditText input_fee = (EditText)findViewById(R.id.input_fee);

            int basic = 75;
            //距離
            double distance = Double.parseDouble(instance.getText().toString());
            double basicCount = Double.parseDouble(set_instance.getText().toString());
            double addCost = Double.parseDouble(input_fee.getText().toString());
            //費用計算
            double count = basic + ((distance / basicCount) * addCost);

            TextView cost = (TextView)findViewById(R.id.output);
            //里程低於250公尺時
            if (distance < 250){
                cost.setText(nf.format(basic+addCost)+"元");
            }//每250公尺時且費率加收5元
            else if(distance >= 250 && addCost >=5){
                cost.setText(nf.format(count) + "元");
            }
        }
    };
}