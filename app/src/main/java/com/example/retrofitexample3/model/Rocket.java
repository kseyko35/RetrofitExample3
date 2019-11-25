package com.example.retrofitexample3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Rocket implements Parcelable {

    private String rocket_id;
    private FirstStage first_stage;
    private SecondStage second_stage;

    protected Rocket(Parcel in) {
        rocket_id = in.readString();
    }

    public static final Creator<Rocket> CREATOR = new Creator<Rocket>() {
        @Override
        public Rocket createFromParcel(Parcel in) {
            return new Rocket(in);
        }

        @Override
        public Rocket[] newArray(int size) {
            return new Rocket[size];
        }
    };

    public String getRocket_id() {
        return rocket_id;
    }

    public void setRocket_id(String rocket_id) {
        this.rocket_id = rocket_id;
    }

    public FirstStage getFirst_stage() {
        return first_stage;
    }

    public void setFirst_stage(FirstStage first_stage) {
        this.first_stage = first_stage;
    }

    public SecondStage getSecond_stage() {
        return second_stage;
    }

    public void setSecond_stage(SecondStage second_stage) {
        this.second_stage = second_stage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rocket_id);
    }
}
