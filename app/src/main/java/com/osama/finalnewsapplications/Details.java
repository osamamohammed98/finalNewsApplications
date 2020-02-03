package com.osama.finalnewsapplications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.osama.finalnewsapplications.Adabter.AdabterForNews;
import com.osama.finalnewsapplications.DB.ManuplationDB;
import com.osama.finalnewsapplications.Model.ModelItem;

public class Details extends AppCompatActivity {

    private ManuplationDB manuplationDB;
    private ImageView imageView;
    private TextView title;
    private TextView body;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        manuplationDB = new ManuplationDB(this);
        imageView = findViewById(R.id.img_title);
        title = findViewById(R.id.boldTilt);
        body = findViewById(R.id.body);

        int id = getIntent().getIntExtra(AdabterForNews.KEY_FOR_DETAILS, -1);
        ModelItem modelItem =manuplationDB.GetAllDataFromDataBaseByID(id);

        imageView.setImageResource(Integer.parseInt(modelItem.getImage()));
        title.setText(modelItem.getTitle());
        body.setText(modelItem.getBody());

    }
}
