package com.example.retrofitexample3.model;//package com.example.myapplication.model;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//public class RocketRespModel implements Parcelable {
//
//    private String rocket_id;
//    private FirstStage first_stage;
//    private SecondStage second_stage;
//
//    protected RocketRespModel(Parcel in) {
//        rocket_id = in.readString();
//        first_stage = in.readString();
//        second_stage = in.readString();
//    }
//
//    public static final Creator<RocketRespModel> CREATOR = new Creator<RocketRespModel>() {
//        @Override
//        public RocketRespModel createFromParcel(Parcel in) {
//            return new RocketRespModel(in);
//        }
//
//        @Override
//        public RocketRespModel[] newArray(int size) {
//            return new RocketRespModel[size];
//        }
//    };
//
//    public String getId() {
//        return rocket_id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(id);
//        dest.writeString(name);
//        dest.writeString(desc);
//    }
//}
