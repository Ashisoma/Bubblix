package com.example.bubblix.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.bubblix.helper.UserHelper;

import com.example.bubblix.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        user = FirebaseAuth.getInstance().getCurrentUser();

        reference = FirebaseDatabase.getInstance().getReference("users");

        userId = user.getUid();

        final TextView greeting = findViewById(R.id.greeting);
        final TextView fullName = findViewById(R.id.nameTV);
        final TextView accountEmail = findViewById(R.id.emailTv);
        final TextView myLocation = findViewById(R.id.locationTv);


        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelper profile = snapshot.getValue(UserHelper.class);
                if (profile != null){

                    String name = profile.fullName;
                    String email = profile.email;
                    String location = profile.location;

                    fullName.setText(name);
                    myLocation.setText(location);
                    greeting.setText("Welcome, "+ name + "!");
                    fullName.setText(name);
                    accountEmail.setText(email);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfileActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        });
    }

}