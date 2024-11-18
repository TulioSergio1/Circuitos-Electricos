package com.example.circuitoseltricos.fragmentos;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.circuitoseltricos.MainActivity;
import com.example.circuitoseltricos.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SistemaEletrico2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SistemaEletrico2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageButton buttonVoltar;
    private ImageButton infoDialog;
    private RadioButton radioButton5;
    private RadioButton radioButton6;
    private RadioButton radioButton7;
    private RadioButton radioButton8;
    private RadioButton radioButton9;
    private RadioButton radioButton10;
    private RadioButton radioButton11;
    private RadioButton radioButton12;
    private ImageView caboVermelhoCurvado;
    private ImageView caboVermelhoCurvadoInvertido;
    private ImageView caboPretoCurvado;
    private ImageView caboPretoCurvadoInvertido;
    private ImageView conectorLigados;

    private boolean isDialogShowing = false;
    private boolean isCombination1Correct = false;
    private boolean isCombination2Correct = false;
    private boolean isCombination3Correct = false;
    private boolean isCombination4Correct = false;

    public SistemaEletrico2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SistemaEletrico2.
     */
    // TODO: Rename and change types and number of parameters
    public static SistemaEletrico2 newInstance(String param1, String param2) {
        SistemaEletrico2 fragment = new SistemaEletrico2();
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
        View view = inflater.inflate(R.layout.fragment_sistema_eletrico2, container, false);

        infoDialog = view.findViewById(R.id.buttonInfo);
        buttonVoltar = view.findViewById(R.id.buttonVoltar);
        radioButton5 = view.findViewById(R.id.radioButton5);
        radioButton6 = view.findViewById(R.id.radioButton6);
        radioButton7 = view.findViewById(R.id.radioButton7);
        radioButton8 = view.findViewById(R.id.radioButton8);
        radioButton9 = view.findViewById(R.id.radioButton9);
        radioButton10 = view.findViewById(R.id.radioButton10);
        radioButton11 = view.findViewById(R.id.radioButton11);
        radioButton12 = view.findViewById(R.id.radioButton12);

        caboPretoCurvado = view.findViewById(R.id.caboPretoCurvado);
        caboVermelhoCurvado = view.findViewById(R.id.caboVermelhoCurvado);
        caboPretoCurvadoInvertido = view.findViewById(R.id.caboPretoCurvadoInvertido);
        caboVermelhoCurvadoInvertido = view.findViewById(R.id.caboVermelhoCurvadoInvertido);
        conectorLigados = view.findViewById(R.id.conectoresImageView);

        radioButton5.setOnClickListener(v -> {
            if (radioButton5.isChecked()) {
                verificarCombinacoes();
            } });

        radioButton6.setOnClickListener(v -> {
            if (radioButton6.isChecked()) {
                verificarCombinacoes();
            } });

        radioButton7.setOnClickListener(v -> {
            if (radioButton7.isChecked()) {
                verificarCombinacoes();
            } });

        radioButton8.setOnClickListener(v -> {
            if (radioButton8.isChecked()) {
                verificarCombinacoes();
            } });

        radioButton9.setOnClickListener(v -> {
            if (radioButton9.isChecked()) {
                verificarCombinacoes();
            } });

        radioButton10.setOnClickListener(v -> {
            if (radioButton10.isChecked()) {
                verificarCombinacoes();
            } });

        radioButton11.setOnClickListener(v -> {
            if (radioButton11.isChecked()) {
                verificarCombinacoes();
            } });

        radioButton12.setOnClickListener(v -> {
            if (radioButton12.isChecked()) {
                verificarCombinacoes();
            } });

        buttonVoltar.setOnClickListener(view1 -> {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);
        });

        infoDialog.setOnClickListener(v -> {
            Dialog dialog = new Dialog(getContext());
            dialog.setContentView(R.layout.layout_question_dialog_serie);
            dialog.show();
            ImageButton fecharIcon = dialog.findViewById(R.id.fecharIcon);
            fecharIcon.setOnClickListener(view1 -> dialog.dismiss());
            fecharIcon.setOnClickListener(view1 -> {
                dialog.dismiss();
            });
        });


        return view;
    }

    private void verificarCombinacoes() {
        // Verificar combinações quando nenhuma combinação correta foi feita ainda
        boolean combinacao1 = radioButton5.isChecked() && radioButton7.isChecked();
        boolean combinacao2 = radioButton6.isChecked() && radioButton8.isChecked();
        boolean combinacao3 = radioButton9.isChecked() && radioButton10.isChecked();
        boolean combinacao4 = radioButton11.isChecked() && radioButton12.isChecked();
        boolean combinacaoInvalida = !combinacao1 && !combinacao2 && !combinacao3 && !combinacao4 &&
                ((radioButton5.isChecked() && radioButton6.isChecked()) ||
                        (radioButton5.isChecked() && radioButton8.isChecked()) ||
                        (radioButton5.isChecked() && radioButton9.isChecked()) ||
                        (radioButton5.isChecked() && radioButton10.isChecked()) ||
                        (radioButton5.isChecked() && radioButton11.isChecked()) ||
                        (radioButton5.isChecked() && radioButton12.isChecked()) ||

                        (radioButton6.isChecked() && radioButton7.isChecked()) ||
                        (radioButton6.isChecked() && radioButton9.isChecked()) ||
                        (radioButton6.isChecked() && radioButton10.isChecked()) ||
                        (radioButton6.isChecked() && radioButton11.isChecked()) ||
                        (radioButton6.isChecked() && radioButton12.isChecked()) ||

                        (radioButton7.isChecked() && radioButton8.isChecked()) ||
                        (radioButton7.isChecked() && radioButton9.isChecked()) ||
                        (radioButton7.isChecked() && radioButton10.isChecked()) ||
                        (radioButton7.isChecked() && radioButton11.isChecked()) ||
                        (radioButton7.isChecked() && radioButton12.isChecked()) ||

                        (radioButton8.isChecked() && radioButton9.isChecked()) ||
                        (radioButton8.isChecked() && radioButton10.isChecked()) ||
                        (radioButton8.isChecked() && radioButton11.isChecked()) ||
                        (radioButton8.isChecked() && radioButton12.isChecked()) ||

                        (radioButton9.isChecked() && radioButton11.isChecked()) ||
                        (radioButton9.isChecked() && radioButton12.isChecked()) ||

                        (radioButton10.isChecked() && radioButton11.isChecked()) ||
                        (radioButton10.isChecked() && radioButton12.isChecked())
                );

        if (combinacao1) {
            isCombination1Correct = true;
            caboPretoCurvado.setVisibility(View.VISIBLE);
        }

        if (combinacao2) {
            isCombination2Correct = true;
            caboVermelhoCurvado.setVisibility(View.VISIBLE);
        }

        if (combinacao3) {
            isCombination3Correct = true;
            caboVermelhoCurvadoInvertido.setVisibility(View.VISIBLE);
        }

        if (combinacao4) {
            isCombination4Correct = true;
            caboPretoCurvadoInvertido.setVisibility(View.VISIBLE);
        }

        if (combinacao1 == true && combinacao2 == true){
            conectorLigados.setVisibility(View.VISIBLE);
        }

        if (combinacaoInvalida) {
            mostrarDialog();
            desmarcarRadioButtonsInvalidas();
        }
    }

    private void desmarcarRadioButtonsInvalidas() {
        // Desmarca os RadioButtons das combinações inválidas
        if (!isCombination1Correct) {
            radioButton5.setChecked(false);
            radioButton7.setChecked(false);
        }
        if (!isCombination2Correct) {
            radioButton6.setChecked(false);
            radioButton8.setChecked(false);
        }
        if (!isCombination3Correct) {
            radioButton9.setChecked(false);
            radioButton10.setChecked(false);
        }
        if (!isCombination4Correct) {
            radioButton11.setChecked(false);
            radioButton12.setChecked(false);
        }
    }

    private void mostrarDialog() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.layout_alert_dialog);
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