package com.example.bubblix.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.bubblix.R;

import java.util.UUID;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        payBtn = this.view.findViewById(R.id.payBtn);
        mPesaPhoneNumber = this.view.findViewById(R.id.mpesa_phone_number);
        mPesaAmount = this.view.findViewById(R.id.mpesa_amount);
        amountToPay = this.view.findViewById(R.id.paymentAmount);
        pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        payBtn.setOnClickListener(this);

        mDarajaApiClient = new DarajaApiClient();
        mProgressDialog = new ProgressDialog(getContext());
    }

    private void initUI(View view) {

        String payable_balance = getArguments().getString("payable_balance", "0");

        Log.w("wwwwwwwww", getArguments().toString());

        pref = PreferenceManager.getDefaultSharedPreferences(getActivity());


        String payment_amount = payable_balance;
        String first_name = pref.getString("_login_first_name", "");

        String last_name = pref.getString("_login_last_name", "");
        String email = pref.getString("_login_user_email", "");
        String phone_number = pref.getString("_login_phone_number", "");
        String currency_code = "KES";
        Integer member_code = pref.getInt("_login_user_id", '0');
        String user_code = "03001170251810"; //pref.getString("_login_user_code", "");

        String reference = UUID.randomUUID().toString();

//        TextView tvAmount = (TextView) view.findViewById(R.id.tvHowToPay_amount);
        //TextView tvMemberCode = (TextView) view.findViewById(R.id.tvHowToPay_member_account_number);
//        TextView tvPayNowMpesa = (TextView) view.findViewById(R.id.tvPayNowMpesa);


        //tvMemberCode.setText(tvMemberCode.getText().toString() + " " + user_code);

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager manager = getActivity().getPackageManager();

                Intent intent = manager.getLaunchIntentForPackage("com.android.stk");
                if ( intent != null ) {
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "It seems like you do not have the Sim Toolkit. Open it manually.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void getAccessToken(){
        mDarajaApiClient.setGetAccessToken(true);
        mDarajaApiClient.mpesaService().getAccessToken().enqueue(new Callback<com.knownafrique.haki.models.net.mpesa_models.AccessToken>() {
            @Override
            public void onResponse(Call<com.knownafrique.haki.models.net.mpesa_models.AccessToken> call, Response<com.knownafrique.haki.models.net.mpesa_models.AccessToken> response) {
                if (response.isSuccessful()){
                    mDarajaApiClient.setAuthToken(response.body().accessToken);
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {

            }
        });
    }

    public void performSTKPush(String phoneNumber, String amount) {
        mProgressDialog.setTitle("Please wait...");
        mProgressDialog.setMessage("Processing your request");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();

        String timeStamp = MpesaDetailsValidation.getTimeStamp();
        STKPush stkPush = new STKPush(
                BUSINESS_SHORT_CODE,
                MpesaDetailsValidation.getPassword(BUSINESS_SHORT_CODE, PASSKEY, timeStamp),
                timeStamp,
                TRANSACTION_TYPE,
                String.valueOf(amount),
                MpesaDetailsValidation.sanitizePhoneNumber(phoneNumber),
                PARTYB,
                MpesaDetailsValidation.sanitizePhoneNumber(phoneNumber),
                CALLBACKURL,
                "HAKI", //Account reference
                "Testing"  //Transaction description
        );

        mDarajaApiClient.setGetAccessToken(false);

        //Send data to mpesa API
        mDarajaApiClient.mpesaService().sendPush(stkPush).enqueue(new Callback<MpesaResponse>() {
            @Override
            public void onResponse(@NonNull Call<MpesaResponse> call, @NonNull Response<MpesaResponse> response) {
                mProgressDialog.dismiss();
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "---------------success ------------");
                        mpesaMerchantId =  response.body().getMerchantRequestID();
                        Log.d(TAG, mpesaMerchantId);
                        sendMpesaData(mpesaMerchantId);
                    } else {
                        Timber.e("Response %s", response.errorBody().string());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MpesaResponse> call, @NonNull Throwable t) {
                mProgressDialog.dismiss();
                Timber.e(t);
            }
        });

    }
    @Override
    public void onClick(View v) {
        if (v == payBtn){
            Toast.makeText(getContext(), "Processing...", Toast.LENGTH_LONG).show();
            String phone = mPesaPhoneNumber.getText().toString().trim();
            String amnt = mPesaAmount.getText().toString().trim();
            String amount = pref.getString("hourly_charge",amnt);
//          performSTKPush(phone, "1");
            performSTKPush(phone, amnt);

        }
    }
}