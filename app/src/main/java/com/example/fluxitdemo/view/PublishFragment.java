package com.example.fluxitdemo.view;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fluxitdemo.R;



public class PublishFragment extends Fragment {

    private CardView circleImageViewProducts;
    private CardView circleImageViewVehicles;
    private CardView circleImageViewRealState;
    private CardView circleImageServices;



    public PublishFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_publish, container, false);

        circleImageViewProducts = view.findViewById(R.id.circleImageViewProducts);
        circleImageViewVehicles = view.findViewById(R.id.circleImageViewVehicles);
        circleImageViewRealState = view.findViewById(R.id.circleImageViewRealState);
        circleImageServices = view.findViewById(R.id.circleImageViewServices);

        return view;
    }

}
