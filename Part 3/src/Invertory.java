import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Invertory {
    static List<Guitar> guitars = new ArrayList<>();
    static void addGuitar(String serialNumber, double price, String builder,
                          String model,String type,String backWood,String topWood) throws IOException {
        FileWriter file = new FileWriter("guitars_database.txt", true);
        BufferedWriter write = new BufferedWriter(file);
        PrintWriter p = new PrintWriter(write);
        String guitar = serialNumber + " " + price + " " + builder + " " + model
                + " " + type + " " + backWood + " " + topWood;
        p.println(guitar);
        guitars.add(new Guitar(serialNumber,price,builder,model,type,backWood,topWood));
        p.close();
        write.close();
        file.close();
    }
    static Guitar getGuitar(String serialNumber) throws IOException {
        FileReader file = new FileReader("guitars_database.txt");
        Scanner read = new Scanner(file);
        String line = "";
        String price = "";
        String builder = "";
        String model = "";
        String type = "";
        String backWood = "";
        String topWood = "";
        int j = 0;
        while (read.hasNext()){
            line = read.next();
            if (j == 0){
                j++;

                continue;
            } else if (j == 1){
                price = line;
                j++;

                continue;
            } else if (j == 2) {
                builder = line;

                j++;
                continue;
            } else if (j == 3) {
                model = line;

                j++;
                continue;
            }else if (j == 4){
                type = line;

                j++;
                continue;
            } else if (j == 5) {
                backWood = line;

                j++;
                continue;
            }else {
                topWood = line;
                System.out.println(line);
                if (!guitars.contains(new Guitar(serialNumber,Double.parseDouble(price),builder,model,type,backWood,topWood))){
                    guitars.add(new Guitar(serialNumber,Double.parseDouble(price),builder,model,type,backWood,topWood));
                }
                j = 0;
                continue;
            }
        }
        read.close();
        for (int i = 0; i < guitars.size(); i++) {
                Guitar guitar = guitars.get(i);
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }
    static Guitar searchGuitar(Guitar guitar) throws IOException {
        String serial = guitar.getSerialNumber();
        return getGuitar(serial);
    }

}
