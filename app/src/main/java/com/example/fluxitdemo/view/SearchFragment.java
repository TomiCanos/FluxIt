package com.example.fluxitdemo.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fluxitdemo.R;
import com.example.fluxitdemo.model.DAOProduct;
import com.example.fluxitdemo.model.Product;
import com.example.fluxitdemo.model.adapters.ProductAdapter;
import com.example.fluxitdemo.model.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    private EditText editText;
    private RecyclerView recyclerView;
    private DAOProduct daoProduct;
    private ProductAdapter productAdapter;
    private List<Product> products;
    private View view;

    public SearchFragment() {
        daoProduct = new DAOProduct();
        products = new ArrayList<>();
        productAdapter = new ProductAdapter(products);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        editText = view.findViewById(R.id.editTextSearchQuery);
        recyclerView = view.findViewById(R.id.recyclerViewResultProducts);

        setview(view);

        return view;
    }

    private void setview(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(productAdapter);

        if (!products.isEmpty()) {
            productAdapter.dataSetChanged(products);
            recyclerView.setVisibility(View.VISIBLE);
        }
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch(v);
                    return true;
                }
                return false;
            }
        });
    }

    private void performSearch(View view) {
        editText.clearFocus();
        InputMethodManager in = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(editText.getWindowToken(), 0);

        daoProduct.searchProducts(editText.getText().toString(), new ResultListener<List<Product>>() {
            @Override
            public void finish(List<Product> results) {
                recyclerView.setVisibility(View.VISIBLE);
                productAdapter.dataSetChanged(results);
                products = results;
            }
        });

    }
}
