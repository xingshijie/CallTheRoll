package com.xingshijie.calltheroll.DB;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/23 0023.
 */
public class TheClass extends DataSupport{

    private String name;
    private int count;
    private List<Student> studentArrayList=new ArrayList<>();
    private List<CallTheRoll> callTheRollList=new ArrayList<>();
    private List<AttendanceCount> attendanceCountList=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public List<CallTheRoll> getCallTheRollList() {
        return callTheRollList;
    }

    public void setCallTheRollList(List<CallTheRoll> callTheRollList) {
        this.callTheRollList = callTheRollList;
    }

    public List<AttendanceCount> getAttendanceCountList() {
        return attendanceCountList;
    }

    public void setAttendanceCountList(List<AttendanceCount> attendanceCountList) {
        this.attendanceCountList = attendanceCountList;
    }
}
