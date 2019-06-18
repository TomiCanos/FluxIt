package com.example.fluxitdemo.model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Data Access Object, pretty much self explainatory
public class DAOProduct {
    private Retrofit retrofit;
    private ProductService productService;

    public DAOProduct() {
        // looks for http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // adding the base url from mercadolibre API and setting Gson convertor as Json-Java parser
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/")
                .addConverterFactory(GsonConverterFactory.create());


        //building retrofit on top of http
        retrofit = builder.client(httpClient.build()).build();

        //instanciating the service to get the products from internet
        productService = retrofit.create(ProductService.class);
    }

    public void searchProducts(String searchQuery, final ResultListener<List<Product>> resultListener) {
        Call<ProductsContainer> call = productService.searchProduct(searchQuery);
        call.enqueue(new Callback<ProductsContainer>() {
            @Override
            public void onResponse(Call<ProductsContainer> call, Response<ProductsContainer> response) {
                List<Product> results = response.body().getResults();
                resultListener.finish(results);
            }

            @Override
            public void onFailure(Call<ProductsContainer> call, Throwable t) {
                resultListener.finish(new ArrayList<Product>());
            }
        });
    }
}
