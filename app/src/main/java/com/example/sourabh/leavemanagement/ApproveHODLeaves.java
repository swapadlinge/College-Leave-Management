package com.example.sourabh.leavemanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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

public class ApproveHODLeaves extends AppCompatActivity {

    private ListView listViewLeaves;
    List<Leaves> leaveList;
    DatabaseReference databaseLeaves;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_hodleaves);

        listViewLeaves = (ListView)findViewById(R.id.listViewApprove) ;


        leaveList = new ArrayList<>();
        databaseLeaves = FirebaseDatabase.getInstance().getReference("HOD Leaves");

        listViewLeaves.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Leaves leaves = leaveList.get(position);
                showUpdateDialog(leaves.getId(),leaves.getName(),leaves.getDept(),leaves.getDays(),leaves.getDate(),leaves.getMonth(),leaves.getYear(),leaves.getReason(),leaves.getStatus());

                return false;
            }
        });

        Query query = FirebaseDatabase.getInstance().getReference("HOD Leaves")
                .orderByChild("dept");


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
            LeaveList adaptor = new LeaveList(ApproveHODLeaves.this,leaveList);
            listViewLeaves.setAdapter(adaptor);



        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };


//************************************************************************
private void showUpdateDialog(final String id, final String name, final String dept, final String days, final String date, final String month, final String year, final String reason, String status)
{
    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

    LayoutInflater inflater = getLayoutInflater();

    final View dialogView = inflater.inflate(R.layout.update_dialog,null);

    dialogBuilder.setView(dialogView);

    final Spinner spinnerStauts = (Spinner) dialogView.findViewById(R.id.spinnerStatus);
    Button buttonPublish = (Button) dialogView.findViewById(R.id.buttonPublish);

    dialogBuilder.setTitle("Approving Leave of "+name);

    final AlertDialog alertDialog = dialogBuilder.create();
    alertDialog.show();


    buttonPublish.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String stat = spinnerStauts.getSelectedItem().toString();
            updateLeaves(id,name,dept,days,date,month,year,reason,stat);

            alertDialog.dismiss();

            Intent intent = getIntent();
            finish();
            startActivity(intent);

        }
    });



}

    private void updateLeaves(String id , String name ,String dept ,String days ,String date ,String month ,String year ,String reason ,String status )
    {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("HOD Leaves").child(id);

        Leaves leaves = new Leaves(id,name,dept,days,date,month,year,reason,status);
        databaseReference.setValue(leaves);

        Toast.makeText(this,"Published SuccessFully",Toast.LENGTH_LONG).show();

    }





}
