package com.juaracoding.herjuaracoding;

import android.os.Parcel;
import android.os.Parcelable;


public class ModelData implements Parcelable {

    private String nama;
    private String alamat;


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public ModelData() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.alamat);
    }

    protected ModelData(Parcel in) {
        this.nama = in.readString();
        this.alamat = in.readString();
    }

    public static final Creator<ModelData> CREATOR = new Creator<ModelData>() {
        @Override
        public ModelData createFromParcel(Parcel source) {
            return new ModelData(source);
        }

        @Override
        public ModelData[] newArray(int size) {
            return new ModelData[size];
        }
    };
}