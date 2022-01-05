package com.akhdanfirdaus.orderin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.akhdanfirdaus.orderin.model.DataSource;
import com.akhdanfirdaus.orderin.model.Item;
import com.akhdanfirdaus.orderin.model.ItemAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        ArrayList<Item> list = DataSource.getListItem(getApplicationContext());
        ItemAdapter adapter = new ItemAdapter(list);

        RecyclerView rv = findViewById(R.id.item_list_rv);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_action_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem profile = menu.getItem(R.id.menu_profile);
        profile.setTitle(currentUser.getEmail());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout_menu) {
            mAuth.signOut();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}