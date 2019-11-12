package com.juaracoding.applicationsurvey.model.survey;


import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable, Parcelable
{

    @SerializedName("survey")
    @Expose
    private List<Survey> survey = null;
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
    private final static long serialVersionUID = -1204513606221955622L;

    protected Data(Parcel in) {
        in.readList(this.survey, (com.juaracoding.applicationsurvey.model.survey.Survey.class.getClassLoader()));
    }

    public Data() {
    }

    public List<Survey> getSurvey() {
        return survey;
    }

    public void setSurvey(List<Survey> survey) {
        this.survey = survey;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(survey);
    }

    public int describeContents() {
        return  0;
    }

}
