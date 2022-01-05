package com.akhdanfirdaus.orderin.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class DataSource extends SQLiteOpenHelper {
    private static final String DBNAME = "orderapp";
    private static final int DBVER = 1;

    public DataSource(Context context) {
        super(context, DBNAME, null, DBVER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE menu (id INTEGER PRIMARY KEY NOT NULL, name STRING NOT NULL, price INTEGER NOT NULL, description STRING NOT NULL, photo STRING NOT NULL)";
        sqLiteDatabase.execSQL(sql);

        Log.d("SQLTAG", "onCreate:" + sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS menu");
        onCreate(sqLiteDatabase);
    }

    public void insertDummyData() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(1, "Batagor", 10000, "Batagor merupakan nama makanan dari singkatan bakso, tahu, dan goreng. Makanan khas Sunda ini adalah adaptasi dari hidangan Tionghoa-Indonesia.", "batagor"));
        list.add(new Item(2, "Nasi Goreng", 15000, "Nasi goreng adalah sebuah makanan berupa nasi yang digoreng dan diaduk dalam minyak goreng, margarin, atau mentega. Biasanya ditambah kecap manis, bawang merah, bawang putih, asam jawa, lada dan bumbu-bumbu lainnya; seperti telur, ayam, dan kerupuk", "nasigoreng"));
        list.add(new Item(3, "Cireng", 2000, "Cireng adalah makanan ringan yang berasal dari daerah Sunda yang dibuat dengan cara menggoreng campuran adonan yang berbahan utama tepung kanji atau tapioka.", "cireng"));
        list.add(new Item(4, "Donat", 2000, "Donat adalah penganan yang digoreng, dibuat dari adonan tepung terigu, gula, telur, dan mentega. Donat yang paling umum adalah donat berbentuk cincin dengan lubang di tengah dan donat berbentuk bundar dengan isian manis, seperti selai, jelly, krim, dan custard.", "donut"));
        list.add(new Item(5, "Mie Goreng", 5000, "Mi goreng berarti \"mi yang digoreng\" adalah makanan yang berasal dari Indonesia yang populer dan juga digemari di Malaysia, dan Singapura.", "mie_goreng"));

        for (Item item : list) {
            insertData(item);
        }
    }

    public void insertData(Item item) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", item.getId());
        contentValues.put("name", item.getName());
        contentValues.put("price", item.getPrice());
        contentValues.put("description", item.getDescription());
        contentValues.put("photo", item.getPhoto());

        SQLiteDatabase db = this.getWritableDatabase();
        long res = db.insert("menu", null, contentValues);
        Log.d("SQLTAG", res +" is Inserted");
        db.close();
    }

    public ArrayList<Item> readData() {
        String sql = "SELECT * FROM menu";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery(sql, null);

        ArrayList<Item> list = new ArrayList<>();

        while (result.moveToNext()) {
            Log.d("SQLTAG", "Data: " + result.getString(1).toString());
            list.add(new Item(result.getInt(0), result.getString(1), result.getInt(2), result.getString(3), result.getString(4)));
        }

        result.close();

        return list;
    }

    public Item readById(int id) {
        String sql = "SELECT * FROM menu WHERE id = " + id;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery(sql, null);

        Item item = null;

        if (result.moveToFirst()) {
            item = new Item(result.getInt(0), result.getString(1), result.getInt(2), result.getString(3), result.getString(4));
        }

        result.close();

        return item;
    }
}
