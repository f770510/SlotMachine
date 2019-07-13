package com.example.slotmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_Start;
    TextView tv_Logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Start=(Button)findViewById(R.id.btn_Start);
        tv_Logo=(TextView)findViewById(R.id.tv_Logo);
        btn_Start.setOnClickListener(btn_StartOnClickListener);
        ObjectAnimator animTxtFalling =
                ObjectAnimator.ofFloat(tv_Logo, "y", 0, 500);
        animTxtFalling.setDuration(2000);
        animTxtFalling.setRepeatCount(0);
        animTxtFalling.setInterpolator(new BounceInterpolator());
        animTxtFalling.start();
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
