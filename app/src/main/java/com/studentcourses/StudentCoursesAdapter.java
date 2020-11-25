package com.studentcourses;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.List;

public class StudentCoursesAdapter extends BaseAdapter {
    ProgressDialog progressDialog;
    List<CourcesPojo> courcesPojos;
    Context cnt;
    public StudentCoursesAdapter(List<CourcesPojo> ar, Context cnt)
    {
        this.courcesPojos=ar;
        this.cnt=cnt;
    }
    @Override
    public int getCount() {
        return courcesPojos.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int pos, View view, ViewGroup viewGroup)
    {
        LayoutInflater obj1 = (LayoutInflater)cnt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View obj2=obj1.inflate(R.layout.list_view_student_courses,null);

        TextView tv_clg_name=(TextView)obj2.findViewById(R.id.tv_clg_name);
        tv_clg_name.setText("College Name :"+courcesPojos.get(pos).getCollege_name());


        CardView card_view=(CardView)obj2.findViewById(R.id.card_view);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cnt,AvailableCourcesActivity.class);
                intent.putExtra("c1",courcesPojos.get(pos).getAvailable_course_1());
                intent.putExtra("c2",courcesPojos.get(pos).getAvailable_course_2());
                intent.putExtra("c3",courcesPojos.get(pos).getAvailable_course_3());
                intent.putExtra("c4",courcesPojos.get(pos).getAvailable_course_4());
                intent.putExtra("c5",courcesPojos.get(pos).getAvailable_course_5());
                intent.putExtra("c6",courcesPojos.get(pos).getAvailable_course_6());
                intent.putExtra("c7",courcesPojos.get(pos).getAvailable_course_7());
                intent.putExtra("c8",courcesPojos.get(pos).getAvailable_course_8());
                intent.putExtra("college_name",courcesPojos.get(pos).getCollege_name());

                cnt.startActivity(intent);
                //((Activity)cnt).finish();

            }
        });



        return obj2;
    }

}