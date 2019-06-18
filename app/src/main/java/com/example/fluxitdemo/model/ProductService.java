package com.example.fluxitdemo.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Requests listing
public interface ProductService {

    @GET("/sites/MLA/search")
    Call<ProductsContainer> searchProduct(@Query("q") String searchQuery);
}
