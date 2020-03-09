import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VigenereApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Vigenere vigenere = new Vigenere();
        vigenere.prepareMap();
        BorderPane borderPane = new BorderPane();
        borderPane.setRight(vigenere.hBox);
        VBox vBox = new VBox();
        TextField textField = new TextField();
        TextField textField1 = new TextField();
        Button button = new Button("chart");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vigenere.createChart(textField.getText(),vigenere.code(textField.getText()));
            }
        });
        Button button1 = new Button("code/decode");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vigenere.key = textField1.getText();
                vigenere.decode(vigenere.code(textField.getText()));
            }
        });

        vBox.getChildren().addAll(textField,textField1,button1,button);
        borderPane.setLeft(vBox);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(VigenereApp.class,args);
    }
}
