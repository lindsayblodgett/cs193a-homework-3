package com.example.lindsay.puppypal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void beginBrowse(View view) {
        Intent intent = new Intent(this, BrowsePuppies.class);
        startActivity(intent);
    }
}
