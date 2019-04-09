package com.example.studyjams2018;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studyjams2018.adapters.ProductListAdapter;
import com.example.studyjams2018.entity.Product;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private Product[] products = new Product[5];
    private TextView totalAmount;

    private void initializeData() {
        products[0] = new Product("Cappuccino", 23, R.drawable.ic_capuccino);
        products[1] = new Product("Americano", 25, R.drawable.ic_americano);
        products[2] = new Product("Espresso", 35, R.drawable.ic_espresso);
        products[3] = new Product("Flat White", 30, R.drawable.ic_flat_white);
        products[4] = new Product("Mocha", 31, R.drawable.ic_mocha);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        totalAmount = findViewById(R.id.total_amount_value);
        list = findViewById(R.id.products_list);

        initializeData();

        final ProductListAdapter adapter = new ProductListAdapter(products);
        adapter.setListener(new ProductListAdapter.ProductAmountChangesListener() {
            @Override
            public void onChanged() {
                updateCartView();
            }
        });
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = adapter.getItem(position);
                product.setAmount(product.getAmount() + 1);
                updateCartView();
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void updateCartView() {
        int tAmount = 0;
        for (Product product : products) {
            Integer amount = product.getAmount();
            tAmount += amount * product.getPrice();
        }
        totalAmount.setText(String.valueOf(tAmount));
    }
}








