package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.googlecode.aviator.AviatorEvaluator;

public class GridLayout extends AppCompatActivity {
    //定义界面上的需要的控件对象
    private TextView tvInput;
    private TextView tvResult;

    private String inputStr;
    private String express;
    private boolean flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        tvInput = findViewById(R.id.tv_input);
        tvResult = findViewById(R.id.tv_result);

        flag = true;
        inputStr = "";
        express = "";
    }


    public void calculate(View view) {
        Button button = (Button) view;
        if (flag) {
            inputStr = "";
            tvInput.setText(inputStr);
            tvResult.setText("0");
            flag = !flag;
        }
        switch (view.getId()) {
            case R.id.btn_0:
            case R.id.btn_00:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_dian:
            case R.id.btn_jia:
            case R.id.btn_jian:
                inputStr += button.getText().toString();
                express += button.getText().toString();
                break;
            case R.id.btn_cheng:
                inputStr += button.getText().toString();
                express += "*";
                break;
            case R.id.btn_chu:
                inputStr += button.getText().toString();
                express += "/";
                break;
            case R.id.btn_c:
                inputStr = "";
                express = "";
                break;
            case R.id.btn_del:
                if (inputStr.length() > 0) {
                    inputStr = inputStr.substring(0, inputStr.length() - 1);
                    express = express.substring(0, express.length() - 1);
                }
            case R.id.btn_qu:
                if (tvResult.length() > 0) {
                    long temp = Long.parseLong(tvResult.getText().toString());
                    tvResult.setText(String.valueOf(temp * 0.01));
                }
                break;
            case R.id.btn_deng:
                if (express.length() > 0) {
                    Long result = (Long) AviatorEvaluator.execute(express);
                    tvResult.setText(String.valueOf(result * 1));
                    
                }
                flag = true;
                express = "";
                break;
        }
        tvInput.setText(inputStr);
    }
}