package com.example.xk.oatest;

/**
 * Created by xk on 2018/9/19.
 */

public class Leave {
    /**
     * 申请日期
     */
    private String submitDate;

    /**
     * 请假日期
     */
    private String leaveDate;

    /**
     * 审批状态
     */
    private String leaveStatus;

    public Leave() {
    }

    public Leave(String submitDate, String leaveDate, String leaveStatus) {
        this.submitDate = submitDate;
        this.leaveDate = leaveDate;
        this.leaveStatus = leaveStatus;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "submitDate='" + submitDate + '\'' +
                ", leaveDate='" + leaveDate + '\'' +
                ", leaveStatus='" + leaveStatus + '\'' +
                '}';
    }
}
