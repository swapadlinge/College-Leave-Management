package com.example.sourabh.leavemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HODHomePage extends AppCompatActivity {

    Button buttonApproveLeave,buttonViewEmployee,buttonApplyLeave;

    Button buttonLogoutHod;

     String CurrentDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hodhome_page);


        CurrentDepartment = getIntent().getExtras().getString("Dept");

        buttonLogoutHod = findViewById(R.id.buttonLogoutHod);

        buttonApproveLeave = findViewById(R.id.buttonApproveLeaves);
        buttonApplyLeave = findViewById(R.id.buttonApplyLeave);
        buttonViewEmployee = findViewById(R.id.buttonViewEmployee);

        buttonLogoutHod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HODHomePage.this,MainActivity.class));
            }
        });

        buttonApproveLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HODHomePage.this,HODLeaveApproval.class);
                intent.putExtra("Department",CurrentDepartment);
                startActivity(intent);

            }
        });

        buttonApplyLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HODHomePage.this, ApplyHODLeave.class));
            }
        });

        buttonViewEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HODHomePage.this,ViewEmployee.class));

            }
        });



    }
}
