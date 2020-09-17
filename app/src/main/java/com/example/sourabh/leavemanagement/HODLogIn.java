package com.example.sourabh.leavemanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HODLogIn extends AppCompatActivity {

    //*****************************************************
    String ComputerDepartmentPassword = "111";
    String ExtcDeaprtmentPassword = "333";
    String CivilDepartmentPassword = "222";
    String ProductionDepartmentPassword="444";
    String ElectricalDepartmentPassword="555";
    //****************************************************

  private  Spinner spinnerDept;
   private EditText editTextPasssword;
   private Button buttonLogin;
   TextView txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hodlog_in);

        spinnerDept= findViewById(R.id.spinnerDept);
        editTextPasssword = findViewById(R.id.editTextPass);
        buttonLogin = findViewById(R.id.buttonHODLogin);
        txt = findViewById(R.id.textViewDeptView);




        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if((spinnerDept.getSelectedItem().toString().equals("Computer")) && editTextPasssword.getText().toString().trim().equals(ComputerDepartmentPassword))
                {

                    Toast.makeText(HODLogIn.this,"Login Success",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(HODLogIn.this,HODHomePage.class);
                    intent.putExtra("Dept",spinnerDept.getSelectedItem().toString());
                    startActivity(intent);
                }
                else if((spinnerDept.getSelectedItem().toString().equals("Civil")) && editTextPasssword.getText().toString().trim().equals(CivilDepartmentPassword))
                {
                    Toast.makeText(HODLogIn.this,"Login Success",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(HODLogIn.this,HODHomePage.class);
                    intent.putExtra("Dept",spinnerDept.getSelectedItem().toString());
                    startActivity(intent);
                }
                else if((spinnerDept.getSelectedItem().toString().equals("Extc")) && editTextPasssword.getText().toString().trim().equals(ExtcDeaprtmentPassword))
                {
                    Toast.makeText(HODLogIn.this,"Login Success",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(HODLogIn.this,HODHomePage.class);
                    intent.putExtra("Dept",spinnerDept.getSelectedItem().toString());
                    startActivity(intent);
                }
                else if((spinnerDept.getSelectedItem().toString().equals("Production")) && editTextPasssword.getText().toString().trim().equals(ProductionDepartmentPassword))
                {
                    Toast.makeText(HODLogIn.this,"Login Success",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(HODLogIn.this,HODHomePage.class);
                    intent.putExtra("Dept",spinnerDept.getSelectedItem().toString());
                    startActivity(intent);
                }
                else if((spinnerDept.getSelectedItem().toString().equals("Electrical")) && editTextPasssword.getText().toString().trim().equals(ElectricalDepartmentPassword))
                {
                    Toast.makeText(HODLogIn.this,"Login Success",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(HODLogIn.this,HODHomePage.class);
                    intent.putExtra("Dept",spinnerDept.getSelectedItem().toString());
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(HODLogIn.this,"Enter Valid Password",Toast.LENGTH_LONG).show();
                }


            }
        });

    }

}
