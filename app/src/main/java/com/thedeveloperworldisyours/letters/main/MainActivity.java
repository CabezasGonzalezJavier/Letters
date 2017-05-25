package com.thedeveloperworldisyours.letters.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.thedeveloperworldisyours.letters.ActivityUtils;
import com.thedeveloperworldisyours.letters.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);


        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.main_activity_content_frame);

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainFragment, R.id.main_activity_content_frame);
        }

        new MainPresenter(mainFragment);

    }

}
