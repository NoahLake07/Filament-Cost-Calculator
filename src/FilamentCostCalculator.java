public class FilamentCostCalculator {
    private static final double PI = Math.PI;
    private static final double DENSITY_PLA = 1.24;  // g/cm^3
    private static final double DENSITY_ABS = 1.04;  // g/cm^3
    private static final double DENSITY_TPU = 1.21;  // g/cm^3
    private static final double DENSITY_PETG = 1.27;  // g/cm^3

    public static double calculateLength(double weight, double diameter, String type) {
        double radius = diameter / 2;
        double density = switch (type) {
            case "PLA" -> DENSITY_PLA;
            case "ABS" -> DENSITY_ABS;
            case "TPU" -> DENSITY_TPU;
            case "PETG" -> DENSITY_PETG;
            default -> throw new IllegalArgumentException("Unknown filament type: " + type);
        };
        return (weight / (density * PI * Math.pow(radius / 10, 2))) / 100;  // converting cm to meters
    }

    public static double calculateCostPerMeter(double cost, double length) {
        return cost / length;
    }
}