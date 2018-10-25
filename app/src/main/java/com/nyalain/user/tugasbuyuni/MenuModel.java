package com.nyalain.user.tugasbuyuni;

import java.io.Serializable;

public class MenuModel implements Serializable {

    private String judul_menu;
    private String deskripsi_menu;
    private int image_menu;

    public String getJudul_menu() {
        return judul_menu;
    }

    public void setJudul_menu(String judul_menu) {
        this.judul_menu = judul_menu;
    }

    public String getDeskripsi_menu() {
        return deskripsi_menu;
    }

    public void setDeskripsi_menu(String deskripsi_menu) {
        this.deskripsi_menu = deskripsi_menu;
    }

    public int getImage_menu() {
        return image_menu;
    }

    public void setImage_menu(int image_menu) {
        this.image_menu = image_menu;
    }
}