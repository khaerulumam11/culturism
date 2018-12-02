package com.example.khaerulumam.culturism.model;

public class ListTempatData {
    String namatempat;
    int id;

    public ListTempatData(){

    }

    public ListTempatData (int id, String namatempat){
        this.id = id;
        this.namatempat = namatempat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamatempat() {
        return namatempat;
    }

    public void setNamatempat(String namatempat) {
        this.namatempat = namatempat;
    }
}
