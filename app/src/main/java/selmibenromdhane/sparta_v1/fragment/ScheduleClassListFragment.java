package selmibenromdhane.sparta_v1.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import selmibenromdhane.sparta_v1.R;
import selmibenromdhane.sparta_v1.app.AppConfig;
import selmibenromdhane.sparta_v1.parser.ScheduleClassListDownloader;

public class ScheduleClassListFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager lLayout;

    SharedPreferences sh;
    SharedPreferences.Editor ed;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        lLayout = new LinearLayoutManager(getActivity());


        View rootView = inflater.inflate(R.layout.class_fragment_schedule, container, false);

        setHasOptionsMenu(true);


        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(lLayout);

//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());

        new ScheduleClassListDownloader(getActivity(), AppConfig.URL_SCHEDULE1,recyclerView).execute();

        return rootView;
    }

}
