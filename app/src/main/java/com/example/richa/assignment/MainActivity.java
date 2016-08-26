package com.example.richa.assignment;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String FLAG = "no";
    private int Correct = 0;
    private int Incorrect = 0;
    private int Hint = 0;
    private int Cheat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("MainActivity", "onCreate");
        TextView txt = (TextView) findViewById(R.id.txt_number);
        Random r = new Random();
        int num = r.nextInt(1000) + 1;
        String abc = "Is " + num + " a prime number?";
        txt.setText(abc);

        final Button bt_True = (Button) findViewById(R.id.bt_true);
        final Button bt_False = (Button) findViewById(R.id.bt_false);
        final Button bt_Next = (Button) findViewById(R.id.bt_next);
        final Button bt_Cheat = (Button) findViewById(R.id.bt_cheat);
        final Button bt_Hint = (Button) findViewById(R.id.bt_hint);
        final Button bt_Score = (Button) findViewById(R.id.bt_score);
        bt_True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Clicked on :" + bt_True.getText());
                int val = find_num();
                Boolean ans = is_prime(val);
                Log.d("MainActivity", "output number:" + val + "  " + ans);
                if (ans) {
                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    Correct++;
                } else {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    Incorrect++;
                }

                bt_True.setEnabled(false);
                bt_False.setEnabled(false);
                bt_Hint.setEnabled(false);
                bt_Cheat.setEnabled(false);
            }
        });

        bt_False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Clicked on :" + bt_False.getText());
                int val = find_num();
                Boolean ans = is_prime(val);
                Log.d("MainActivity", "output number:" + val + "  " + ans);

                if (!ans) {
                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    Correct++;
                } else {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    Incorrect++;
                }
                bt_True.setEnabled(false);
                bt_False.setEnabled(false);
                bt_Hint.setEnabled(false);
                bt_Cheat.setEnabled(false);
            }
        });

        bt_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Clicked on :" + bt_Next.getText());
                TextView txt = (TextView) findViewById(R.id.txt_number);
                Random r = new Random();
                int num = r.nextInt(1000) + 1;
                String abc = "Is " + num + " a prime number?";
                txt.setText(abc);
                bt_True.setEnabled(true);
                bt_False.setEnabled(true);
                bt_Hint.setEnabled(true);
                bt_Cheat.setEnabled(true);
            }
        });

        bt_Cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CheatActivity.class);
                intent.putExtra("txt_number", find_num());
                startActivity(intent);
                FLAG = "Cheat";
                if (Cheat > 3) {
                    bt_Cheat.setEnabled(false);
                }

            }
        });

        bt_Hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HintActivity.class);
                intent.putExtra("txt_number", find_num());
                startActivity(intent);
                FLAG = "Hint";
                if (Hint > 3) {
                    bt_Hint.setEnabled(false);
                }
            }
        });

        bt_Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                intent.putExtra("Correct", Correct);
                intent.putExtra("Incorrect", Incorrect);
                intent.putExtra("Cheat", Cheat);
                intent.putExtra("Hint", Hint);
                startActivity(intent);


            }
        });
    }


    private Boolean is_prime(int val) {
        if (val % 2 == 0)
            return false;
        for (int i = 2; i < (val / 2) + 1; i++) {
            if (val % i == 0)
                return false;
        }
        return true;
    }

    private int find_num() {
        TextView txt = (TextView) findViewById(R.id.txt_number);
        String str = (String) txt.getText();
        String builder = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                builder = builder + (c);
            }
        }
        return Integer.parseInt(builder);
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
        if (FLAG.equals("Hint")) {
            Toast.makeText(MainActivity.this, "Hint used", Toast.LENGTH_LONG).show();
            FLAG = "no";
            Hint++;
        }
        if (FLAG.equals("Cheat")) {
            Toast.makeText(MainActivity.this, "Cheat used", Toast.LENGTH_SHORT).show();
            FLAG = "no";
            Cheat++;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume" + FLAG);
        if (FLAG.equals("Hint")) {
            Toast.makeText(MainActivity.this, "Hint used", Toast.LENGTH_LONG).show();
            FLAG = "no";
            Hint++;
        }
        if (FLAG.equals("Cheat")) {
            Toast.makeText(MainActivity.this, "Cheat used", Toast.LENGTH_SHORT).show();
            FLAG = "no";
            Cheat++;
        }
        Log.d("MainActivity", "onResume" + FLAG);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }


}
