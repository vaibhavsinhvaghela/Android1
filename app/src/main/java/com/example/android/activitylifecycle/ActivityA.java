package com.example.android.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityA extends AppCompatActivity {

    Button activityB, dialog, close;
    TextView threadCount;
    int count = 0001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Intent intent = getIntent();
        count = intent.getIntExtra("counter value",0001);


        activityB = (Button) findViewById(R.id.button);
        dialog = (Button)findViewById(R.id.button2);
        close = (Button)findViewById(R.id.button4);

        threadCount = (TextView)findViewById(R.id.textView3);
        threadCount.setText(" "+count);

        //override onClick()
        activityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++; //Thread Count Incremented
                Intent a_intent=new Intent(getApplicationContext(), ActivityB.class);// Calling Activity B from A
                a_intent.putExtra("counter value", count); // Sending counter value to Activity B
                startActivity(a_intent);//ActivityB Starts
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //to stop android application
                moveTaskToBack(true);
                finish();
            }
        });

        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                Intent a_intent=new Intent(getApplicationContext(), Dialog.class);// Calling Dialog from A
                a_intent.putExtra("counter value", count); // Sending counter value to Dialog
                startActivity(a_intent);//Dialog Starts
            }
        });

    }
    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        startActivity(intent);
    }
    public void startDialog(View v) {
        Intent intent = new Intent(ActivityA.this, Dialog.class);
        startActivity(intent);

    }
    public void finishActivityA(View v) {
        ActivityA.this.finish();
    }
}
