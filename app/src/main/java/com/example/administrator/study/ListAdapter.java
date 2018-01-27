package com.example.administrator.study;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/23.
 */

public class ListAdapter extends ArrayAdapter<Listt> {
    private int resourceId;

    public ListAdapter(@NonNull Context context, int resource,List<Listt> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }
    public View getView(int position,View convertView,ViewGroup parent){
        Listt list=getItem(position);
        //View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.img=(ImageView)view.findViewById(R.id.item_imgId);
            viewHolder.name=view.findViewById(R.id.item_name);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.img.setImageResource(list.getImgId());
        viewHolder.name.setText(list.getName());
       // ImageView img=(ImageView)view.findViewById(R.id.item_imgId);
       // TextView name=(TextView)view.findViewById(R.id.item_name);
        //img.setImageResource(list.getImgId());
       // name.setText(list.getName());
        return view;
    }

    private class ViewHolder {
        ImageView img;
        TextView name;
    }
}
