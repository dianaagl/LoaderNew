package ru.sberbank.apploaders;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user8 on 18.05.2017.
 */

public class FragmentElement extends Fragment {
    private static String ARG_TEXT = "text";

    public static FragmentElement newInstance(String specie, int mass, int height, String nickName) {
        FragmentElement catFragment = new FragmentElement();
        Bundle args = new Bundle();
        args.putString("specie", specie);
        args.putInt("mass", mass);
        args.putInt("height", height);
        args.putString("nickName", nickName);
        catFragment.setArguments(args);
        return catFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        String specie = getArguments().getString("specie","");
        int mass = getArguments().getInt("mass", 0);
        int height = getArguments().getInt("height", 0);
        String name = getArguments().getString("nickName", "");
        LinearLayout layout = new LinearLayout(getActivity().getApplicationContext());
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView specieView = new TextView(getActivity().getApplicationContext());
        TextView massView = new TextView(getActivity().getApplicationContext());
        TextView heightView = new TextView(getActivity().getApplicationContext());
        TextView nameView = new TextView(getActivity().getApplicationContext());

        specieView.setText(specie);
        massView.setText(String.valueOf(mass));
        heightView.setText(String.valueOf(height));
        nameView.setText(name);

        layout.addView(specieView);
        layout.addView(nameView);
        layout.addView(heightView);
        layout.addView(massView);

        layout.setId(R.id.container);



        return layout;


    }

}
