import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Cesar extends Application {
    BarChart barChart;
    BarChart<String,Number> barChart1;
    XYChart.Series series;
    String cesar;
    List<String> litery = new ArrayList<>();
    List<Integer> ilosc = new ArrayList<>();
    HBox hBox = new HBox();
    Map test = new TreeMap();
    Map testt = new TreeMap();
    //String[] litery = new String[]{};
    //Integer[] ilosc = new Integer[]{};
    //List<XYChart.Series> seriesList = new ArrayList<>();
    public void setLitery(List<String> litery){
        litery.add("a");
        litery.add("b");
        litery.add("c");
        litery.add("d");
        litery.add("e");
        litery.add("f");
        litery.add("g");
        litery.add("h");
        litery.add("i");
        litery.add("j");
        litery.add("k");
        litery.add("l");
        litery.add("m");
        litery.add("n");
        litery.add("o");
        litery.add("p");
        litery.add("q");
        litery.add("r");
        litery.add("s");
        litery.add("t");
        litery.add("u");
        litery.add("v");
        litery.add("w");
        litery.add("x");
        litery.add("y");
        litery.add("z");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        setLitery(litery);
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis2 = new CategoryAxis();
        final NumberAxis yAxis2 = new NumberAxis();
        ComboBox comboBox = new ComboBox();
        ObservableList<Integer> observableList = FXCollections.observableList(new ArrayList<>());
        for (int i = 0; i < 26; i++) {
            observableList.add(i);
        }
        comboBox.setItems(observableList);
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                /*List<String> test = new ArrayList<>();
                setLitery(test);*/
                List<Integer> test2 = new ArrayList<>();

                Collection<Integer> a = test.values();
                Object[] objects = a.toArray();
                Integer[] ilosci = new Integer[26];
                for (int i = 0; i < a.size(); i++) {
                    ilosci[i]=(Integer) objects[i];
                }

                Collection<Integer> b = testt.values();
                Object[] objects1 = b.toArray();
                Integer[] ilosci1=new Integer[26];
                for (int i = 0; i < b.size(); i++) {
                    ilosci1[i] = (Integer) objects1[i];
                }


                for (int i = comboBox.getSelectionModel().getSelectedIndex(); i < 26+comboBox.getSelectionModel().getSelectedIndex(); i++) {
                    if(i>25){
                        test2.add(ilosci[i-26]);//ilosc.get(i-26));
                    }else {
                        test2.add(ilosci[i]);
                    }
                }
                int kek = 0;
                for (int i = 0; i < test2.size(); i++) {
                    if(test2.get(i).equals(ilosci1[i])){
                        kek++;
                        System.out.println(test2.get(i)+" "+ilosci1[i]+" rowne");
                    }else{
                        System.out.println(test2.get(i)+" "+ilosci1[i]+" nie rowne");
                    }
                }
                if(kek==26){
                    System.out.println("przesuniecie to: "+comboBox.getSelectionModel().getSelectedIndex()+" lub "+(26-comboBox.getSelectionModel().getSelectedIndex()));
                }else{
                    System.out.println("nie bardzo");
                }
            }
        });
        VBox vBox = new VBox();
        Label a = new Label("text: ");
        TextField textField = new TextField();
        textField.setText("daniel kuc nowogard koszalin frida");
        Label c = new Label("rotacja: ");
        TextField textField2 = new TextField();
        textField2.setText("3");
        Label b = new Label("wyjscie: ");
        TextField textField1 = new TextField();

        textField1.setEditable(false);
        Button button = new Button("szyfruj");
        Button button1 = new Button("wykres");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                barChart = new BarChart<String, Number>(xAxis, yAxis);
                series = new XYChart.Series();
                xAxis.setLabel("litera");
                yAxis.setLabel("ilosc");

                /*for (int i = 0; i < textField.getText().length(); i++) {
                    String test = textField.getText().substring(i, i + 1);
                    if (!litery.contains(test)) {
                        litery.add(test);
                    }
                }*/
                for (int i = 0; i < litery.size(); i++) {
                    int iloscc = 0;
                    for (int j = 0; j < textField.getText().length(); j++) {
                        String test = textField.getText().substring(j, j + 1);
                        if (litery.get(i).equals(test)) {
                            iloscc++;
                        }
                    }
                    ilosc.add(iloscc);
                }
                //Map test = new TreeMap();
                for (int i = 0; i < litery.size(); i++) {
                    test.put(litery.get(i),ilosc.get(i));
                }
                Set<String> keys = test.keySet();
                //Collections.sort(litery);
                //series = new XYChart.Series();
                barChart.setTitle("Przed");

                for(String key : keys)
                for (int i = 0; i < keys.size(); i++) {
                    series.getData().add(new XYChart.Data(key, test.get(key)));
                    //seriesList.add(series);
                }

                barChart.getData().addAll(series);
                if(!hBox.getChildren().contains(barChart)){
                    hBox.getChildren().add(barChart);
                }

                barChart1 = new BarChart<String, Number>(xAxis2,yAxis2);
                XYChart.Series series1 = new XYChart.Series();
                xAxis2.setLabel("litera");
                yAxis2.setLabel("ilosc");

                List<String> litery2 = new ArrayList<>();
                setLitery(litery2);
                List<Integer> ilosc2 = new ArrayList<>();
                barChart1.setTitle("Po");

                /*for (int i = 0; i < textField1.getText().length(); i++) {
                    String testt = textField1.getText().substring(i, i + 1);
                    if (!litery2.contains(testt)) {
                        litery2.add(testt);
                    }
                }*/
                for (int i = 0; i < litery2.size(); i++) {
                    int iloscc = 0;
                    for (int j = 0; j < textField1.getText().length(); j++) {
                        String testt = textField1.getText().substring(j, j + 1);
                        if (litery2.get(i).equals(testt)) {
                            iloscc++;
                        }
                    }
                    ilosc2.add(iloscc);
                }
                //Map testt = new TreeMap();
                for (int i = 0; i < litery2.size(); i++) {
                    testt.put(litery2.get(i),ilosc2.get(i));
                }
                Set<String> keyss = testt.keySet();
                //Collections.sort(litery);
                //series = new XYChart.Series();
                barChart.setTitle("Przed");

                for(String key : keyss)
                    for (int i = 0; i < keyss.size(); i++) {
                        series1.getData().add(new XYChart.Data(key, testt.get(key)));
                        //seriesList.add(series);
                    }
                barChart1.getData().addAll(series1);
                if(!hBox.getChildren().contains(barChart1)){
                    hBox.getChildren().add(barChart1);
                }
            }
        });
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CesarText cesarText = new CesarText();
                if(textField.getText()==null || textField.getText().equals("") ||textField.getText().equals(" ")){
                    List<String> tekst = cesarText.files();
                    for (int i = 0; i < tekst.size(); i++) {
                        File file = new File("C:\\Users\\Ithilgore\\Downloads\\SpringPlayground\\OiBI\\texts\\"+i+"_szyfr.txt");
                        try {
                            FileWriter fileWriter = new FileWriter(file);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            bufferedWriter.write(cesarText.code(tekst.get(i),Integer.parseInt(textField2.getText())));
                            bufferedWriter.close();
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }else{
                    cesar = cesarText.code(textField.getText(), Integer.parseInt(textField2.getText()));
                    textField1.setText(cesar);
                }

            }
        });
        vBox.getChildren().addAll(a, textField, c, textField2, b, textField1, button,button1,comboBox);
        borderPane.setLeft(vBox);
        borderPane.setCenter(hBox);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.show();
    }
    public void correct(){

    }

    public static void main(String[] args) {
        launch(Cesar.class, args);
    }
}
