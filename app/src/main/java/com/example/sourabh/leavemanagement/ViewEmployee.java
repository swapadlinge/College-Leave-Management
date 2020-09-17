package com.example.sourabh.leavemanagement;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewEmployee extends AppCompatActivity {



    ListView listViewEmp;
    List<EmployeeProfile> empList;

    DatabaseReference databaseEmp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);

        listViewEmp = (ListView)findViewById(R.id.ListViewEmp) ;

        empList = new ArrayList<>();

        databaseEmp = FirebaseDatabase.getInstance().getReference("Employee");


        Query query1 = FirebaseDatabase.getInstance().getReference("Employee")
                .orderByChild("dept");

        query1.addListenerForSingleValueEvent(valueEventListener);


    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            empList.clear();
            for(DataSnapshot empSnapshot : dataSnapshot.getChildren())
            {

                EmployeeProfile employeeProfile = empSnapshot.getValue(EmployeeProfile.class);
                empList.add(employeeProfile);
            }
            EmployeeList adaptor = new EmployeeList(ViewEmployee.this,empList);
            listViewEmp.setAdapter(adaptor);



        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}
