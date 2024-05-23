package com.sp.DTO;

public class InfoDTO {
    private String info;

    public InfoDTO(String info) {
        this.info = info;
    }
    public InfoDTO(){
    this.info = "";
    }
    public String getInfo() {
        return info;
    }
    public String setInfo(String info) {
        this.info = info;
        return info;
    }
}

