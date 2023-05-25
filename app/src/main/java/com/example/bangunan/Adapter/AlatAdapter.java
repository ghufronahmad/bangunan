package com.example.bangunan.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bangunan.R;

import java.util.ArrayList;

public class AlatAdapter extends RecyclerView.Adapter<AlatAdapter.ViewHolder> {
    ArrayList<AlatAdapter>alatDomains;

    public AlatAdapter(ArrayList<AlatAdapter> alatDomains) {
        this.alatDomains = alatDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_alat,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull AlatAdapter.ViewHolder holder, int position) {
        holder.title.setText(alatDomains.get(position).getTitle());

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(alatDomains,get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return alatDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView pic;
        TextView addQ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            pic=itemView.findViewById(R.id.picBor);
            addQ=itemView.findViewById(R.id.addQ);
        }
    }
}
