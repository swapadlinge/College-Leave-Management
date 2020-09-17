package com.example.sourabh.leavemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OfficeHomePage extends AppCompatActivity {

    Button buttonApproveHODLeave;
    Button buttonViewEmployee;

    Button buttonLogoutOffice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_home_page);
        buttonApproveHODLeave = findViewById(R.id.buttonApproveHodLeave);

        buttonLogoutOffice=findViewById(R.id.buttonOfficeLogout);

        buttonLogoutOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OfficeHomePage.this,MainActivity.class));
            }
        });

        buttonApproveHODLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OfficeHomePage.this,ApproveHODLeaves.class));
            }
        });


        buttonViewEmployee = findViewById(R.id.buttonViewEmployee);
        buttonViewEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OfficeHomePage.this,ViewEmployee.class));
            }
        });

    }
}
