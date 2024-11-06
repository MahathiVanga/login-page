package com.example.loginpage;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = findViewById(R.id.productRecyclerView);

        // Convert productList from field to local variable
        List<Product> productList = new ArrayList<>();
        loadProducts(productList); // Pass the list as parameter

        ProductAdapter adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // Modified to accept productList as parameter
    private void loadProducts(List<Product> productList) {
        productList.add(new Product("Product 1", "$10", R.drawable.product1_image));
        productList.add(new Product("Product 2", "$20", R.drawable.product2_image));
        productList.add(new Product("Product 3", "$15", R.drawable.product3_image));
    }
}