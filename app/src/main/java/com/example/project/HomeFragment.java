package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {
    String s1[],s2[],s3[];
    int imageshed[] = {R.drawable.jujutsu_wide,R.drawable.opm_wide,R.drawable.kaguya_wide};
    int images[] = {R.drawable.jujutsu,R.drawable.opm,R.drawable.kaguya};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ViewFlipper viewFlipper = rootView.findViewById(R.id.image_VF);

        for(int i =0; i<imageshed.length;i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(imageshed[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            viewFlipper.addView(imageView);
            viewFlipper.setFlipInterval(3000);
            viewFlipper.setAutoStart(true);
            viewFlipper.setInAnimation(getActivity(), android.R.anim.slide_in_left);
            viewFlipper.setOutAnimation(getActivity(), android.R.anim.slide_out_right);
        }

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.hometitle);
        s2 = getResources().getStringArray(R.array.homedes);
        s3 = getResources().getStringArray(R.array.homestock);

        MyAdapter myAdapter = new MyAdapter(getActivity(),s1,s2,s3,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        s1 = getResources().getStringArray(R.array.hometitle);
        s2 = getResources().getStringArray(R.array.homedes);
        s3 = getResources().getStringArray(R.array.stock);

        return rootView;
    }
}
