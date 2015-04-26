package com.xingshijie.calltheroll.DB;

import android.widget.ListView;

import org.litepal.crud.DataSupport;

import java.io.DataOutputStream;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/23 0023.
 */
public class CallTheRoll extends DataSupport {

    private Date date;
    private TheClass theClass=null;
    private List<CallTheRollRecord> callTheRollRecord;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TheClass getTheClass() {
        if(theClass==null){
            List<TheClass> list=DataSupport.where("calltheroll_id= ?", String.valueOf(getBaseObjId())).find(TheClass.class);
            if(!list.isEmpty()){
                theClass=list.get(0);
            }
        }
        return theClass;
    }

    public void setTheClass(TheClass theClass) {
        this.theClass = theClass;
    }

    public List<CallTheRollRecord> getCallTheRollRecord() {
        if(callTheRollRecord==null){
            callTheRollRecord=DataSupport.where("calltheroll_id= ?", String.valueOf(getBaseObjId())).find(CallTheRollRecord.class);
        }
        return callTheRollRecord;
    }

    public void setCallTheRollRecord(ArrayList<CallTheRollRecord> callTheRollRecord) {
        this.callTheRollRecord = callTheRollRecord;
    }
}
