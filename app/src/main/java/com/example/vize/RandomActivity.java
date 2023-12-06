package com.example.vize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
public class RandomActivity extends AppCompatActivity {

    private int numberOfBars=0;
    private int min=0;
    private int max=100;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random2);

        layout=findViewById(R.id.layout);
        EditText numberOfBarsInput=findViewById(R.id.et_adet);
        numberOfBarsInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
                    numberOfBars=Integer.parseInt(s.toString());
                    updateProgressBars();
                }catch (NumberFormatException e){

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        EditText minInput=findViewById(R.id.et_min);
        minInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                min=Integer.parseInt(s.toString());
                updateProgressBars();
            }catch (NumberFormatException e){

            }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        EditText maxInput=findViewById(R.id.et_min);
        maxInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    max=Integer.parseInt(s.toString());
                    updateProgressBars();
                }catch (NumberFormatException e){

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void updateProgressBars() {
        if(min>max){
            Toast.makeText(this,"değerleri kontrol edin",Toast.LENGTH_SHORT).show();
            return;
        }
        else if (min==max){
            Toast.makeText(this,"değerleri kontrol edin",Toast.LENGTH_SHORT).show();
            return;
        }
        layout.removeAllViews();
        Random random=new Random();
        for (int i=0;i<numberOfBars;i++){
            int radomNum=random.nextInt(max-min+1)+min;

            LinearLayout progressBarLayout=new LinearLayout(this);
            progressBarLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            ProgressBar progressBar=new ProgressBar(this,null, android.R.attr.progressBarStyleHorizontal);
            progressBar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));

            int progress=(int)(100*(float)(radomNum-min)/(max-min));
            progressBar.setProgress(progress);

            TextView minTextView=new TextView(this);
            minTextView.setText(String.valueOf(min));

            TextView maxTextView=new TextView(this);
            maxTextView.setText(String.valueOf(max));

            LinearLayout.LayoutParams minTextViewParams=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
            );
            minTextViewParams.setMargins(0,0,16,0);
            minTextView.setLayoutParams(minTextViewParams);

            LinearLayout.LayoutParams maxTextViewParams=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
            );
            maxTextViewParams.setMargins(16,0,0,0);
            maxTextView.setLayoutParams(maxTextViewParams);

            progressBarLayout.addView(minTextView);
            progressBarLayout.addView(progressBar);
            progressBarLayout.addView(maxTextView);

            TextView radomTexView=new TextView(this);
            radomTexView.setText(radomNum+"=%"+progress);

            LinearLayout.LayoutParams randomLayoutParams=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT
            );
            randomLayoutParams.setMargins(450,0,0,16);

            LinearLayout.LayoutParams progressBarLayoutParams=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT
            );
            progressBarLayoutParams.setMargins(0,25,0,100);

            layout.addView(radomTexView,randomLayoutParams);
            layout.addView(progressBarLayout,progressBarLayoutParams);

        }
    }
}