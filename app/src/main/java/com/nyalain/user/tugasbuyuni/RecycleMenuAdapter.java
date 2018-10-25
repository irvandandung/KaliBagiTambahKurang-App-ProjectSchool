package com.nyalain.user.tugasbuyuni;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleMenuAdapter extends RecyclerView.Adapter<RecycleMenuAdapter.ViewHolder> {

    private ArrayList<MenuModel> lists;
    private String TAG = getClass().getSimpleName();

    public RecycleMenuAdapter(ArrayList<MenuModel> lists){
        Log.d(TAG, "RecycleMenuAdapter: " + lists);
        this.lists = lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item_menu,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + lists);
        holder.textJudul.setText(lists.get(position).getJudul_menu());
        holder.textDeskripsi.setText(lists.get(position).getDeskripsi_menu());
        holder.imageMenu.setImageResource(lists.get(position).getImage_menu());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.image_menu)
        ImageView imageMenu;
        @BindView(R.id.text_judul_menu)
        TextView textJudul;
        @BindView(R.id.text_deskripsi_menu)
        TextView textDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            v.getContext().startActivity(new Intent(v.getContext(), DetailActivity.class)
                    .putExtra("MENU",String.valueOf(getAdapterPosition())));
        }
    }
}