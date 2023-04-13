package com.example.foodapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{

    Context context;
    ArrayList<Product> productArrayList;

    public ProductAdapter(Context context, ArrayList<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Product temp = productArrayList.get(position);
        holder.img_food.setImageResource(productArrayList.get(position).getFood_image());
        holder.tv_food.setText(productArrayList.get(position).getFood_name());
        holder.tv_des.setText(productArrayList.get(position).getFood_des());
        holder.tv_price.setText(productArrayList.get(position).getFood_price());

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                Intent intent = new Intent(context,FoodDetailActivity.class);
                intent.putExtra("food_name",temp.getFood_name());
                intent.putExtra("food_des",temp.getFood_des());
                intent.putExtra("food_price",temp.getFood_price());
                intent.putExtra("food_img",temp.getFood_image());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
           }
       });

    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img_food;
        TextView tv_food;
        TextView tv_des;
        TextView tv_price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_food = itemView.findViewById(R.id.img_food);
            tv_food = itemView.findViewById(R.id.tv_food);
            tv_des = itemView.findViewById(R.id.tv_description);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }
}
