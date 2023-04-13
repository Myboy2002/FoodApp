package com.example.foodapp;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ProductFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Product> productArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        recyclerView = view.findViewById(R.id.rcv_product);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

        productArrayList = new ArrayList<>();

        productArrayList.add(new Product(R.drawable.food_img_1,"food 1","this is food 1","$2"));
        productArrayList.add(new Product(R.drawable.food_img_2,"food 2","this is food 2","$3"));
        productArrayList.add(new Product(R.drawable.food_img_1,"food 1","this is food 1","$4"));
        productArrayList.add(new Product(R.drawable.food_img_1,"food 1","this is food 1","$2"));
        productArrayList.add(new Product(R.drawable.food_img_2,"food 2","this is food 2","$3"));
        productArrayList.add(new Product(R.drawable.food_img_1,"food 1","this is food 1","$4"));
        productArrayList.add(new Product(R.drawable.food_img_2,"food 2","this is food 2","$5"));
        productArrayList.add(new Product(R.drawable.food_img_1,"food 1","this is food 1","$2"));
        productArrayList.add(new Product(R.drawable.food_img_2,"food 2","this is food 2","$3"));
        productArrayList.add(new Product(R.drawable.food_img_1,"food 1","this is food 1","$4"));
        productArrayList.add(new Product(R.drawable.food_img_2,"food 2","this is food 2","$5"));

        recyclerView.setAdapter(new ProductAdapter(getContext(),productArrayList));
        return view;
    }
}