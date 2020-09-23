package com.example.targilsdarot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class calc extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    TextView td, tsn, tx, tn;
    ListView list;
    int x1, d,i, a, n = 2;
    boolean kind;
    double a2;
    String sa;
    String[] sidra = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        Intent gi = getIntent();
        tx = (TextView) findViewById(R.id.tx);
        tsn = (TextView) findViewById(R.id.tsn);
        tn = (TextView) findViewById(R.id.tn);
        td = (TextView) findViewById(R.id.td);
        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);
        list.setChoiceMode(list.CHOICE_MODE_SINGLE);
        ArrayAdapter<String>adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,sidra);
        list.setAdapter(adp);

        x1 = gi.getIntExtra("a", 1);
        kind = gi.getBooleanExtra("k", false);
        d = gi.getIntExtra("b", 1);
        tx.setText(x1);
        td.setText(d);
        if (kind) {
            for ( i = 0; i < 20; i++) {
                a = x1 + (d * (n - 1));
                sa=Integer.toString(a);
                sidra[i] = sa;
                n++;
            }

        }
        else{
            Double n2=Double.valueOf(n);
            Double d2=Double.valueOf(d);
            Double x1s=Double.valueOf(x1);
            // math.pow uses double

            for ( i = 0; i < 20; i++){
                a2=x1s*Math.pow(d2,(n2-1));
                a=(int) Math.round(a2);
                sa=Integer.toString(a);
                 sidra[i]=sa;
                n2++;
            }

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         tn.setText(sidra[position]);
         tsn.setText(position+2);
    }
}
