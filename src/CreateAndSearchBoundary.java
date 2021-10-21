import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CreateAndSearchBoundary<T> {

    private final String title;
    private final String searchIdentifier;
    private final List<T> entities = new ArrayList<>();
    private final List<String> fields;
    private final Map<String, TextField> fieldsMap = new HashMap<>();
    private final Function<Map<String, TextField>, T> onCreate;
    private final BiFunction<String, List<T>, Optional<Map<String, String>>> onSearch;

    public CreateAndSearchBoundary(
        final String title,
        final String searchIdentifier,
        final List<String> fields,
        final Function<Map<String, TextField>, T> onCreate,
        final BiFunction<String, List<T>, Optional<Map<String, String>>> onSearch
    ) {
        this.title = title;
        this.searchIdentifier = searchIdentifier;
        this.fields = fields;
        this.onCreate = onCreate;
        this.onSearch = onSearch;
    }

    private Button generateCreateButton() {
        final var createButton = new Button();
        createButton.setText("Adicionar");
        createButton.setOnAction(e -> {
            entities.add(onCreate.apply(fieldsMap));
        });
        return createButton;
    }

    private Button generateSearchButton() {
        final var searchButton = new Button();
        searchButton.setText("Pesquisar");
        searchButton.setOnAction(e ->
            onSearch
                .apply(this.fieldsMap.get(searchIdentifier).getText(), entities)
                .ifPresent(values ->
                    values.forEach((key, value) -> {
                        fieldsMap.get(key).setText(value);
                    })
                )
        );

        return searchButton;
    }

    public void start(final Stage stage) {
        final var pane = new GridPane();
        final var row = new Counter();

        fields.forEach(field -> {
            var textField = new TextField();
            fieldsMap.put(field, textField);
            pane.add(new Label(field), 0, row.toInt());
            pane.add(textField, 1, row.toInt());
            row.increment();
        });

        pane.add(generateCreateButton(), 0, row.toInt());
        pane.add(generateSearchButton(), 1, row.toInt());

        stage.setTitle(title);
        stage.setScene(new Scene(pane, 600, 400));
        stage.show();
    }
}
