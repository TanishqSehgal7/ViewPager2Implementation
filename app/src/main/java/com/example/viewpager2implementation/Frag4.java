package com.example.viewpager2implementation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewpager2implementation.databinding.FragmentFrag4Binding;

public class Frag4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Frag4() {
        // Required empty public constructor
    }
    //extra code not relevant
    private var board = arrayListOf("", "", "", "", "", "", "", "", "")
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mp: MediaPlayer
    private lateinit var mp1: MediaPlayer
        
    public static Frag4 newInstance(String param1, String param2) {
        Frag4 fragment = new Frag4();
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

    private FragmentFrag4Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFrag4Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}
