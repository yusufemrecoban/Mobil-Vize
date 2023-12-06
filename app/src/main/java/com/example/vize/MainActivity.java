package com.example.vize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCnvt;
    Button btnRnd;
    Button btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCnvt=findViewById(R.id.btn_cnvt);
        btnRnd=findViewById(R.id.btn_rnd);
        btnSms=findViewById(R.id.btn_sms);

        btnCnvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vx) {
                Intent x= new Intent(MainActivity.this,Convertor.class);
                startActivity(x);
            }
        });
        btnRnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vy) {
                Intent y= new Intent(MainActivity.this,RandomActivity.class);
                startActivity(y);
            }
        });
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vz) {
                Intent z= new Intent(MainActivity.this,Sms.class);
                startActivity(z);
            }
        });
    }
}