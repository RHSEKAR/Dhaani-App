package com.example.jojo.dhaaniapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class OnClickItemView extends AppCompatActivity {

    public TextView DescTextView;
    public ImageView imageView, ButtonTrailer, Button480p, Button720p, Button1080p;
    private String movieName, desc, trailerLink, Linkof480p, Linkof720p, Linkof1080p;
    private String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_item_view);


        try {
            movieName = getIntent().getExtras().getString("city_name");
            desc = getIntent().getExtras().getString("desc");
            image = getIntent().getExtras().getString("image");
            //      Toast.makeText(getApplicationContext(), movieName + "    " + trailerLink + "    " + Linkof480p + "      " + Linkof720p + "    " + Linkof1080p, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Send Feedback To developer", Toast.LENGTH_SHORT).show();
        }

        DescTextView = (TextView) findViewById(R.id.description);
        imageView = (ImageView) findViewById(R.id.image_on_click_view);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(movieName);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        try {
            //   URL url = new URL(MoviesDetails.getImage());
            //   Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            // holder.imageView.setImageBitmap(bmp);

            Picasso.with(getBaseContext()).load(image).into(imageView);

            //holder.imageView.setImageResource(R.drawable.ic_launcher_background);

        } catch (Exception e) {
            imageView.setImageResource(R.drawable.ic_launcher_foreground);
            //    Toast.makeText(getBaseContext(), "connot preview image", Toast.LENGTH_SHORT).show();
        }

        DescTextView.setText(desc);


    }
}
