package opgave1;

public class App {
    public static void main(String[] args) {
        Chili[] chilier = new Chili[5];

        Chili c1 = new Chili("Pepper x", 1000000);
        Chili c2 = new Chili("Carolina", 100000);
        Chili c3 = new Chili("Scoth", 50000);
        Chili c4 = new Chili("Habenero", 100000);
        Chili c5 = new Chili("Jalepeno",5000);

        chilier[0] = c1;
        chilier[1] = c2;
        chilier[2] = c3;
        chilier[3] = c4;
        chilier[4] = c5;

        System.out.println("max:" + max(chilier));
        System.out.println(avg(chilier));
    }

    public static Measurable max(Measurable[] objects) {
        Measurable max = null;
        for (Measurable m : objects) {
            if (max != null && m.getMeasure() > max.getMeasure()) {
                max = m;
            } else if (max == null) {
                max = m;

            }
        }
        return max;
    }

    public static double avg(Measurable[] objects) {
        double sum = 0;
        for (Measurable m : objects) {
            sum += m.getMeasure();
        }
        return sum / objects.length;
    }
}
