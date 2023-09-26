package com.example.projectvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BusList extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;
    List<String> ListdataHeader;
    HashMap<String,List<String>> Listdatachild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);

        prepareListData();

        expandableListView=findViewById(R.id.idExpandableListView);
        customAdapter=new CustomAdapter(this,ListdataHeader,Listdatachild);
        expandableListView.setAdapter(customAdapter);
    }
    public void prepareListData()
    {
        String[] headerString=getResources().getStringArray(R.array.BusListHeader);
        String[] childString=getResources().getStringArray(R.array.BusListChild);

        ListdataHeader=new ArrayList<>();
        Listdatachild=new HashMap<>();

        for (int i=0;i<headerString.length;i++)
        {
            //adding hader data
            ListdataHeader.add(headerString[i]);
            List<String> child=new ArrayList<>();
            child.add(childString[i]);
            Listdatachild.put(ListdataHeader.get(i),child);
        }
    }
}