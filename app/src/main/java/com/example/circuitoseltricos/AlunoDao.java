package com.example.circuitoseltricos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao

public interface AlunoDao {
    @Insert
    public void inserir(Aluno... aluno);
    @Update
    public void atualizar(Aluno... aluno);


    @Query("SELECT * FROM aluno WHERE id_aluno = :idAluno")
    public Aluno getAluno(int idAluno);

    @Query("SELECT * FROM aluno")
    public List<Aluno> getAlunos();



}
