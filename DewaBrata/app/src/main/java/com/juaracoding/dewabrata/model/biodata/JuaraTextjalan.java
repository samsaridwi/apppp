
package com.juaracoding.dewabrata.model.biodata;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JuaraTextjalan implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("dari")
    @Expose
    private String dari;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("status")
    @Expose
    private String status;
    public final static Creator<JuaraTextjalan> CREATOR = new Creator<JuaraTextjalan>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JuaraTextjalan createFromParcel(Parcel in) {
            return new JuaraTextjalan(in);
        }

        public JuaraTextjalan[] newArray(int size) {
            return (new JuaraTextjalan[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7176950366686106012L;

    protected JuaraTextjalan(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.dari = ((String) in.readValue((String.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.time = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JuaraTextjalan() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDari() {
        return dari;
    }

    public void setDari(String dari) {
        this.dari = dari;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(dari);
        dest.writeValue(text);
        dest.writeValue(time);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
