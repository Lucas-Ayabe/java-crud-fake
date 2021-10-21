import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new CreateAndSearchBoundary<Curso>(
            "Gestão de cursos",
            "nome",
            List.of(
                "id",
                "nome",
                "codigo",
                "nomeDoCoordenador",
                "quantidadeDeAlunos"
            ),
            fields -> {
                System.out.println("Criando...");
                return new Curso(
                    Integer.parseInt(fields.get("id").getText()),
                    fields.get("nome").getText(),
                    fields.get("codigo").getText(),
                    fields.get("nomeDoCoordenador").getText(),
                    Integer.parseInt(fields.get("quantidadeDeAlunos").getText())
                );
            },
            (search, entities) -> {
                final var talvezCurso = entities
                    .stream()
                    .filter(curso -> curso.nome.equals(search))
                    .findFirst();

                if (talvezCurso.isPresent()) {
                    final var map = new HashMap<String, String>();
                    final var curso = talvezCurso.get();
                    map.put("id", curso.id.toString());
                    map.put("nome", curso.nome);
                    map.put("codigo", curso.codigo);
                    map.put("nomeDoCoordenador", curso.nomeDoCoordenador);
                    map.put(
                        "quantidadeDeAlunos",
                        curso.quantidadeDeAlunos.toString()
                    );

                    return Optional.of(map);
                }

                System.out.println("Não encontrado");
                return Optional.empty();
            }
        )
            .start(stage);
    }
}
