package com.example.vize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sms extends AppCompatActivity {

    EditText textPho;
    EditText textMsg;
    Button btnPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        textPho=findViewById(R.id.txt_pho);
        textMsg=findViewById(R.id.txt_msg);
        btnPush=findViewById(R.id.btn_push);

        btnPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber=textPho.getText().toString();
                String message=textMsg.getText().toString();

                sendSms(phoneNumber,message);
            }
        });
    }
    private void sendSms(String phoneNumber,String message){
        Uri uri=Uri.parse("smsto:"+phoneNumber);

        Intent intent=new Intent(Intent.ACTION_SENDTO,uri);

        intent.putExtra("sms_body",message);
        startActivity(intent);
    }
}