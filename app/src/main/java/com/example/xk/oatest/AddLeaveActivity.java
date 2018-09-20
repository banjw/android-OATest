package com.example.xk.oatest;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import static android.R.style.Theme;

public class AddLeaveActivity extends AppCompatActivity implements TextView.OnClickListener {

    private static final String TAG = "AddLeaveActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_leave);

        Button back = (Button) findViewById(R.id.title_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button add = (Button) findViewById(R.id.title_add);
        add.setText("");

        Button leaveSubmit = (Button) findViewById(R.id.leave_submit);
        leaveSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        TextView title = (TextView) findViewById(R.id.title_text);
        title.setText("新建请假申请");

        TextView startDateView = (TextView) findViewById(R.id.start_data);
        startDateView.setOnClickListener(this);

        TextView startTimeView = (TextView) findViewById(R.id.start_time);
        startTimeView.setOnClickListener(this);

        TextView endDateView = (TextView) findViewById(R.id.end_date);
        endDateView.setOnClickListener(this);

        TextView endTimeView = (TextView) findViewById(R.id.end_time);
        endTimeView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_data:
                this.showDatePickerDialog(AddLeaveActivity.this,android.R.style.Theme_Material_Light_Dialog_Alert,(TextView) v,Calendar.getInstance());
                break;
            case R.id.start_time:
                this.showTimePickerDialog(AddLeaveActivity.this,android.R.style.Theme_Material_Light_Dialog_Alert,(TextView) v,Calendar.getInstance());
                break;
            case R.id.end_date:
                this.showDatePickerDialog(AddLeaveActivity.this,android.R.style.Theme_Material_Light_Dialog_Alert,(TextView) v,Calendar.getInstance());
                break;
            case R.id.end_time:
                this.showTimePickerDialog(AddLeaveActivity.this,android.R.style.Theme_Material_Light_Dialog_Alert,(TextView) v,Calendar.getInstance());
                break;
            default:
                break;
        }
    }

    /**
     * 日期选择
     * @param activity
     * @param themeResId
     * @param tv
     * @param calendar
     */
    private void showDatePickerDialog(Activity activity, int themeResId, final TextView tv, Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity , themeResId,new DatePickerDialog.OnDateSetListener() {
            // 绑定监听器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作
                tv.setText(year + "年" + (monthOfYear+1)+ "月" + dayOfMonth + "日");
                Log.d(TAG, "onDateSet: "+"您选择了：" + year + "年" + (monthOfYear+1)+ "月" + dayOfMonth + "日");
            }
        }
                // 设置初始日期
                , calendar.get(Calendar.YEAR)
                ,calendar.get(Calendar.MONTH)
                ,calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    /**
     * 时间选择
     * @param activity
     * @param themeResId
     * @param tv
     * @param calendar
     */
    private void showTimePickerDialog(Activity activity,int themeResId, final TextView tv, Calendar calendar) {
        // Calendar c = Calendar.getInstance();
        // 创建一个TimePickerDialog实例，并把它显示出来
        // 解释一哈，Activity是context的子类
        new TimePickerDialog( activity,themeResId,
                // 绑定监听器
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tv.setText(hourOfDay + "时" + minute  + "分");
                        Log.d(TAG, "onTimeSet: "+"您选择了：" + hourOfDay + "时" + minute  + "分");
                    }
                }
                // 设置初始时间
                , calendar.get(Calendar.HOUR_OF_DAY)
                , calendar.get(Calendar.MINUTE)
                // true表示采用24小时制
                ,true).show();
    }
}
