package com.example.retrofitexample3.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

class Payloads implements Parcelable {
    private String payload_id;
    private List<String> norad_id;
    private List<String> customers;
    private OrbitParams orbit_params;

    protected Payloads(Parcel in) {
        payload_id = in.readString();
        norad_id = in.createStringArrayList();
        customers = in.createStringArrayList();
    }

    public static final Creator<Payloads> CREATOR = new Creator<Payloads>() {
        @Override
        public Payloads createFromParcel(Parcel in) {
            return new Payloads(in);
        }

        @Override
        public Payloads[] newArray(int size) {
            return new Payloads[size];
        }
    };

    public String getPayload_id() {
        return payload_id;
    }

    public void setPayload_id(String payload_id) {
        this.payload_id = payload_id;
    }

    public List<String> getNorad_id() {
        return norad_id;
    }

    public void setNorad_id(List<String> norad_id) {
        this.norad_id = norad_id;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public OrbitParams getOrbit_params() {
        return orbit_params;
    }

    public void setOrbit_params(OrbitParams orbit_params) {
        this.orbit_params = orbit_params;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(payload_id);
        dest.writeStringList(norad_id);
        dest.writeStringList(customers);
    }
}
