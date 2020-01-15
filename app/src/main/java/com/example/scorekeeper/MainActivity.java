package com.example.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mScoreText1;
    TextView mScoreText2;

    int mScoreTeam1;
    int mScoreTeam2;

    final static String SCORE_TEAM_1="SCORE_TEAM_1";
    final static String SCORE_TEAM_2="SCORE_TEAM_2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1=findViewById(R.id.score_1);
        mScoreText2=findViewById(R.id.score_2);

        if (savedInstanceState!=null){
            mScoreTeam1 = savedInstanceState.getInt(SCORE_TEAM_1);
            mScoreTeam2 = savedInstanceState.getInt(SCORE_TEAM_2);
            //Set the score text views
            mScoreText1.setText(String.valueOf(mScoreTeam1));
            mScoreText2.setText(String.valueOf(mScoreTeam2));
        }

        findViewById(R.id.increaseTeam1).setOnClickListener(this::increaseScore);
        findViewById(R.id.decreaseTeam1).setOnClickListener(this::decreaseScore);
        findViewById(R.id.increaseTeam2).setOnClickListener(this::increaseScore);
        findViewById(R.id.decreaseTeam2).setOnClickListener(this::decreaseScore);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SCORE_TEAM_1,mScoreTeam1);
        outState.putInt(SCORE_TEAM_2,mScoreTeam2);
        super.onSaveInstanceState(outState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.night_mode) {
            int night_mode = AppCompatDelegate.getDefaultNightMode();
            if (night_mode==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                //item.setTitle(R.string.day_mode); //NB Does NOT work
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                //item.setTitle(R.string.night_mode); //NB Does NOT work

            }
        }
        recreate();

        return true;
    }

    void increaseScore(View view){
        if (view.getId()==R.id.increaseTeam1){
            mScoreTeam1++;
            mScoreText1.setText(String.valueOf(mScoreTeam1));
        }
        if (view.getId()==R.id.increaseTeam2){
            mScoreTeam2++;
            mScoreText2.setText(String.valueOf(mScoreTeam2));
        }
    }

    void decreaseScore(View view){
        if (view.getId()==R.id.decreaseTeam1){
            if (mScoreTeam1>0){
                mScoreTeam1--;
                mScoreText1.setText(String.valueOf(mScoreTeam1));
            }
        }
        if (view.getId()==R.id.decreaseTeam2){
            if (mScoreTeam2>0) {
                mScoreTeam2--;
                mScoreText2.setText(String.valueOf(mScoreTeam2));
            }
        }
    }




}
