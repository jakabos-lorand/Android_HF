package com.example.activitylifecyclemonitor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityTwo extends AppCompatActivity {
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_two);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.two), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button gomb2 = findViewById(R.id.button2);
        tv2 = findViewById(R.id.cimke2);

        gomb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ActivityTwo.this, ActivityThree.class);
                startActivity(myIntent);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.append("\n"+tv2.getText());
            }
        });

        Log.d("Status: ", "ActivityTwo:onCreate");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("cimke", tv2.getText().toString());
        Log.d("Status: ", "ActivityTwo:onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv2.setText(savedInstanceState.getString("cimke"));
        Log.d("Status: ", "ActivityTwo:onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Status: ", "ActivityTwo:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Status: ", "ActivityTwo:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Status: ", "ActivityTwo:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Status: ", "ActivityTwo:onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Status: ", "ActivityTwo:onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Status: ", "ActivityTwo:onDestroy");
    }
}
