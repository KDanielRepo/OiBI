import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CesarText {
    public static void main(String[] args) {
        CesarText cesarText = new CesarText();
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj text: ");
        String text = scanner.nextLine();
        System.out.println("o ile przesunac? ");
        int rotation = scanner.nextInt();
        char[] chars = text.toCharArray();
        System.out.println("przed: "+cesarText.conv(chars));
        for (int i = 0; i < chars.length; i++) {
            char test = chars[i];
            int a = test;
            a = a+rotation;
            chars[i] = (char) a;
        }
        System.out.println("po: "+cesarText.conv(chars));

    }
    public String code(String string,int rot){
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char test = chars[i];
            int a = test;
            if(a==32){
                chars[i] = ' ';
            }else{
                a = a+rot;
                if(a>122){
                    int aa = a-123;
                    a = 97+aa;
                }
                chars[i] = (char) a;
            }
        }
        return conv(chars);
    }
    public String conv(char[] chars){
        String out = "";
        for (int i = 0; i < chars.length; i++) {
            out+=chars[i];
        }
        return out;
    }
    public List<String> files(){
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            File file = new File("C:\\Users\\Ithilgore\\Downloads\\SpringPlayground\\OiBI\\texts\\"+i+".txt");
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                strings.add(bufferedReader.readLine());
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }
}
