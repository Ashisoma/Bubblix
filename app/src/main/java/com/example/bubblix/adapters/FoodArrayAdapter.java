package com.example.bubblix.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

public class FoodArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mFoodName;
    private String [] mFoodPrice;

    public FoodArrayAdapter(Context mContext, int resource, String [] mArtistsSong, String [] mArtistName){
        super(mContext, resource);
        this.mFoodName = mArtistsSong;
        this.mContext = mContext;
        this.mFoodPrice = mArtistName;
    }

    @Override
    public Object getItem(int position) {
        String foodName = mFoodName[position];
        String foodPrice = mFoodPrice[position];
        return  String.format("%s \nHit Song: %s", foodName, foodPrice);
    }

    @Override
    public int getCount(){
        return mFoodName.length;
    }
}
