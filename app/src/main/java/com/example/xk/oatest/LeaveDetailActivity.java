package com.example.xk.oatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LeaveDetailActivity extends AppCompatActivity {

    private static final String TAG = "LeaveDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_detail);

        TextView back = (TextView) findViewById(R.id.title_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView add = (TextView) findViewById(R.id.title_add);
        add.setText("");

        TextView title = (TextView) findViewById(R.id.title_text);
        title.setText("请假明细");

    }
}
