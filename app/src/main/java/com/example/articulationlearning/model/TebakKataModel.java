package com.example.articulationlearning.model;

import com.example.articulationlearning.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TebakKataModel {
    private int id;
    private ArrayList<ItemOptionModel> multipleChoice;
    private String correctAnswer = "";
    private Boolean isImageQuestion;
    private int image;

    public TebakKataModel(int id) {
        this.id = id;
        if (id == 0) {
            image = R.drawable.ic_pembelajaran;
            isImageQuestion = false;
            correctAnswer = "Novita dan kania mengikuti latihan simulasi bencana";
            multipleChoice = new ArrayList<ItemOptionModel>(Arrays.asList(
                    new ItemOptionModel(0, "Bencana")
                    , new ItemOptionModel(1, "Novita")
                    , new ItemOptionModel(2, "latihan")
                    , new ItemOptionModel(3, "dan")
                    , new ItemOptionModel(4, "simulasi")
                    , new ItemOptionModel(5, "Kania")
                    , new ItemOptionModel(6, "mengikuti")));
        } else if (id == 1) {
            image = R.drawable.ic_pembelajaran_2;
            isImageQuestion = true;
            correctAnswer = "kebakaran";
            multipleChoice = new ArrayList<ItemOptionModel>(Arrays.asList(
                    new ItemOptionModel(1, "K")
                    , new ItemOptionModel(2, "E")
                    , new ItemOptionModel(3, "B")
                    , new ItemOptionModel(4, "A")
                    , new ItemOptionModel(5, "K")
                    , new ItemOptionModel(6, "A")
                    , new ItemOptionModel(7, "R")
                    , new ItemOptionModel(7, "A")
                    , new ItemOptionModel(7, "N")
            ));
        } else {
            image = R.drawable.ic_pembelajaran;
            isImageQuestion = false;
            correctAnswer = "Saya bernama novita merasa sangat dingin sekali";
            multipleChoice = new ArrayList<ItemOptionModel>(Arrays.asList(
                    new ItemOptionModel(1, "Saya")
                    , new ItemOptionModel(2, "Novita")
                    , new ItemOptionModel(3, "bernama")
                    , new ItemOptionModel(4, "dingin")
                    , new ItemOptionModel(5, "merasa")
                    , new ItemOptionModel(6, "sangat")
                    , new ItemOptionModel(7, "sekali")));
        }
    }

    public ArrayList<ItemOptionModel> getMultipleChoice() {
        return multipleChoice;
    }

    public Boolean getIsImageQuestion() {
        return isImageQuestion;
    }

    public int getImage() {
        return image;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
