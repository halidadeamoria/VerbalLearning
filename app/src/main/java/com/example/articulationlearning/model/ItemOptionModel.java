package com.example.articulationlearning.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ItemOptionModel implements Serializable {
    private int id;
    private String text;
    private boolean isSelected;
    private List<String> multipleChoice;
    public ItemOptionModel(int id, String text){
        this.id= id;
        this.text=text;
        if(id==0){
            multipleChoice= Arrays.asList("Bencana","Novita", "latihan", "dan", "simulasi", "Kania", "mengikuti");
        }else if(id==1){
            multipleChoice= Arrays.asList("Saya","Mengikuti", "anda");
        }else{
            multipleChoice= Arrays.asList("Saya","Mengikuti", "anda");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
