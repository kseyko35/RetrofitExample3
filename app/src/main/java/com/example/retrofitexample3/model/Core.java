package com.example.retrofitexample3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Core implements Parcelable {


    private  String core_serial;
    private Integer flight;
    private Object block;

    protected Core(Parcel in) {
        core_serial = in.readString();
        if (in.readByte() == 0) {
            flight = null;
        } else {
            flight = in.readInt();
        }
    }

    public static final Creator<Core> CREATOR = new Creator<Core>() {
        @Override
        public Core createFromParcel(Parcel in) {
            return new Core(in);
        }

        @Override
        public Core[] newArray(int size) {
            return new Core[size];
        }
    };

    public String getCore_serial() {
        return core_serial;
    }

    public void setCore_serial(String core_serial) {
        this.core_serial = core_serial;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Object getBlock() {
        return block;
    }

    public void setBlock(Object block) {
        this.block = block;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(core_serial);
        if (flight == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(flight);
        }
    }
}
