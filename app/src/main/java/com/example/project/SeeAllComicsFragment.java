package com.example.project;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SeeAllComicsFragment extends Fragment {
    String s1[],s2[],s3[];
    int images[] = {R.drawable.jujutsu,R.drawable.opm,R.drawable.kaguya,R.drawable.snk,R.drawable.kengan_ashura};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_see_all_comics, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.title);
        s2 = getResources().getStringArray(R.array.description);
        s3 = getResources().getStringArray(R.array.stock);

        MyAdapter myAdapter = new MyAdapter(getActivity(),s1,s2,s3,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        s1 = getResources().getStringArray(R.array.title);
        s2 = getResources().getStringArray(R.array.description);
        s3 = getResources().getStringArray(R.array.stock);

        return rootView;
    }
}
