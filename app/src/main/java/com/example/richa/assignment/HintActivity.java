package com.example.richa.assignment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hint_layout);
        TextView Txt_Answer= (TextView) findViewById(R.id.txt_answer);
        int numb=getIntent().getExtras().getInt("txt_number");
        int factor=is_prime(numb);
        String aaa=numb+"";
        if(factor==1) {
            String out=aaa + " has no factor other than 1 & " + aaa;
            Txt_Answer.setText(out);
        }
        else {
            String out=factor + " is a factor of " + aaa;
            Txt_Answer.setText(out);
        }

    }

    private int is_prime(int val) {

        if (val % 2 == 0) {
            return 2;
        }
        for (int i = 2; i < (val / 2) + 1; i++) {
            if (val % i == 0)
                return i;
        }
        return 1;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("MainActivity", "Changed to landscape");
        } else {
            Log.d("MainActivity", "Changed to portrait");
        }
    }



}
