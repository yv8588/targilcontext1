package com.example.targilsdarot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
boolean kind=false;
Switch choose;
EditText first,d;
double a,b;
String firsts,ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        choose=(Switch)findViewById(R.id.choose);
        first=(EditText)findViewById(R.id.first);
        d=(EditText)findViewById(R.id.d);

    }

    public void kind(View view) {
        if(choose.isChecked()){
            kind=true;//סדרה חשבונית(true)
        }
        else{
            kind=false;//סדרה הנדסית(FALSE)
        }
    }

    public void gosec(View view) {
        firsts=first.getText().toString();
        ds=d.getText().toString();
        if((firsts.equals(""))||ds.equals("")) {
            Toast.makeText(getApplicationContext(),"enter num",Toast.LENGTH_SHORT).show();
        }
        else {
            a=Double.parseDouble(firsts);
            b=Double.parseDouble(ds);
        }
        Intent si=new Intent(this,calc.class);
        si.putExtra("k",kind);//סוג סדרה
        si.putExtra("a",a);//איבר ראשון
        si.putExtra("b",b);//מכפיל
        startActivity(si);

    }
}