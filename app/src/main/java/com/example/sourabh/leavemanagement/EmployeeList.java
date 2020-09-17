package com.example.sourabh.leavemanagement;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class EmployeeList extends ArrayAdapter<EmployeeProfile> {

    private Activity context;
    private List<EmployeeProfile> empList;

    public EmployeeList(Activity context, List<EmployeeProfile> empList)
    {
        super(context,R.layout.emp_list_layout,empList);
        this.context = context;
        this.empList = empList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.emp_list_layout,null,true);





        TextView textViewEName = (TextView) listViewItem.findViewById(R.id.textViewEname);
        TextView textViewEEmail = (TextView) listViewItem.findViewById(R.id.textViewEEmail);
        TextView textViewEDept = (TextView) listViewItem.findViewById(R.id.textViewEDept);
        TextView textViewEDOJ = (TextView) listViewItem.findViewById(R.id.textViewEDOJ);





        EmployeeProfile emp = empList.get(position);

        textViewEName.setText(emp.getName());
        textViewEEmail.setText(emp.getEmailid());
        textViewEDept.setText(emp.getDept());
        textViewEDOJ.setText(emp.getDoj());

        return listViewItem;

    }

}
