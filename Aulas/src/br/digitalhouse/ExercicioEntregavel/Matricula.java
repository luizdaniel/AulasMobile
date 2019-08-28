package br.digitalhouse.ExercicioEntregavel;

import java.util.Date;

public class Matricula {
    private Aluno aluno;
    private Curso curso;
    private Date date;

    public Matricula(Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;
        this.date =  new Date();
    }
}