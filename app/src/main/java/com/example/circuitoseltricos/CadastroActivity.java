package com.example.circuitoseltricos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.ads.MobileAds;

public class CadastroActivity extends AppCompatActivity {

    private Button cadastrarButton;
    private EditText nomeEditText;
    private EditText periodoEditText;
    private Spinner cursoSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cadastrarButton = findViewById(R.id.cadastrarButton);
        nomeEditText = findViewById(R.id.nomeEditText);
        periodoEditText = findViewById(R.id.periodoEditText);
        cursoSpinner = findViewById(R.id.cursoSpinner);

        new Thread(
                () -> {
                    // Initialize the Google Mobile Ads SDK on a background thread.
                    MobileAds.initialize(this, initializationStatus -> {});
                })
                .start();

        AppDatabase instance = AppDatabase.getInstance(getApplicationContext());

        cadastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = nomeEditText.getText().toString().trim();
                String periodo = periodoEditText.getText().toString().trim();
                String curso = cursoSpinner.getSelectedItem().toString();

                if (!nome.equals("") && !periodo.equals("") && !curso.equals("Selecione seu curso")){

                    Aluno aluno = new Aluno(nome, periodo, curso);
                    instance.getAlunoDao().inserir(aluno);
                    nomeEditText.setText("");
                    periodoEditText.setText("");
                    Toast.makeText(getApplicationContext(), "Dados salvos!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}