package com.osama.finalnewsapplications;


import android.content.SharedPreferences;
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
public class FragmentMain extends Fragment {

    SharedPreferences.Editor editor;
    SharedPreferences preferences;

    public FragmentMain() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    ArrayList<ModelItem> items;
    ManuplationDB manuplationDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // String images = x;
        String is_fav = "0";
        View view = inflater.inflate(R.layout.fragment_fragment_main, container, false);
        manuplationDB = new ManuplationDB(getContext());

        editor = getActivity().getSharedPreferences("is_f", 0).edit();
        preferences = getActivity().getSharedPreferences("is_f", 0);
        Boolean aBoolean = preferences.getBoolean("is_first", true);
        if (aBoolean) {
            addData();
            editor.putBoolean("is_first", false);
            editor.apply();
        }
        recyclerView = view.findViewById(R.id.rec_main);
        items = new ArrayList<>();

        //   String x = String.valueOf(R.drawable.osama);


//        String title ="dsfjdsfnj,dsnfdjskfn";
//        String body ="sdfjksdf";




       /* manuplationDB.AddData(new ModelItem(Integer.parseInt(is_fav) ,
                body,
                title,
                images));*/
        //  items.add(new ModelItem("dsfsdfds","sdfsdfsd",x));
        items = manuplationDB.GetAllDataFromDataBase();
//        items.clear();
//        items =manuplationDB.GetAllDataFromDataBase();

        recyclerView.setAdapter(new AdabterForNews(getActivity(), items));
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);


        return view;
    }

    public void ShowDataMain() {
        String is_fav = "0";
        manuplationDB = new ManuplationDB(getContext());

        editor = getActivity().getSharedPreferences("is_f", 0).edit();
        preferences = getActivity().getSharedPreferences("is_f", 0);
        Boolean aBoolean = preferences.getBoolean("is_first", true);
        if (aBoolean) {
            addData();
            editor.putBoolean("is_first", false);
            editor.apply();
        }
        recyclerView = getActivity().findViewById(R.id.rec_main);
        items = new ArrayList<>();

        //   String x = String.valueOf(R.drawable.osama);


//        String title ="dsfjdsfnj,dsnfdjskfn";
//        String body ="sdfjksdf";




       /* manuplationDB.AddData(new ModelItem(Integer.parseInt(is_fav) ,
                body,
                title,
                images));*/
        //  items.add(new ModelItem("dsfsdfds","sdfsdfsd",x));
        items = manuplationDB.GetAllDataFromDataBase();
//        items.clear();
//        items =manuplationDB.GetAllDataFromDataBase();

        recyclerView.setAdapter(new AdabterForNews(getActivity(), items));
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }

    public void addData() {
        String is_fav = "0";
        manuplationDB.AddData(new ModelItem(Integer.parseInt(is_fav), "On October 25, 1999, a private jet took off from Orlando International airport for Texas with the reigning US Open champion on board. It never reached its destination, and millions of TV viewers witnessed the tragedy of its final flight.",
                "A champion and a statesman - 20 years on, the tragic loss of Payne Stewart",
                String.valueOf(R.drawable.d1)));
        manuplationDB.AddData(new ModelItem(Integer.parseInt(is_fav),
                "Tromso Skyrace is more than just extreme. When describing the course in 2014, race director Kilian Jornet admitted: \"You could die.",
                "Hillary Allen: How American skyrunner returned to the race that almost killed her",
                String.valueOf(R.drawable.d2)));
        manuplationDB.AddData(new ModelItem(Integer.parseInt(is_fav),
                "There is a small, white plaque hidden away in the back streets of bustling Yokohama, so hard to find that even the man responsible for its creation has to ask for directions.",
                "Rugby World Cup: One man's search into Japan's mysterious rugby past",
                String.valueOf(R.drawable.d3)));
        manuplationDB.AddData(new ModelItem(Integer.parseInt(is_fav),
                "And within its inscription lies the seed of a remarkable story: one involving samurai, an armed cricket match and a long-running feud about the true origins of a sport now taking Japan by storm. Sometimes history can be more fantastical than fiction.",
                "Going back to run the race that almost killed you",
                String.valueOf(R.drawable.d4)));
        manuplationDB.AddData(new ModelItem(Integer.parseInt(is_fav),
                "The love 72-year-old Briton Galbraith has for his subject is clear from the moment you meet him. Our first encounter is on a crowded platform at Shibuya station, home to Tokyo's famously busy crossing. He has promised to take me to the sports club in Yokohama where he is historian.",
                "Uncovering Japan's mysterious rugby past",
                String.valueOf(R.drawable.d5)));
        manuplationDB.AddData(new ModelItem(Integer.parseInt(is_fav),
                "past being spun out before this World Cup. As soon as we get on to the train he launches into his alternative tale. At times, it is hard to keep up. We almost miss our stop.\n" +
                        "\n" +
                        "But when we eventually make it to the club - a low, white, rectangular building being repaired after a recent typhoon - he starts again from the beginning",
                "'Do we want to have a family? Or do we want to run fast?",
                String.valueOf(R.drawable.d6)));
        manuplationDB.AddData(new ModelItem(Integer.parseInt(is_fav),
                "It is a Saturday afternoon in Geuzenveld, a quiet suburb on the outskirts of Amsterdam. Three hundred metres away from the main station, children are playing football. On the fence behind one of the goals, a large banner dominates the scene.",
                "Abdelhak Nouri: The Ajax prodigy who suffered permanent brain damage",
                String.valueOf(R.drawable.d7)));
        manuplationDB.AddData(new ModelItem(Integer.parseInt(is_fav),
                "Before that fateful match at the tiny Lindenstadion Hippach, about 65km from Innsbruck, Nouri had suffered stomach pains and had not slept well. Conditions in the Alps that day were very hot. Still, he played, replacing Hakim Ziyech after half-time",
                "Ajax later admitted their medical team's treatment of Nouri was 'inadequate",
                String.valueOf(R.drawable.d8)));
        manuplationDB.AddData(new ModelItem(Integer.parseInt(is_fav),
                "In the playground that now bears Nouri's name, a young man playing basketball greets the visitor in Arabic. \"As-salamu alaykum,\" he says. He is used to seeing strangers, the many people who bring flowers.\n" +
                        "\n" +
                        "The Nouri family live just around the corner. His younger sisters are outside, chatting with friends. Nouri is one of seven children.",
                "The inside story of Neymar's on-off Barcelona return\n",
                String.valueOf(R.drawable.d9)));
        manuplationDB.AddData(new ModelItem(Integer.parseInt(is_fav),
                "Geuzenveld has plenty of migrant communities. Mohammed Nouri, his father, came from Morocco and for many years worked in a butcher's not far from Anne Frank's house in Amsterdam's trendy Jordaan neighbourhood.\n" +
                        "\n" +
                        "\"I can still see him playing with a small ball, all around where you are sitting,\" Mohammed says, as Rabia, the player's mother, offers mint tea and Moroccan delicacies. This has always been their home.",
                "The 'bunch of cast-offs' who made NFL history",
                String.valueOf(R.drawable.d10)));


    }
}
