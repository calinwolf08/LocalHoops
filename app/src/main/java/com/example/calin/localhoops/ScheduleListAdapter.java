package com.example.calin.localhoops;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Calin on 9/20/2016.
 */
public class ScheduleListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> scheduleListTitle;
    private HashMap<String, List<String>> scheduleListDetail;

    public ScheduleListAdapter(Context context, List<String> scheduleListTitle,
                               HashMap<String, List<String>> scheduleListDetail) {
        this.context = context;
        this.scheduleListTitle = scheduleListTitle;
        this.scheduleListDetail = scheduleListDetail;
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.scheduleListDetail.get(this.scheduleListTitle.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.scheduleListTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.scheduleListDetail
                .get(this.scheduleListTitle.get(groupPosition))
                .get(childPosition);
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
        String listTitle = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)
                    this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.schedule_list_group, null);
        }

        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.scheduleListGroup);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String scheduleListText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.schedule_list_item, null);
        }

        TextView scheduleListItem = (TextView) convertView
                .findViewById(R.id.scheduleListItem);
        scheduleListItem.setText(scheduleListText);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
