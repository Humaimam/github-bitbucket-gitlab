package com.example.joyeco;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class faq_adapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

    Activity activity;
    JSONArray jsonObject;
    public faq_adapter(Activity activity, JSONArray jsonObject){
        this.activity = activity;
        this.jsonObject = jsonObject;
    }

    @Override
    public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.expanded_item, parent, false);
            TextView title = (TextView)convertView.findViewById(R.id.subText);
            try {
                title.setText(((JSONObject)getGroup(groupPosition)).getString("subtitle"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return convertView;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public int getGroupCount() {
        return this.jsonObject.length();
    }

    @Override
    public Object getGroup(int groupPosition) {
        try {
            return this.jsonObject.get(groupPosition);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.common_list_item, parent, false);
            TextView title = (TextView)convertView.findViewById(R.id.comName);
            ImageView leadingIcon = (ImageView) convertView.findViewById(R.id.leadingIcon);
            leadingIcon.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_baseline_east_24));
            try {
                title.setText(((JSONObject)getGroup(groupPosition)).getString("title"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }}