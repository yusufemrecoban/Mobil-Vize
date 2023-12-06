package com.example.vize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Convertor extends AppCompatActivity {

    EditText etDec;
    Spinner spDec;
    TextView tvDec;
    private int decimal;

    EditText etMb;
    Spinner spMb;
    TextView tvMb;
    private int mb;

    RadioGroup radioGroup;
    RadioButton rbFah;
    RadioButton rbKel;
    EditText etCel;
    TextView tvCel;
    private int cel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);

        etDec=findViewById(R.id.et_dec);
        spDec=findViewById(R.id.sp_dec);
        tvDec=findViewById(R.id.tv_dec);

        etMb=findViewById(R.id.et_mb);
        spMb=findViewById(R.id.sp_mb);
        tvMb=findViewById(R.id.tv_mb);

        etCel=findViewById(R.id.et_cel);
        tvCel=findViewById(R.id.tv_cel);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        rbFah=(RadioButton)findViewById(R.id.rb_fah);
        rbKel=(RadioButton)findViewById(R.id.rb_kel);

        ArrayList<String> decList=new ArrayList<>();
        decList.add("İkilik");
        decList.add("Sekizlik");
        decList.add("On Altılık");

        ArrayList<String> mbList=new ArrayList<>();
        mbList.add("Kilobyte");
        mbList.add("Byte");
        mbList.add("Kibibyte");
        mbList.add("Bit");

        ArrayAdapter<String> adapterDec=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,decList);
        adapterDec.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDec.setAdapter(adapterDec);

        spDec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                try {
                    decimal=Integer.parseInt(etDec.getText().toString());

                    switch (position){
                        case 0:
                            tvDec.setText(Integer.toBinaryString(decimal));
                            break;
                        case 1:
                            tvDec.setText(Integer.toOctalString(decimal));
                            break;
                        case 2:
                            tvDec.setText(Integer.toHexString(decimal));
                            break;
                    }

                }
                catch (Exception e){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adapterMb=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,mbList);
        adapterMb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMb.setAdapter(adapterMb);

        spMb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                try {
                    mb=Integer.parseInt(etMb.getText().toString());

                    switch (position){
                        case 0:
                            tvMb.setText(mb*1000+"kilobyte");
                            break;
                        case 1:
                            tvMb.setText(mb*1000000+"Byte");
                            break;
                        case 2:
                            tvMb.setText(mb*9765625+"Kibibyte");
                            break;
                        case 3:
                            tvMb.setText(mb*8000000+"Bit");
                            break;
                    }

                }
                catch (Exception e){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        try {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    System.out.println(checkedId);
                    cel=Integer.parseInt(etCel.getText().toString());
                    double trans;
                    switch (checkedId){
                        case 2131231261:
                            trans=(cel*9.0/5.0)+32.0;
                            tvCel.setText(Double.toString(trans));
                            break;
                        case 2131231262:
                            trans=cel+273.15;
                            tvCel.setText(Double.toString(trans));
                            break;
                    }
                }
            });
        }catch (Exception e){
            System.out.println(e);
        }
    }
}