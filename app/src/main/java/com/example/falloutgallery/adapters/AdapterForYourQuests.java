package com.example.falloutgallery.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falloutgallery.R;
import com.example.falloutgallery.classes.CardItem;
import com.example.falloutgallery.inTheCard;

import java.util.ArrayList;

public class AdapterForYourQuests extends RecyclerView.Adapter<AdapterForYourQuests.RecyclerViewViewHolder> {
    private ArrayList<CardItem> arrayList;
    private Context context;

    public class RecyclerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView textView;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            imageView =itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView1);
        }

        @Override
        public void onClick(View v){
            int position = getAdapterPosition();
            CardItem cardItem = arrayList.get(position);

            Intent intent = new Intent(context, inTheCard.class);
            intent.putExtra("imgRsrc",cardItem.getImgRsrc());
            intent.putExtra("title", cardItem.getTitle());

            context.startActivity(intent);
        }

    }

    public AdapterForYourQuests(ArrayList<CardItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterForYourQuests.RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layot, parent,false);
        AdapterForYourQuests.RecyclerViewViewHolder recyclerViewViewHolder = new AdapterForYourQuests.RecyclerViewViewHolder(view);

        return recyclerViewViewHolder;
    }

    public void onBindViewHolder(@NonNull AdapterForYourQuests.RecyclerViewViewHolder holder, int position) {
        CardItem cardItem = arrayList.get(position);
        holder.imageView.setImageResource(cardItem.getImgRsrc());
        holder.textView.setText(cardItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
