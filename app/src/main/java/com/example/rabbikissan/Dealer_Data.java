package com.example.rabbikissan;

public class Dealer_Data {

    private String dealerName;
    private String dealerArea;
    private String dealerImage;
    private String dealerNumber;
    private String dealerId;

    public Dealer_Data(){

    }

    public Dealer_Data(String dealerName, String dealerArea, String dealerImage, String dealerNumber,String dealerId) {
        this.dealerName = dealerName;
        this.dealerArea = dealerArea;
        this.dealerImage = dealerImage;
        this.dealerNumber = dealerNumber;
        this.dealerId = dealerId;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }
    public String getDealerName() {
        return dealerName;
    }

    public void setDealerArea(String dealerArea) {
        this.dealerArea = dealerArea;
    }
    public String getDealerArea() {
        return dealerArea;
    }

    public void setDealerImage(String dealerImage) {
        this.dealerImage = dealerImage;
    }
    public String getDealerImage() {
        return dealerImage;
    }
    public void setDealerNumber(String dealerNumber) {
        this.dealerNumber = dealerNumber;
    }
    public String getDealerNumber() {
        return dealerNumber;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }
    
     public String getDealerId(){ return dealerId; }
}
