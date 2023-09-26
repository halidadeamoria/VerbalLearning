package com.example.articulationlearning.database;

public interface QueryResponse<T> {
    void onSuccess(T data, int idData);
    void onFailure(String message);
}