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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddEmployee extends AppCompatActivity {

    private EditText EmpId,DOJ,EmpName,Password;
    private Spinner EmpDept;
    private Button Register;
    private TextView userLogin;

    private FirebaseAuth firebaseAuth;
    private String emailid,name,dept,doj,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        EmpId = findViewById(R.id.editTextEmpId);
        EmpName = findViewById(R.id.editTextEmpName);
        DOJ = findViewById(R.id.editTextDOJ);
        Password = findViewById(R.id.editTextPassword);
        EmpDept = findViewById(R.id.spinnerEmpDept);
        Register = findViewById(R.id.buttonRegister);
        userLogin = findViewById(R.id.userLogin);


        firebaseAuth= firebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    //upload the data to database
                    String user_Email = EmpId.getText().toString().trim();
                    String user_password = Password.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_Email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //sendemailverification();
                                sendUerData();
                                Toast.makeText(AddEmployee.this,"Successfully Registered,Upload completed!!",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AddEmployee.this,HomeActivity.class));

                            }
                            else{
                                Toast.makeText(AddEmployee.this, "Please Enter Valid Data !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddEmployee.this,MainActivity.class));
            }
        });
    }


    private Boolean validate(){
        Boolean result = false;
        name = EmpName.getText().toString();
        password = Password.getText().toString();
        emailid = EmpId.getText().toString();
        doj = DOJ.getText().toString();
        dept = EmpDept.getSelectedItem().toString();

            if (name.isEmpty() || password.isEmpty() || emailid.isEmpty() || doj.isEmpty() || dept.isEmpty() ){
                Toast.makeText(this,"Please Enter all the details",Toast.LENGTH_SHORT).show();
            }
            result = true;

        return result;
    }



    public void sendUerData(){

       DatabaseReference dbRef= FirebaseDatabase.getInstance().getReference("Employee");
        EmployeeProfile userProfile = new EmployeeProfile(emailid,name,dept,doj);
        dbRef.child(name).setValue(userProfile);
    }
}
