import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Map<Integer,String> alfabet = new TreeMap<>();
        String[] litery = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        Integer[] cyfry = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        for (int i = 0; i < 260000000; i++) {
            int random = ThreadLocalRandom.current().nextInt(0,26);
            cyfry[random] +=1;
        }
        double min = 0;
        double max = 0;
        int avgu = 0;
        int up = 0;
        int avgd = 0;
        int down = 0;
        for (int i = 0; i < litery.length; i++) {
            alfabet.put(cyfry[i],litery[i]);
            System.out.println(litery[i]+" : "+cyfry[i]);
            if(cyfry[i]>max){
                max=cyfry[i];
            }
            if(i==0){
                min = cyfry[i];
            }else if(cyfry[i]<min){
                min = cyfry[i];
            }
            if(cyfry[i]>10000000){
                avgu+=cyfry[i];
                up++;
            }else{
                avgd+=cyfry[i];
                down++;
            }
        }
        System.out.println("min = "+min);
        System.out.println("max = "+max);
        System.out.println("gorna = "+avgu/up);
        System.out.println("dolna = "+avgd/down);
        System.out.println("min % = "+min/100000);
        System.out.println("max % = "+max/100000);
    }
}
