package Model;

public class LengthMeasures {
    private int id;
    private String lengthName;
    private int lengthCoefficient;

    public LengthMeasures() {

    }

    public LengthMeasures(int id, String lengthName, int lengthCoefficient) {
        this.id = id;
        this.lengthName = lengthName;
        this.lengthCoefficient = lengthCoefficient;
    }

    public LengthMeasures(String lengthName, int lengthCoefficient) {
        this.lengthName = lengthName;
        this.lengthCoefficient = lengthCoefficient;
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

    public int getLengthCoefficient() {
        return lengthCoefficient;
    }

    public void setLengthCoefficient(int lengthCoefficient) {
        this.lengthCoefficient = lengthCoefficient;
    }
}
