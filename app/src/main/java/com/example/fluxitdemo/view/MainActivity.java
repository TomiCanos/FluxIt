package com.example.fluxitdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fluxitdemo.R;
import com.example.fluxitdemo.model.DAOProduct;
import com.example.fluxitdemo.model.Product;
import com.example.fluxitdemo.model.ProductAdapter;
import com.example.fluxitdemo.model.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private RecyclerView recyclerView;
    private DAOProduct daoProduct;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        daoProduct = new DAOProduct();
        productAdapter = new ProductAdapter(new ArrayList<Product>());

        setview();
    }

    private void setview() {
        editText = findViewById(R.id.edittxt_search_query);
        recyclerView = findViewById(R.id.recycler_view_result_products);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(productAdapter);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    return true;
                }
                return false;
            }
        });
    }

    private void performSearch() {
        editText.clearFocus();
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(editText.getWindowToken(), 0);

        daoProduct.searchProducts(
                editText.getText().toString(),
                new ResultListener<List<Product>>() {
                    @Override
                    public void finish(List<Product> results) {
                        productAdapter.dataSetChanged(results);
                    }
                })
        ;

    }
}
