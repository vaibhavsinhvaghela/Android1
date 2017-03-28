package com.example.android.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class Dialog extends AppCompatActivity {
    Button dialog;
    int threadCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog);
        Intent b_intent = getIntent();//intent from Activity A
        threadCount = b_intent.getIntExtra("counter value", 0);//Get the value of Thread Counter
        threadCount++;
        dialog = (Button) findViewById(R.id.btn_finish_dialog);

        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //generate the object of intent to call ActivityA
                Intent myIntent = new Intent(getApplicationContext(), ActivityA.class);
                myIntent.putExtra("counter value", threadCount);//sending threadCount to Activity A
                startActivity(myIntent);
            }
        });
    }

    /**
     * Callback method defined by the View
     * @param v
     */
    public void finishDialog(View v) {
        Dialog.this.finish();
    }
}
