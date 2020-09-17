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

public class LeaveList extends ArrayAdapter<Leaves>
{
    private Activity context;
    private List<Leaves> leavesList;

    public LeaveList(Activity context, List<Leaves> leavesList)
    {
        super(context,R.layout.list_layout,leavesList);
        this.context = context;
        this.leavesList = leavesList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);





        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewDept = (TextView) listViewItem.findViewById(R.id.textViewDept);
        TextView textViewDate = (TextView) listViewItem.findViewById(R.id.textViewDate);
        TextView textViewMonth = (TextView) listViewItem.findViewById(R.id.textViewMonth);
        TextView textViewYear = (TextView) listViewItem.findViewById(R.id.textViewYear);
        TextView textViewDays = (TextView) listViewItem.findViewById(R.id.textViewDays);
        TextView textViewReason = (TextView) listViewItem.findViewById(R.id.textViewReason);
        TextView textViewStatus = (TextView) listViewItem.findViewById(R.id.textViewStatus);




        Leaves leaves = leavesList.get(position);

        textViewName.setText(leaves.getName());
        textViewDept.setText(leaves.getDept());
        textViewDate.setText(leaves.getDate());
        textViewMonth.setText(leaves.getMonth());
        textViewYear.setText(leaves.getYear());
        textViewDays.setText(leaves.getDays());
        textViewReason.setText(leaves.getReason());
        textViewStatus.setText(leaves.getStatus());

        return listViewItem;

    }

}
