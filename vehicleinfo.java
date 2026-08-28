abstract class vehicle {
    String vehicleNumber;
    String brand;
    abstract void startEngine();

    final void showVehicleIdentity() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
    }
}

class car extends vehicle {
    
    void startEngine() {
        System.out.println("Car is started");
    }
}

class bike extends vehicle {
    
    void startEngine() {
        System.out.println("Bike is started");
    }
}

class vehicleinfo {
    public static void main(String[] args) {
        bike b1 = new bike();
        b1.vehicleNumber = "KA823879128";
        b1.brand = "Goodbrand";
        b1.showVehicleIdentity();
        b1.startEngine();
        
    }
}
