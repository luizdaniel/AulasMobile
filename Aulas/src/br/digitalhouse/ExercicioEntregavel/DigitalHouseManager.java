package br.digitalhouse.ExercicioEntregavel;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {
    private List<Aluno> alunos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    private List<Matricula> matriculas = new ArrayList<>();

    public void registrarCurso(String nome, Integer codigoCurso, Integer qtdMaxAlunos) {
        Curso curso = new Curso();
        curso.setNome(nome);
        curso.setCodigoDoCurso(codigoCurso);
        curso.setQtdMaximaAlunos(qtdMaxAlunos);

        cursos.add(curso);
        System.out.println("Curso: " + curso.getNome() + " -> Adicionado com sucesso.");
    }

    public void excluirCurso(Integer codigoCurso) {

        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getCodigoDoCurso().equals(codigoCurso)){
                cursos.remove(cursos.get(i));
                System.out.println("Curso Excluido.");
            } else {
                System.out.println("Curso não localizado.");
            }
        }
    }

    public void alocarProfessores(Integer codigoDoCurso, Integer codigoProfessorTitular, Integer codigoProfessorAdjunto) {
        Curso curso = null;
        ProfessorTitular titular = null;
        ProfessorAdjunto adjunto = null;

        //pesquisar curso
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getCodigoDoCurso().equals(codigoDoCurso)){
                curso = cursos.get(i);
            }
        }

        //pesquisar prof titular
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getCodigoDeProfessor().equals(codigoProfessorTitular)){
                titular = (ProfessorTitular) professores.get(i);
            }
        }

        //pesquisar prof titular
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getCodigoDeProfessor().equals(codigoProfessorAdjunto)){
                adjunto = (ProfessorAdjunto) professores.get(i);
            }
        }

        //Se encontrou os professores e o curso
        if (curso != null && titular != null && adjunto != null){
            curso.setProfAdjunto(adjunto);
            curso.setProfTitular(titular);
            System.out.println("Prof Titular: " + titular.getNome() + " - Prof adjunto: " + adjunto.getNome() + " -> adicionados no curso: " + curso.getNome());

        }else{
            if(titular == null){
                System.out.println("titular não encontrado.");
            }
            if(adjunto == null){
                System.out.println("adjunto não encontrado.");
            }
            if(curso == null){
                System.out.println("Curso não encontrado.");
            }

        }
    }

    public void matricularAluno(Integer codigoAluno, Integer codigoCurso) {
        Curso curso = null;
        Aluno aluno = null;
        Matricula matricula;

        //pesquisar curso
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getCodigoDoCurso().equals(codigoCurso)){
                curso = cursos.get(i);
            }
        }

        //pesquisar aluno
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getCodigo().equals(codigoAluno)){
                aluno = alunos.get(i);
            }
        }

        //Se encontrou o aluno e o curso então matricular
        if (aluno != null && curso != null){

            if(curso.adicionarUmAluno(aluno)){
                matricula = new Matricula(aluno, curso);
                matriculas.add(matricula);
            }

        }else{
            if(aluno == null){
                System.out.println("Aluno não encontrado.");
            }
            if(curso == null){
                System.out.println("Curso não encontrado.");
            }

        }

    }

    public void matricularAluno(String nome, String sobrenome, Integer codigoAluno) {
        Aluno aluno = new Aluno(nome, sobrenome, codigoAluno);
        alunos.add(aluno);
        System.out.println("Aluno: " + aluno.getNome() + " -> Adicionado com sucesso.");
    }

    public void excluirProfessor(Integer codigoProfessor) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getCodigoDeProfessor().equals(codigoProfessor)){
                professores.remove(professores.get(i));
                System.out.println("Professor Excluido.");
            } else {
                System.out.println("Professor não localizado.");
            }
        }
    }

    public void registrarProfessorTitular(String nome, String sobrenome, Integer codigoProf, String especialidade){
        ProfessorTitular profTit = new ProfessorTitular();
        profTit.setTempoDeCasa(0);
        profTit.setNome(nome);
        profTit.setSobreNome(sobrenome);
        profTit.setCodigoDeProfessor(codigoProf);
        profTit.setEspecialidade(especialidade);

        professores.add(profTit);
        System.out.println("Profesor Titular adicionado: " + nome);
    }

    public void registrarProfessorAdjunto(String nome, String sobrenome, Integer codigoProf, Integer qtHoras){
        ProfessorAdjunto profAd = new ProfessorAdjunto();
        profAd.setTempoDeCasa(0);
        profAd.setNome(nome);
        profAd.setSobreNome(sobrenome);
        profAd.setCodigoDeProfessor(codigoProf);
        profAd.setQtdDeHrs(qtHoras);

        professores.add(profAd);
        System.out.println("Profesor Adjunto adicionado: " + nome);
    }

    public List<Curso> consultarCursos(Aluno aluno){

        return null;
    }

}