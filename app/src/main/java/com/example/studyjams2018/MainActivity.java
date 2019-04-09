package com.example.studyjams2018;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studyjams2018.entity.Product;

public class MainActivity extends AppCompatActivity{

    private TextView totalAmount, price, amount, name;
    private ImageView image;
    private Button btnOrder;
    private int _amount;
    private Product _product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        name = findViewById(R.id.product_name);
        image = findViewById(R.id.product_image);
        price = findViewById(R.id.product_price);
        amount = findViewById(R.id.amount);
        btnOrder = findViewById(R.id.btn_order);

        totalAmount = findViewById(R.id.total_amount_value);

        _product = new Product("Cappuccino", 23, R.drawable.ic_capuccino);
        image.setImageDrawable(ContextCompat.getDrawable(this, _product.getPhotoId()));
        name.setText(_product.getName());
        price.setText(String.valueOf(_product.getPrice()));
    }

    private void updateCartView() {
        int tAmount = 0;
        btnOrder.setVisibility(_amount == 0 ? View.VISIBLE : View.INVISIBLE);
        amount.setText(String.valueOf(_amount));
        tAmount += _amount * _product.getPrice();
        totalAmount.setText(String.valueOf(tAmount));
    }

    public void increaseAmount(View view) {
        _amount++;
        updateCartView();
    }

    public void decreaseAmount(View view) {
        _amount--;
        updateCartView();
    }
}








