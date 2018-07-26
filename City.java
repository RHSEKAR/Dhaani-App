package com.example.jojo.dhaaniapp;

public class City {
    private String cityName, Desc, link, cityImage;

    public City()
    {}

    public City(String softwareName, String softwareDesc, String downloadLink, String image) {
        this.cityName = softwareName;
        this.Desc = softwareDesc;
        this.link = downloadLink;
        this.cityImage = image;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCityImage() {
        return cityImage;
    }

    public void setCityImage(String cityImage) {
        this.cityImage = cityImage;
    }
}
