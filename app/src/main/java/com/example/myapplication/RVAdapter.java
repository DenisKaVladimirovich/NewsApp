package com.example.myapplication;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Денис on 14.05.2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{
    List<Person> persons;
    RVAdapter(List<Person> persons){
        this.persons = persons;
    }
    View v;
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int position) {
        personViewHolder.personName.setText(persons.get(position).name);
        personViewHolder.personAge.setText(persons.get(position).age);
        Picasso.with(v.getContext()).load(persons.get(position).photoId).into(personViewHolder.personPhoto);
        v.setOnClickListener(new PostClickListener(position));

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }


    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;
        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }
}