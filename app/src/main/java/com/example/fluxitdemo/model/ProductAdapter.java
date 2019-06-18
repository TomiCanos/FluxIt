package com.example.fluxitdemo.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fluxitdemo.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {

    private List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    //grabs the view to be inflated
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View productCell = inflater.inflate(R.layout.recycler_view_product_cell, parent, false);
        ProductHolder productHolder = new ProductHolder(productCell);

        return productHolder;
    }

    // binds each product with its recycler view list cell
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Product product = products.get(position);
        ((ProductHolder) holder).loadView(product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    // updates the data set to be shown
    public void dataSetChanged(List<Product> newProducts) {
//        products.addAll(newProducts);
        products = newProducts;
        notifyDataSetChanged();
    }

    //inflates the view with the information of the selected product
    private class ProductHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView price;
        private TextView condition;
        private ImageView thumbnail;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.recycler_view_product_title);
            price = itemView.findViewById(R.id.recycler_view_product_price);
            thumbnail = itemView.findViewById(R.id.recycler_view_product_thumbnail);
            condition = itemView.findViewById(R.id.recycler_view_product_condition);
        }

        public void loadView(Product product) {
            title.setText(product.getTitle());
            price.setText("$ " + product.getPrice());
            condition.setText(product.getCondition());
            Glide.with(itemView).load(product.getThumbnail())
                    .placeholder(R.drawable.product_default_thumbnail)
                    .into(thumbnail);
        }
    }

}
