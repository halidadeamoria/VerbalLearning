package com.example.articulationlearning.model;

import com.example.articulationlearning.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum VocalEnum {
    WORDS, SENTENCES, TITLE, SUBTTITLE, DESC, VIDEO,WORDS_VOICE, SENTENCES_VOICE;

    public List<Integer> getData() {
        if (this == WORDS) {
            return  Arrays.asList(
                    R.array.words_vocal_a,
                    R.array.words_vocal_i,
                    R.array.words_vocal_u,
                    R.array.words_vocal_e,
                    R.array.words_vocal_o
            );
        } else if (this == SENTENCES) {
            return Arrays.asList(
                    R.array.sentences_vocal_a,
                    R.array.sentences_vocal_i,
                    R.array.sentences_vocal_u,
                    R.array.sentences_vocal_e,
                    R.array.sentences_vocal_0
            );
        } else if (this == TITLE) {
            return Arrays.asList(
                    R.string.title_a,
                    R.string.title_i,
                    R.string.title_u,
                    R.string.title_e,
                    R.string.title_0
            );
        } else if (this == DESC) {
            return  Arrays.asList(
                    R.string.text_vocal_a,
                    R.string.text_vocal_i,
                    R.string.text_vocal_u,
                    R.string.text_vocal_e,
                    R.string.text_vocal_o
            );
        } else if (this == VIDEO) {
            return Arrays.asList(
                    R.raw.vokal_huruf_a,
                    R.raw.vokal_huruf_i,
                    R.raw.vokal_huruf_u,
                    R.raw.vokal_huruf_e,
                    R.raw.vokal_huruf_o
            );
        } else {
            return  Arrays.asList(
                    R.string.subtitle_a,
                    R.string.subtitle_i,
                    R.string.subtitle_u,
                    R.string.subtitle_e,
                    R.string.subtitle_0
            );
        }
    }
    public List<Integer> getData(int index) {
        if (this == WORDS_VOICE) {
            if (index == 0) {
                return Arrays.asList(
                        R.raw.vocal_a_1,
                        R.raw.vocal_a_2,
                        R.raw.vocal_a_3,
                        R.raw.vocal_a_4,
                        R.raw.vocal_a_5
                );
            }else if (index == 1) {
                return Arrays.asList(
                        R.raw.vocal_i_1,
                        R.raw.vocal_i_2,
                        R.raw.vocal_i_3,
                        R.raw.vocal_i_4,
                        R.raw.vocal_i_5
                );
            }else if (index == 2) {
                return Arrays.asList(
                        R.raw.vocal_u_1,
                        R.raw.vocal_u_2,
                        R.raw.vocal_u_3,
                        R.raw.vocal_u_4,
                        R.raw.vocal_u_5
                );
            }else if (index == 3) {
                return Arrays.asList(
                        R.raw.vocal_e_1,
                        R.raw.vocal_e_2,
                        R.raw.vocal_e_3,
                        R.raw.vocal_e_4,
                        R.raw.vocal_e_5
                );
            }
            else if (index == 4) {
                return Arrays.asList(
                        R.raw.vocal_o_1,
                        R.raw.vocal_o_2,
                        R.raw.vocal_o_3,
                        R.raw.vocal_o_4,
                        R.raw.vocal_o_5
                );
            }else {
                return new ArrayList<>();
            }

        } else if (this == SENTENCES_VOICE) {
            if (index == 0) {
                return Arrays.asList(
                        R.raw.sentence_vocal_a_1,
                        R.raw.sentence_vocal_a_2,
                        R.raw.sentence_vocal_a_3,
                        R.raw.sentence_vocal_a_4,
                        R.raw.sentence_vocal_a_5
                );
            }else if (index == 1) {
                return Arrays.asList(
                        R.raw.sentence_vocal_i_1,
                        R.raw.sentence_vocal_i_2,
                        R.raw.sentence_vocal_i_3,
                        R.raw.sentence_vocal_i_4,
                        R.raw.sentence_vocal_i_5
                );
            }else if (index == 2) {
                return Arrays.asList(
                        R.raw.sentence_vocal_u_1,
                        R.raw.sentence_vocal_u_2,
                        R.raw.sentence_vocal_u_3,
                        R.raw.sentence_vocal_u_4,
                        R.raw.sentence_vocal_u_5
                );
            }else if (index == 3) {
                return Arrays.asList(
                        R.raw.sentence_vocal_e_1,
                        R.raw.sentence_vocal_e_2,
                        R.raw.sentence_vocal_e_3,
                        R.raw.sentence_vocal_e_4,
                        R.raw.sentence_vocal_e_5
                );
            }else if (index == 4) {
                return Arrays.asList(
                        R.raw.sentence_vocal_o_1,
                        R.raw.sentence_vocal_o_2,
                        R.raw.sentence_vocal_o_3,
                        R.raw.sentence_vocal_o_4,
                        R.raw.sentence_vocal_o_5
                );
            } else {
                return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }
}
