package model;

public class Location {
    private String province;
    private String district;
    private String sector;
    private String cell;
    private String village;

    public Location(String province, String district, String sector, String cell, String village) {
        this.province = province;
        this.district = district;
        this.sector = sector;
        this.cell = cell;
        this.village = village;
    }

    public String getProvince() {
        return province;
    }
}
