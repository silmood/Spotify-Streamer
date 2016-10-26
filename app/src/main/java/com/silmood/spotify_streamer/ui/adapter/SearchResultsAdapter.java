package com.silmood.spotify_streamer.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.silmood.spotify_streamer.R;
import com.silmood.spotify_streamer.domain.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Pedro Antonio Hernández on 13/06/2015.
 *
 */
public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>{

    ArrayList<Artist> artists;
    ItemClickListener clickListener;
    Context context;

    public SearchResultsAdapter(Context context) {
        this.artists = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_artist, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Artist currentArtist = artists.get(position);

        holder.setArtistName(currentArtist.getName());

        if(currentArtist.getMediumImage() != null)
            holder.setArtistImage(currentArtist.getMediumImage().getUrl());

        else
            holder.setPlaceholderImage();
    }

    @Override
    public int getItemCount() {
        return artists.isEmpty() ? 0 : artists.size();

    }

    /**
     * Add item in the last index
     *
     * @param artist The item to be inserted
     */
    public void addItem(Artist artist) {
        if (artist == null)
            throw new NullPointerException("The item cannot be null");

        artists.add(artist);
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * Add item in determined index
     *
     * @param artist    The event to be inserted
     * @param position Index for the new event
     */
    public void addItem(Artist artist, int position) {
        if (artist == null)
            throw new NullPointerException("The item cannot be null");

        if (position < getItemCount() || position > getItemCount())
            throw new IllegalArgumentException("The position must be between 0 and lastIndex + 1");

        artists.add(position, artist);
        notifyItemInserted(position);
    }

    /**
     * Add a bunch of items
     *
     * @param artists Collection to add
     * */
    public void addAll(List<Artist> artists) {
        if (artists == null)
            throw new NullPointerException("The items cannot be null");

        this.artists.addAll(artists);
        notifyItemRangeInserted(getItemCount() - 1, artists.size());
    }

    public void replace(ArrayList<Artist> artists){
        this.artists = artists;
        notifyDataSetChanged();
    }

    /**
     * Delete all the items
     * */
    public void clear() {
        if (!artists.isEmpty()) {
            artists.clear();
            notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public static final int IMG_SIZE_DP = 112;

        public int IMG_SIZE_PX;

        @BindView(R.id.img_artist)
        CircleImageView artistImage;

        @BindView(R.id.txt_artist_name)
        TextView artistName;

        public ViewHolder(View itemView) {
            super(itemView);

            artistImage = (CircleImageView) itemView.findViewById(R.id.img_artist);
            artistName = (TextView) itemView.findViewById(R.id.txt_artist_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null)
                        clickListener.onItemClicked(getPosition());
                }
            });

            setupDimensions();
        }

        private void setupDimensions() {
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            IMG_SIZE_PX = IMG_SIZE_DP * (metrics.densityDpi / 160);
        }

        public void setArtistName(String name){
            artistName.setText(name);
        }

        public void setArtistImage(String urlImage) {
            Picasso.with(context)
                    .load(urlImage)
                    .placeholder(R.drawable.artist_placeholder)
                    .resize(IMG_SIZE_PX, IMG_SIZE_PX)
                    .into(artistImage);
        }

        public void setPlaceholderImage() {
            Picasso.with(context)
                    .load(R.drawable.artist_placeholder)
                    .resize(IMG_SIZE_PX, IMG_SIZE_PX)
                    .into(artistImage);
        }
    }

    /**
     * Created by Pedro Antonio Hernández on 03/06/2015.
     *
     * A simple interface to be configured in a RecyclerView
     */
    public interface ItemClickListener{
        /**
         * This method will be invoked when an item from the list be clicked
         * @param position position in the list
         * */
        void onItemClicked(int position);
    }
}
