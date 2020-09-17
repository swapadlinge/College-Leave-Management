package com.example.sourabh.leavemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button logout;

    Button buttonEmployeeLeave;
    Button buttonViewLeaves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.buttonLogut);

        buttonEmployeeLeave= (Button)findViewById(R.id.buttonApplyLeave);
        buttonViewLeaves = findViewById(R.id.buttonViewLeaves);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });
        buttonViewLeaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ViewEmpLeaves.class));

            }
        });

        buttonEmployeeLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this,ApplyEmployeeLeave.class));

            }
        });


    }

    private void Logout(){

        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(HomeActivity.this,MainActivity.class));

    }


}
