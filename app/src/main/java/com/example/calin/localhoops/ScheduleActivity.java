package com.example.calin.localhoops;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.calin.localhoops.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Calin on 9/20/2016.
 */
public class ScheduleActivity extends AppCompatActivity {

    ExpandableListView scheduleListView;
    ExpandableListAdapter scheduleListAdapter;
    List<String> scheduleListTitle;
    HashMap<String, List<String>> scheduleListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        scheduleListView = (ExpandableListView)
                findViewById(R.id.scheduleListView);
        scheduleListDetail = ScheduleListDataPump.getData();
        scheduleListTitle = new ArrayList<String>(scheduleListDetail.keySet());
        scheduleListAdapter = new ScheduleListAdapter(this, scheduleListTitle,
                scheduleListDetail);
        scheduleListView.setAdapter(scheduleListAdapter);
        scheduleListView.setOnGroupExpandListener(
            new ExpandableListView.OnGroupExpandListener() {
                @Override
                public void onGroupExpand(int groupPosition) {
                    Toast.makeText(getApplicationContext(),
                            scheduleListTitle.get(groupPosition) + " List Expanded.",
                            Toast.LENGTH_SHORT).show();
                }
        });

        scheduleListView.setOnGroupCollapseListener(
            new ExpandableListView.OnGroupCollapseListener() {
                @Override
                public void onGroupCollapse(int groupPosition) {
                    Toast.makeText(getApplicationContext(),
                            scheduleListTitle.get(groupPosition) + " List Collapsed.",
                            Toast.LENGTH_SHORT).show();
                }
        });

        scheduleListView.setOnChildClickListener(
            new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    Toast.makeText(
                            getApplicationContext(),
                            scheduleListTitle.get(groupPosition)
                                    + " -> "
                                    + scheduleListDetail.get(
                                    scheduleListTitle.get(groupPosition)).get(
                                    childPosition), Toast.LENGTH_SHORT
                    ).show();

                    return false;
                }
        });
    }
}
