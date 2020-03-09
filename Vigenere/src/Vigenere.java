import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;

import java.util.*;

public class Vigenere {
    Map<String,Integer> first = new TreeMap<>();
    Map<Integer,String> second = new TreeMap<>();
    String key = "informatyka";
    String tekst = "";
    List<Integer> ilosc = new ArrayList<>();
    List<Integer> iloscc = new ArrayList<>();
    HBox hBox = new HBox();
    public static void main(String[] args) {
        Vigenere vigenere = new Vigenere();
        vigenere.prepareMap();
        Scanner scanner = new Scanner(System.in);
        vigenere.tekst = scanner.nextLine();
        vigenere.tekst = vigenere.code(vigenere.tekst);
        vigenere.decode(vigenere.tekst);
    }
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
    public void prepareMap(){
        List<String> strings = new ArrayList<>();
        setLitery(strings);
        for (int i = 0; i < 26; i++) {
            first.put(strings.get(i),i);
            second.put(i,strings.get(i));
        }
    }
    public String code(String st){
        String wynik = "";
        for (int i = 0; i < st.length(); i++) {
            String a = st.substring(i,i+1);
            String b = key.substring(i,i+1);
            int test = first.get(a);
            int test2 = first.get(b);
            int test3 = (test+test2);
            while(test3>26){
                test3-=26;
            }
            wynik+=second.get(test3);
        }
        System.out.println(wynik);
        return wynik;
    }
    public void decode(String st){
        String wynik = "";
        for (int i = 0; i < st.length(); i++) {
            String a = st.substring(i,i+1);
            String b = key.substring(i,i+1);
            int test = first.get(a);
            int test2 = first.get(b);
            int test3 = Math.abs((test-test2));
            while(test3>26){
                test3-=26;
            }
            wynik+=second.get(test3);
        }
        System.out.println(wynik);
    }
    public void createChart(String tekst,String tekst2){
        BarChart barChart;
        BarChart<String,Number> barChart1;
        XYChart.Series series;

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis2 = new CategoryAxis();
        final NumberAxis yAxis2 = new NumberAxis();

        barChart = new BarChart<String, Number>(xAxis, yAxis);
        series = new XYChart.Series();
        xAxis.setLabel("litera");
        yAxis.setLabel("ilosc");

        for (int i = 0; i < first.size(); i++) {
            int iloscc = 0;
            for (int j = 0; j < tekst.length(); j++) {
                String test = tekst.substring(j, j + 1);
                if (second.get(i).equals(test)) {
                    iloscc++;
                }
            }
            ilosc.add(iloscc);
        }
        Map test = new TreeMap();
        for (int i = 0; i < first.size(); i++) {
            test.put(second.get(i),ilosc.get(i));
        }
        Set<String> keys = test.keySet();

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

        List<Integer> ilosc2 = new ArrayList<>();
        barChart1.setTitle("Po");


        for (int i = 0; i < first.size(); i++) {
            int iloscc = 0;
            for (int j = 0; j < tekst2.length(); j++) {
                String testt = tekst2.substring(j, j + 1);
                if (second.get(i).equals(testt)) {
                    iloscc++;
                }
            }
            ilosc2.add(iloscc);
        }
        Map testt = new TreeMap();
        for (int i = 0; i < first.size(); i++) {
            testt.put(second.get(i),ilosc2.get(i));
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
}
