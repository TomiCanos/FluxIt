package com.example.fluxitdemo.model.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fluxitdemo.R;
import com.example.fluxitdemo.model.MenuItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter {

    private List<MenuItem> menuItems;

    public MenuItemAdapter (List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    //grabs de view to be inflated
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View menuItemCell = inflater.inflate(R.layout.recycler_view_menu_item_cell, parent, false);
        MenuItemHolder menuItemHolder = new MenuItemHolder(menuItemCell);

        return menuItemHolder;
    }

    //binds each product with its recycler view list cell
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuItem menuItem = menuItems.get(position);
        ((MenuItemHolder) holder).loadView(menuItem);
    }


    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    //inflates the view with the information of the selected product
    private class MenuItemHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView icon;


        public MenuItemHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.recycler_view_menu_item_title);
            icon = itemView.findViewById(R.id.recycler_view_menu_item_icon);
        }

        public void loadView(MenuItem menuItem) {
            title.setText(menuItem.getText());
            icon.setImageResource(menuItem.getImage());
        }
    }
}
