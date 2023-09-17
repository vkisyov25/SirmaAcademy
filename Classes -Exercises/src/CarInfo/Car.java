package CarInfo;

public class Car {
    private String Brand;
    private String Model;
    private int Horsepower;

    public Car(String brand, String model, int horsepower) {
        Brand = brand;
        Model = model;
        Horsepower = horsepower;
    }

    public Car(String brand, String model) {
        Brand = brand;
        Model = model;
        Horsepower = -1;
    }

    public Car(String brand) {
        Brand = brand;
        Model = "unknown";
        Horsepower = -1;
    }


    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public int getHorsepower() {
        return Horsepower;
    }

    public void setHorsepower(int horsepower) {
        Horsepower = horsepower;
    }


    public String carInfo() {
        return "The car is: " +getBrand()+" "+getModel()+" - "+getHorsepower()+"HP.";
    }

}



