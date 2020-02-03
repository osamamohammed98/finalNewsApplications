package com.osama.finalnewsapplications.Adabter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.osama.finalnewsapplications.DB.ManuplationDB;
import com.osama.finalnewsapplications.Details;
import com.osama.finalnewsapplications.Model.ModelItem;
import com.osama.finalnewsapplications.R;

import java.util.ArrayList;

public class AdabterForNews extends RecyclerView.Adapter<AdabterForNews.ViewHolder> {
    private Activity activity;
    private ArrayList<ModelItem> items;
    private ManuplationDB manuplationDB;
    public static final String KEY_FOR_DETAILS = "key";

//    public void updateRecyclerView(ArrayList<ModelItem> items) {
//        items = items;
//        notifyDataSetChanged();
//    }

    public AdabterForNews(Activity activity, ArrayList<ModelItem> items) {
        this.activity = activity;
        this.items = items;
        // updateRecyclerView(items);
        //notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity).inflate(R.layout.custom_main_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        ModelItem m1 = items.get(i);
        final ModelItem modelItem = items.get(i);
        viewHolder.tv_title.setText(modelItem.getTitle());
        viewHolder.iv_title.setImageResource(Integer.parseInt(modelItem.getImage()));
        manuplationDB = new ManuplationDB(activity);
        m1 = manuplationDB.GetAllDataFromDataBaseByID(modelItem.getId());
        viewHolder.iv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Details.class);
                intent.putExtra(KEY_FOR_DETAILS, modelItem.getId());
                activity.startActivity(intent);
            }
        });
        viewHolder.tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Details.class);
                intent.putExtra(KEY_FOR_DETAILS, modelItem.getId());
                activity.startActivity(intent);
            }
        });
        viewHolder.iv_fave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   viewHolder.iv_fave.setImageResource(R.drawable.ic_favorite_black_click);
                //int x = modelItem.getIs_fav();
                //   manuplationDB.update(modelItem.getId());
                //notifyDataSetChanged();
                if (viewHolder.iv_fave.getDrawable().getConstantState() == viewHolder.iv_fave.getResources().getDrawable(R.drawable.ic_favorite_unclick).getConstantState()) {
                    viewHolder.iv_fave.setImageResource(R.drawable.ic_favorite_black_click);
                    manuplationDB.update(modelItem.getId());
                } else if (viewHolder.iv_fave.getDrawable().getConstantState() == viewHolder.iv_fave.getResources().getDrawable(R.drawable.ic_favorite_black_click).getConstantState()) {
                    viewHolder.iv_fave.setImageResource(R.drawable.ic_favorite_unclick);
                    manuplationDB.updatezero(modelItem.getId());
                } else {
                    viewHolder.iv_fave.setImageResource(R.drawable.ic_favorite_black_click);
                    manuplationDB.update(modelItem.getId());
                }

            }
        });
        // to make image favert full or empty
        if (String.valueOf(modelItem.getIs_fav()).equals("1")) {
            viewHolder.iv_fave.setImageResource(R.drawable.ic_favorite_black_click);
        } else {
            viewHolder.iv_fave.setImageResource(R.drawable.ic_favorite_unclick);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_title;
        private ImageView iv_fave;
        private TextView tv_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            final ModelItem modelItem = null;
            iv_title = itemView.findViewById(R.id.custom_image_title_main);
            iv_fave = itemView.findViewById(R.id.custom_fav_title_main);
            tv_title = itemView.findViewById(R.id.custom_text_title_main);
//            iv_title.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(activity, Details.class);
//                    intent.putExtra(KEY_FOR_DETAILS, modelItem.getId());
//                    activity.startActivity(intent);
//                }
//            });
//            tv_title.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(activity, Details.class);
//                    intent.putExtra(KEY_FOR_DETAILS, -1);
//                    activity.startActivity(intent);
//                }
//            });
        }
    }
}
