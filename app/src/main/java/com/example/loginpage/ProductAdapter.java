package com.example.loginpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private final Context context;
    private final List<Product> productList;

    public ProductAdapter(@NonNull Context context, @NonNull List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.bind(product, context);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView productImage;
        private final TextView productName;
        private final TextView productPrice;
        private final Button addToCartButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
        }

        public void bind(final Product product, final Context context) {
            try {
                // Set product details
                productName.setText(product.getName());
                productPrice.setText(product.getPrice());
                productImage.setImageResource(product.getImageResourceId());

                // Handle click events
                itemView.setOnClickListener(v ->
                        Toast.makeText(context,
                                "Selected: " + product.getName(),
                                Toast.LENGTH_SHORT).show()
                );

                addToCartButton.setOnClickListener(v ->
                        Toast.makeText(context,
                                product.getName() + " added to cart!",
                                Toast.LENGTH_SHORT).show()
                );

            } catch (Exception e) {
                // Handle any errors during binding
                Toast.makeText(context,
                        "Error loading product details",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}