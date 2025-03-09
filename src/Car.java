public class Car {
    private String reg;
    private String make;
    private String model;
    private int year;
    private int mileage;

    public Car(String reg, String make, String model, int year, int mileage) {
        this.reg = reg;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public String getReg() {
        return reg;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }
}
