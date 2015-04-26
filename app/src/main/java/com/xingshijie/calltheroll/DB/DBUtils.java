package com.xingshijie.calltheroll.DB;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2015/4/23 0023.
 */
public class DBUtils {

    public static boolean addNewStudent(String name,String number,String mac,TheClass theClass){

        theClass=DataSupport.find(TheClass.class,3,true);
        if(theClass==null){
            theClass=new TheClass();
            theClass.setName("软114");
            theClass.setCount(3);
            theClass.save();
        }

        AttendanceCount attendanceCount=DataSupport.find(AttendanceCount.class,15);
        attendanceCount.save();

//        AttendanceCount attendanceCount=new AttendanceCount();
//        attendanceCount.setCount(0);
//        attendanceCount.save();
//
//        Student student=new Student();
//        student.setName(name);
//        student.setNumber(number);
//        student.setMac(mac);
//        student.getAttendanceCountList().add(attendanceCount);
//        student.save();
//
//        theClass.getStudentArrayList().add(student);
//        //student.getTheClassList().add(theClass);
//        //theClass.save();
//        theClass.getAttendanceCountList().add(attendanceCount);
//        theClass.save();


        return true;
    }


}
