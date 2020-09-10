package com.adopet.classes;

import android.location.Address;
import android.location.Location;
import android.media.Image;
import android.text.format.Time;


public class SourceProfile {
    private Image sourceImg;
    private String name, region, info, location, address;

    //Sets
    public void setSourceImg(Image sourceImg) { this.sourceImg = sourceImg; }
    public void setName(String name) { this.name = name; }
    public void setRegion(String region) { this.region = region; }
    public void setInfo(String info) { this.info = info; }
    public void setLocation(String location) { this.location = location; }
    public void setAddress(String address) { this.address = address; }

    //Gets
    public Image getSourceImg() { return sourceImg; }
    public String getName() { return name; }
    public String getRegion() { return region; }
    public String getInfo() { return info; }
    public String getLocation() { return location; }
    public String getAddress() { return address; }
}
