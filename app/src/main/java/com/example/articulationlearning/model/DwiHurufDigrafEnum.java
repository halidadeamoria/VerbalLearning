package com.example.articulationlearning.model;

import com.example.articulationlearning.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum DwiHurufDigrafEnum {
    WORDS,VIDEO, SENTENCES, TITLE, SUBTTITLE, DESC,WORDS_VOICE, SENTENCES_VOICE;

    public List<Integer> getData() {
        if (this == WORDS) {
            return Arrays.asList(
                    R.array.words_digraf_kh,
                    R.array.words_digraf_ng,
                    R.array.words_digraf_ny,
                    R.array.words_digraf_sy
            );
        } else if (this == SENTENCES) {
            return Arrays.asList(
                    R.array.sentences_digraf_kh,
                    R.array.sentences_digraf_ng,
                    R.array.sentences_digraf_ny,
                    R.array.sentences_digraf_sy
            );
        } else if (this == TITLE) {
            return Arrays.asList(
                    R.string.title_digraf_kh,
                    R.string.title_digraf_ng,
                    R.string.title_digraf_ny,
                    R.string.title_digraf_sy
            );
        } else if (this == DESC) {
            return Arrays.asList(
                    R.string.text_digraf_kh,
                    R.string.text_digraf_ng,
                    R.string.text_digraf_ny,
                    R.string.text_digraf_sj
            );
        } else if (this == VIDEO) {
            return Arrays.asList(
                    R.raw.vokal_huruf_a,
                    R.raw.vokal_huruf_i,
                    R.raw.vokal_huruf_u,
                    R.raw.vokal_huruf_e,
                    R.raw.vokal_huruf_o
            );
        }else {
            return Arrays.asList(
                    R.string.subtitle_digraf_kh,
                    R.string.subtitle_digraf_ng,
                    R.string.subtitle_digraf_ny,
                    R.string.subtitle_digraf_sy
            );
        }
    }
    public List<Integer> getData(int index) {
        if (this == WORDS_VOICE) {
            if (index == 0) {
                return Arrays.asList(
                        R.raw.digraf_kh_1,
                        R.raw.digraf_kh_2,
                        R.raw.digraf_kh_3,
                        R.raw.digraf_kh_4,
                        R.raw.digraf_kh_5
                );
            }else if (index == 1) {
                return Arrays.asList(
                        R.raw.digraf_ng_1,
                        R.raw.digraf_ng_2,
                        R.raw.digraf_ng_3,
                        R.raw.digraf_ng_4,
                        R.raw.digraf_ng_5
                );
            }else if (index == 2) {
                return Arrays.asList(
                        R.raw.digraf_ny_1,
                        R.raw.digraf_ny_2,
                        R.raw.digraf_ny_3,
                        R.raw.digraf_ny_4,
                        R.raw.digraf_ny_5
                );
            }else if (index == 3) {
                return Arrays.asList(
                        R.raw.digraf_sy_1,
                        R.raw.digraf_sy_2,
                        R.raw.digraf_sy_3,
                        R.raw.digraf_sy_4,
                        R.raw.digraf_sy_4
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
                        R.raw.digraf_sentences_kh_1,
                        R.raw.digraf_sentences_kh_2,
                        R.raw.digraf_sentences_kh_3,
                        R.raw.digraf_sentences_kh_4,
                        R.raw.digraf_sentences_kh_5
                );
            }else  if (index == 1) {
                return Arrays.asList(
                        R.raw.digraf_sentences_ng_1,
                        R.raw.digraf_sentences_ng_2,
                        R.raw.digraf_sentences_ng_3,
                        R.raw.digraf_sentences_ng_4,
                        R.raw.digraf_sentences_ng_5
                );
            }else  if (index == 2) {
                return Arrays.asList(
                        R.raw.digraf_sentences_ny_1,
                        R.raw.digraf_sentences_ny_2,
                        R.raw.digraf_sentences_ny_3,
                        R.raw.digraf_sentences_ny_4,
                        R.raw.digraf_sentences_ny_5
                );
            }else  if (index == 3) {
                return Arrays.asList(
                        R.raw.digraf_sentences_sy_1,
                        R.raw.digraf_sentences_sy_2,
                        R.raw.digraf_sentences_sy_3,
                        R.raw.digraf_sentences_sy_4
                );
            } else {
                return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }
}
