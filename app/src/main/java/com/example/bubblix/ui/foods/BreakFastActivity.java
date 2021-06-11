package com.example.bubblix.ui.foods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bubblix.R;
import com.example.bubblix.ui.CartActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BreakFastActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.smallCupTea) Button mSmallCup;
    @BindView(R.id.fulCUpTea) Button mFullCup;
    @BindView(R.id.three_chapo) Button mChapos;
//    @BindView(R.id.customOrderBtn) Button mSpecialOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break_fast);
        ButterKnife.bind(this);

        mSmallCup.setOnClickListener(this);
        mFullCup.setOnClickListener(this);
        mChapos.setOnClickListener(this);
//        mSmallCup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if ( v == mSmallCup){
           // send notification and ask for payment
        }
        else if ( v == mFullCup){

        }
        else if ( v == mChapos){

        }
    }
}