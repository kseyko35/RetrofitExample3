package com.example.retrofitexample3.model;

import android.os.Parcel;
import android.os.Parcelable;

class OrbitParams implements Parcelable {

    private String reference_system;
    private Object semi_major_axis_km = null;

    protected OrbitParams(Parcel in) {
        reference_system = in.readString();
    }

    public static final Creator<OrbitParams> CREATOR = new Creator<OrbitParams>() {
        @Override
        public OrbitParams createFromParcel(Parcel in) {
            return new OrbitParams(in);
        }

        @Override
        public OrbitParams[] newArray(int size) {
            return new OrbitParams[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(reference_system);
    }

    public String getReference_system() {
        return reference_system;
    }

    public void setReference_system(String reference_system) {
        this.reference_system = reference_system;
    }

    public Object getSemi_major_axis_km() {
        return semi_major_axis_km;
    }

    public void setSemi_major_axis_km(Object semi_major_axis_km) {
        this.semi_major_axis_km = semi_major_axis_km;
    }
}
