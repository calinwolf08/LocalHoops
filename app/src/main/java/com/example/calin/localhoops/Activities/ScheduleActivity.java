package com.example.calin.localhoops.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.calin.localhoops.Fragments.CoachScheduleFragment;
import com.example.calin.localhoops.Fragments.PlayerScheduleFragment;
import com.example.calin.localhoops.R;
import com.example.calin.localhoops.Adapters.ScheduleListAdapter;
import com.example.calin.localhoops.ScheduleListDataPump;
import com.example.calin.localhoops.User;

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
    User userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.schedule_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment;

        if (extras != null) {
            userType = (User) extras.getSerializable("userType");

            switch (userType) {
                case ADMIN:
                    fragment = new CoachScheduleFragment();
                    fragmentTransaction.add(R.id.top_fragment, fragment, "coach_schedule_fragment");
                    fragmentTransaction.commit();
                    break;
                case COACH:
                    fragment = new CoachScheduleFragment();
                    fragmentTransaction.add(R.id.top_fragment, fragment, "coach_schedule_fragment");
                    fragmentTransaction.commit();
                    break;
                case PARENT:
                    fragment = new PlayerScheduleFragment();
                    fragmentTransaction.add(R.id.top_fragment, fragment, "player_schedule_fragment");
                    fragmentTransaction.commit();
                    break;
                case PLAYER:
                    fragment = new PlayerScheduleFragment();
                    fragmentTransaction.add(R.id.top_fragment, fragment, "player_schedule_fragment");
                    fragmentTransaction.commit();
                    break;
                default:
            }
        }

        scheduleListView = (ExpandableListView) findViewById(R.id.scheduleListView);
        scheduleListDetail = ScheduleListDataPump.getData();
        scheduleListTitle = new ArrayList<String>(scheduleListDetail.keySet());
        scheduleListAdapter = new ScheduleListAdapter(this, scheduleListTitle,
                scheduleListDetail);
        scheduleListView.setAdapter(scheduleListAdapter);

        setListViewListeners();

    }

    private void setListViewListeners() {
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

                        openEventActivity();

                        return true;
                    }
                });
    }

    public void openEventActivity() {
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }
}