public class Curso {

    public Integer id;
    public String nome;
    public String codigo;
    public String nomeDoCoordenador;
    public Integer quantidadeDeAlunos;

    public Curso(
        Integer id,
        String nome,
        String codigo,
        String nomeDoCoordenador,
        Integer quantidadeDeAlunos
    ) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.nomeDoCoordenador = nomeDoCoordenador;
        this.quantidadeDeAlunos = quantidadeDeAlunos;
    }

    @Override
    public String toString() {
        return (
            "Curso [codigo=" +
            codigo +
            ", id=" +
            id +
            ", nome=" +
            nome +
            ", nomeDoCoordenador=" +
            nomeDoCoordenador +
            ", quantidadeDeAlunos=" +
            quantidadeDeAlunos +
            "]"
        );
    }
}
