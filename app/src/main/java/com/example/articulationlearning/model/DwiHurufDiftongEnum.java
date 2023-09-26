package com.example.articulationlearning.model;

import com.example.articulationlearning.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum DwiHurufDiftongEnum {
    WORDS,VIDEO, SENTENCES, TITLE, SUBTTITLE, DESC, WORDS_VOICE, SENTENCES_VOICE;

    public List<Integer> getData() {
        if (this == WORDS) {
            return Arrays.asList(
                    R.array.words_diftong_ai,
                    R.array.words_diftong_au,
                    R.array.words_diftong_ei,
                    R.array.words_diftong_oi
            );
        } else if (this == SENTENCES) {
            return Arrays.asList(
                    R.array.sentences_diftong_ai,
                    R.array.sentences_diftong_au,
                    R.array.sentences_diftong_ei,
                    R.array.sentences_diftong_oi
            );
        } else if (this == TITLE) {
            return Arrays.asList(
                    R.string.title_dwitong_ai,
                    R.string.title_dwitong_au,
                    R.string.title_dwitong_ei,
                    R.string.title_dwitong_oi
            );
        } else if (this == DESC) {
            return Arrays.asList(
                    R.string.text_diftong_ai,
                    R.string.text_diftong_au,
                    R.string.text_diftong_ei,
                    R.string.text_diftong_oi
            );
        }else if (this == VIDEO) {
            return Arrays.asList(
                    R.raw.vokal_huruf_a,
                    R.raw.vokal_huruf_i,
                    R.raw.vokal_huruf_u,
                    R.raw.vokal_huruf_e,
                    R.raw.vokal_huruf_o
            );
        } else {
            return Arrays.asList(
                    R.string.subtitle_dwitong_ai,
                    R.string.subtitle_dwitong_au,
                    R.string.subtitle_dwitong_ei,
                    R.string.subtitle_dwitong_oi
            );
        }
    }

    public List<Integer> getData(int index) {
        if (this == WORDS_VOICE) {
            if (index == 0) {
                return Arrays.asList(
                        R.raw.diftong_ai_1,
                        R.raw.diftong_ai_2,
                        R.raw.diftong_ai_3,
                        R.raw.diftong_ai_4,
                        R.raw.diftong_ai_5
                );
            }else if (index == 1) {
                return Arrays.asList(
                        R.raw.diftong_au_1,
                        R.raw.diftong_au_2,
                        R.raw.diftong_au_3,
                        R.raw.diftong_au_4,
                        R.raw.diftong_au_5
                );
            }else if (index == 2) {
                return Arrays.asList(
                        R.raw.diftong_ei_1,
                        R.raw.diftong_ei_2,
                        R.raw.diftong_ei_3,
                        R.raw.diftong_ei_3,
                        R.raw.diftong_ei_3
                );
            }else if (index == 3) {
                return Arrays.asList(
                        R.raw.diftong_oi_1,
                        R.raw.diftong_oi_2,
                        R.raw.diftong_oi_3,
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
                        R.raw.diftong_sentences_ai_1,
                        R.raw.diftong_sentences_ai_2,
                        R.raw.diftong_sentences_ai_3,
                        R.raw.diftong_sentences_ai_4,
                        0
                );
            } else {
                return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }
}
