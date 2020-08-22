import java.util.HashMap;

public class ShannonBiodiversity {

    private static int population;
    private static double diversity;
    private static double equitability;
    private static int richness;
    private static HashMap<String, Integer> list;

    public ShannonBiodiversity() {
        list = new HashMap<>();
        population = 0;
        diversity = 0.0;
        equitability = 0.0;
        richness = 0;
        initialize();
        System.out.println(toString());
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

    public void addSet(String key, Integer value) {
        list.put(key, value);
    }

    public void removeSet(String key, Integer value) {
        list.remove(key, value);
    }

    public void clear() {
        list.clear();
    }

    public String toString() {
        System.out.print("Diversity: " + diversity + " Equitability: " + equitability);
        return "Diversity: " + diversity + " Equitability: " + equitability;
    }
}