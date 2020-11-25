package com.studentcourses;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class StudentDashboardActivity extends AppCompatActivity {
    ListView list_view;
    List<CourcesPojo> courcesPojos;
    ProgressDialog progressDialog;
    StudentCoursesAdapter studentCoursesAdapter;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);


        getSupportActionBar().setTitle(" Home");
        db = FirebaseFirestore.getInstance();


        courcesPojos = new ArrayList<>();

        list_view=(ListView)findViewById(R.id.list_view);
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait data is being Loaded");
        progressDialog.show();
        GetAdvisorDetails();

    }

    public void GetAdvisorDetails() {
        db.collection("Colleges")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                CourcesPojo homeDataPojo = document.toObject(CourcesPojo.class);
                                courcesPojos.add(homeDataPojo);
                            }
                            studentCoursesAdapter = new StudentCoursesAdapter(courcesPojos, StudentDashboardActivity.this);
                            list_view.setAdapter(studentCoursesAdapter);

                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
}