package com.adopet.classes;

import android.location.Address;
import android.location.Location;
import android.media.Image;
import android.text.format.Time;


public class SourceProfile {
    //private Image sourceImg;
    private String sourceImg, name, phone, region, info, address;

    //Sets
    public void setSourceImg(String sourceImg) { this.sourceImg = sourceImg; }
    public void setName(String name) { this.name = name; }
    public void setRegion(String region) { this.region = region; }
    public void setInfo(String info) { this.info = info; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }

    //Gets
    public String getSourceImg() { return sourceImg; }
    public String getName() { return name; }
    public String getRegion() { return region; }
    public String getInfo() { return info; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
}
