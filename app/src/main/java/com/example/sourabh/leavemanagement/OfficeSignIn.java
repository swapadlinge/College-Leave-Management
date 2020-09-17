package com.example.sourabh.leavemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OfficeSignIn extends AppCompatActivity {
    //**************************************
   private String OfficePassword = "111";
    //*****************************
    EditText editTextPassword;
    Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_sign_in);

        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignIn = findViewById(R.id.buttonLogIn);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextPassword.getText().toString().trim().equals(OfficePassword)) {
                    Toast.makeText(OfficeSignIn.this, "Login SuccessFull", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(OfficeSignIn.this, OfficeHomePage.class));
                }
                else
                {
                    Toast.makeText(OfficeSignIn.this, "Enter Valid Password", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
