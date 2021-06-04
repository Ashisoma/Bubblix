package com.example.bubblix.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bubblix.R;
import com.example.bubblix.adapters.FoodArrayAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;

public class CartActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private  String[] songName = new String[]{"hello", "jesus", "love", "better", "Live for you", "At the Center", "Come as you are", "we belong to you", "who am i", "Moyo wangu", "One day ata a time", "I can only imagine", "Wanna be happy"};
    private String [] artistName = new String[] {"Adele", "Ada", "hER", "hIM", "L.M.A.M","Houghton", "Crowder", "T-sharp", "hillsong", "Patrick Kibuya", "Bill Gaither", "Mercy me", "Kirk Franklyne"};
    @BindView(R.id.listView)
    ListView mListView;
//    @BindView(R.id.songTextView)
    TextView mSongTextView;
    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        FoodArrayAdapter adapter = new FoodArrayAdapter(this, android.R.layout.simple_list_item_1, songName, artistName);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String song = ((TextView)view).getText().toString();
                Toast.makeText(CartActivity.this, song, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String nameSong = intent.getStringExtra("song");
        mSongTextView.setText("Here are the songs available: " + nameSong);



        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // textView=findViewById(R.id.textView);
        toolbar = findViewById(R.id.toolbar);

        /// toolbar

        setSupportActionBar(toolbar);

        // navigation
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(CartActivity.this, DashboardActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                Intent intent2 = new Intent(CartActivity.this, ProfileActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_cart:
                Intent i = new Intent(CartActivity.this, CartActivity.class);
                startActivity(i);
                break;
            case R.id.logOut:
                FirebaseAuth.getInstance().signOut();
                Intent intent3 = new Intent(CartActivity.this, LogIn.class);
                startActivity(intent3);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_contact:
                Toast.makeText(this, "We will get back to you shortly", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}