package com.adopet.classes;

import android.location.Address;
import android.location.Location;
import android.media.Image;
import android.text.format.Time;


public class SourceProfile {
    private Image sourceImg;
    private String name, region, info;
    private String location;
    private String address;

    public void setSourceImg(Image sourceImg) { this.sourceImg = sourceImg; }
    public void setRegion(String region) { this.region = region; }
    public void setLocation(String location) { this.location = location; }
}
