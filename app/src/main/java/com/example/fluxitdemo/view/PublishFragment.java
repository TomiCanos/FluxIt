package com.example.fluxitdemo.view;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fluxitdemo.R;

import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublishFragment extends Fragment {

    private CircleImageView circleImageViewProducts;
    private CircleImageView circleImageViewVehicles;
    private CircleImageView circleImageViewRealState;
    private CircleImageView circleImageServices;



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
