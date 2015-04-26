package com.xingshijie.calltheroll.DB;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2015/4/23 0023.
 */
public class AttendanceCount extends DataSupport{
    private Student student;
    private TheClass theClass=null;
    private int count;
    private int id;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public TheClass getTheClass() {
        return theClass;
    }

    public void setTheClass(TheClass theClass) {
        this.theClass = theClass;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
