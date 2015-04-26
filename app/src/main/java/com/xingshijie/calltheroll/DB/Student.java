package com.xingshijie.calltheroll.DB;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/23 0023.
 */
public class Student extends DataSupport{
    private String name;
    private String number;
    private String mac;
    private List<TheClass> theClassList=new ArrayList<>();
    private List<CallTheRollRecord> callTheRollRecordList=new ArrayList<>();
    private List<AttendanceCount> attendanceCountList=new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }


    public List<CallTheRollRecord> getCallTheRollRecordList() {
        return callTheRollRecordList;
    }

    public void setCallTheRollRecordList(List<CallTheRollRecord> callTheRollRecordList) {
        this.callTheRollRecordList = callTheRollRecordList;
    }

    public List<TheClass> getTheClassList() {

        return theClassList;
    }

    public void setTheClassList(List<TheClass> theClassList) {
        this.theClassList = theClassList;
    }

    public List<AttendanceCount> getAttendanceCountList() {
        return attendanceCountList;
    }

    public void setAttendanceCountList(List<AttendanceCount> attendanceCountList) {
        this.attendanceCountList = attendanceCountList;
    }
}
