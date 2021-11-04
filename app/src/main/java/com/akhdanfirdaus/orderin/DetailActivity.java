package com.akhdanfirdaus.orderin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.akhdanfirdaus.orderin.model.DataSource;
import com.akhdanfirdaus.orderin.model.Item;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int selectedItem = getIntent().getIntExtra("id", -1);

        if (selectedItem != -1) {
            Item item = DataSource.getListItem(getApplicationContext()).get(selectedItem);

            getSupportActionBar().setTitle(item.getName());

            ImageView photoView = findViewById(R.id.item_photo);
            TextView nameView = findViewById(R.id.item_name);
            TextView priceView = findViewById(R.id.item_price);
            TextView descriptionView = findViewById(R.id.item_description);

            photoView.setBackground(item.getPhoto());
            nameView.setText(item.getName());
            priceView.setText("Rp. " + item.getPrice());
            descriptionView.setText(item.getDescription());
        }
    }
}