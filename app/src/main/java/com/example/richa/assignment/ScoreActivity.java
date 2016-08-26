package com.example.richa.assignment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_layout);

        TextView AnsCorrect = (TextView) findViewById(R.id.ans_correct);
        TextView AnsIncorrect = (TextView) findViewById(R.id.ans_incorrect);
        TextView AnsCheat = (TextView) findViewById(R.id.ans_cheat);
        TextView AnsHint = (TextView) findViewById(R.id.ans_hint);

        String correct = getIntent().getExtras().getInt("Correct") + "";
        String incorrect = getIntent().getExtras().getInt("Incorrect") + "";
        String hint = getIntent().getExtras().getInt("Hint") + "";
        String cheat = getIntent().getExtras().getInt("Cheat") + "";

        AnsCorrect.setText(correct);
        AnsIncorrect.setText(incorrect);
        AnsCheat.setText(cheat);
        AnsHint.setText(hint);
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
