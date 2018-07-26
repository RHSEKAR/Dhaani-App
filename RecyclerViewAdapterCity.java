package com.example.jojo.dhaaniapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterCity extends RecyclerView.Adapter<RecyclerViewAdapterCity.ViewHolderCity> {

    private Context mContext;
    private List<City> cityList;
    View view;

    public RecyclerViewAdapterCity(Context mContext, List<City> cityList) {
        this.mContext = mContext;
        this.cityList = cityList;
    }

    public RecyclerViewAdapterCity.ViewHolderCity onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_show_city, parent, false);


        return new RecyclerViewAdapterCity.ViewHolderCity(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterCity.ViewHolderCity holder, final int position) {


        final City CityDetails = cityList.get(position);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent onClickIntent = new Intent(mContext, OnClickItemView.class);
                onClickIntent.putExtra("city_name", CityDetails.getCityName());
                onClickIntent.putExtra("desc", CityDetails.getDesc());
                onClickIntent.putExtra("image", CityDetails.getCityImage());

                mContext.startActivity(onClickIntent);


                //-----------------------------------------------------------
                //  StringBuffer s = new StringBuffer();
                //  s.append(position);
                //  Toast.makeText(mContext,s.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        try {
            //   URL url = new URL(MoviesDetails.getImage());
            //   Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            // holder.imageView.setImageBitmap(bmp);

            Picasso.with(mContext).load(CityDetails.getCityImage()).into(holder.imageView);

            //holder.imageView.setImageResource(R.drawable.ic_launcher_background);

        } catch (Exception e) {
            holder.imageView.setImageResource(R.drawable.ic_launcher_background);

            // Toast.makeText(mContext,"connot preview image",Toast.LENGTH_SHORT).show();
        }

        holder.CityNameTextView.setText(CityDetails.getCityName());


    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }


    class ViewHolderCity extends RecyclerView.ViewHolder {
        public TextView CityNameTextView;
        public ImageView imageView;

        public ViewHolderCity(View itemView) {
            super(itemView);

            CityNameTextView = (TextView) itemView.findViewById(R.id.city_name);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);


        }
    }
}
