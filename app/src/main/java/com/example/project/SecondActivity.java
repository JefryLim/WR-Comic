package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView title, description, stock;
    EditText amount;
    Button addcart;

    String data1, data2, data3;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        stock = findViewById(R.id.stock_TV);
        amount = findViewById(R.id.editamount_ET);
        addcart = findViewById(R.id.add_to_cart_B);

        getData();
        setData();
        addCart();
    }

    private void addCart() {
        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amount.getText().toString().isEmpty()){
                    Toast.makeText(SecondActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SecondActivity.this, "Thank you for your purchase!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("data3")){

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            myImage = getIntent().getIntExtra("myImage",1);
        }else{
            Toast.makeText(this,"No Data.", Toast.LENGTH_LONG).show();
        }
    }
    private void setData(){
        title.setText(data1);
        description.setText(data2);
        stock.setText(data3);
        mainImageView.setImageResource(myImage);
    }
}