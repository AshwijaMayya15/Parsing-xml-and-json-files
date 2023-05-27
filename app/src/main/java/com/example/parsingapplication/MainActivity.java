package com.example.parsingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bxml,bjson,bjx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bxml=(Button) findViewById(R.id.button_xml);
        bxml.setOnClickListener(this);
        bjson=(Button) findViewById(R.id.button_json);
        bjson.setOnClickListener(this);
        bjx=(Button) findViewById(R.id.button_jx);
        bjx.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v.equals(bjson)){
            Intent it=new Intent(this,ViewActivity.class);
            it.putExtra("mode",1);
            startActivity(it);
        }
        else if(v.equals(bxml)){
            Intent it=new Intent(this,ViewActivity.class);
            it.putExtra("mode",2);
            startActivity(it);
        }
        else if(v.equals(bjx)){
            Intent it=new Intent(this,ViewActivity.class);
            it.putExtra("mode",3);
            startActivity(it);
        }
    }
}