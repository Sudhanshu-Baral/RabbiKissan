package com.example.rabbikissan;

public class RiceRate {
    private String date;
    private String rice_name;
    private String rice_type;
    private String rate;




    private int rice_image;
    private int inc_dec;



    public RiceRate( String date,String rice_name, String rice_type, String rate, int rice_image,int inc_dec) {
        this.date=date;
        this.rice_name = rice_name;
        this.rice_type=rice_type;
        this.rate = rate;
        this.rice_image = rice_image;
        this.inc_dec=inc_dec;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public String getRice_name() {
        return rice_name;
    }

    public void setRice_name(String rice_name) {
        this.rice_name = rice_name;
    }
    public String getRice_type() {
        return rice_type;
    }

    public void setRice_type(String rice_type) {
        this.rice_type = rice_type;
    }
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }


    public int getRice_image() {
        return rice_image;
    }

    public void setRice_image(int rice_image) {
        this.rice_image = rice_image;
    }
    public int getInc_dec() {
        return inc_dec;
    }

    public void setInc_dec(int inc_dec) {
        this.inc_dec = inc_dec;
    }
}
