/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author smallgod
 */
public class DBScheduleString {

    @SerializedName("schedule")
    @Expose
    private List<Schedule> schedule = null;

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    public class Schedule {

        @SerializedName("time")
        @Expose
        private Time time;
        @SerializedName("day")
        @Expose
        private List<String> day = null;

        public Time getTime() {
            return time;
        }

        public void setTime(Time time) {
            this.time = time;
        }

        public List<String> getDay() {
            return day;
        }

        public void setDay(List<String> day) {
            this.day = day;
        }

        public class Time {

            @SerializedName("slot")
            @Expose
            private String slot;
            @SerializedName("preferred")
            @Expose
            private Integer preferred;

            public String getSlot() {
                return slot;
            }

            public void setSlot(String slot) {
                this.slot = slot;
            }

            public Integer getPreferred() {
                return preferred;
            }

            public void setPreferred(Integer preferred) {
                this.preferred = preferred;
            }

        }

    }

}
