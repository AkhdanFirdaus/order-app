package com.akhdanfirdaus.orderin.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Item {
    final int id;
    final String name;
    final int price;
    final String description;
    final String photo;

    public int getId() {return id; }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() { return photo; }

    Item(int id, String name, int price, String description, String photo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.photo = photo;
    }
}
