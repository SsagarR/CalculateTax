package com.example.calculatetax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private float sal,tax,year;
    private EditText et_monthlysal;
    private Button btn_cal;
    private TextView tv_taxreslt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        et_monthlysal=findViewById(R.id.et_monthlysal);
        btn_cal=findViewById(R.id.btn_cal);
        tv_taxreslt=findViewById(R.id.tv_taxresult);

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sal=Float.parseFloat(et_monthlysal.getText().toString());
                year=sal*12;
                if(year<=200000 && year>1){
                    tax=(year*1)/100;
                    tv_taxreslt.setText(""+tax);
                }else if(year>200000 && year<=350000){
                    tax=((year-200000)*15/100)+2000;
//                    taxvalue =(((200000*1)/100) + ((year - 200000)*15/100));
                    tv_taxreslt.setText(""+tax);

                }else if(year>350000){
                    tax=(((year-200000-150000)*25)/100)+2000+22500;

//            taxvalue =(((200000*1)/100) + ((year - 200000)*15/100) +(year -350000)*25/100);
                    tv_taxreslt.setText(""+tax);
                }
            }
        });
    }
}

