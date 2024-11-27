package com.example.circuitoseltricos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "aluno")
public class Aluno {
    @ColumnInfo(name = "id_aluno")
    @PrimaryKey(autoGenerate = true)
    private int idAluno;

    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "periodo")
    private String periodo;
    @ColumnInfo(name = "curso")
    private String curso;


    public Aluno(String nome, String periodo, String curso) {
        this.nome = nome;
        this.periodo = periodo;
        this.curso = curso;
    }

    // Getters e setters
    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "idAluno=" + idAluno +
                ", nome='" + nome + '\'' +
                ", periodo='" + periodo + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }
}
