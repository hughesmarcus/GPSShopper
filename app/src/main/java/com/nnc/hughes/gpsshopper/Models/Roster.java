package com.nnc.hughes.gpsshopper.Models;

/**
 * Created by marcus on 7/26/17.
 */
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Roster implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("position")
    @Expose
    private String position;
    public final static Parcelable.Creator<Roster> CREATOR = new Creator<Roster>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Roster createFromParcel(Parcel in) {
            Roster instance = new Roster();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.imageUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.position = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Roster[] newArray(int size) {
            return (new Roster[size]);
        }

    }
            ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(imageUrl);
        dest.writeValue(position);
    }

    public int describeContents() {
        return 0;
    }

}