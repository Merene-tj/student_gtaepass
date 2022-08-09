package com.example.hp.gatepass;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class OneClassStaffAdapter extends ArrayAdapter<OneClassStaff> {

    Context mCtx;
    int listLayoutRes;
    List<OneClassStaff> employeeListt;
    SQLiteDatabase mDatabase;
    TextView oneview, twoview, threeview, fourview,fiveview,sixview,sevenview;
    Button bt;
    TextView roll,name;


    public OneClassStaffAdapter(@NonNull Context context, int resource, List<OneClassStaff> employeeList, SQLiteDatabase mDatabase) {
        super(context, resource, employeeList);
        this.mCtx = context;
        this.listLayoutRes = resource;
        this.employeeListt = employeeList;
        this.mDatabase = mDatabase;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        final OneClassStaff employee = employeeListt.get(position);

        oneview = view.findViewById(R.id.sstunaveview);
        twoview = view.findViewById(R.id.sstuidview);
        threeview = view.findViewById(R.id.sstudateview);
        fourview = view.findViewById(R.id.ssturequestview);
        fiveview = view.findViewById(R.id.sstupnumview);
        sixview = view.findViewById(R.id.sstudentresponse);
        sevenview = view.findViewById(R.id.sstudentcomment);

        bt = view.findViewById(R.id.sstuselectbt);

        oneview.setText(employee.getOnone());
        twoview.setText(employee.getOntwo());
        threeview.setText(employee.getOnthree());
        fourview.setText(employee.getOnfour());
        fiveview.setText(employee.getOnfive());
        sixview.setText(employee.getOnsix());
        sevenview.setText(employee.getOnseven());

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt1= oneview.getText().toString();
                String txt2 = twoview.getText().toString();
                String txt3 = threeview.getText().toString();
                String txt4 = fourview.getText().toString();
                String txt5 = fiveview.getText().toString();
                String txt6 = sixview.getText().toString();
                String txt7 = sevenview.getText().toString();

                Intent in = new Intent(mCtx,HODRequestActivity.class);
                in.putExtra("1", txt1);
                in.putExtra("2",txt2);
                in.putExtra("3",txt3);
                in.putExtra("4",txt4);
                in.putExtra("5",txt5);
                in.putExtra("6",txt6);
                in.putExtra("7",txt7);

                mCtx.startActivity(in);
            }
        });
        return view;
    }
}
