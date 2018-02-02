package com.example.peter.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.Collections;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

   public List<BookCls> mData;
    private Context mInflater;
    private static ItemClickListener mClickListener;

    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context mInflater, List<BookCls> data) {

        this.mInflater=mInflater;
        this.mData = data;
        this.mClickListener = mClickListener;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mInflater);
        View view = inflater.inflate(R.layout.recyclerview_row, null);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BookCls book1 = mData.get(position);
        holder.titleview.setText(book1.getTitle());
        holder.authorview.setText(book1.getAuthor());
        Drawable asdf = mInflater.getResources().getDrawable(book1.getImage());
        holder.imageView.setImageDrawable(asdf);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleview, authorview;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleview = itemView.findViewById(R.id.booktitle);
            authorview = itemView.findViewById(R.id.bookview);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            mClickListener.onItemClick(view, this.getAdapterPosition());
        }
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}