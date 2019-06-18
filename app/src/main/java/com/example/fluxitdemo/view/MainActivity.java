package com.example.fluxitdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fluxitdemo.R;
import com.example.fluxitdemo.model.DAOProduct;
import com.example.fluxitdemo.model.Product;
import com.example.fluxitdemo.model.ResultListener;

import java.util.List;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private EditText editText;
    private DAOProduct daoProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daoProduct = new DAOProduct();

        setview();
    }

    private void setview() {
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.search_fubol_button);
        editText = findViewById(R.id.editText);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    daoProduct.searchProducts(editText.getText().toString(),
                            new ResultListener<List<Product>>() {
                        @Override
                        public void finish(List<Product> results) {
                            textView.setText("");
                            for (Product product : results) {
                                textView.setText(textView.getText() + product.getTitle());
                            }
                        }
                    });
                }
            });
    }
}
