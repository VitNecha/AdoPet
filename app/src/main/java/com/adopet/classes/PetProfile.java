package com.adopet.classes;

import android.media.Image;

import com.google.firebase.firestore.DocumentReference;

import java.util.Date;

public class PetProfile {
    //private Image mainImg;
    private int ageNum;
    private String mainImg, name, breed, description, size, publishDate, ageType;
    //private Date publishDate;
    private DocumentReference source;
    private SourceProfile sourceProfile;

    public PetProfile(){ super(); }
    public PetProfile(String img, int ageNum, String ageType, String name, String breed, String size, String date, String desc) {
        setMainImg(img);
        setAge(ageNum, ageType);
        setName(name);
        setBreed(breed);
        setSize(size);
        setPublishDate(date);
        setDescription(desc);
    }

    //Sets
    public void setMainImg(String mainImg) { this.mainImg = mainImg; }
    public void setAge(int age, String ageType) {
        this.ageNum = age;
        this.ageType = ageType;
    }
    public void setName(String name) { this.name = name; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }
    public void setDescription(String description) { this.description = description; }
    public void setSize(String size) { this.size = size; }
    public void setSource(DocumentReference source) { this.source = source;}
    public void setSourceProfile(SourceProfile sourceProfile) { this.sourceProfile = sourceProfile; }

    //Gets
    public String getMainImg() { return mainImg; }
    public String getName() { return name; }
    public int getAgeNum() { return ageNum; }
    public String getAgeType() { return ageType; }
    public String getBreed() { return breed; }
    public String getSize() { return size; }
    public String getDescription() { return description; }
    public String getPublishDate() { return publishDate; }
    public DocumentReference getSource() { return source; }
    public SourceProfile getSourceProfile() { return sourceProfile; }
}
