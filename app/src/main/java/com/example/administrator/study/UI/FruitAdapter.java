package com.example.administrator.study.UI;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.study.R;

import java.util.List;

/**
 * Created by Administrator on 2018/1/27.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private Context mContext;
    private List<Fruit> mFruitLst;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView fruitimage;
        TextView fruitname;
        public ViewHolder(View view) {
            super(view);
            cardView=(CardView)view;
            fruitimage=(ImageView)view.findViewById(R.id.fruit_image);
            fruitname=(TextView)view.findViewById(R.id.fruit_name);
        }
    }
    public FruitAdapter(List<Fruit> fruitList){
        mFruitLst=fruitList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Fruit fruit=mFruitLst.get(position);
                Intent t=new Intent(mContext,FruitActivity.class);
                t.putExtra(FruitActivity.FRUIT_NAME,fruit.getName());
                t.putExtra(FruitActivity.FRUIT_IMAGE_ID,fruit.getImgId());
                mContext.startActivity(t);
            }
        });
        //return new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit=mFruitLst.get(position);
        holder.fruitname.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImgId()).into(holder.fruitimage);
    }

    @Override
    public int getItemCount() {
        return mFruitLst.size();
    }


}
