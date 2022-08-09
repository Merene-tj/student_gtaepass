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


public class OneClassHodAdapter extends ArrayAdapter<OneClassHod> {

    Context mCtx;
    int listLayoutRes;
    List<OneClassHod> employeeListt;
    SQLiteDatabase mDatabase;
    TextView oneview, twoview, threeview, fourview,fiveview,sixview,sevenview,eightview,nineview;
    Button bt;
    TextView roll,name;


    public OneClassHodAdapter(@NonNull Context context, int resource, List<OneClassHod> employeeList, SQLiteDatabase mDatabase) {
        super(context, resource, employeeList);
        this.mCtx = context;
        this.listLayoutRes = resource;
        this.employeeListt = employeeList;
        this.mDatabase = mDatabase;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        final OneClassHod employee = employeeListt.get(position);

        oneview = view.findViewById(R.id.hstunaveview);
        twoview = view.findViewById(R.id.hstuidview);
        threeview = view.findViewById(R.id.hstudateview);
        fourview = view.findViewById(R.id.hsturequestview);
        fiveview = view.findViewById(R.id.hstupnumview);
        sixview = view.findViewById(R.id.hstfrequestview);
        sevenview = view.findViewById(R.id.hstfcommentview);
        eightview = view.findViewById(R.id.hhodrequestview);
        nineview = view.findViewById(R.id.hhodcommentview);

        bt = view.findViewById(R.id.hodselectbt);

        oneview.setText(employee.getOnone());
        twoview.setText(employee.getOntwo());
        threeview.setText(employee.getOnthree());
        fourview.setText(employee.getOnfour());
        fiveview.setText(employee.getOnfive());
        sixview.setText(employee.getOnsix());
        sevenview.setText(employee.getOnseven());
        eightview.setText(employee.getOneight());
        nineview.setText(employee.getOnnine());

//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String txt1= oneview.getText().toString();
//                String txt2 = twoview.getText().toString();
//                String txt3 = threeview.getText().toString();
//                String txt4 = fourview.getText().toString();
//                String txt5 = fiveview.getText().toString();
//                String txt6 = sixview.getText().toString();
//                String txt7 = sevenview.getText().toString();
//                String txt8 = eightview.getText().toString();
//
//
//
//                Intent in = new Intent(mCtx,AdminViewActivity.class);
//                in.putExtra("1", txt1);
//                in.putExtra("2",txt2);
//                in.putExtra("3",txt3);
//                in.putExtra("4",txt4);
//                in.putExtra("5",txt5);
//                in.putExtra("6",txt6);
//                in.putExtra("7",txt7);
//                in.putExtra("8",txt8);
//
//                mCtx.startActivity(in);
//            }
//        });






        return view;

    }
}
