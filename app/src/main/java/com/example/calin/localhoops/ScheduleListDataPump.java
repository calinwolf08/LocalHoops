package com.example.calin.localhoops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Calin on 9/20/2016.
 * Will fetch schedule data
 */
public class ScheduleListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail =
                new HashMap<String, List<String>>();

        List<String> todayEvents = new ArrayList<String>();
        todayEvents.add("Practice 7pm - 8pm 6/14");
        todayEvents.add("Team Meeting 8pm - 8:30pm 6/14");

        List<String> tomorrowEvents = new ArrayList<String>();
        tomorrowEvents.add("Game 1 10am 6/15");
        tomorrowEvents.add("Game 2 12pm 6/15");

        List<String> thisWeekEvents = new ArrayList<String>();
        thisWeekEvents.add("Game TBD 6/16");

        List<String> comingUpEvents = new ArrayList<String>();
        comingUpEvents.add("Tournament 7/4");
        comingUpEvents.add("Tournament 7/20");

        expandableListDetail.put("Today", todayEvents);
        expandableListDetail.put("Tomorrow", tomorrowEvents);
        expandableListDetail.put("This Week", thisWeekEvents);
        expandableListDetail.put("Coming Up", comingUpEvents);

        return expandableListDetail;
    }
}
