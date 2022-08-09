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


public class OneClassAdapter extends ArrayAdapter<OneClass> {

    Context mCtx;
    int listLayoutRes;
    List<OneClass> employeeListt;
    SQLiteDatabase mDatabase;
    TextView oneview, twoview, threeview, fourview,fiveview;
    Button bt;
    TextView roll,name;


    public OneClassAdapter(@NonNull Context context, int resource, List<OneClass> employeeList, SQLiteDatabase mDatabase) {
        super(context, resource, employeeList);
        this.mCtx = context;
        this.listLayoutRes = resource;
        this.employeeListt = employeeList;
        this.mDatabase = mDatabase;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        final OneClass employee = employeeListt.get(position);

        oneview = view.findViewById(R.id.stunaveview);
        twoview = view.findViewById(R.id.stuidview);
        threeview = view.findViewById(R.id.studateview);
        fourview = view.findViewById(R.id.sturequestview);
        fiveview = view.findViewById(R.id.stupnumview);

        bt = view.findViewById(R.id.stuselectbt);

        oneview.setText(employee.getOnone());
        twoview.setText(employee.getOntwo());
        threeview.setText(employee.getOnthree());
        fourview.setText(employee.getOnfour());
        fiveview.setText(employee.getOnfive());

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt1= oneview.getText().toString();
                String txt2 = twoview.getText().toString();
                String txt3 = threeview.getText().toString();
                String txt4 = fourview.getText().toString();
                String txt5 = fiveview.getText().toString();

                Intent in = new Intent(mCtx,StaffRequestActivity.class);
                in.putExtra("1", txt1);
                in.putExtra("2",txt2);
                in.putExtra("3",txt3);
                in.putExtra("4",txt4);
                in.putExtra("5",txt5);

                mCtx.startActivity(in);
            }
        });






        return view;

    }
}
