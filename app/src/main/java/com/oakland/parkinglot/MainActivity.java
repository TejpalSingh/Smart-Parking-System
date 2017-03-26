package com.oakland.parkinglot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    ImageView iv1,iv2,iv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv1=(ImageView)findViewById(R.id.imageView14) ;
        iv2=(ImageView)findViewById(R.id.imageView13) ;
        iv3=(ImageView)findViewById(R.id.imageView12) ;

        iv1.setVisibility(View.INVISIBLE);
        iv2.setVisibility(View.INVISIBLE);
        iv3.setVisibility(View.INVISIBLE);

        database=   FirebaseDatabase.getInstance();
        myRef = database.getReference("Parking_spot");

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                Log.e("test",dataSnapshot.toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s)
            {

                Log.e("test",dataSnapshot.toString());

               switch (Integer.valueOf(dataSnapshot.getKey()))

               {
                   case 3:

                       if(dataSnapshot.getValue().equals("0"))
                       {
                           iv1.setVisibility(View.INVISIBLE);
                       }
                       else
                       {
                           iv1.setVisibility(View.VISIBLE);
                       }

                       break;
                   case 2:

                       if(dataSnapshot.getValue().equals("0"))
                       {
                           iv2.setVisibility(View.INVISIBLE);
                       }
                       else
                       {
                           iv2.setVisibility(View.VISIBLE);
                       }
                       break;
                   case 1:

                       if(dataSnapshot.getValue().equals("0"))
                       {
                           iv3.setVisibility(View.INVISIBLE);
                       }
                       else
                       {
                           iv3.setVisibility(View.VISIBLE);
                       }
                       break;



               }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
