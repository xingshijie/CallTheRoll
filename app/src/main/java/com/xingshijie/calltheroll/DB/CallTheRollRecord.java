package com.xingshijie.calltheroll.DB;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2015/4/23 0023.
 */
public class CallTheRollRecord extends DataSupport{
    private Student student;
    private CallTheRoll callTheRoll;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public CallTheRoll getCallTheRoll() {
        return callTheRoll;
    }

    public void setCallTheRoll(CallTheRoll callTheRoll) {
        this.callTheRoll = callTheRoll;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
