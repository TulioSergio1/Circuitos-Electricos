package com.example.circuitoseltricos.fragmentos;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.circuitoseltricos.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SistemaEletrico1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SistemaEletrico1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Switch modoNoturno;
    private ImageView lightView;
    private ImageView lightView2;
    private FloatingActionButton floatingActionButton;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private ImageView caboVermelho1;
    private ImageView caboPreto1;
    private boolean isDialogShowing = false;

    public SistemaEletrico1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SistemaEletrico1 newInstance(String param1, String param2) {
        SistemaEletrico1 fragment = new SistemaEletrico1();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sistema_eletrico1, container, false);

        // Vincula o lightView usando findViewById
        lightView = view.findViewById(R.id.lightView);
        lightView2 = view.findViewById(R.id.lightView2);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        radioButton1 = view.findViewById(R.id.radioButton1);
        radioButton2 = view.findViewById(R.id.radioButton2);
        radioButton3 = view.findViewById(R.id.radioButton3);
        radioButton4 = view.findViewById(R.id.radioButton4);
        caboVermelho1 = view.findViewById(R.id.caboVermelho1);
        caboPreto1 = view.findViewById(R.id.caboPreto1);

        // Variável para controlar o estado de ambos os RadioButtons
        final boolean[] isChecked1 = {false};
        final boolean[] isChecked2 = {false};
        final boolean[] isChecked3 = {false};
        final boolean[] isChecked4 = {false};

        radioButton1.setOnClickListener(v -> {
            if (isDialogShowing) return; // Se o Dialog está visível, evita outra interação

            isChecked1[0] = !isChecked1[0]; // Alterna o estado

            if (isChecked1[0]) {
                radioButton1.setChecked(true);
                if (radioButton1.isChecked() && radioButton2.isChecked()){
                    caboVermelho1.setVisibility(View.VISIBLE);
                } else if (radioButton1.isChecked() && radioButton3.isChecked() || radioButton4.isChecked()) {
                    // Exibe o Dialog e desmarca os RadioButtons
                    radioButton1.setChecked(false);
                    radioButton3.setChecked(false);
                    radioButton4.setChecked(false);
                    isChecked1[0] = false;
                    isChecked3[0] = false;
                    isChecked4[0] = false;
                    mostrarDialog();
                }
            } else {
                radioButton1.setChecked(false);
                caboVermelho1.setVisibility(View.INVISIBLE);
            }
        });

        radioButton2.setOnClickListener(v -> {
            if (isDialogShowing) return;

            isChecked2[0] = !isChecked2[0];

            if (isChecked2[0]) {
                radioButton2.setChecked(true);
                if (radioButton1.isChecked() && radioButton2.isChecked()){
                    caboVermelho1.setVisibility(View.VISIBLE);
                } else if (radioButton2.isChecked() && radioButton3.isChecked() || radioButton4.isChecked() ) {
                    radioButton2.setChecked(false);
                    radioButton4.setChecked(false);
                    radioButton3.setChecked(false);
                    isChecked2[0] = false;
                    isChecked3[0] = false;
                    isChecked4[0] = false;
                    mostrarDialog();
                }
            } else {
                radioButton2.setChecked(false);
                caboVermelho1.setVisibility(View.INVISIBLE);
            }
        });

        radioButton3.setOnClickListener(v -> {
            if (isDialogShowing) return; // Se o Dialog está visível, evita outra interação

            isChecked3[0] = !isChecked3[0];

            if (isChecked3[0]) {
                radioButton3.setChecked(true);

                if (radioButton3.isChecked() && radioButton4.isChecked()){
                    caboPreto1.setVisibility(View.VISIBLE);
                } else if (radioButton1.isChecked() && radioButton3.isChecked() || radioButton4.isChecked()) {
                    // Exibe o Dialog e desmarca os RadioButtons
                    radioButton1.setChecked(false);
                    radioButton3.setChecked(false);
                    isChecked1[0] = false;
                    isChecked3[0] = false;
                    mostrarDialog();
                } else if (radioButton2.isChecked() && radioButton3.isChecked() || radioButton4.isChecked() ) {
                    radioButton2.setChecked(false);
                    radioButton4.setChecked(false);
                    radioButton3.setChecked(false);
                    isChecked2[0] = false;
                    isChecked3[0] = false;
                    isChecked4[0] = false;
                    mostrarDialog();
                }
            } else {
                radioButton3.setChecked(false);
                caboPreto1.setVisibility(View.INVISIBLE);
            }
        });

        radioButton4.setOnClickListener(v -> {
            if (isDialogShowing) return;

            isChecked4[0] = !isChecked4[0];

            if (isChecked4[0]) {
                radioButton4.setChecked(true);
                if (radioButton3.isChecked() && radioButton4.isChecked()){
                    caboPreto1.setVisibility(View.VISIBLE);
                } else if (radioButton1.isChecked() && radioButton4.isChecked() || radioButton3.isChecked()) {
                    // Exibe o Dialog e desmarca os RadioButtons
                    radioButton1.setChecked(false);
                    radioButton3.setChecked(false);
                    radioButton4.setChecked(false);
                    isChecked1[0] = false;
                    isChecked3[0] = false;
                    isChecked4[0] = false;
                    mostrarDialog();

                } else if (radioButton2.isChecked() && radioButton4.isChecked() || radioButton3.isChecked()) {
                    radioButton2.setChecked(false);
                    radioButton4.setChecked(false);
                    radioButton3.setChecked(false);
                    isChecked2[0] = false;
                    isChecked3[0] = false;
                    isChecked4[0] = false;
                    mostrarDialog();
                }
            } else {
                radioButton4.setChecked(false);
                caboPreto1.setVisibility(View.INVISIBLE);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lightView.setVisibility(View.VISIBLE);
                lightView2.setVisibility(View.VISIBLE);

                ObjectAnimator fadeIn = ObjectAnimator.ofFloat(lightView2, "alpha", 0.1f, 1.0f);
                fadeIn.setDuration(6000); // Duração de 6 segundos para aumentar o brilho

                ObjectAnimator fadeIn2 = ObjectAnimator.ofFloat(lightView, "alpha", 0.1f, 1.0f);
                fadeIn2.setDuration(2000); // Duração de 2 segundos para aumentar o brilho

                fadeIn2.start();
                fadeIn.start();
            }
        });

        return view;
    }

    public void mostrarDialog(){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.layout_custom_dialog);
        dialog.show();
        ImageButton fecharIcon = dialog.findViewById(R.id.fecharIcon);
        fecharIcon.setOnClickListener(v -> {
            dialog.dismiss();
        });
    }
}