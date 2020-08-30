package com.adopet.classes;

import android.media.Image;
import java.util.Date;

public class PetProfile {
    private Image mainImg;
    private int age;
    private String name, breed, description;
    private Date publishDate;

    public PetProfile(Image img, int age, String name, String breed, Date date, String desc) {
        setMainImg(img);
        setAge(age);
        setName(name);
        setBreed(breed);
        setPublishDate(date);
        setDescription(desc);
    }

    public void setMainImg(Image mainImg) { this.mainImg = mainImg; }
    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setPublishDate(Date publishDate) { this.publishDate = publishDate; }
    public void setDescription(String description) { this.description = description; }
}
