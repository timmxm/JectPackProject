package com.example.mahti.jetpackproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<CardDetail> mData ;


    public RecyclerViewAdapter(MainActivity mContext, List<CardDetail> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_contact,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.card_name.setText(mData.get(position).getName());
        holder.card_blood.setText(mData.get(position).getBloodType());
        holder.card_allergy.setText(mData.get(position).getAllergies());
        holder.card_disease.setText(mData.get(position).getUnderlyingDisease());
        Picasso.with(holder.itemView.getContext()).load(mData.get(position).getImageUrl()).into(holder.card_pic);


        //holder.card_pic.setImageResource(mData.get(position).getPicture());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,CardDetailActivity.class);

                // passing data to the book activity
                intent.putExtra("card_name",mData.get(position).getName());
                intent.putExtra("card_blood",mData.get(position).getBloodType());
                intent.putExtra("card_allergy",mData.get(position).getAllergies());
                intent.putExtra("card_disease",mData.get(position).getUnderlyingDisease());
                intent.putExtra("phone_number",mData.get(position).getPhoneNumber());
                intent.putExtra("card_pic",mData.get(position).getImageUrl());
                // start the activity
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView ;

        TextView card_name;
        TextView card_blood;
        TextView card_allergy;
        TextView card_disease;
        ImageView card_pic;

        public MyViewHolder(View itemView) {
            super(itemView);

            card_name = (TextView) itemView.findViewById(R.id.card_name) ;
            card_blood = (TextView) itemView.findViewById(R.id.card_blood) ;
            card_allergy = (TextView) itemView.findViewById(R.id.card_allergy) ;
            card_disease = (TextView) itemView.findViewById(R.id.card_disease) ;

            card_pic = (ImageView) itemView.findViewById(R.id.card_pic);
            cardView = (CardView) itemView.findViewById(R.id.cardDetail);



        }
    }


}
