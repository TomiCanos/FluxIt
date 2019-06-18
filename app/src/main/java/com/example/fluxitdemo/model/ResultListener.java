package com.example.fluxitdemo.model;


//async requests
public interface ResultListener<T> {
    void finish(T results);
}
