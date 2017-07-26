package com.nnc.hughes.gpsshopper;

/**
 * Created by marcus on 7/26/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nnc.hughes.gpsshopper.Models.Roster;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RosterAdapter extends RecyclerView.Adapter<RosterAdapter.ViewHolder> {
    private ArrayList<Roster> roster;
    private Context context;
    public RosterAdapter(Context context,ArrayList<Roster> roster) {
        this.context = context;
        this.roster = roster;

    }
    private OnItemClickListener onItemClickListener;
    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    @Override
    public RosterAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RosterAdapter.ViewHolder viewHolder, int i) {
        final Roster player = roster.get(i);
        viewHolder.name.setText(roster.get(i).getName());
        viewHolder.position.setText(roster.get(i).getPosition());
        Picasso.with(context).load(roster.get(i).getImageUrl()).resize(120, 120).into(viewHolder.picture);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(player);
            }
        };
        viewHolder.mView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return roster.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,position;
        private ImageView picture;
        private View mView;
        public ViewHolder(View view) {
            super(view);
            mView = view;
            name = (TextView)view.findViewById(R.id.name);
            position = (TextView)view.findViewById(R.id.position);
            picture = (ImageView)view.findViewById(R.id.imageView);

        }
    }

}