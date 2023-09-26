package com.example.articulationlearning.model;

import com.example.articulationlearning.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum KonsonanEnum {
    WORDS, SENTENCES, DESC, VIDEO,WORDS_VOICE, SENTENCES_VOICE;

    public List<Integer> getData() {
        if (this == WORDS) {
            return Arrays.asList(
                    R.array.words_a,
                    R.array.words_b,
                    R.array.words_c,
                    R.array.words_d,
                    R.array.words_g,
                    R.array.words_f,
                    R.array.words_g,
                    R.array.words_h,
                    R.array.words_h,
                    R.array.words_j,
                    R.array.words_k,
                    R.array.words_l,
                    R.array.words_m,
                    R.array.words_n,
                    R.array.words_g,
                    R.array.words_p,
                    R.array.words_q,
                    R.array.words_r,
                    R.array.words_s,
                    R.array.words_t,
                    R.array.words_g,
                    R.array.words_v,
                    R.array.words_w,
                    R.array.words_x,
                    R.array.words_y,
                    R.array.words_z
            );
        } else if (this == SENTENCES) {
            return Arrays.asList(
                    R.array.sentences_a,
                    R.array.sentences_b,
                    R.array.sentences_c,
                    R.array.sentences_d,
                    R.array.sentences_a,
                    R.array.sentences_f,
                    R.array.sentences_g,
                    R.array.sentences_h,
                    R.array.sentences_a,
                    R.array.sentences_j,
                    R.array.sentences_k,
                    R.array.sentences_l,
                    R.array.sentences_m,
                    R.array.sentences_n,
                    R.array.sentences_a,
                    R.array.sentences_p,
                    R.array.sentences_q,
                    R.array.sentences_r,
                    R.array.sentences_s,
                    R.array.sentences_t,
                    R.array.sentences_a,
                    R.array.sentences_v,
                    R.array.sentences_w,
                    R.array.sentences_x,
                    R.array.sentences_y,
                    R.array.sentences_z
            );
        } else if (this == DESC) {
            return Arrays.asList(
                    R.string.text_a,
                    R.string.text_b,
                    R.string.text_c,
                    R.string.text_d,
                    R.string.text_e,
                    R.string.text_f,
                    R.string.text_g,
                    R.string.text_h,
                    R.string.text_i,
                    R.string.text_j,
                    R.string.text_k,
                    R.string.text_l,
                    R.string.text_m,
                    R.string.text_n,
                    R.string.text_o,
                    R.string.text_p,
                    R.string.text_q,
                    R.string.text_r,
                    R.string.text_s,
                    R.string.text_t,
                    R.string.text_u,
                    R.string.text_v,
                    R.string.text_w,
                    R.string.text_x,
                    R.string.text_y,
                    R.string.text_z
            );
        } else if (this == VIDEO) {

            return Arrays.asList(
                    0,
                    R.raw.huruf_b,
                    R.raw.huruf_c,
                    R.raw.huruf_d,
                    0,
                    R.raw.huruf_f,
                    R.raw.huruf_g,
                    R.raw.huruf_h,
                    0,
                    R.raw.huruf_j,
                    R.raw.huruf_k,
                    R.raw.huruf_l,
                    R.raw.huruf_m,
                    R.raw.huruf_n,
                    0,
                    R.raw.huruf_p,
                    R.raw.huruf_q,
                    R.raw.huruf_r,
                    R.raw.huruf_s,
                    R.raw.huruf_t,
                    0,
                    R.raw.huruf_v,
                    R.raw.huruf_w,
                    R.raw.huruf_x,
                    R.raw.huruf_y,
                    R.raw.huruf_z
            );
        }else{
            return Arrays.asList();
        }
    }
    public List<Integer> getData(int index) {
        if (this == WORDS_VOICE) {
            if (index == 0) {
                return Arrays.asList();
            }else if (index == 1) {
                return Arrays.asList(
                        R.raw.konsonan_b_1,
                        R.raw.konsonan_b_2,
                        R.raw.konsonan_b_3,
                        R.raw.konsonan_b_4,
                        R.raw.konsonan_b_5
                );
            }else if (index == 2) {
                return Arrays.asList(
                        R.raw.konsonan_c_1,
                        R.raw.konsonan_c_2,
                        R.raw.konsonan_c_3,
                        R.raw.konsonan_c_4,
                        R.raw.konsonan_c_5
                );
            }else if (index == 3) {
                return Arrays.asList(
                        R.raw.konsonan_d_1,
                        R.raw.konsonan_d_2,
                        R.raw.konsonan_d_3,
                        R.raw.konsonan_d_4,
                        R.raw.konsonan_d_5
                );
            }
            else if (index == 4) {
                return Arrays.asList();
            }else if (index == 5) {
                return Arrays.asList(
                        R.raw.konsonan_f_1,
                        R.raw.konsonan_f_2,
                        R.raw.konsonan_f_3,
                        R.raw.konsonan_f_4,
                        R.raw.konsonan_f_5
                );
            }else if (index == 6) {
                return Arrays.asList(
                        R.raw.konsonan_g_1,
                        R.raw.konsonan_g_2,
                        R.raw.konsonan_g_3,
                        R.raw.konsonan_g_4,
                        R.raw.konsonan_g_5
                );
            }else if (index == 7) {
                return Arrays.asList(
                        R.raw.konsonan_h_1,
                        R.raw.konsonan_h_2,
                        R.raw.konsonan_h_3,
                        R.raw.konsonan_h_4,
                        R.raw.konsonan_h_5
                );
            }else if (index == 8) {
                return Arrays.asList();
            }else if (index == 9) {
                return Arrays.asList(
                        R.raw.konsonan_j_1,
                        R.raw.konsonan_j_2,
                        R.raw.konsonan_j_3,
                        R.raw.konsonan_j_4,
                        R.raw.konsonan_j_5
                );
            }else if (index == 10) {
                return Arrays.asList(
                        R.raw.konsonan_k_1,
                        R.raw.konsonan_k_2,
                        R.raw.konsonan_k_3,
                        R.raw.konsonan_k_4,
                        R.raw.konsonan_k_5
                );
            }else if (index == 11) {
                return Arrays.asList(
                        R.raw.konsonan_l_1,
                        R.raw.konsonan_l_2,
                        R.raw.konsonan_l_3,
                        R.raw.konsonan_l_4,
                        R.raw.konsonan_l_5
                );
            }else if (index == 12) {
                return Arrays.asList(
                        R.raw.konsonan_m_1,
                        R.raw.konsonan_m_2,
                        R.raw.konsonan_m_3,
                        R.raw.konsonan_m_4,
                        R.raw.konsonan_m_5
                );
            }else if (index == 13) {
                return Arrays.asList(
                        R.raw.konsonan_n_1,
                        R.raw.konsonan_n_2,
                        R.raw.konsonan_n_3,
                        R.raw.konsonan_n_4,
                        R.raw.konsonan_n_5
                );
            }else if (index == 14) {
                return Arrays.asList();
            }else if (index == 15) {
                return Arrays.asList(
                        R.raw.konsonan_p_1,
                        R.raw.konsonan_p_2,
                        R.raw.konsonan_p_3,
                        R.raw.konsonan_p_4,
                        R.raw.konsonan_p_5
                );
            }else if (index == 16) {
                return Arrays.asList(
                        R.raw.konsonan_q_1,
                        R.raw.konsonan_q_2,
                        R.raw.konsonan_q_3,
                        R.raw.konsonan_q_4,
                        R.raw.konsonan_q_5
                );
            }else if (index == 17) {
                return Arrays.asList(
                        R.raw.konsonan_r_1,
                        R.raw.konsonan_r_2,
                        R.raw.konsonan_r_3,
                        R.raw.konsonan_r_4,
                        R.raw.konsonan_r_5
                );
            }else if (index == 18) {
                return Arrays.asList(
                        R.raw.konsonan_s_1,
                        R.raw.konsonan_s_2,
                        R.raw.konsonan_s_3,
                        R.raw.konsonan_s_4,
                        R.raw.konsonan_s_5
                );
            }else if (index == 19) {
                return Arrays.asList(
                        R.raw.konsonan_t_1,
                        R.raw.konsonan_t_2,
                        R.raw.konsonan_t_3,
                        R.raw.konsonan_t_4,
                        R.raw.konsonan_t_5
                );
            }else if (index == 21) {
                return Arrays.asList(
                        R.raw.konsonan_v_1,
                        R.raw.konsonan_v_2,
                        R.raw.konsonan_v_3,
                        R.raw.konsonan_v_4,
                        R.raw.konsonan_v_5
                );
            }else if (index == 22) {
                return Arrays.asList(
                        R.raw.konsonan_w_1,
                        R.raw.konsonan_w_2,
                        R.raw.konsonan_w_3,
                        R.raw.konsonan_w_4,
                        R.raw.konsonan_w_5
                );
            }else if (index == 23) {
                return Arrays.asList(
                        R.raw.konsonan_x_1,
                        R.raw.konsonan_x_2,
                        R.raw.konsonan_x_3,
                        R.raw.konsonan_x_4,
                        R.raw.konsonan_x_5
                );
            }else if (index == 24) {
                return Arrays.asList(
                        R.raw.konsonan_y_1,
                        R.raw.konsonan_y_2,
                        R.raw.konsonan_y_3,
                        R.raw.konsonan_y_4,
                        R.raw.konsonan_y_5
                );
            }else if (index == 25) {
                return Arrays.asList(
                        R.raw.konsonan_z_1,
                        R.raw.konsonan_z_2,
                        R.raw.konsonan_z_3,
                        R.raw.konsonan_z_4,
                        R.raw.konsonan_z_5
                );
            }else {
                return new ArrayList<>();
            }

        } else if (this == SENTENCES_VOICE) {
            if (index == 0) {
                return Arrays.asList(
                );
            }else if (index == 1) {
                return Arrays.asList(
                        R.raw.konsonan_b_1,
                        R.raw.sentence_konsonan_b_2,
                        R.raw.sentence_konsonan_b_3,
                        R.raw.sentence_konsonan_b_4,
                        R.raw.sentence_konsonan_b_5
                );
            }else if (index == 2) {
                return Arrays.asList(
                        R.raw.sentence_konsonan_c_1,
                        R.raw.sentence_konsonan_c_2,
                        R.raw.sentence_konsonan_c_3,
                        R.raw.sentence_konsonan_c_4,
                        R.raw.sentence_konsonan_c_5
                );
            }else if (index == 3) {
                return Arrays.asList(
                        R.raw.sentence_konsonan_d_1,
                        R.raw.sentence_konsonan_d_2,
                        R.raw.sentence_konsonan_d_3,
                        R.raw.sentence_konsonan_d_4,
                        R.raw.sentence_konsonan_d_5
                );
            }else if (index == 4) {
                return Arrays.asList();
            }else if (index == 5) {
                return Arrays.asList(
                        R.raw.sentence_konsonan_f_1,
                        R.raw.sentence_konsonan_f_2,
                        R.raw.sentence_konsonan_f_3,
                        R.raw.sentence_konsonan_f_4,
                        R.raw.sentence_konsonan_f_5
                );
            }else if (index == 6) {
                return Arrays.asList(
                        R.raw.sentence_konsonan_g_1,
                        R.raw.sentence_konsonan_g_2,
                        R.raw.sentence_konsonan_g_3,
                        R.raw.sentence_konsonan_g_4,
                        R.raw.sentence_konsonan_g_5
                );
            } else if (index == 7) {
                return Arrays.asList(
                        R.raw.sentence_konsonan_h_1,
                        R.raw.sentence_konsonan_h_2,
                        R.raw.sentence_konsonan_h_3,
                        R.raw.sentence_konsonan_h_4,
                        R.raw.sentence_konsonan_h_5
                );
            }else if (index == 8) {
                return Arrays.asList();
            }else if (index == 9) {
                return Arrays.asList(
                        R.raw.sentence_konsonan_j_1,
                        R.raw.sentence_konsonan_j_2,
                        R.raw.sentence_konsonan_j_3,
                        R.raw.sentence_konsonan_j_4,
                        R.raw.sentence_konsonan_j_5
                );
            }else if (index == 10) {
                return Arrays.asList(
                        R.raw.sentence_konsonan_k_1,
                        R.raw.sentence_konsonan_k_2,
                        R.raw.sentence_konsonan_k_3,
                        R.raw.sentence_konsonan_k_4,
                        R.raw.sentence_konsonan_k_5
                );
            }else if (index == 11) {
                return Arrays.asList(
                        R.raw.sentence_konsonan_l_1,
                        R.raw.sentence_konsonan_l_2,
                        R.raw.sentence_konsonan_l_3,
                        R.raw.sentence_konsonan_l_4,
                        R.raw.sentence_konsonan_l_5
                );
            }else if (index == 12) {
                return Arrays.asList(
                        R.raw.sentence_konsonan_m_1,
                        R.raw.sentence_konsonan_m_2,
                        R.raw.sentence_konsonan_m_3,
                        R.raw.sentence_konsonan_m_4,
                        R.raw.sentence_konsonan_m_5
                );
            } else if (index == 13) {
                return Arrays.asList(
                        R.raw.sentence_konsonan_n_1,
                        R.raw.sentence_konsonan_n_2,
                        R.raw.sentence_konsonan_n_3,
                        R.raw.sentence_konsonan_n_4,
                        R.raw.sentence_konsonan_n_5
                );
            } else if (index == 14) {
                return Arrays.asList();
            } else if (index == 15) {
                return Arrays.asList(
                        R.raw.sentence_konsonan_p_1,
                        R.raw.sentence_konsonan_p_2,
                        R.raw.sentence_konsonan_p_3,
                        R.raw.sentence_konsonan_p_4,
                        R.raw.sentence_konsonan_p_5
                );
            }else if (index == 25) {
                return Arrays.asList(
                        R.raw.sentence_konsonan_z_1,
                        R.raw.sentence_konsonan_z_2,
                        R.raw.sentence_konsonan_z_3,
                        R.raw.sentence_konsonan_z_4,
                        R.raw.sentence_konsonan_z_5
                );
            }   else {
                return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }
}
