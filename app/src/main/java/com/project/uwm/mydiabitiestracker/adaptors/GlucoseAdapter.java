package com.project.uwm.mydiabitiestracker.adaptors;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.uwm.mydiabitiestracker.ItemClickSupport;
import com.project.uwm.mydiabitiestracker.R;
import com.project.uwm.mydiabitiestracker.objects.FoodConsumedObject;
import com.project.uwm.mydiabitiestracker.objects.GlucoseReadingObject;

import java.util.List;

/**
 * Created by Anitha on 7/26/2017.
 */

public class GlucoseAdapter extends RecyclerView.Adapter<GlucoseAdapter.ViewHolder> {
    private List<GlucoseReadingObject> mFoods;
    private Context mContext;

    public GlucoseAdapter(Context context, List<GlucoseReadingObject> foods){
        mFoods = foods;
        mContext = context;
    }
    private Context getContext(){
        return mContext;
    }
    @Override
    public GlucoseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View glucoseView = inflater.inflate(R.layout.item_glucose, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(glucoseView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(GlucoseAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        GlucoseReadingObject glucose = mFoods.get(position);

        // Set item views based on your views and data model
        TextView gdateTextView = viewHolder.gdateTextView;
        gdateTextView.setText(glucose.getGdate());
        TextView gtimeTextView = viewHolder.gtimeTextView;
        gtimeTextView.setText(glucose.getGdate());
        TextView glevel = viewHolder.glevel;
        glevel.setText(Integer.toString(glucose.getGlucose_level()));
        TextView greadingtaken = viewHolder.greadingtaken;
        greadingtaken.setText(glucose.getReading_taken());


    }

    @Override
    public int getItemCount() {
        return mFoods.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView gdateTextView;
        public TextView gtimeTextView;
        public TextView glevel;
        public TextView greadingtaken;
    ;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            gdateTextView = (TextView) itemView.findViewById(R.id.rvs_date_gvalue);
            gtimeTextView = (TextView) itemView.findViewById(R.id.rvs_time_gvalue);
            glevel = (TextView) itemView.findViewById(R.id.rvs_glevel);
            greadingtaken = (TextView) itemView.findViewById(R.id.rvs_greadingTaken);
        }


        //how to use this
        //https://www.littlerobots.nl/blog/Handle-Android-RecyclerView-Clicks/
      /*  ItemClickSupport RecyclerItemClickSupport = new ItemClickSupport(itemView);
        RecyclerItemClickSupport.addTo(itemView).setOnItemClickListener(new RecyclerItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                // do something
            }
        });*/


    }
}
