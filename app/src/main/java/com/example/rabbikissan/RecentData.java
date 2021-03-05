package com.example.rabbikissan;

public class RecentData {
    String Name;
    String Area;
    String id;
    Integer imageUrl;



    public RecentData(String name, String area, String id, Integer imageUrl) {
        Name = name;
        Area = area;
        this.id = id;
        this.imageUrl=imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
