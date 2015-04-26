package com.xingshijie.calltheroll;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xingshijie.calltheroll.DB.AttendanceCount;
import com.xingshijie.calltheroll.DB.CallTheRoll;
import com.xingshijie.calltheroll.DB.CallTheRollRecord;
import com.xingshijie.calltheroll.DB.Student;
import com.xingshijie.calltheroll.DB.TheClass;

import org.litepal.crud.DataSupport;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TheClassFragment extends Fragment {


    /**
     * 表示此类的班级，次班级用find（true）获得，包括一个班级完整的数据
     */
    private TheClass theClass=null;
    private CallTheRoll callTheRoll=null;
    private long id=0;
    private TheClassCallbacks mListener;

    private ListView listView;



    public TheClassFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        id=mListener.getClassId();
        theClass=DataSupport.find(TheClass.class,id,true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (TheClassCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_the_class, container, false);
        listView=(ListView)view.findViewById(R.id.listView_class_student);
        listView.setAdapter(new StudentArrayAdapter(getActivity(),R.layout.listitem_student,0,theClass.getStudentArrayList()));
        return view;
    }


    private class StudentArrayAdapter extends ArrayAdapter<Student>{
        private List<Student> studentList;
        LayoutInflater layoutInflater;
        public StudentArrayAdapter(Context context, int resource,
                                         int textViewResourceId, List<Student> items) {
            super(context, resource, textViewResourceId,items);
            layoutInflater=(LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.studentList=items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=convertView;
            v=layoutInflater.inflate(R.layout.listitem_student,null);
            Student student=studentList.get(position);
            TextView textView=(TextView)v.findViewById(R.id.textView_student_name);
            TextView textView1=(TextView)v.findViewById(R.id.textView_student_number);
            ImageButton imageButton=(ImageButton)v.findViewById(R.id.imageButton2);
            ImageButton imageButton1=(ImageButton)v.findViewById(R.id.imageButton3);

            if(student!=null){
                textView.setText(student.getName());
                textView1.setText(student.getNumber());
            }
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


            return v;
        }
    }

    /**
     * 标记此学生已经签到
     * 次数加1，记录加上 student id
     * @return
     */
    private Boolean studentCallTheRoll(Student student,int id){
        for(AttendanceCount attendanceCount:theClass.getAttendanceCountList()){
            if(id==attendanceCount.getId())
                attendanceCount.setCount(attendanceCount.getCount()+1);
        }
        CallTheRollRecord callTheRollRecord=new CallTheRollRecord();
        callTheRollRecord.setStudent(student);
        callTheRollRecord.setCallTheRoll(callTheRoll);
        callTheRollRecord.setStatus(1);
        callTheRollRecord.save();

        callTheRoll.getCallTheRollRecord().add(callTheRollRecord);
        return true;
    }

    public static interface TheClassCallbacks{
        public int getClassId();
    }

}
