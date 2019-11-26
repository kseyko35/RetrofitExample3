package com.example.retrofitexample3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Links implements Parcelable {

    private String mission_patch;
    private String wikipedia;

    public String getMission_patch() {
        return mission_patch;
    }

    public void setMission_patch(String mission_patch) {
        this.mission_patch = mission_patch;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    protected Links(Parcel in) {
        mission_patch = in.readString();
        wikipedia = in.readString();
    }

    public static final Creator<Links> CREATOR = new Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mission_patch);
        dest.writeString(wikipedia);
    }
}
