package com.example.retrofitexample3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseModel implements Parcelable {
    private int flight_number;
    private String mission_name;
    private Boolean is_tentative;
    private Rocket rocket;

    protected BaseModel(Parcel in) {
        flight_number = in.readInt();
        mission_name = in.readString();
        byte tmpIs_tentative = in.readByte();
        is_tentative = tmpIs_tentative == 0 ? null : tmpIs_tentative == 1;
        rocket = in.readParcelable(Rocket.class.getClassLoader());
    }

    public static final Creator<BaseModel> CREATOR = new Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel in) {
            return new BaseModel(in);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public Boolean getIs_tentative() {
        return is_tentative;
    }

    public void setIs_tentative(Boolean is_tentative) {
        this.is_tentative = is_tentative;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(flight_number);
        dest.writeString(mission_name);
        dest.writeByte((byte) (is_tentative == null ? 0 : is_tentative ? 1 : 2));
        dest.writeParcelable(rocket, flags);
    }
}
