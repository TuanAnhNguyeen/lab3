package com.example.lab3;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SaffModel {
    private String name;
    private String photo;
    private Date ngaySinh;
    private boolean gender;
    private boolean married;
    private String country;
    private String note;
    private String[] hobbies;

    public SaffModel() {
    }

//    public SaffModel(String name, Date ngaySinh, boolean gender, boolean married, String country, String note, String[] hobbies) {
//        this.name = name;
//        this.ngaySinh = ngaySinh;
//        this.gender = gender;
//        this.married = married;
//        this.country = country;
//        this.note = note;
//        this.hobbies = hobbies;
//    }

    public SaffModel(String name, String photo, Date ngaySinh, boolean gender, boolean married, String country, String note, String[] hobbies) {
        this.name = name;
        this.photo = photo;
        this.ngaySinh = ngaySinh;
        this.gender = gender;
        this.married = married;
        this.country = country;
        this.note = note;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public String toString() {
        if(hobbies==null){
            return "";
        }
        String soThich = "";
            for (int i = 0; i < hobbies.length; i++) {
                if (hobbies[i].equals("R")) {
                    soThich = soThich + "Đọc Sách, ";
                }
                if (hobbies[i].equals("T")) {
                    soThich = soThich + "Du Lịch, ";
                }
                if (hobbies[i].equals("M")) {
                    soThich = soThich + "Nghe Nhạc, ";
                }
                if (hobbies[i].equals("O")) {
                    soThich = soThich + "Khác ";
                }
            }
            return soThich;
    }

    public String convertNgaySinh() {
        return new SimpleDateFormat("yyyy-mm-dd").format(ngaySinh);
    }
}
