package com.example.fluxitdemo.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fluxitdemo.R;
import com.example.fluxitdemo.model.MenuItem;
import com.example.fluxitdemo.model.adapters.MenuItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private RecyclerView recyclerView;


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        recyclerView = view.findViewById(R.id.menuRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(new MenuItemAdapter(getMenuItems()));


        return view;
    }

    private List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        MenuItem purchasesQuestions = new MenuItem(R.drawable.circle_image_view_purchases_questions, "Preguntas");
        MenuItem purchasesAppraisals = new MenuItem(R.drawable.circle_image_view_appraisals, "Presupuestos");
        MenuItem purchasesPurchases = new MenuItem(R.drawable.circle_image_view_purchases_purchases, "Compras");
        MenuItem sellsUploads = new MenuItem(R.drawable.circle_image_view_sells_uploads, "Publicaciones");
        MenuItem sellsQuestions = new MenuItem(R.drawable.circle_image_view_sells_questions, "Preguntas");
        MenuItem sellsAppraisals = new MenuItem(R.drawable.circle_image_view_appraisals, "Presupuestos");
        MenuItem sellsSells = new MenuItem(R.drawable.circle_image_view_sells_sells, "Ventas");
        MenuItem configurationMyAccount = new MenuItem(R.drawable.circle_image_view_my_account, "Mis Datos");
        MenuItem configurationSecurity = new MenuItem(R.drawable.circle_image_view_configuration_security, "Seguridad");
        MenuItem configurationReputation = new MenuItem(R.drawable.circle_image_view_configuration_reputation, "Reputación");
        MenuItem configurationAdjustments = new MenuItem(R.drawable.circle_image_view_configuration_adjustments, "Ajustes");
        MenuItem configurationHelp = new MenuItem(R.drawable.circle_image_view_configuration_help, "Ayuda");

        menuItems.add(purchasesQuestions);
        menuItems.add(purchasesAppraisals);
        menuItems.add(purchasesPurchases);
        menuItems.add(sellsUploads);
        menuItems.add(sellsQuestions);
        menuItems.add(sellsAppraisals);
        menuItems.add(sellsSells);
        menuItems.add(configurationMyAccount);
        menuItems.add(configurationSecurity);
        menuItems.add(configurationReputation);
        menuItems.add(configurationAdjustments);
        menuItems.add(configurationHelp);

        return menuItems;
    }

}
