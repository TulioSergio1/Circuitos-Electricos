package com.example.circuitoseltricos.recycleView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.circuitoseltricos.R;

public class AlunoViewHolder extends RecyclerView.ViewHolder {

    private TextView nomeTextView;
    private TextView cursoTextView;
    private TextView periodoTextView;

    public AlunoViewHolder(View itemView) {
        super(itemView);
        nomeTextView = itemView.findViewById(R.id.nomeTextView);
        cursoTextView = itemView.findViewById(R.id.cursoTextView);
        periodoTextView = itemView.findViewById(R.id.periodoTextView);
    }

    public TextView getNomeTextView() {
        return nomeTextView;
    }

    public void setNomeTextView(TextView nomeTextView) {
        this.nomeTextView = nomeTextView;
    }

    public TextView getCursoTextView() {
        return cursoTextView;
    }

    public void setCursoTextView(TextView cursoTextView) {
        this.cursoTextView = cursoTextView;
    }

    public TextView getPeriodoTextView() {
        return periodoTextView;
    }

    public void setPeriodoTextView(TextView periodoTextView) {
        this.periodoTextView = periodoTextView;
    }
}
