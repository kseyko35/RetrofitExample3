package com.example.retrofitexample3.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

class SecondStage implements Parcelable {
    private Integer block;
    private List<Payloads> payloads;

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public List<Payloads> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payloads> payloads) {
        this.payloads = payloads;
    }

    protected SecondStage(Parcel in) {
        if (in.readByte() == 0) {
            block = null;
        } else {
            block = in.readInt();
        }
    }

    public static final Creator<SecondStage> CREATOR = new Creator<SecondStage>() {
        @Override
        public SecondStage createFromParcel(Parcel in) {
            return new SecondStage(in);
        }

        @Override
        public SecondStage[] newArray(int size) {
            return new SecondStage[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (block == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(block);
        }
    }
}
