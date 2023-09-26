package com.example.articulationlearning.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.articulationlearning.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearningModel implements Parcelable {

    private Integer ascii;

    public LearningModel() {

    }

    protected LearningModel(Parcel in) {
        if (in.readByte() == 0) {
            ascii = null;
        } else {
            ascii = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (ascii == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(ascii);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LearningModel> CREATOR = new Creator<LearningModel>() {
        @Override
        public LearningModel createFromParcel(Parcel in) {
            return new LearningModel(in);
        }

        @Override
        public LearningModel[] newArray(int size) {
            return new LearningModel[size];
        }
    };

    public Integer getIdVideo(int type) {
        if (type == 1) {
            return KonsonanEnum.VIDEO.getData().get(ascii);
        } else if (type == 2) {
            return VocalEnum.VIDEO.getData().get(ascii);
        } else if (type == 3) {
            return DwiHurufDiftongEnum.VIDEO.getData().get(ascii);
        } else {
            return DwiHurufDigrafEnum.VIDEO.getData().get(ascii);
        }
    }


    public Integer getAscii() {
        return 97 + ascii;
    }

    public void setAscii(Integer ascii) {
        this.ascii = ascii;
    }

    public Integer getDesc(int type) {
        if (type == 1) {
            return KonsonanEnum.DESC.getData().get(ascii);
        } else if (type == 2) {
            return VocalEnum.DESC.getData().get(ascii);
        } else if (type == 3) {
            return DwiHurufDiftongEnum.DESC.getData().get(ascii);
        } else {
            return DwiHurufDigrafEnum.DESC.getData().get(ascii);
        }
    }


    public Integer getWords(int type) {
        if (type == 1) {
            return KonsonanEnum.WORDS.getData().get(ascii);
        } else if (type == 2) {
            return VocalEnum.WORDS.getData().get(ascii);
        } else if (type == 3) {
            return DwiHurufDiftongEnum.WORDS.getData().get(ascii);
        } else {
            return DwiHurufDigrafEnum.WORDS.getData().get(ascii);
        }
    }


    public Integer getSentences(int type) {
        if (type == 1) {
            return KonsonanEnum.SENTENCES.getData().get(ascii);
        } else if (type == 2) {
            return VocalEnum.SENTENCES.getData().get(ascii);
        } else if (type == 3) {
            return DwiHurufDiftongEnum.SENTENCES.getData().get(ascii);
        } else {
            return DwiHurufDigrafEnum.SENTENCES.getData().get(ascii);
        }
    }


    public Integer getTitle(int type) {
        if (type == 2) {
            return VocalEnum.TITLE.getData().get(ascii);
        } else if (type == 3) {
            return DwiHurufDiftongEnum.TITLE.getData().get(ascii);
        } else {
            return DwiHurufDigrafEnum.TITLE.getData().get(ascii);
        }
    }


    public Integer getSubtitle(int type) {
        if (type == 2) {
            return VocalEnum.SUBTTITLE.getData().get(ascii);
        } else if (type == 3) {
            return DwiHurufDiftongEnum.SUBTTITLE.getData().get(ascii);
        } else {
            return DwiHurufDigrafEnum.SUBTTITLE.getData().get(ascii);
        }
    }

    public List<Integer> getWordVoice(int type) {
        if (type == 3) {
            return DwiHurufDiftongEnum.WORDS_VOICE.getData(ascii);
        } else if (type == 4) {
            return DwiHurufDigrafEnum.WORDS_VOICE.getData(ascii);
        } else if (type == 2) {
            return VocalEnum.WORDS_VOICE.getData(ascii);
        } else if (type == 1) {
            return KonsonanEnum.WORDS_VOICE.getData(ascii);
        } else {
            return new ArrayList<>();
        }
    }

    public List<Integer> getSentencesVoice(int type) {
        if (type == 3) {
            return DwiHurufDiftongEnum.SENTENCES_VOICE.getData(ascii);
        } else if (type == 4) {
            return DwiHurufDigrafEnum.SENTENCES_VOICE.getData(ascii);
        } else if (type == 2) {
            return VocalEnum.SENTENCES_VOICE.getData(ascii);
        } else if (type == 1) {
            return KonsonanEnum.SENTENCES_VOICE.getData(ascii);
        } else {
            return new ArrayList<>();
        }
    }
}
