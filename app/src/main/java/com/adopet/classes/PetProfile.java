package com.adopet.classes;

import android.media.Image;
import java.util.Date;

public class PetProfile {
    private Image mainImg;
    private int ageNum;
    private String name, breed, description, size, ageType;
    private Date publishDate;
    private SourceProfile source;

    public PetProfile(Image img, int ageNum, String ageType, String name, String breed, String size, Date date, String desc) {
        setMainImg(img);
        setAge(ageNum, ageType);
        setName(name);
        setBreed(breed);
        setSize(size);
        setPublishDate(date);
        setDescription(desc);
    }

    //Sets
    public void setMainImg(Image mainImg) { this.mainImg = mainImg; }
    public void setAge(int age, String ageType) {
        this.ageNum = age;
        this.ageType = ageType;
    }
    public void setName(String name) { this.name = name; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setPublishDate(Date publishDate) { this.publishDate = publishDate; }
    public void setDescription(String description) { this.description = description; }
    public void setSize(String size) { this.size = size; }
    public void setSource(SourceProfile source) { this.source = source;}

    //Gets
    public Image getMainImg() { return mainImg; }
    public String getName() { return name; }
    public int getAgeNum() { return ageNum; }
    public String getAgeType() { return ageType; }
    public String getBreed() { return breed; }
    public String getSize() { return size; }
    public String getDescription() { return description; }
    public Date getPublishDate() { return publishDate; }
    public SourceProfile getSource() { return source; }

}
