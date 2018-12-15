package com.example.mahti.jetpackproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// Main adapter inherits RecyclerView.Adapter<BaseViewHolder>
// so there are some methods needed to be overridden

public class MainAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<BaseItem> itemList = new ArrayList<>();


    // Create the view that is holding our item
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        if (viewType == ViewType.TYPE_CARD_VIEW) {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_contact, parent, false);
            return new CardViewHolder(v);
        }
        throw new RuntimeException("Type doesn't not match");
    }

    // Bind the view holder (View) to the item (Model)
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        BaseItem i = itemList.get(position);
        if (holder instanceof CardViewHolder) {
            CardViewItem cardViewItem = (CardViewItem) i;
            ((CardViewHolder) holder).setcard_pic(cardViewItem.getcard_pic());
            ((CardViewHolder) holder).setcard_name(cardViewItem.getcard_name());
            ((CardViewHolder) holder).setcardPrompt_blood(cardViewItem.getcardPrompt_blood());
            ((CardViewHolder) holder).setcard_blood(cardViewItem.getcard_blood());
            ((CardViewHolder) holder).setcardPrompt_allergy(cardViewItem.getcardPrompt_allergy());
            ((CardViewHolder) holder).setcard_allergy(cardViewItem.getcard_allergy());
            ((CardViewHolder) holder).setcardPrompt_disease(cardViewItem.getcardPrompt_disease());
            ((CardViewHolder) holder).setcard_disease(cardViewItem.getcard_disease());
        }
    }

    // The following methods used to operate list such as count, get, set
    @Override
    public int getItemCount() {
        if (!itemList.isEmpty()) { // || itemList != null) {
            return itemList.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position).getType();
    }

    public void setItemList(List<BaseItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }
}