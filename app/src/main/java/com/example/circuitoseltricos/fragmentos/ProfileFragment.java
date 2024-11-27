package com.example.circuitoseltricos.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.circuitoseltricos.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String nome, String periodo, String curso) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString("nome", nome);
        args.putString("periodo", periodo);
        args.putString("curso", curso);
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Referências aos TextViews
        TextView nomeTextView = view.findViewById(R.id.nomeTextView);
        TextView periodoTextView = view.findViewById(R.id.periodoTextView);
        TextView cursoTextView = view.findViewById(R.id.cursoTextView);

        // Obter dados da Intent
        if (getActivity() != null) {
            Intent intent = getActivity().getIntent();
            String nome = intent.getStringExtra("nome");
            String periodo = intent.getStringExtra("periodo");
            String curso = intent.getStringExtra("curso");

            // Atualizar os TextViews
            nomeTextView.setText(nome);
            periodoTextView.setText(periodo);
            cursoTextView.setText(curso);
        }

        return view;
    }
}
