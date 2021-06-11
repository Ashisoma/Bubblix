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

public class SupperActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.mayaiBtn) Button mMayai;
    @BindView(R.id.mixUgalibtn) Button mMixBtn;
    @BindView(R.id.mBambaBtn) Button mBamba;
    @BindView(R.id.mPilauBTN) Button mPilau;
    @BindView(R.id.riceNdenguBtn) Button mRiceNdengu;
    @BindView(R.id.mMatumboBTN) Button mMatumbo;
    @BindView(R.id.mriceBeansBTN) Button mRiceBeans;
    @BindView(R.id.mOmenBTN) Button mOmenBTN;
    @BindView(R.id.mCustomBtnO) Button mCustomBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supper);
        ButterKnife.bind(this);

        mBamba.setOnClickListener(this);
        mCustomBTN.setOnClickListener(this);
        mMatumbo.setOnClickListener(this);
        mMayai.setOnClickListener(this);
        mMixBtn.setOnClickListener(this);
        mOmenBTN.setOnClickListener(this);
        mPilau.setOnClickListener(this);
        mRiceBeans.setOnClickListener(this);
        mRiceNdengu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if ( v == mBamba){
            // send notification and ask for payment
        }
        else if ( v == mCustomBTN){
            Intent intent = new Intent(SupperActivity.this, CustomPurchaseActivity.class);
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
        else if ( v == mMixBtn){

        }
    }
}