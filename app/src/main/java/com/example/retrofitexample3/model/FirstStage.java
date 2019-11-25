package com.example.retrofitexample3.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class FirstStage implements Parcelable {

    private List<Core> cores= null;

    protected FirstStage(Parcel in) {
    }

    public static final Creator<FirstStage> CREATOR = new Creator<FirstStage>() {
        @Override
        public FirstStage createFromParcel(Parcel in) {
            return new FirstStage(in);
        }

        @Override
        public FirstStage[] newArray(int size) {
            return new FirstStage[size];
        }
    };

    public List<Core> getCores() {
        return cores;
    }

    public void setCores(List<Core> cores) {
        this.cores = cores;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
