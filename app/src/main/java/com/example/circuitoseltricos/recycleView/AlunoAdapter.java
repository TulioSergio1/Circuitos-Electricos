package com.example.circuitoseltricos.recycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.circuitoseltricos.Aluno;
import com.example.circuitoseltricos.R;

import java.util.List;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoViewHolder> {

    private List<Aluno> listaDeAlunos;

    public AlunoAdapter(List<Aluno> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

    @NonNull
    @Override
    public AlunoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aluno, parent, false);
        AlunoViewHolder alunoViewHolder = new AlunoViewHolder(view);
        return alunoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlunoViewHolder holder, int position){
        Aluno aluno = listaDeAlunos.get(position);
        String nome = aluno.getNome();
        String curso = aluno.getCurso();
        String periodo = aluno.getPeriodo();

        holder.getNomeTextView().setText(nome);
        holder.getCursoTextView().setText(curso);
        holder.getPeriodoTextView().setText(periodo);
    }

    public int getItemCount() {
        return listaDeAlunos.size();
    }
}
