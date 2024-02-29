class Garage {
  public static void main(String[] args) {
    // Construct cars
    Car blueCar = new Car("Acura", "2017", 2500);
    Car whiteCar = new Car("Volvo", "2016", 3000);

    // Info
    System.out.println("--Car One--");
    blueCar.displayInfo(blueCar.brand, blueCar.model, blueCar.fuelLevel);
    System.out.println("--Car Two--");
    whiteCar.displayInfo(whiteCar.brand, whiteCar.model, whiteCar.fuelLevel);

    // Drive
    System.out.println(blueCar.drive(blueCar.fuelLevel, blueCar.brand, blueCar.model));
    System.out.println(whiteCar.drive(whiteCar.fuelLevel, whiteCar.brand, whiteCar.model));

    // Refuel
    System.out.println(blueCar.refuel(blueCar.fuelLevel, blueCar.brand, blueCar.model));
    System.out.println(whiteCar.refuel(whiteCar.fuelLevel, whiteCar.brand, whiteCar.model));

    // Info
    System.out.println("--Car One--");
    blueCar.displayInfo(blueCar.brand, blueCar.model, blueCar.fuelLevel);
    System.out.println("--Car Two--");
    whiteCar.displayInfo(whiteCar.brand, whiteCar.model, whiteCar.fuelLevel);

  }
}

class Car {
  // Initialize variables
  String brand;
  String model;
  double fuelLevel;

  // Constructor method
  public Car(String brand, String model, double fuelLevel) {
    this.brand = brand;
    this.model = model;
    this.fuelLevel = fuelLevel;
  }

  // Drive method
  public double drive(double fuelLevel, String brand, String model) {
    System.out.println("\nDriving " + brand + model + "...");
    fuelLevel -= 1000;
    System.out.println("Trip made! Fuel level has lowered to: " + fuelLevel);
    return fuelLevel;
  }

  // Refuel method
  public double refuel(double fuelLevel, String brand, String model) {
    System.out.println("\nRefueling " + brand + model + "...");
    fuelLevel += 1500;
    System.out.println("Refueled! New fuel level: " + fuelLevel);
    return fuelLevel;
  }

  // displayInfo method
  public void displayInfo(String brand, String model, double speed) {
    System.out.println("Brand: " + brand + "\nModel: " + model + "\nFuel Level: " + fuelLevel);
  }
  
  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}
