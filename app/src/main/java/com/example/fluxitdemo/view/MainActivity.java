package com.example.fluxitdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fluxitdemo.R;
import com.example.fluxitdemo.model.DAOProduct;
import com.example.fluxitdemo.model.Product;
import com.example.fluxitdemo.model.ProductAdapter;
import com.example.fluxitdemo.model.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private RecyclerView recyclerView;
    private DAOProduct daoProduct;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daoProduct = new DAOProduct();
        productAdapter = new ProductAdapter(new ArrayList<Product>());

        setview();
    }

    private void setview() {
        button = findViewById(R.id.button_search);
        editText = findViewById(R.id.edittxt_search_query);
        recyclerView = findViewById(R.id.recycler_view_result_products);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(productAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                daoProduct.searchProducts(editText.getText().toString(),
                        new ResultListener<List<Product>>() {
                            @Override
                            public void finish(List<Product> results) {
                                productAdapter.dataSetChanged(results);
                            }
                        })
                ;
            }
        });
    }
}
