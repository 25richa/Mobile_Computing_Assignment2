package com.example.richa.assignment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


public class CheatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheat_layout);
        TextView Txt_Answer = (TextView) findViewById(R.id.txt_answer);
        int numb = getIntent().getExtras().getInt("txt_number");
        boolean bool = is_prime(numb);
        String aaa = numb + "";
        if (bool) {
            String out = aaa + " is a prime number";
            Txt_Answer.setText(out);
        } else {
            String out = aaa + " is not a prime number";
            Txt_Answer.setText(out);
        }

    }

    private Boolean is_prime(int val) {
        if (val % 2 == 0)
            return false;
        for (int i = 2; i < (val / 2) + 1; i++) {
            if (val % i == 0) {
                return false;
            }
        }
        return true;
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
