package com.adopet.classes;

import android.location.Address;
import android.location.Location;
import android.media.Image;
import android.text.format.Time;


public class SourceProfile {
    private Image sourceImg;
    private String name, region, info;
    private Location location;
    private Address address;

    public void setSourceImg(Image sourceImg) { this.sourceImg = sourceImg; }

    public void setRegion(String region) {
        this.region = region;

    }
}
