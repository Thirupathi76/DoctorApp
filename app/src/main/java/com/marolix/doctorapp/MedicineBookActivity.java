package com.marolix.doctorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.marolix.doctorapp.adapter.MedicineBookAdapter;
import com.marolix.doctorapp.database.DatabaseCart;
import com.marolix.doctorapp.font.EditText_AvenirLTStd_Book;
import com.marolix.doctorapp.interfaces.ClickListener;

public class MedicineBookActivity extends AppCompatActivity {

    LinearLayout bottom_cart_layout;
    TextView text_cart;
    private int total;
    String[] prod_name = {"Asthalin Inhaler 200 md", "Aspirin 150mg", " Ecospirin Naph 43", "Colpal 430", "Dolo 650", "Lamvir-se 30","Seval Tablets"};
    String[] prod_price = {"90", "34", "120", "100", "68", "20", "280"};
    String[] num_items = {"3 tablet", "1 tablet", "4 tablet","4 tablet","10 tablet","10 tablet", "4 tablet"};
    int [] images = {};
    DatabaseCart databaseCart;
    EditText search_medicines;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        databaseCart = new DatabaseCart(this);

        bottom_cart_layout = findViewById(R.id.bottom_cart_layout);
        search_medicines = findViewById(R.id.search_medicines);
        search_medicines.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() >= 3){
                    Toast.makeText(MedicineBookActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_cart = findViewById(R.id.cart_text);
//        String product_name = getIntent().getStringExtra("PRODUCT_NAME");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Book");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MedicineBookAdapter adapter = new MedicineBookAdapter(this, prod_name, prod_price, images,
                new ClickListener() {
            @Override
            public void itemClick(View view, int pos, int quantity) {
                if (view.getId() == R.id.item_add) {

                    Log.e("Click ", "databaseCart " + pos);
                    total = total + Integer.parseInt(prod_price[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to Cart items \u20B9 " + total);


                    if (!databaseCart.checkIfExists(prod_name[pos])) {

                        databaseCart.addItemsToCart(prod_name[pos], prod_price[pos], String.valueOf(quantity));
                    } else if (quantity == 0){
                        databaseCart.removeItemsFromCart(prod_name[pos]);
                    }
                    else
                        databaseCart.updateCartItems(prod_name[pos], prod_price[pos], String.valueOf(quantity));

                    /*if (quantity == 0){
                        databaseCart.removeItemsFromCart(prod_name[pos]);
                    }*/
                    if (total == 0) {
//                        databaseCart.dropTable();
//                        databaseCart.removeItemsFromCart(prod_name[pos]);
                        bottom_cart_layout.setVisibility(View.GONE);
                    }

                } else if (view.getId() == R.id.item_sub) {
                    Log.e("Click ", "databaseCart " + pos);

                    /*if (quantity == 0){
                        databaseCart.removeItemsFromCart(prod_name[pos]);
                    }*/
//                    databaseCart.removeItemsFromCart(prod_name[pos]);
                    total = total - Integer.parseInt(prod_price[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to databaseCart items " + total);
                    if (!databaseCart.checkIfExists(prod_name[pos])) {
                        databaseCart.addItemsToCart(prod_name[pos], prod_price[pos], String.valueOf(quantity));
                    } else if (quantity == 0){
                        databaseCart.removeItemsFromCart(prod_name[pos]);
                    } else
                        databaseCart.updateCartItems(prod_name[pos], prod_price[pos], String.valueOf(quantity));


                    if (total == 0) {
//                        databaseCart.dropTable();
//                        databaseCart.removeItemsFromCart(prod_name[pos]);
                        bottom_cart_layout.setVisibility(View.GONE);
                    }
                }
            }
        });
        recyclerView.setAdapter(adapter);
        bottom_cart_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (total == 0) {
//                    databaseCart.removeItemsFromCart(prod_name[0]);
                }
                Intent intent = new Intent(MedicineBookActivity.this, CartActivity.class);
                intent.putExtra("CART", String.valueOf(total));
                startActivity(intent);

            }
        });

        text_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicineBookActivity.this, CartActivity.class);
                intent.putExtra("CART", String.valueOf(total));
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
