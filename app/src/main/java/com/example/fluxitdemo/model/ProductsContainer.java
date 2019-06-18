package com.example.fluxitdemo.model;

import java.util.List;

// POJO list for hadling several results from one service call
class ProductsContainer {
    private List<Product> results;

    public List<Product> getResults() {
        return results;
    }
}
