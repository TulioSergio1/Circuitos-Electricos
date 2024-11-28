package com.example.circuitoseltricos.fragmentos;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.circuitoseltricos.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SistemaEletrico#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SistemaEletrico extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button instalacoesButton;
    private Button dadosMax;
    private Button dadosMin;
    private FloatingActionButton floatingActionButton;
    private ImageButton buttonInfo;
    private ImageButton buttonFechar;

    private ImageView lightView;

    private TextView dadosTextView;
    private TextView dadosMinTextView;
    private TextView dadosMaxTextView;




    public SistemaEletrico() {
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
    public static SistemaEletrico newInstance(String param1, String param2) {
        SistemaEletrico fragment = new SistemaEletrico();
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

        instalacoesButton = view.findViewById(R.id.instalacaoButton);
        dadosMax = view.findViewById(R.id.buttonDadosMax);
        dadosMin = view.findViewById(R.id.buttonDadosMin);
        buttonInfo = view.findViewById(R.id.buttonInfo);
        buttonFechar = view.findViewById(R.id.fecharIcon);

        lightView = view.findViewById(R.id.lightView2);

        floatingActionButton = view.findViewById(R.id.floatingActionButton);

        dadosTextView = view.findViewById(R.id.dados);
        dadosMaxTextView = view.findViewById(R.id.dadosMax);
        dadosMinTextView = view.findViewById(R.id.dadoMin);



        buttonInfo.setOnClickListener(view1 -> {
            mostrarDialog();
        });

        instalacoesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new InstalacoesSolaresFragment());
                fragmentTransaction.addToBackStack(null); // Permite voltar para o fragmento anterior
                fragmentTransaction.commit();
            }
        });

        final boolean[] botoesAtivados = {false};

        floatingActionButton.setOnClickListener(view1 -> {


            SharedPreferences sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            botoesAtivados[0] = sharedPreferences.getBoolean("botoesAtivados", false);

            // Verificar se os botões estão ativados antes de ativar o sistema
            if (botoesAtivados[0] == true) {

                if ((dadosMaxTextView.getVisibility() == View.INVISIBLE) && (dadosMinTextView.getVisibility() == View.INVISIBLE) ){
                    ativarSistema();
                }
            } else {
                desativarSistema();
            }

        });

        dadosMax.setOnClickListener(view1 -> {

            if (botoesAtivados[0] == true){
                dadosTextView.setVisibility(View.INVISIBLE);
                dadosMinTextView.setVisibility(View.INVISIBLE);
                dadosMaxTextView.setVisibility(View.VISIBLE);
            }

        });

        dadosMin.setOnClickListener(view1 -> {

            if (botoesAtivados[0] == true){
                dadosTextView.setVisibility(View.INVISIBLE);
                dadosMinTextView.setVisibility(View.VISIBLE);
                dadosMaxTextView.setVisibility(View.INVISIBLE);
            }
        });

        return view;
    }


    // Método para ativar o sistema
    private void ativarSistema() {
        lightView.setVisibility(View.VISIBLE);

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(lightView, "alpha", 0.1f, 1.0f);
        fadeIn.setDuration(6000); // Duração de 6 segundos para aumentar o brilho
        fadeIn.start();

        dadosTextView.setVisibility(View.VISIBLE);
    }

    // Método para desativar ou manter o sistema desativado
    private void desativarSistema() {
        lightView.setVisibility(View.INVISIBLE); // Ou mantenha oculto
    }

    private void mostrarDialog() {
        // Cria o dialog
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.layout_question_dialog);

        // Encontrar o botão de fechar dentro do dialog
        buttonFechar = dialog.findViewById(R.id.fecharIcon);

        // Exibe o dialog
        dialog.show();

        // Configura o comportamento do botão fechar
        buttonFechar.setOnClickListener(view -> {
            dialog.dismiss(); // Fecha o dialog
        });
    }

}
