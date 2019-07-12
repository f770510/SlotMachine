package com.example.slotmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_Start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Start=(Button)findViewById(R.id.btn_Start);
        btn_Start.setOnClickListener(btn_StartOnClickListener);
    }
    View.OnClickListener btn_StartOnClickListener =new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,GameActivity.class);
            startActivity(intent);
        }
    };
}
