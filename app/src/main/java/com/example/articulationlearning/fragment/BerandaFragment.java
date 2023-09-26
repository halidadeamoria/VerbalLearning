package com.example.articulationlearning.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.articulationlearning.ActivityDwiHuruf;
import com.example.articulationlearning.ActivityKonsonan;
import com.example.articulationlearning.ActivityVocal;
import com.example.articulationlearning.adapter.HomeMenuAdapter;
import com.example.articulationlearning.adapter.VocalAdapter;
import com.example.articulationlearning.databinding.FragmentBerandaBinding;
import com.example.articulationlearning.util.BaseAppCompatActivity;
import com.example.articulationlearning.util.SessionManager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BerandaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BerandaFragment extends Fragment {
    private FragmentBerandaBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BerandaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BerandaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BerandaFragment newInstance(String param1, String param2) {
        BerandaFragment fragment = new BerandaFragment();
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
        binding = FragmentBerandaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        HomeMenuAdapter adapter = new HomeMenuAdapter((BaseAppCompatActivity) requireActivity());
        binding.rvData.setLayoutManager(new GridLayoutManager(requireContext(), 1));
        binding.userTxt.setText(SessionManager.getName(requireContext()));
        binding.rvData.setAdapter(adapter);
        ArrayList<Integer> items = new ArrayList<>();
        items.add(0);
        items.add(0);
        items.add(0);
        adapter.addItems(items);
    }
}