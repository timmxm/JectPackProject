package com.example.mahti.jetpackproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<CardDetail> mData ;


    public RecyclerViewAdapter(Context mContext, List<CardDetail> mData) {
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

        holder.card_name.setText(mData.get(position).getcard_name());
        holder.card_blood.setText(mData.get(position).getcard_blood());
        holder.card_allergy.setText(mData.get(position).getcard_allergy());
        holder.card_disease.setText(mData.get(position).getcard_disease());

        holder.card_pic.setImageResource(mData.get(position).getcard_pic());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,CardDetailActivity.class);

                // passing data to the book activity
                intent.putExtra("card_name",mData.get(position).getcard_name());
                intent.putExtra("card_blood",mData.get(position).getcard_blood());
                intent.putExtra("card_allergy",mData.get(position).getcard_allergy());
                intent.putExtra("card_disease",mData.get(position).getcard_disease());
                intent.putExtra("phone_number",mData.get(position).getphone_number());
                intent.putExtra("card_pic",mData.get(position).getcard_pic());
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
