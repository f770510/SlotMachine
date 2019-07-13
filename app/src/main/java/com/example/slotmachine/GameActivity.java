package com.example.slotmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    Button btn_Go;
    Button btn_Less;
    Button btn_Plus;
    TextView tv_Rand1;
    TextView tv_Rand2;
    TextView tv_Rand3;
    TextView tv_Bet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btn_Go = (Button) findViewById(R.id.btn_Go);
        btn_Less = (Button) findViewById(R.id.btn_Less);
        btn_Plus = (Button) findViewById(R.id.btn_Plus);
        tv_Rand1 = (TextView) findViewById(R.id.tv_Rand1);
        tv_Rand2 = (TextView) findViewById(R.id.tv_Rand2);
        tv_Rand3 = (TextView) findViewById(R.id.tv_Rand3);
        tv_Bet = (TextView) findViewById(R.id.tv_Bet);
        btn_Go.setOnClickListener(btn_GoOnClickListener);
        btn_Less.setOnClickListener(btn_LessClickListener);
        btn_Plus.setOnClickListener(btn_PlusClickListener);

    }

    View.OnClickListener btn_GoOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int[] result = GetLottery(1, 49, 3);
            tv_Rand1.setText(String.valueOf( result[0]));
            tv_Rand2.setText(String.valueOf( result[1]));
            tv_Rand3.setText(String.valueOf( result[2]));
        }
    };
    View.OnClickListener btn_LessClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int temp_tv_Bet = Integer.parseInt(tv_Bet.getText().toString());
            temp_tv_Bet=temp_tv_Bet-1;
            tv_Bet.setText(String.valueOf(temp_tv_Bet));
        }
    };
    View.OnClickListener btn_PlusClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int temp_tv_Bet = Integer.parseInt(tv_Bet.getText().toString());
            temp_tv_Bet=temp_tv_Bet+1;
            tv_Bet.setText(String.valueOf(temp_tv_Bet));
        }
    };

    private int[] GetLottery(int start, int end, int length) {
        int[] result = new int[length];

        //建立 ranger 資料 (樂透的球)
        int temp_size = Math.abs(start - end);
        //建立 亂數區
        int[] temp = new int[temp_size];
        for (int i = 0; i < temp_size; i++) {
            temp[i] = start + i;
        }
        //撲克牌發牌擾亂程式
        for (int i = temp_size - 1; i > 1; i--) {
            Random ran = new Random();
            int random_index = ran.nextInt(i - 1);
            //swap random_index <--> last index
            int swap_temp = temp[i - 1];
            temp[i - 1] = temp[random_index];
            temp[random_index] = swap_temp;
        }

        //取top length
        for (int i = 0; i < length; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}
