package com.example.calin.localhoops.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calin.localhoops.R;

/**
 * Created by Calin on 10/30/2016.
 */

public class PlayerScheduleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.player_schedule_fragment, null);
        return v;
    }
}
