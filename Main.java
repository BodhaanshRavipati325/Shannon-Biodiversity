import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

class Main {

    private static HashMap<String, Integer> list = new HashMap<>();
    private static int population = 0;
    private static double diversity = 0;
    private static double equitability = 0;
    private static int richness = 0;

    public static void main(String[] args) throws FileNotFoundException {
        initialize();
        System.out.println(diversity);
        System.out.println(equitability);
        Scanner sc = new Scanner(new File("Biodiversity Cars Analysis - Sheet1.csv"));  
        sc.useDelimiter(",");   //sets the delimiter pattern  
        while (sc.hasNext()) { //returns a boolean value   
            System.out.print(sc.next() + " ");  //find and returns the next complete token from this scanner  
        }   
        sc.close(); 
        //closes the scanner  
    }

    public static void initialize() {
        createList();
        getPop();
        getRichness();
        computeDiversity();
        computeEquitability();
    }

    public static double getN(String name) {
        return list.get(name);
    }

    private static void getRichness() {
        richness = list.size();
    }

    public static double getP(String name) {
        return (double)getN(name) / population;
    }

    public static void getPop() {
        list.forEach((k, v) ->  population += v);
    }

    public static double ln(double num) {
        return Math.log(num);
    }

    public static void computeDiversity() {
        list.forEach((k, v) -> diversity += (ln(getP(k)) * -1 * getP(k)));
    }

    public static void computeEquitability() {
        equitability = diversity / ln(richness);
    }

    public static void createList() {
        list.put("Honda Civic", 2);
        list.put("Chevrolet Silverado", 1);
        list.put("Nissan Altima", 1);
        list.put("Scion tC", 1);
        list.put("Ford Fusion", 1);
    }
}