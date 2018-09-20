package com.example.xk.oatest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xk on 2018/9/19.
 */

public class LeaveAdapter extends ArrayAdapter<Leave> {


    /**
     * 请假数据
     */
    private List<Leave> leaveList;

    /**
     * 子布局
     */
    private int resourceId;

    public LeaveAdapter(Context context, int textViewResourceId, List<Leave> objects) {
        super(context, textViewResourceId, objects);
        leaveList = objects;
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Leave leave = leaveList.get(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.content_zero = (TextView) view.findViewById(R.id.content_zero);
            viewHolder.content_one = (TextView) view.findViewById(R.id.content_one);
            viewHolder.content_two = (TextView) view.findViewById(R.id.content_two);
            view.setTag(viewHolder);//将 viewHolder 存储在View中
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();// 重新获取 viewHolder
        }
        viewHolder.content_zero.setText(leave.getSubmitDate());
        viewHolder.content_one.setText(leave.getLeaveDate());
        viewHolder.content_two.setText(leave.getLeaveStatus());
        return view;
    }

    /**
     * 内部类，用做对控件的缓存实例
     */
    class ViewHolder{
        TextView content_zero;
        TextView content_one;
        TextView content_two;
    }
}
