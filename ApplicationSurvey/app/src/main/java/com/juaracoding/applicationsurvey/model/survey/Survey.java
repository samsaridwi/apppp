package com.juaracoding.applicationsurvey.model.survey;


import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Survey implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("umur")
    @Expose
    private String umur;
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("jawabA")
    @Expose
    private String jawabA;
    @SerializedName("jawabB")
    @Expose
    private String jawabB;
    @SerializedName("jawabC")
    @Expose
    private String jawabC;
    @SerializedName("tanda_tangan")
    @Expose
    private String tandaTangan;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("status")
    @Expose
    private String status;
    public final static Creator<Survey> CREATOR = new Creator<Survey>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Survey createFromParcel(Parcel in) {
            return new Survey(in);
        }

        public Survey[] newArray(int size) {
            return (new Survey[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3974300626180376883L;

    protected Survey(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.nama = ((String) in.readValue((String.class.getClassLoader())));
        this.alamat = ((String) in.readValue((String.class.getClassLoader())));
        this.umur = ((String) in.readValue((String.class.getClassLoader())));
        this.foto = ((String) in.readValue((String.class.getClassLoader())));
        this.latitude = ((String) in.readValue((String.class.getClassLoader())));
        this.longitude = ((String) in.readValue((String.class.getClassLoader())));
        this.jawabA = ((String) in.readValue((String.class.getClassLoader())));
        this.jawabB = ((String) in.readValue((String.class.getClassLoader())));
        this.jawabC = ((String) in.readValue((String.class.getClassLoader())));
        this.tandaTangan = ((String) in.readValue((String.class.getClassLoader())));
        this.tanggal = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Survey() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getJawabA() {
        return jawabA;
    }

    public void setJawabA(String jawabA) {
        this.jawabA = jawabA;
    }

    public String getJawabB() {
        return jawabB;
    }

    public void setJawabB(String jawabB) {
        this.jawabB = jawabB;
    }

    public String getJawabC() {
        return jawabC;
    }

    public void setJawabC(String jawabC) {
        this.jawabC = jawabC;
    }

    public String getTandaTangan() {
        return tandaTangan;
    }

    public void setTandaTangan(String tandaTangan) {
        this.tandaTangan = tandaTangan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(nama);
        dest.writeValue(alamat);
        dest.writeValue(umur);
        dest.writeValue(foto);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(jawabA);
        dest.writeValue(jawabB);
        dest.writeValue(jawabC);
        dest.writeValue(tandaTangan);
        dest.writeValue(tanggal);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
