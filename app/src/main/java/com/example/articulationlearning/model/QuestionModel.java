package com.example.articulationlearning.model;

import com.example.articulationlearning.R;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class QuestionModel implements Serializable {
    int position;
    private int image;
    private int indexAnswer;
    private List<String> multipleChoice;
    public QuestionModel(int position){
        this.position=position;
        if(position==0) {
            image = R.drawable.banjir;
            multipleChoice = Arrays.asList("Hujan", "Rumah", "Banjir", "Gempa");
            indexAnswer = 2;
        }if(position==1) {
            image = R.drawable.kebakaran;
            multipleChoice = Arrays.asList("Banjir", "Hujan", "Gempa", "Kebakaran");
            indexAnswer = 3;
        }
        else{
            image= R.drawable.tsunami;
            multipleChoice= Arrays.asList("Tsunami","Angin", "Gempa", "Bencana");
            indexAnswer=0;
        }
    }

    public int getImage() {
        return image;
    }

    public List<String> getMultipleChoice() {
        return multipleChoice;
    }

    public int getIndexAnswer() {
        return indexAnswer;
    }
}
