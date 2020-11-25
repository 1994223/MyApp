package com.studentcourses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class AvailableCourcesActivity extends AppCompatActivity {
    TextView tv_course1,tv_course2,tv_course3,tv_course4,tv_course5,tv_course6,tv_course7,tv_course8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_cources);


        getSupportActionBar().setTitle(getIntent().getStringExtra("college_name"));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_course1=(TextView)findViewById(R.id.tv_course1);
        tv_course2=(TextView)findViewById(R.id.tv_course2);
        tv_course3=(TextView)findViewById(R.id.tv_course3);
        tv_course4=(TextView)findViewById(R.id.tv_course4);
        tv_course5=(TextView)findViewById(R.id.tv_course5);
        tv_course6=(TextView)findViewById(R.id.tv_course6);
        tv_course7=(TextView)findViewById(R.id.tv_course7);
        tv_course8=(TextView)findViewById(R.id.tv_course8);

        tv_course1.setText(getIntent().getStringExtra("c1"));
        tv_course2.setText(getIntent().getStringExtra("c2"));
        tv_course3.setText(getIntent().getStringExtra("c3"));
        tv_course4.setText(getIntent().getStringExtra("c4"));
        tv_course5.setText(getIntent().getStringExtra("c5"));
        tv_course6.setText(getIntent().getStringExtra("c6"));
        tv_course7.setText(getIntent().getStringExtra("c7"));
        tv_course8.setText(getIntent().getStringExtra("c8"));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}