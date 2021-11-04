package com.akhdanfirdaus.orderin.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Item {
    final Drawable photo;
    final String name;
    final int price;
    final String description;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    Item(Drawable photo, String name, int price, String description) {
        this.photo = photo;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
