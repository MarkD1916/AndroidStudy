package Model;

public class WeightMeasures {
    private int id;
    private String weightName;
    private double weigthCoefficientKilogram;



    public WeightMeasures() {
    }

    public WeightMeasures(String weightName, double weigthCoefficientKilogram) {
        this.weightName = weightName;
        this.weigthCoefficientKilogram = weigthCoefficientKilogram;
    }

    public WeightMeasures(int id, String weightName, double weigthCoefficientKilogram) {
        this.id = id;
        this.weightName = weightName;
        this.weigthCoefficientKilogram = weigthCoefficientKilogram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeightName() {
        return weightName;
    }

    public void setWeightName(String weightName) {
        this.weightName = weightName;
    }

    public double getWeigthCoefficientKilogram() {
        return weigthCoefficientKilogram;
    }

    public void setWeigthCoefficientKilogram(double weigthCoefficientKilogram) {
        this.weigthCoefficientKilogram = weigthCoefficientKilogram;
    }
}
