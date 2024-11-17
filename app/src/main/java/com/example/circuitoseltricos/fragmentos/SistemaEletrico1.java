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
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
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
    private FloatingActionButton floatingActionButton;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private ImageView caboVermelho1;
    private ImageView caboPreto1;
    private TextView dadosTextView;
    private TextView dadosMin;
    private TextView dadosMax;
    private Button buttonDadosMax;
    private Button buttonDadosMin;

    private boolean isDialogShowing = false;
    private boolean isCombination1Correct = false;
    private boolean isCombination2Correct = false;


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

        lightView = view.findViewById(R.id.lightView2);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        radioButton1 = view.findViewById(R.id.radioButton1);
        radioButton2 = view.findViewById(R.id.radioButton2);
        radioButton3 = view.findViewById(R.id.radioButton3);
        radioButton4 = view.findViewById(R.id.radioButton4);
        caboVermelho1 = view.findViewById(R.id.caboVermelho1);
        caboPreto1 = view.findViewById(R.id.caboPreto1);
        dadosTextView = view.findViewById(R.id.dados);
        dadosMax = view.findViewById(R.id.dadosMax);
        dadosMin = view.findViewById(R.id.dadoMin);
        buttonDadosMax = view.findViewById(R.id.buttonDadosMax);
        buttonDadosMin = view.findViewById(R.id.buttonDadosMin);


        // RadioButton1 - Combinação com RadioButton2 (cabo vermelho)
        radioButton1.setOnClickListener(v -> {
            if (radioButton1.isChecked()) {
                verificarCombinacoes();
            } });

        radioButton2.setOnClickListener(v -> {
            if (radioButton2.isChecked()) {
                verificarCombinacoes();
            } });

        radioButton3.setOnClickListener(v -> {
            if (radioButton3.isChecked()) {
                verificarCombinacoes();
            } });
        radioButton4.setOnClickListener(v -> {
            if (radioButton4.isChecked()) {
                verificarCombinacoes();
            } });

        floatingActionButton.setOnClickListener(view1 -> {

            if ((caboVermelho1.getVisibility() == View.VISIBLE) && (caboPreto1.getVisibility() == View.VISIBLE)){
                lightView.setVisibility(View.VISIBLE);

                ObjectAnimator fadeIn = ObjectAnimator.ofFloat(lightView, "alpha", 0.1f, 1.0f);
                fadeIn.setDuration(4000); // Duração de 6 segundos para aumentar o brilho

                fadeIn.start();

                dadosTextView.setVisibility(View.VISIBLE);

                ObjectAnimator fadeInTextView = ObjectAnimator.ofFloat(dadosTextView, "alpha", 0.1f, 1.0f);
                fadeInTextView.setDuration(4000); // Duração de 6 segundos para aumentar o brilho

                fadeInTextView.start();
            }
        });

        buttonDadosMax.setOnClickListener(view1 -> {

            if (lightView.getVisibility() == View.VISIBLE){
                dadosMax.setVisibility(View.VISIBLE);
                dadosTextView.setVisibility(View.INVISIBLE);
                dadosMin.setVisibility(View.INVISIBLE);
            }

        });

        buttonDadosMin.setOnClickListener(view1 -> {
            if (lightView.getVisibility() == View.VISIBLE){
                dadosMax.setVisibility(View.INVISIBLE);
                dadosTextView.setVisibility(View.INVISIBLE);
                dadosMin.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    private void verificarCombinacoes() {
        // Verificar combinações quando nenhuma combinação correta foi feita ainda
        boolean combinacao1 = radioButton1.isChecked() && radioButton2.isChecked();
        boolean combinacao2 = radioButton3.isChecked() && radioButton4.isChecked();
        boolean combinacaoInvalida = !combinacao1 && !combinacao2 &&
                ((radioButton1.isChecked() && radioButton3.isChecked()) || (radioButton1.isChecked() && radioButton4.isChecked()) ||
                        (radioButton2.isChecked() && radioButton3.isChecked()) || (radioButton2.isChecked() && radioButton4.isChecked()));

        if (combinacao1) {
            isCombination1Correct = true;
            caboVermelho1.setVisibility(View.VISIBLE);
        }

        if (combinacao2) {
            isCombination2Correct = true;
            caboPreto1.setVisibility(View.VISIBLE);
        }

        if (combinacaoInvalida) {
            mostrarDialog();
            desmarcarRadioButtonsInvalidas();
        }
    }

    private void desmarcarRadioButtonsInvalidas() {
        if (!isCombination1Correct) {
            radioButton1.setChecked(false);
            radioButton2.setChecked(false);
        }
        if (!isCombination2Correct) {
            radioButton3.setChecked(false);
            radioButton4.setChecked(false);
        }
    }

    private void mostrarDialog() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.layout_custom_dialog);
        dialog.show();
        ImageButton fecharIcon = dialog.findViewById(R.id.fecharIcon);
        fecharIcon.setOnClickListener(v -> dialog.dismiss());
        isDialogShowing = true;
        // A flag é resetada quando o diálogo é fechado
        fecharIcon.setOnClickListener(v -> {
            dialog.dismiss();
            isDialogShowing = false;
        });
    }
}
