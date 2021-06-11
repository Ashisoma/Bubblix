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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bubblix.R;
import com.example.bubblix.adapters.FoodArrayAdapter;
import com.example.bubblix.ui.foods.BreakFastActivity;
import com.example.bubblix.ui.foods.LunchActivity;
import com.example.bubblix.ui.foods.SupperActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.LunchBtn) Button mLunchButton;
    @BindView(R.id.breakFastBTN) Button mBreakFastBtn;
    @BindView(R.id.SupperBtn) Button mSupperBtn;
    @BindView(R.id.customOrderBtn) Button mSpecialOrderBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);

        mBreakFastBtn.setOnClickListener(this);
        mLunchButton.setOnClickListener(this);
        mSupperBtn.setOnClickListener(this);
        mSpecialOrderBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ( v == mBreakFastBtn){
            Intent intent = new Intent(CartActivity.this, BreakFastActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        if ( v == mLunchButton){
            Intent intent = new Intent(CartActivity.this, LunchActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        if ( v == mSupperBtn){
            Intent intent = new Intent(CartActivity.this, SupperActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        if ( v == mSpecialOrderBtn){
            Intent intent = new Intent(CartActivity.this, CustomPurchaseActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

    }
}