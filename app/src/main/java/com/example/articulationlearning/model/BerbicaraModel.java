package com.example.articulationlearning.model;

import com.example.articulationlearning.R;

import java.util.Arrays;
import java.util.List;

public class BerbicaraModel {
    private List<Integer> kesiapsiagaanBencanaC = Arrays.asList(
            R.raw.kb_c_1,
            R.raw.kb_c_2,
            R.raw.kb_c_3,
            R.raw.kb_c_4,
            R.raw.kb_c_4);
    private List<String> kesiapsiagaanBencanaCText = Arrays.asList(
            "Bencana", "Cobaan", "Hancur", "Racun", "");
    private List<Integer> kesiapsiagaanBencanaJ = Arrays.asList(
            R.raw.kb_j_1,
            R.raw.kb_j_2,
            R.raw.kb_j_3,
            R.raw.kb_j_4,
            R.raw.kb_j_4);
    private List<String> kesiapsiagaanBencanaJText = Arrays.asList(
            "Jiwa", "Jatuh", "Banjir", "Terjang", "");
    private List<Integer> kesiapsiagaanBencanaNYA = Arrays.asList(
            R.raw.kb_n_1,
            R.raw.kb_n_2,
            R.raw.kb_n_3,
            R.raw.kb_n_3,
            R.raw.kb_n_3);
    private List<String> kesiapsiagaanBencanaNYAText = Arrays.asList(
            "Nyaman", "Nyaris", "Penyakit", "", "");

    private List<Integer> kesiapsiagaanBencanaK = Arrays.asList(
            R.raw.kb_k_1,
            R.raw.kb_k_2,
            R.raw.kb_k_3,
            R.raw.kb_k_4,
            R.raw.kb_k_5);
    private List<String> kesiapsiagaanBencanaKText = Arrays.asList(
            "Korban", "Kebakaran", "Ledakan", "Konflik", "Rusak");
    private List<Integer> kesiapsiagaanBencanaG = Arrays.asList(
            R.raw.kb_g_1,
            R.raw.kb_g_2,
            R.raw.kb_g_3,
            R.raw.kb_g_4,
            R.raw.kb_g_4);
    private List<String> kesiapsiagaanBencanaGText = Arrays.asList(
            "Gempa", "Gunung Api", "Siaga", "Rugi", "");
    private List<Integer> kesiapsiagaanBencanaNG = Arrays.asList(
            R.raw.kb_ng_1,
            R.raw.kb_ng_2,
            R.raw.kb_ng_3,
            R.raw.kb_ng_4,
            R.raw.kb_ng_5);
    private List<String> kesiapsiagaanBencanaNGText = Arrays.asList(
            "Ngeri", "Angin", "Hangus", "Longsor", "Hilang");
    private List<Integer> kesiapsiagaanBencanaH = Arrays.asList(
            R.raw.kb_h_1,
            R.raw.kb_h_2,
            R.raw.kb_h_3,
            R.raw.kb_h_4,
            R.raw.kb_h_4);
    private List<String> kesiapsiagaanBencanaHText = Arrays.asList(
            "Hidup", "Harta", "Musibah", "Runtuh", "");

//    Kesehatan reproduksi

    private List<Integer> kesehatanReproduksiC = Arrays.asList(
            R.raw.kr_c_1,
            R.raw.kr_c_2);
    private List<String> kesehatanReproduksiCText = Arrays.asList(
            "Cantik", "Cacar");
    private List<Integer> kesehatanReproduksiJ = Arrays.asList(
            R.raw.kr_j_1,
            R.raw.kr_j_2,
            R.raw.kr_j_3);
    private List<String> kesehatanReproduksiJText = Arrays.asList(
            "Jamur", "Jakun", "Remaja");
    private List<Integer> kesehatanReproduksiNYA = Arrays.asList(
            R.raw.kr_nya_1,
            R.raw.kr_nya_2,
            R.raw.kr_nya_3);
    private List<String> kesehatanReproduksiNYAText = Arrays.asList(
            "Nyaring", "Penyakit", "Banyak");

    private List<Integer> kesehatanReproduksiK = Arrays.asList(
            R.raw.kr_k_1,
            R.raw.kr_k_2,
            R.raw.kr_k_3,
            R.raw.kr_k_4,
            R.raw.kr_k_5);
    private List<String> kesehatanReproduksiKText = Arrays.asList(
            "Kuman", "Khitan", "Reproduksi", "Bakteri", "Rokok");
    private List<Integer> kesehatanReproduksiG = Arrays.asList(
            R.raw.kr_g_1,
            R.raw.kr_g_2,
            R.raw.kr_g_3);
    private List<String> kesehatanReproduksiGText = Arrays.asList(
            "Gizi", "Gatal", "Vagina");
    private List<Integer> kesehatanReproduksiNG = Arrays.asList(
            R.raw.kr_ng_1,
            R.raw.kr_ng_2,
            R.raw.kr_ng_3,
            R.raw.kr_ng_4);
    private List<String> kesehatanReproduksiNGText = Arrays.asList(
            "Ngilu", "Pinggul", "Keringat", "Buang");
    private List<Integer> kesehatanReproduksiH = Arrays.asList(
            R.raw.kr_h_1,
            R.raw.kr_h_2,
            R.raw.kr_h_3,
            R.raw.kr_h_4,
            R.raw.kr_h_5);
    private List<String> kesehatanReproduksiHText = Arrays.asList(
            "Hormon", "Alkohol", "Olahraga", "Bersih", "Basuh");

    private int type;
    private String text;
    private int videoId;

    public BerbicaraModel(int type, int position) {
        this.type = type;
        if (type == 1) {
            // Kesiapsiagaan bencara C
            videoId = kesiapsiagaanBencanaC.get(position);
            text = kesiapsiagaanBencanaCText.get(position);
        } else if (type == 2) {
            // Kesiapsiagaan bencara J
            videoId = kesiapsiagaanBencanaJ.get(position);
            text = kesiapsiagaanBencanaJText.get(position);
        } else if (type == 3) {
            // Kesiapsiagaan bencara NYA
            videoId = kesiapsiagaanBencanaNYA.get(position);
            text = kesiapsiagaanBencanaNYAText.get(position);
        } else if (type == 4) {
            // Kesiapsiagaan bencara K
            videoId = kesiapsiagaanBencanaK.get(position);
            text = kesiapsiagaanBencanaKText.get(position);
        } else if (type == 5) {
            // Kesiapsiagaan bencara G
            videoId = kesiapsiagaanBencanaG.get(position);
            text = kesiapsiagaanBencanaGText.get(position);
        } else if (type == 6) {
            // Kesiapsiagaan bencara NG
            videoId = kesiapsiagaanBencanaNG.get(position);
            text = kesiapsiagaanBencanaNGText.get(position);
        } else if (type == 7) {
            // Kesiapsiagaan bencara H
            videoId = kesiapsiagaanBencanaH.get(position);
            text = kesiapsiagaanBencanaHText.get(position);
        } else if (type == 8) {
            // Kesiapsiagaan bencara C
            videoId = kesehatanReproduksiC.get(position);
            text = kesehatanReproduksiCText.get(position);
        } else if (type == 9) {
            // Kesiapsiagaan bencara J
            videoId = kesehatanReproduksiJ.get(position);
            text = kesehatanReproduksiJText.get(position);
        } else if (type == 10) {
            // Kesiapsiagaan bencara NYA
            videoId = kesehatanReproduksiNYA.get(position);
            text = kesehatanReproduksiNYAText.get(position);
        } else if (type == 11) {
            // Kesiapsiagaan bencara K
            videoId = kesehatanReproduksiK.get(position);
            text = kesehatanReproduksiKText.get(position);
        } else if (type == 12) {
            // Kesiapsiagaan bencara G
            videoId = kesehatanReproduksiG.get(position);
            text = kesehatanReproduksiGText.get(position);
        } else if (type == 13) {
            // Kesiapsiagaan bencara NG
            videoId = kesehatanReproduksiNG.get(position);
            text = kesehatanReproduksiNGText.get(position);
        } else if (type == 14) {
            // Kesiapsiagaan bencara H
            videoId = kesehatanReproduksiH.get(position);
            text = kesehatanReproduksiHText.get(position);
        }

    }

    public int getVideoId() {
        return videoId;
    }

    public String getText() {
        return text;
    }
}
