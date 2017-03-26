package com.oakland.parkinglot;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class demoPark extends Fragment{

    public demoPark() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FirebaseDatabase database;
    DatabaseReference myRef;
    ImageView iv1,iv2,iv3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


View view=inflater.inflate(R.layout.park_demo, container, false);

        iv1=(ImageView)view.findViewById(R.id.imageView14) ;
        iv2=(ImageView)view.findViewById(R.id.imageView13) ;
        iv3=(ImageView)view.findViewById(R.id.imageView12) ;

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



        // Inflate the layout for this fragment
        return view;




    }

}
