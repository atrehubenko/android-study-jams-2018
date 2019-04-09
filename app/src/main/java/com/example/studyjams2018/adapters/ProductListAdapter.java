package com.example.studyjams2018.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studyjams2018.R;
import com.example.studyjams2018.entity.Product;

public class ProductListAdapter extends BaseAdapter {
    private Product[] products;
    private ProductAmountChangesListener listener;

    public ProductListAdapter(Product[] products) {
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.length;
    }

    @Override
    public Product getItem(int position) {
        if (position < products.length) {
            return products[position];
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder viewHolder;
        Product product = getItem(position);
        if (v == null) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_product, parent, false);
            viewHolder = new ViewHolder(v, product);
            v.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) v.getTag();
        }
        if (product != null) {
            viewHolder.image.setImageDrawable(ContextCompat.getDrawable(v.getContext(), product.getPhotoId()));
            viewHolder.name.setText(product.getName());
            viewHolder.price.setText(String.valueOf(product.getPrice()));
            Integer amount = product.getAmount();
            viewHolder.btnOrder.setVisibility(amount == 0 ? View.VISIBLE : View.INVISIBLE);
            viewHolder.amount.setText(amount.toString());
        }
        return v;
    }

    private class ViewHolder implements View.OnClickListener {
        Product product;
        ImageView image;
        TextView name;
        TextView price;
        TextView amount;
        Button increase;
        Button decrease;
        Button btnOrder;

        public ViewHolder(@NonNull View itemView, Product product) {
            this.product = product;
            image = itemView.findViewById(R.id.item_image);
            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
            amount = itemView.findViewById(R.id.amount);
            decrease = itemView.findViewById(R.id.btn_decrease);
            increase = itemView.findViewById(R.id.btn_increase);
            btnOrder = itemView.findViewById(R.id.btn_order);
            btnOrder.setFocusable(false);
            decrease.setOnClickListener(this);
            increase.setOnClickListener(this);
            btnOrder.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int amount = product.getAmount();
            switch (v.getId()) {
                case R.id.btn_order:
                case R.id.btn_increase:
                    amount++;
                    break;
                case R.id.btn_decrease:
                    amount--;
                    break;
            }
            product.setAmount(amount);
            notifyDataSetChanged();
            listener.onChanged();
        }
    }

    public interface ProductAmountChangesListener {
        void onChanged();
    }

    public void setListener(ProductAmountChangesListener listener) {
        this.listener = listener;
    }
}