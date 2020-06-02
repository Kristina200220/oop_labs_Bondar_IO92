package lab7;

public class Car implements Comparable<Car>{
    private int fuelConsumption;
    private int speed;
    private int price;
    private String companyAndModel;

    public Car(int fuelConsumption, int speed, int price, String companyAndModel) throws WrongFuelConsumptionException,
            WrongNameException, WrongPriceException, WrongSpeedException {
                if (fuelConsumption < 0) {
                    throw new WrongFuelConsumptionException();
                } else if (speed < 0) {
                    throw new WrongSpeedException();
                } else if (price < 0) {
                    throw new WrongPriceException();
                } else if (companyAndModel.equals("") || companyAndModel.contains("  ")) {
                    throw new WrongNameException();
                } else {
                    this.fuelConsumption = fuelConsumption;
                    this.speed = speed;
                    this.price = price;
                    this.companyAndModel = companyAndModel;
                }
    }

    public int getPrice() {
        return price;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getSpeed() {
        return speed;
    }

    public String getCompanyAndModel() {
        return companyAndModel;
    }

    @Override
    public String toString() {
        return "Car: " + companyAndModel + ", price: " + price + "$, max speed: " + speed + "km/h, fuel consumption: "
                + fuelConsumption;
    }

    @Override
    public boolean equals(Object obj) {
        return  obj instanceof Car &&
                fuelConsumption == ((Car) obj).getFuelConsumption() &&
                speed == ((Car) obj).getSpeed() &&
                price == ((Car) obj).getPrice() &&
                companyAndModel.equals(((Car) obj).getCompanyAndModel());
    }

    public int compareTo(Car t) {
        return Integer.compare(fuelConsumption, t.getFuelConsumption());
    }

}
