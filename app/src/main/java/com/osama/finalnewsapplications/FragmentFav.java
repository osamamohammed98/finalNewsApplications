package com.osama.finalnewsapplications;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.osama.finalnewsapplications.Adabter.AdabterForNews;
import com.osama.finalnewsapplications.DB.ManuplationDB;
import com.osama.finalnewsapplications.Model.ModelItem;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFav extends Fragment {


    public FragmentFav() {
        // Required empty public constructor

    }

    RecyclerView recyclerView;
    ArrayList<ModelItem> items;
    ManuplationDB manuplationDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_fav, container, false);
        recyclerView = view.findViewById(R.id.rec_main);
        showData();

        return view;
    }

    public void showData() {

        // onDetach();
        manuplationDB = new ManuplationDB(getContext());
        // onResume();
        items = new ArrayList<>();
        //  String x = String.valueOf(R.drawable.osama);
        // items.add(new ModelItem("dsfsdfds","sdfsdfsd",x));

        items = manuplationDB.GetAllDataFromDataBaseByFav();
//        items.clear();
//        items = manuplationDB.GetAllDataFromDataBaseByFav();
        recyclerView.setAdapter(new AdabterForNews(getActivity(), items));
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//    }
//    @Override
//    public void onResume() {
//        super.onResume();
//       // recyclerView = view.findViewById(R.id.rec_main);
//        items = new ArrayList<>();
//        //  String x = String.valueOf(R.drawable.osama);
//        // items.add(new ModelItem("dsfsdfds","sdfsdfsd",x));
//
//        items = manuplationDB.GetAllDataFromDataBaseByFav();
//        recyclerView.setAdapter(new AdabterForNews(getActivity(), items));
//        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(manager);
//    }
}
