package com.example.rabbikissan;

public class HomeData {
    private String schemeName;
    private String schmeDesc;
    private int schmeImage;

    public HomeData(String schemeName, String schmeDesc, int schmeImage) {
        this.schemeName = schemeName;
        this.schmeDesc = schmeDesc;
        this.schmeImage = schmeImage;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public String getSchmeDesc() {
        return schmeDesc;
    }

    public int getSchmeImage() {
        return schmeImage;
    }
}

