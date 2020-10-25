package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.musicshop.test.TestClass;

import java.util.*;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    Button minButton;
    Button plusButton;
    Button addToCart;
    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    TextView quantityText;
    HashMap goodsMap;
    String goodsName;
    double price;
    ImageView goodsImageView;
    EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        spinnerArrayList = ShopData.list;
        goodsMap = ShopData.createMap();
//
//        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
//        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(spinnerAdapter);
//        spinner.setOnItemSelectedListener(this);

//       settingListeners();
        settingSpinner();


        minButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                decreaseQuantity();
            }
        });
        addToCart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addToCart();
            }
        });
        plusButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                increaseQuantity();
            }
        });
}

    private void initViews()
    {
        spinner = findViewById(R.id.spinner);
        minButton = findViewById(R.id.minButton);
        addToCart = findViewById(R.id.addToCart);
        plusButton = findViewById(R.id.plusButton);
        quantityText = findViewById(R.id.quantityText);
        goodsImageView = findViewById(R.id.goodsImageView);
        userNameEditText = findViewById(R.id.usernameEditText);

    }
    private void settingListeners()
    {
//        spinnerArrayList = ShopData.list;
//        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
//        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(spinnerAdapter);
//        spinner.setOnItemSelectedListener(this);

    }
    private void settingSpinner()
    {
        spinnerArrayList = ShopData.list;
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void increaseQuantity()
    {
        quantity = quantity + 1;
        TextView quantityText = findViewById(R.id.quantityText);
        quantityText.setText("" + quantity);
        TextView zeroText = findViewById(R.id.zeroText);
        zeroText.setText("" + quantity * price);
    }

    public void addToCart()
    {
        Order order = new Order();
        order.userName = userNameEditText.getText().toString();
        order.quantity = quantity;
        order.goodsName = goodsName;
        order.price = price;
        order.orderPrice = quantity * price;

        Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
        orderIntent.putExtra("userNameForIntent", order.userName);
        orderIntent.putExtra("quantity", order.quantity);
        orderIntent.putExtra("goodsName", order.goodsName);
        orderIntent.putExtra("price", order.price);
        orderIntent.putExtra("orderPrice", order.orderPrice);

        startActivity(orderIntent);

    }
    public void decreaseQuantity()
    {
        quantity = quantity - 1;
        if (quantity < 0)
        {
            quantity = 0;
        }

        quantityText.setText("" + quantity);
        TextView zeroText = findViewById(R.id.zeroText);
        zeroText.setText("" + quantity * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        goodsName = spinner.getSelectedItem().toString();
        price = (double) goodsMap.get(goodsName);
        TextView zeroText = findViewById(R.id.zeroText);
        zeroText.setText("" + quantity * price);
        switch (goodsName)
        {
            case "Bajaj":
                goodsImageView.setImageResource(R.drawable.bajaj);
                break;
            case "BMW":
                goodsImageView.setImageResource(R.drawable.bmw);
                break;
            case "Suzuki":
                goodsImageView.setImageResource(R.drawable.suzuki);
                break;
            case "KTM":
                goodsImageView.setImageResource(R.drawable.ktm);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}