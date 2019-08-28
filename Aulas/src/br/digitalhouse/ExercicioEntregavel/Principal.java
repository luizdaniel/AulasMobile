package br.digitalhouse.ExercicioEntregavel;

public class Principal {
    public static void main(String[] args) {
        DigitalHouseManager escola = new DigitalHouseManager();

        escola.registrarProfessorAdjunto("Maria", "Silva", 1, 1);
        escola.registrarProfessorAdjunto("Ana", "Julia", 2, 2);
        escola.registrarProfessorTitular("Renata", "Azul", 3, "C#");
        escola.registrarProfessorTitular("Mariana", "Verde", 4, "Java");

        escola.registrarCurso("Full Stack", 2001, 3);
        escola.registrarCurso("Android", 2002, 2);

        escola.alocarProfessores(2001, 3, 1);
        escola.alocarProfessores(2002, 4, 2);

        escola.matricularAluno("João", "Ouro", 1);
        escola.matricularAluno("Pedro", "Prata", 2);
        escola.matricularAluno("Antonio", "Bronze", 3);
        escola.matricularAluno("Nath", "Jas", 4);
        escola.matricularAluno("Carla", "Brota", 5);

        escola.matricularAluno(1, 2001);
        escola.matricularAluno(2, 2001);
        escola.matricularAluno(3, 2002);
        escola.matricularAluno(4, 2002);
        escola.matricularAluno(5, 2002);

        escola.consultarCursosDoAluno(2);
    }
}
