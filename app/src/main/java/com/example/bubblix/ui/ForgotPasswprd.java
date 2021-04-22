package com.example.bubblix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bubblix.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;

public class ForgotPasswprd extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.forgotPasswordButton)
    Button mForgotPasswordButton;
    @BindView(R.id.forgotEmailEditText)
    EditText mForgotEmailEditText;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_passwprd);

        mForgotPasswordButton.setOnClickListener(this);

        mAuth = mAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        if (v == mForgotPasswordButton) {
            resetPassword();
        }
    }

    private void resetPassword() {
        String email = mForgotEmailEditText.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            mForgotEmailEditText.setError("Please enter a valid email address");
            mForgotEmailEditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mForgotEmailEditText.setError("Please provide a valid email");
            mForgotEmailEditText.requestFocus();
            return;
        }

        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Toast.makeText(ForgotPasswprd.this, "Check your email to reset your password",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(ForgotPasswprd.this, "Try again! Something went wrong.",Toast.LENGTH_LONG).show();

            }
        });
    }
}