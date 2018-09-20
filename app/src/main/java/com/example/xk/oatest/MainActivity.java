package com.example.xk.oatest;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TextView.OnClickListener, AdapterView.OnItemClickListener{

    private static final String TAG = "MainActivity";

    private List<Leave> leaveList = new ArrayList<Leave>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        TextView back = (TextView) findViewById(R.id.title_back);
        TextView add = (TextView) findViewById(R.id.title_add);

        back.setOnClickListener(this);
        add.setOnClickListener(this);

        initLeave();
        LeaveAdapter adapter = new LeaveAdapter(MainActivity.this, R.layout.item_type, leaveList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    /**
     * 初始化请假数据
     */
    private void initLeave(){
        for (int i =0; i < 10; i++){
            Leave leave = new Leave("请假申请  2018-09-12","调休（2018-09-11 到 2018-09-11）共计1天","审批通过");
            leaveList.add(leave);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.title_back:
                Log.d(TAG, "onClick: title_back");
                finish();
                break;
            case R.id.title_add:
                Log.d(TAG, "onClick: title_add");
                intent = new Intent(MainActivity.this, AddLeaveActivity.class);
                break;
            default:
                break;
        }
        if(null != intent){
            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//列表点击事件
        Leave leave = leaveList.get(position);
        Intent intent = new Intent(MainActivity.this, LeaveDetailActivity.class);
        startActivity(intent);
        Log.d(TAG, "onItemClick: "+leave.toString());
    }
}
