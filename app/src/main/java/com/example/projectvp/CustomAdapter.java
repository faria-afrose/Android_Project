package com.example.projectvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends BaseExpandableListAdapter {

    private Context context;
    List<String> ListdataHeader;
    HashMap<String,List<String>> Listdatachild;

    //constructor


    public CustomAdapter(Context context, List<String> listdataHeader, HashMap<String, List<String>> listdatachild) {
        this.context = context;
        ListdataHeader = listdataHeader;
        Listdatachild = listdatachild;
    }

    @Override
    public int getGroupCount() {
        return ListdataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return Listdatachild.get(ListdataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return ListdataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return Listdatachild.get(ListdataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerText= (String)getGroup(groupPosition);

        if(convertView==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.buslistgrouplayout,null);
        }

       TextView textView= convertView.findViewById(R.id.idheadertextview);
        textView.setText(headerText);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String childText= (String) getChild(groupPosition,childPosition);

        if(convertView==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.buslistchildlayout,null);
        }

        TextView textView= convertView.findViewById(R.id.idchildtextview);
        textView.setText(childText);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
