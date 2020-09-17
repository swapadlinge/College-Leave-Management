package com.example.sourabh.leavemanagement;

import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewEmpLeaves extends AppCompatActivity {

    ListView listViewLeaves;
    List<Leaves> leaveList;

    DatabaseReference databaseLeaves;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_emp_leaves);

        listViewLeaves = (ListView)findViewById(R.id.listView) ;

        leaveList = new ArrayList<>();

        databaseLeaves = FirebaseDatabase.getInstance().getReference("Employee Leaves");

        Query query = FirebaseDatabase.getInstance().getReference("Employee Leaves")
                .orderByChild("date");

        query.addListenerForSingleValueEvent(valueEventListener);





    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            leaveList.clear();
            for(DataSnapshot leaveSnapshot : dataSnapshot.getChildren())
            {

                Leaves leaves = leaveSnapshot.getValue(Leaves.class);
                leaveList.add(leaves);
            }
            LeaveList adaptor = new LeaveList(ViewEmpLeaves.this,leaveList);
            listViewLeaves.setAdapter(adaptor);



        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };


}
