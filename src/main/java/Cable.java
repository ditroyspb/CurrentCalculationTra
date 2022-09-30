public class Cable {

//    double diameter;
    public double diameter;
    public String material;
    public double resistance;

    public Cable() {
    }

    @Override
    public String toString() {
        return "Cable{" +
                "diameter=" + diameter +
                ", material='" + material + '\'' +
                ", resistance='" + resistance + '\'' +
                '}';
    }

    public Cable(double diameter, String material, double resistance) {
        this.diameter = diameter;
        this.material = material;
        this.resistance = resistance;
    }
}
