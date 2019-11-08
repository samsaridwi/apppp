
package com.juaracoding.dewabrata.model.biodata;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable, Parcelable
{

    @SerializedName("juara_textjalan")
    @Expose
    private List<JuaraTextjalan> juaraTextjalan = null;
    public final static Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
    ;
    private final static long serialVersionUID = 6265393029735830742L;

    protected Data(Parcel in) {
        in.readList(this.juaraTextjalan, (com.juaracoding.dewabrata.model.biodata.JuaraTextjalan.class.getClassLoader()));
    }

    public Data() {
    }

    public List<JuaraTextjalan> getJuaraTextjalan() {
        return juaraTextjalan;
    }

    public void setJuaraTextjalan(List<JuaraTextjalan> juaraTextjalan) {
        this.juaraTextjalan = juaraTextjalan;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(juaraTextjalan);
    }

    public int describeContents() {
        return  0;
    }

}
