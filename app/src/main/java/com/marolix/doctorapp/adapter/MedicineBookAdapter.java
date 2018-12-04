package com.marolix.doctorapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marolix.doctorapp.R;
import com.marolix.doctorapp.interfaces.ClickListener;

public class MedicineBookAdapter extends RecyclerView.Adapter<MedicineBookAdapter.MyViewHolder> {

    String[] prod_name;
    String[] prod_price;
    int[] images;
    Context context;
    private ClickListener clickListener;
    String[] num_items = {"3 tablet", "1 tablet", "4 tablet","4 tablet","10 tablet","10 tablet", "4 tablet"};
    int[] medicine_images = {R.drawable.medicine_1,R.drawable.medicine_2,R.drawable.medicine_3,R.drawable.medicine_4,
            R.drawable.medicine_5,R.drawable.medicine_6,R.drawable.medicine_1};
    public MedicineBookAdapter(Context productActivity, String[] product_name, String[] prod_price, int[] images, ClickListener clickListener) {
        context = productActivity;
        this.clickListener = clickListener;
        this.prod_price = prod_price;
        this.prod_name = product_name;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.medicine_book_item, viewGroup, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        return new MyViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.productName.setText(prod_name[i]);
        myViewHolder.prod_unit.setText("1");
        myViewHolder.price.setText("\u20B9"+prod_price[i]);
        myViewHolder.prod_unit.setText(num_items[i]);
//        myViewHolder.quantity.setText("1");
       /* myViewHolder.recycler_view_list.setHasFixedSize(true);
        myViewHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        */
       myViewHolder.prod_image.setImageResource(medicine_images[i]);
       /* myViewHolder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewHolder.sum = myViewHolder.sum + 1;
                Log.e("Quantity value2", "" + myViewHolder.sum);
                if (myViewHolder.sum > 0) {
                    myViewHolder.quantity.setVisibility(View.VISIBLE);
                    myViewHolder.minus.setVisibility(View.VISIBLE);
                }
                myViewHolder.quantity.setText(String.valueOf(myViewHolder.sum));
                //product.setTotalItems(myViewHolder.sum);
//                myViewHolder.quantity.startAnimation(an imFadeIn);
                //AppConstant.selectedProducts.add(product);
                *//*updateProduct(product, myViewHolder.sum);
                productCounter.onProdctCounterChanged(1, Double.parseDouble(product.getPricesModel().getAmount()));
            *//*
            }
        });*/


        /*myViewHolder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myViewHolder.sum > 0) {
                    myViewHolder.sum = myViewHolder.sum - 1;
                    if (myViewHolder.sum == 0) {
                        myViewHolder.quantity.setVisibility(View.INVISIBLE);
                        myViewHolder.minus.setVisibility(View.INVISIBLE);
                    }
                    myViewHolder.quantity.setText(String.valueOf(myViewHolder.sum));
//                    myViewHolder.tv_quantity.startAnimation(animFadeIn);
                    // product.setTotalItems(myViewHolder.sum);
                    // AppConstant.selectedProducts.remove(product);
//                    updateProduct(product, myViewHolder.sum);
//                    productCounter.onProdctCounterChanged(0, Double.parseDouble(product.getPricesModel().getAmount()));

                }
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return prod_name.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView productName, prod_unit, price, quantity;
        TextView  plus, minus;
        ImageView prod_image;
        int sum;

        public MyViewHolder(@NonNull View itemView, final ClickListener listener) {
            super(itemView);

            productName = itemView.findViewById(R.id.productname);
            prod_unit = itemView.findViewById(R.id.tv_unit);
            price = itemView.findViewById(R.id.tv_price);
            quantity = itemView.findViewById(R.id.tv_quantity);
            prod_image = itemView.findViewById(R.id.product_image);
            plus = itemView.findViewById(R.id.item_add);
            minus = itemView.findViewById(R.id.item_sub);

            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sum = sum + 1;
                    Log.e("Quantity value 2 ", "" + sum);
                    if (sum > 0) {
                        quantity.setVisibility(View.VISIBLE);
                        minus.setVisibility(View.VISIBLE);
                    }
                    quantity.setText(String.valueOf(sum));
                    listener.itemClick(view, getAdapterPosition(), sum);
                }
            });

            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (sum > 0) {
                        sum = sum - 1;
                        if (sum == 0) {
                            quantity.setVisibility(View.INVISIBLE);
                            minus.setVisibility(View.INVISIBLE);
                        }
                        quantity.setText(String.valueOf(sum));
                        listener.itemClick(view, getAdapterPosition(), sum);
                    }
                }
            });
        }
    }
}
