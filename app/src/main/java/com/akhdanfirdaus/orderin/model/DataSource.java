package com.akhdanfirdaus.orderin.model;

import android.content.Context;

import com.akhdanfirdaus.orderin.R;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Item> getListItem(Context context) {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Item(context.getDrawable(R.drawable.batagor), "Batagor", 10000, "Batagor merupakan nama makanan dari singkatan bakso, tahu, dan goreng. Makanan khas Sunda ini adalah adaptasi dari hidangan Tionghoa-Indonesia."));
        list.add(new Item(context.getDrawable(R.drawable.nasigoreng), "Nasi Goreng", 15000, "Nasi goreng adalah sebuah makanan berupa nasi yang digoreng dan diaduk dalam minyak goreng, margarin, atau mentega. Biasanya ditambah kecap manis, bawang merah, bawang putih, asam jawa, lada dan bumbu-bumbu lainnya; seperti telur, ayam, dan kerupuk"));
        list.add(new Item(context.getDrawable(R.drawable.cireng), "Cireng", 2000, "Cireng adalah makanan ringan yang berasal dari daerah Sunda yang dibuat dengan cara menggoreng campuran adonan yang berbahan utama tepung kanji atau tapioka."));
        list.add(new Item(context.getDrawable(R.drawable.donut), "Donat", 2000, "Donat adalah penganan yang digoreng, dibuat dari adonan tepung terigu, gula, telur, dan mentega. Donat yang paling umum adalah donat berbentuk cincin dengan lubang di tengah dan donat berbentuk bundar dengan isian manis, seperti selai, jelly, krim, dan custard."));
        list.add(new Item(context.getDrawable(R.drawable.mie_goreng), "Mie Goreng", 5000, "Mi goreng berarti \"mi yang digoreng\" adalah makanan yang berasal dari Indonesia yang populer dan juga digemari di Malaysia, dan Singapura."));
        return list;
    }

    public static Item findItem(Context context, String name) {
        ArrayList<Item> data = getListItem(context);
        for (Item item : data) {
            if (item.getName().contains(name)) {
                return item;
            }
        }
        return null;
    }
}
