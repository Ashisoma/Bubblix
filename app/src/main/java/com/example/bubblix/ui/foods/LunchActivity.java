package com.example.bubblix.ui.foods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bubblix.R;

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

    }
}