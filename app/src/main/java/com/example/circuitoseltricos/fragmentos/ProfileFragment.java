package com.example.circuitoseltricos.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.circuitoseltricos.Aluno;
import com.example.circuitoseltricos.AppDatabase;
import com.example.circuitoseltricos.R;
import com.example.circuitoseltricos.recycleView.AlunoAdapter;

import java.util.ArrayList;
import java.util.List;

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

    private RecyclerView alunosRecycleView;
    private AlunoAdapter alunoAdapter;

    public ProfileFragment() {
        // Required empty public constructor
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
        alunosRecycleView = view.findViewById(R.id.alunosRecycleView);
        AppDatabase instance = AppDatabase.getInstance(getContext());
        List<Aluno> listaDeAlunos = instance.getAlunoDao().getAlunos();

        if (listaDeAlunos != null){
            new Thread(() -> {
                getActivity().runOnUiThread(() -> {
                    alunosRecycleView.setLayoutManager(new LinearLayoutManager(requireContext()));
                    alunoAdapter = new AlunoAdapter(listaDeAlunos);
                    alunosRecycleView.setAdapter(alunoAdapter);
                });
            }).start();
        }



        return view;
    }
}