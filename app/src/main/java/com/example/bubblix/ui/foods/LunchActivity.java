package com.example.bubblix.ui.foods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bubblix.R;
import com.example.bubblix.ui.CartActivity;
import com.example.bubblix.ui.CustomPurchaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LunchActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.matumboBTN) Button mMatumbo;
    @BindView(R.id.ugaliMAyaiBTN) Button mMayai;
    @BindView(R.id.riceBeansBTN) Button mRiceBeans;
    @BindView(R.id.riceNdenguBTN) Button mRiceNdengu;
    @BindView(R.id.bambaBtn) Button mBamba;
    @BindView(R.id.ugaliMixBtn) Button mUgaliMix;
    @BindView(R.id.pilauBtn) Button mPilau;
    @BindView(R.id.CUSTOMbTN) Button mCustomOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        ButterKnife.bind(this);

        mMatumbo.setOnClickListener(this);
        mMayai.setOnClickListener(this);
        mRiceBeans.setOnClickListener(this);
        mRiceNdengu.setOnClickListener(this);
        mBamba.setOnClickListener(this);
        mUgaliMix.setOnClickListener(this);
        mPilau.setOnClickListener(this);
        mCustomOrder.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if ( v == mBamba){
            // send notification and ask for payment
        }
        else if ( v == mCustomOrder){
            Intent intent = new Intent(LunchActivity.this, CustomPurchaseActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        else if ( v == mMayai){

        }
        else if ( v == mPilau){

        }
        else if ( v == mRiceBeans){

        }
        else if ( v == mRiceNdengu){

        }
        else if ( v == mUgaliMix){

        }

    }
}