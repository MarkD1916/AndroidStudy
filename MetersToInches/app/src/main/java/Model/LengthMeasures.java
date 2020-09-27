package Model;

public class LengthMeasures {
    private int id;
    private String lengthName;
    private double lengthCoefficientMetr;

    public LengthMeasures() {

    }

    public LengthMeasures(int id, String lengthName, double lengthCoefficientMetr) {
        this.id = id;
        this.lengthName = lengthName;
        this.lengthCoefficientMetr = lengthCoefficientMetr;
    }

    public LengthMeasures(String lengthName, double lengthCoefficientMetr) {
        this.lengthName = lengthName;
        this.lengthCoefficientMetr = lengthCoefficientMetr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLengthName() {
        return lengthName;
    }

    public void setLengthName(String lengthName) {
        this.lengthName = lengthName;
    }

    public double getLengthCoefficient() {
        return lengthCoefficientMetr;
    }

    public void setLengthCoefficient(double lengthCoefficient) {
        this.lengthCoefficientMetr = lengthCoefficient;
    }
}
