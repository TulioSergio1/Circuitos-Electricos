package com.example.circuitoseltricos.fragmentos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.example.circuitoseltricos.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InstalacoesSolaresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InstalacoesSolaresFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button instalacaoButton;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private RadioButton radioButton6;
    private RadioButton radioButton7;
    private RadioButton radioButton8;
    private RadioButton radioButton9;
    private RadioButton radioButton10;
    private RadioButton radioButton11;
    private RadioButton radioButton12;
    private RadioButton radioButton13;
    private RadioButton radioButton14;
    private RadioButton radioButton15;
    private RadioButton radioButton16;

    private ImageView caboPretoImageView1;
    private ImageView caboPretoImageView2;
    private ImageView caboPretoImageView3;
    private ImageView caboPretoImageView4;
    private ImageView caboPretoImageView5;
    private ImageView caboPretoImageView6;
    private ImageView caboPretoImageView7;
    private ImageView caboPretoImageView8;
    private ImageView caboPretoImageView9;

    private ImageView caboVermelhoImageView1;
    private ImageView caboVermelhoImageView2;
    private ImageView caboVermelhoImageView3;
    private ImageView caboVermelhoImageView4;
    private ImageView caboVermelhoImageView5;
    private ImageView caboVermelhoImageView6;
    private ImageView caboVermelhoImageView7;
    private ImageView caboVermelhoImageView8;
    private ImageView caboVermelhoImageView9;

    private FloatingActionButton voltarButton;

    public InstalacoesSolaresFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment instalacoesSolaresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InstalacoesSolaresFragment newInstance(String param1, String param2) {
        InstalacoesSolaresFragment fragment = new InstalacoesSolaresFragment();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_instalacoes_solares, container, false);

        radioButton1 = view.findViewById(R.id.radioButton1);
        radioButton2 = view.findViewById(R.id.radioButton2);
        radioButton3 = view.findViewById(R.id.radioButton3);
        radioButton4 = view.findViewById(R.id.radioButton4);
        radioButton5 = view.findViewById(R.id.radioButton5);
        radioButton6 = view.findViewById(R.id.radioButton6);
        radioButton7 = view.findViewById(R.id.radioButton7);
        radioButton8 = view.findViewById(R.id.radioButton8);
        radioButton9 = view.findViewById(R.id.radioButton9);
        radioButton10 = view.findViewById(R.id.radioButton10);
        radioButton11 = view.findViewById(R.id.radioButton11);
        radioButton12 = view.findViewById(R.id.radioButton12);
        radioButton13 = view.findViewById(R.id.radioButton13);
        radioButton14 = view.findViewById(R.id.radioButton14);
        radioButton15 = view.findViewById(R.id.radioButton15);
        radioButton16 = view.findViewById(R.id.radioButton16);

        voltarButton = view.findViewById(R.id.voltarButton);

        caboPretoImageView1 = view.findViewById(R.id.caboPretoImageView1);
        caboPretoImageView2 = view.findViewById(R.id.caboPretoImageView2);
        caboPretoImageView3 = view.findViewById(R.id.caboPretoImageView3);
        caboPretoImageView4 = view.findViewById(R.id.caboPretoImageView4);
        caboPretoImageView5 = view.findViewById(R.id.caboPretoImageView5);
        caboPretoImageView6 = view.findViewById(R.id.caboPretoImageView6);
        caboPretoImageView7 = view.findViewById(R.id.caboPretoImageView7);
        caboPretoImageView8 = view.findViewById(R.id.caboPretoImageView8);
        caboPretoImageView9 = view.findViewById(R.id.caboPretoImageView9);

        caboVermelhoImageView1 = view.findViewById(R.id.caboVermelhoImageView1);
        caboVermelhoImageView2 = view.findViewById(R.id.caboVermelhoImageView2);
        caboVermelhoImageView3 = view.findViewById(R.id.caboVermelhoImageView3);
        caboVermelhoImageView4 = view.findViewById(R.id.caboVermelhoImageView4);
        caboVermelhoImageView5 = view.findViewById(R.id.caboVermelhoImageView5);
        caboVermelhoImageView6 = view.findViewById(R.id.caboVermelhoImageView6);
        caboVermelhoImageView7 = view.findViewById(R.id.caboVermelhoImageView7);
        caboVermelhoImageView8 = view.findViewById(R.id.caboVermelhoImageView8);
        caboVermelhoImageView9 = view.findViewById(R.id.caboVermelhoImageView9);

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton1.isChecked() && radioButton2.isChecked()){
                    caboPretoImageView1.setVisibility(View.VISIBLE);
                    caboVermelhoImageView1.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton1.isChecked() && radioButton2.isChecked()) {
                    caboPretoImageView1.setVisibility(View.VISIBLE);
                    caboVermelhoImageView1.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton3.isChecked() && radioButton4.isChecked()){
                    caboPretoImageView2.setVisibility(View.VISIBLE);
                    caboVermelhoImageView2.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton3.isChecked() && radioButton4.isChecked()){
                    caboPretoImageView2.setVisibility(View.VISIBLE);
                    caboVermelhoImageView2.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton5.isChecked() && radioButton6.isChecked()){
                    caboPretoImageView3.setVisibility(View.VISIBLE);
                    caboVermelhoImageView3.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton5.isChecked() && radioButton6.isChecked()){
                    caboPretoImageView3.setVisibility(View.VISIBLE);
                    caboVermelhoImageView3.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton7.isChecked() && radioButton8.isChecked()){
                    caboPretoImageView4.setVisibility(View.VISIBLE);
                    caboVermelhoImageView4.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton7.isChecked() && radioButton8.isChecked()){
                    caboPretoImageView4.setVisibility(View.VISIBLE);
                    caboVermelhoImageView4.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton9.isChecked() && radioButton10.isChecked()){
                    caboPretoImageView5.setVisibility(View.VISIBLE);
                    caboVermelhoImageView5.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton9.isChecked() && radioButton10.isChecked()){
                    caboPretoImageView5.setVisibility(View.VISIBLE);
                    caboVermelhoImageView5.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton11.isChecked() && radioButton12.isChecked()){
                    caboPretoImageView6.setVisibility(View.VISIBLE);
                    caboVermelhoImageView6.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton11.isChecked() && radioButton12.isChecked()){
                    caboPretoImageView6.setVisibility(View.VISIBLE);
                    caboVermelhoImageView6.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton13.isChecked() && radioButton14.isChecked()){
                    caboPretoImageView7.setVisibility(View.VISIBLE);
                    caboVermelhoImageView7.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton13.isChecked() && radioButton14.isChecked()){
                    caboPretoImageView7.setVisibility(View.VISIBLE);
                    caboVermelhoImageView7.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton15.isChecked() && radioButton16.isChecked()){
                    caboPretoImageView8.setVisibility(View.VISIBLE);
                    caboVermelhoImageView8.setVisibility(View.VISIBLE);
                }
            }
        });

        radioButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton15.isChecked() && radioButton16.isChecked()){
                    caboPretoImageView8.setVisibility(View.VISIBLE);
                    caboVermelhoImageView8.setVisibility(View.VISIBLE);
                }
            }
        });


        voltarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton1.isChecked() && radioButton2.isChecked() &&
                        radioButton3.isChecked() && radioButton4.isChecked() &&
                        radioButton5.isChecked() && radioButton6.isChecked() &&
                        radioButton7.isChecked() && radioButton8.isChecked() &&
                        radioButton9.isChecked() && radioButton10.isChecked() &&
                        radioButton11.isChecked() && radioButton12.isChecked() &&
                        radioButton13.isChecked() && radioButton14.isChecked() &&
                        radioButton15.isChecked() && radioButton16.isChecked()) {

                    // Salvar em SharedPreferences
                    SharedPreferences sharedPreferences = requireContext().getSharedPreferences("MyPrefs", requireContext().MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("botoesAtivados", true);
                    editor.apply();

                } else {
                    SharedPreferences sharedPreferences = requireContext().getSharedPreferences("MyPrefs", requireContext().MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    // Limpar todos os dados armazenados
                    editor.clear();
                    editor.apply();
                }

                // Trocar para o novo fragmento
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, new SistemaEletrico());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}