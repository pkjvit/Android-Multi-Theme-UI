package com.pkj.wow.multitheme.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pkj.wow.multitheme.R;
import com.pkj.wow.multitheme.view.FabProgressLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FabProgressLayout mFabProgressLayout;
    private TextView mPlaceholderTV;

    public CardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AuthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardFragment newInstance(String param1, String param2) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFabProgressLayout  = view.findViewById(R.id.fab_progress);
        mPlaceholderTV  = view.findViewById(R.id.tv_placeholder);
        mPlaceholderTV.setVisibility(View.INVISIBLE);

        mFabProgressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlaceholderTV.setVisibility(View.VISIBLE);
                mFabProgressLayout.startProgress();
                mFabProgressLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mFabProgressLayout.stopProgress();
                        mPlaceholderTV.setVisibility(View.INVISIBLE);
                    }
                },5000);
            }
        });
    }
}
