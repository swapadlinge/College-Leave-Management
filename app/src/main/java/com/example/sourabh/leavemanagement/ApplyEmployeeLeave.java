package com.example.sourabh.leavemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyEmployeeLeave extends AppCompatActivity {

    EditText editTextName;
    Spinner spinnerDept,spinnerDays,spinnerDate,spinnerMonth,spinnerYear;
    EditText editTextReason;
    Button buttonApply;

    DatabaseReference databaseLeaves;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_employee_leave);

        editTextName = findViewById(R.id.editTextName);

        spinnerDept = findViewById(R.id.spinnerDept);
        spinnerDays = findViewById(R.id.spinnerDays);
        spinnerDate = findViewById(R.id.spinnerDate);
        spinnerMonth = findViewById(R.id.spinnerMonth);
        spinnerYear = findViewById(R.id.spinnerYear);

        editTextReason = findViewById(R.id.editTextReason);
        buttonApply = findViewById(R.id.buttonApply);

        databaseLeaves = FirebaseDatabase.getInstance().getReference("Employee Leaves");


        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                applyLeave();

            }
        });

        List<String> Dept= new ArrayList<String>();
        List <String> Date = new ArrayList<String>();
        List <String> Month= new ArrayList<String>();
        List <String> Year = new ArrayList<String>();
        List <String> Days = new ArrayList<String>();


        Dept.add("Computer");
        Dept.add("Extc");
        Dept.add("Production");
        Dept.add("Civil");
        Dept.add("Electrical");

        Date.add("1");
        Date.add("2");
        Date.add("3");
        Date.add("4");
        Date.add("5");
        Date.add("6");
        Date.add("7");
        Date.add("8");
        Date.add("9");
        Date.add("10");
        Date.add("11");
        Date.add("12");
        Date.add("13");
        Date.add("14");
        Date.add("15");
        Date.add("16");
        Date.add("17");
        Date.add("18");
        Date.add("19");
        Date.add("20");
        Date.add("21");
        Date.add("22");
        Date.add("23");
        Date.add("24");
        Date.add("25");
        Date.add("26");
        Date.add("27");
        Date.add("28");
        Date.add("29");
        Date.add("30");
        Date.add("31");



        Month.add("01");
        Month.add("02");
        Month.add("03");
        Month.add("04");
        Month.add("05");
        Month.add("06");
        Month.add("07");
        Month.add("08");
        Month.add("09");
        Month.add("10");
        Month.add("11");
        Month.add("12");

        Year.add("2018");
        Year.add("2019");

        Days.add("1");
        Days.add("2");
        Days.add("3");
        Days.add("4");
        Days.add("5");
        Days.add("6");
        Days.add("7");
        Days.add("8");
        Days.add("9");
        Days.add("10");

        //******************************************************
        ArrayAdapter<String> DeptAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Dept);
        ArrayAdapter<String> DateAdaptor = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Date);
        ArrayAdapter<String> MonthAdaptor = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Month);
        ArrayAdapter<String> YearAdaptor = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Year);
        ArrayAdapter<String> DaysAdaptor = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Days);
        //*********************************************************

        DeptAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDept.setAdapter(DeptAdapter);

        spinnerDept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerDept.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //*****************************************************************************
        DateAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDate.setAdapter(DateAdaptor);

        spinnerDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerDate.setSelection(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        MonthAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(MonthAdaptor);

        spinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerMonth.setSelection(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //*****************************************************************************************************888

        YearAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(YearAdaptor);


        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerYear.setSelection(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        DaysAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDays.setAdapter(DaysAdaptor);


        spinnerDays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerDays.setSelection(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    }

    public void applyLeave()
    {
        String empName = editTextName.getText().toString().trim();
        String department = spinnerDept.getSelectedItem().toString();
        String days = spinnerDays.getSelectedItem().toString();
        String date = spinnerDate.getSelectedItem().toString();
        String month = spinnerMonth.getSelectedItem().toString();
        String year = spinnerYear.getSelectedItem().toString();
        String reason = editTextReason.getText().toString().trim();
        String status = "Pending";


             if (!TextUtils.isEmpty(empName))

             {
                 String id = databaseLeaves.push().getKey();

                 Leaves leaves = new Leaves(id, empName, department, days, date, month, year, reason, status);
                 databaseLeaves.child(id).setValue(leaves);
                 Toast.makeText(this, "Added SuccessFully !!!!", Toast.LENGTH_LONG).show();
             }
             else {
                 Toast.makeText(this, "Please Enter Employee Name", Toast.LENGTH_LONG).show();
             }
    }





}
