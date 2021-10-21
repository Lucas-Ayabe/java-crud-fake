import java.time.LocalDate;

public class Aluno {

    public Integer id;
    public String ra;
    public String nome;
    public LocalDate nascimento;

    public Aluno(Integer id, String ra, String nome, LocalDate nascimento) {
        this.id = id;
        this.ra = ra;
        this.nome = nome;
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
