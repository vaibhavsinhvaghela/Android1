package com.example.android.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class ActivityB extends AppCompatActivity {

    Button finish;
    int threadCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Intent b_intent = getIntent();//intent from Activity A
        threadCount = b_intent.getIntExtra("counter value", 0);//Get the value of Thread Counter
        threadCount++;
        finish = (Button) findViewById(R.id.button3);// Maps the Finish button of Activity B

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //generate the object of intent to call ActivityA
                Intent myIntent = new Intent(getApplicationContext(), ActivityA.class);
                myIntent.putExtra("counter value", threadCount);//sending threadCount to Activity A
                startActivity(myIntent);
            }
        });

    }
    public void finishActivityB(View v) {
        ActivityB.this.finish();
    }
}
