import java.util.*;
class Lights{
    public String colorType;
    public String lightType;
    List<String> colors = new ArrayList<>();
    List<String> lights = new ArrayList<>();
    Lights(){

        lights.add("Halogen Lights");
        lights.add("LED ");
        lights.add("Xenon/HID");
        lights.add("Laser Headlights");


        colors.add("1 - Blue");
        colors.add("2 - Red");
        colors.add("3 - Green");
        colors.add("4 - Yellow");
        colors.add("5 - White");
    }

    public String getLightsType(int choice) {
        if (choice - 1 >= 0 && choice - 1 < lights.size()) {
            lightType = lights.get(choice - 1);
            return "ColorType: " + lightType;
        } else {
            return "Invalid choice";
        }
    }
    public String getColorType(int choice){
        if (choice - 1 >= 0 && choice - 1 < colors.size()) {
            colorType = colors.get(choice - 1);
            return "ColorType: " + colorType;
        } else {
            return "Invalid choice";
        }
    }

    public String getLight() {
        return lightType;
    }

    public List<String> getLights() {
        return lights;
    }

    public List<String> getColors() {
        return colors;
    }

    public String getColor() {
        return colorType;
    }
}
class Seat {
    public String seatType;
    final List<String> seats = new ArrayList<>();

    Seat() {
        seats.add("1 - Standard Fabric Seats");
        seats.add("2 - Premium Fabric Seats");
        seats.add("3 - Leather Seats");
        seats.add("4 - Synthetic Leather Seats");
        seats.add("5 - Heated Seats");
        seats.add("6 - Ventilated Seats");
        seats.add("7 - Sport Seats");
    }

    public typeSeat createSeat(int choice) {

        return switch (choice) {
            case 1 -> new StandardSeat("Standard Fabric Seats");
            case 2 -> new PremiumSeat("Premium Fabric Seats");
            case 3 -> new LeatherSeat("Leather Seats");
            case 4 -> new SyntheticSeat("Synthetic Leather Seats");
            case 5 -> new HeatedSeat("Heated Seats");
            case 6 -> new VentilatedSeat("Ventilated Seats");
            case 7 -> new SportSeat("Sport Seats");
            default -> null;
        };
    }

    public void getSeats() {
        for(String seat : seats) {
            System.out.println(seat);
        }
    }

    public String getSeat(int choice) {
        if (choice - 1 >= 0 && choice - 1 < seats.size()) {
            seatType = seats.get(choice - 1);
            return "Seat Type: " + seatType;
        } else {
            return "Invalid choice";
        }
    }

    public String getSeatType() {
        return seatType;
    }
}


interface typeSeat {
    String getType();
}

class StandardSeat implements typeSeat {
    private String type;

    StandardSeat(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}

class PremiumSeat implements typeSeat {
    private String type;

    PremiumSeat(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}

class LeatherSeat implements typeSeat {
    private String type;

    LeatherSeat(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}

class SyntheticSeat implements typeSeat {
    private String type;

    SyntheticSeat(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class HeatedSeat implements typeSeat {
    private String type;

    HeatedSeat(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}

class VentilatedSeat implements typeSeat {
    private String type;

    VentilatedSeat(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}

class SportSeat implements typeSeat {
    private String type;

    SportSeat(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}

abstract class ForEngine {
    abstract void provideOptions();
    abstract String finalizeChoice(int index);
}

class Engine {
    private ForEngine engineType;
    String engineChoice;
    public void setEngineType(ForEngine engineType) {
        this.engineType = engineType;
    }

    public String finalizeEngineChoice(int index) {
        engineChoice = engineType.finalizeChoice(index);
        return engineType.finalizeChoice(index);
    }

    public String getEngineChoice() {
        return engineChoice;
    }

    public void displayOptions() {
        engineType.provideOptions();
    }
}

class ElectricEngine extends ForEngine {
    private final List<String> electricOptions = new ArrayList<>();
    public String engineChoice;
    ElectricEngine() {
        electricOptions.add("Tesla Model 3 Standard Range Motor");
        electricOptions.add("Nissan Leaf Electric Motor (EM57)");
        electricOptions.add("Chevrolet Bolt EV Motor");
        electricOptions.add("Tesla Model S Dual-Motor Long Range");
        electricOptions.add("Audi e-tron Quattro Motors");
        electricOptions.add("Rivian R1T Quad-Motor System");
    }

    @Override
    public void provideOptions() {
        System.out.println("Available Electric Engines:");
        for (int i = 0; i < electricOptions.size(); i++) {
            System.out.println((i + 1) + " - " + electricOptions.get(i));
        }
    }

    @Override
    public String finalizeChoice(int index) {
        if (index >= 0 && index < electricOptions.size()) {
            return "Electric engine " + electricOptions.get(index);
        }
        else {
            return "Invalid for electric engine";
        }
    }



}


class ManualEngine extends ForEngine {
    private final List<String> manualOptions = new ArrayList<>();

    ManualEngine() {
        manualOptions.add("Mazda SkyActiv-G 2.0L Inline-4");
        manualOptions.add("Toyota 2TR-FE 2.7L Inline-4");
        manualOptions.add("Ford EcoBoost 2.3L Inline-4");
        manualOptions.add("Cummins 6.7L Turbo Diesel");
        manualOptions.add("Volkswagen TDI 2.0L");
    }

    @Override
    public void provideOptions() {
        System.out.println("Available Manual Engines:");
        for (int i = 0; i < manualOptions.size(); i++) {
            System.out.println((i + 1) + " - " + manualOptions.get(i));
        }
    }

    @Override
    public String finalizeChoice(int index) {
        if (index >= 0 && index < manualOptions.size()) {
            return "Manual Engine Chosen: " + manualOptions.get(index);
        } else {
            return "Invalid choice for Manual Engine";
        }
    }
}

class AutomaticEngine extends ForEngine {
    private final List<String> automaticOptions = new ArrayList<>();

    AutomaticEngine() {
        automaticOptions.add("Toyota 2GR-FE V6");
        automaticOptions.add("Honda Earth Dreams 1.5L Turbo");
        automaticOptions.add("Subaru Boxer Engine 2.5L H4");
        automaticOptions.add("Nissan HR16DE 1.6L Inline-4");
        automaticOptions.add("Volkswagen TSI 1.4L");
        automaticOptions.add("Audi TFSI 2.0L Inline-4");
    }

    @Override
    public void provideOptions() {
        System.out.println("Available Automatic Engines:");
        for (int i = 0; i < automaticOptions.size(); i++) {
            System.out.println((i + 1) + " - " + automaticOptions.get(i));
        }
    }

    @Override
    public String finalizeChoice(int index) {
        if (index >= 0 && index < automaticOptions.size()) {
            return "Automatic Engine Chosen: " + automaticOptions.get(index);
        } else {
            return "Invalid choice for Automatic Engine.";
        }
    }
}

class Car{
    String carType;
    public Engine engine;
    public Seat seat;
    List<String> carL = new ArrayList<>();
    double baseCost;


    Car(){
        carL.add("1 - Electric car");
        carL.add("2 - Manual car");
        carL.add("3 - Automatic car");
    }
    Car(Engine engine, Seat seat, String carType) {

        this.engine = engine;
        this.seat = seat;
        this.carType = carType;
        this.baseCost = 10000;

    }

    public void displayOptions() {
        for(String option : carL) {
            System.out.println(option);
        }
    }
    public String finalizeOptions(int choice) {
        if (choice - 1 >= 0 && choice - 1 < carL.size()) {
            carType = carL.get(choice - 1);
            return "Car Type: " + carType;
        } else {
            return "Invalid choice";
        }
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public String getCarType() {
        return carType;
    }

    public Engine getEngine(){
        return engine;
    }
    public Seat getSeat(){
        return seat;
    }



    public String toString(){
        return  getCarType() + " / "+ " Engine Type: " + engine.getEngineChoice() + "Seat Type: " + seat.getSeatType();
    }
}

interface Mediator {
    void setEngine(int engineType, int choice);
    void setSeat(int choice);
    void setLights(int lightChoice, int colorChoice);
    void setCarColor(String color);
    double calculateTotalCost();
    String getConfiguration();
}

class VehicleMediator implements Mediator {
    private Engine engine;
    private Seat seat;
    private Lights lights;
    private String carColor;
    private CostCalculator costCalculator;

    public VehicleMediator() {
        this.engine = new Engine();
        this.seat = new Seat();
        this.lights = new Lights();
        this.costCalculator = new CostCalculator();
        this.carColor = "";
    }

    @Override
    public void setEngine(int engineType, int choice) {
        switch (engineType) {
            case 1 -> {
                engine.setEngineType(new ElectricEngine());
                System.out.println(engine.finalizeEngineChoice(choice - 1));
            }
            case 2 -> {
                engine.setEngineType(new ManualEngine());
                System.out.println(engine.finalizeEngineChoice(choice - 1));
            }
            case 3 -> {
                engine.setEngineType(new AutomaticEngine());
                System.out.println(engine.finalizeEngineChoice(choice - 1));
            }
            default -> System.out.println("Invalid engine type.");
        }
    }

    @Override
    public void setSeat(int choice) {
        System.out.println(seat.getSeat(choice));
    }

    @Override
    public void setLights(int lightChoice, int colorChoice) {
        System.out.println(lights.getLightsType(lightChoice));
        System.out.println(lights.getColorType(colorChoice));
    }

    public void setCarColor(String color) {
        this.carColor = color;
    }

    @Override
    public double calculateTotalCost() {
        return costCalculator.calculateTotalCost(engine, seat, lights, carColor);
    }

    @Override
    public String getConfiguration() {
        return "Car Configuration: " +
                "Engine: " + engine.getEngineChoice() +
                ", Seat: " + seat.getSeatType() +
                ", Light: " + lights.getLight() +
                ", Light Color: " + lights.getColor() +
                ", Car Color: " + carColor;
    }
}

interface CarDecorator {
    String getDescription();
}

class BaseCarDecorator implements CarDecorator {
    protected Car car;

    BaseCarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public String getDescription() {
        return car.toString();
    }
}

class RedCarDecorator extends BaseCarDecorator {
    RedCarDecorator(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Red Color";
    }
}

class BlueCarDecorator extends BaseCarDecorator {
    BlueCarDecorator(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Blue Color";
    }
}

class BlackCarDecorator extends BaseCarDecorator {
    BlackCarDecorator(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Black Color";
    }
}

class WhiteCarDecorator extends BaseCarDecorator {
    WhiteCarDecorator(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with White Color";
    }
}

class GreenCarDecorator extends BaseCarDecorator {
    GreenCarDecorator(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Green Color";
    }
}

class CostCalculator {
    private double baseCost;

    CostCalculator() {
        this.baseCost = 5000;
    }

    public double calculateTotalCost(Engine engine, Seat seat, Lights lights, String carColor) {
        double engineCost = calculateEngineCost(engine.getEngineChoice());
        double seatCost = calculateSeatCost(seat.getSeatType());
        double lightCost = calculateLightCost(lights.getLight());
        double lightColorCost = calculateColorCost(lights.getColor());
        double carColorCost = calculateCarColorCost(carColor);
        return baseCost + engineCost + seatCost + lightCost + lightColorCost + carColorCost;
    }

    private double calculateEngineCost(String engineChoice) {
        if (engineChoice.contains("Electric")) {
            return 5000;
        } else if (engineChoice.contains("Manual")) {
            return 3000;
        } else if (engineChoice.contains("Automatic")) {
            return 4000;
        }
        return 0;
    }

    private double calculateSeatCost(String seatType) {
        if (seatType.contains("Premium")) {
            return 1500;
        } else if (seatType.contains("Leather")) {
            return 2000;
        }
        return 500;
    }

    private double calculateLightCost(String lightType) {
        if (lightType.contains("Laser")) {
            return 2000;
        } else if (lightType.contains("LED")) {
            return 1200;
        }
        return 800;
    }

    private double calculateColorCost(String colorType) {
        if (colorType.contains("White")) {
            return 300;
        } else if (colorType.contains("Red")) {
            return 400;
        }
        return 100;
    }

    private double calculateCarColorCost(String carColor) {
        return switch (carColor) {
            case "Red" -> 500;
            case "Blue" -> 300;
            case "Black" -> 400;
            case "White" -> 200;
            case "Green" -> 350;
            default -> 0;
        };
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mediator mediator = new VehicleMediator();

        System.out.println("Choose your car type:");
        System.out.println("1 - Electric Car");
        System.out.println("2 - Manual Car");
        System.out.println("3 - Automatic Car");

        int carType = -1;
        while (carType < 1 || carType > 3) {
            if (scanner.hasNextInt()) {
                carType = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (carType < 1 || carType > 3) {
                System.out.println("Invalid choice. Please choose a valid car type:");
            }
        }

        System.out.println("Choose your engine:");
        switch (carType) {
            case 1 -> System.out.println("1 - Tesla Model 3 Standard Range Motor\n2 - Nissan Leaf Motor\n3 - Chevrolet Bolt EV Motor\n4 - Tesla Model S Dual-Motor\n5 - Audi e-tron Quattro\n6 - Rivian R1T Quad-Motor");
            case 2 -> System.out.println("1 - Mazda SkyActiv-G 2.0L\n2 - Toyota 2TR-FE\n3 - Ford EcoBoost\n4 - Cummins Turbo Diesel\n5 - Volkswagen TDI");
            case 3 -> System.out.println("1 - Toyota 2GR-FE\n2 - Honda Earth Dreams\n3 - Subaru Boxer\n4 - Nissan HR16DE\n5 - Volkswagen TSI\n6 - Audi TFSI");
        }

        int engineChoice = -1;
        while (engineChoice < 1 || (carType == 1 && engineChoice > 6) || (carType == 2 && engineChoice > 5) || (carType == 3 && engineChoice > 6)) {
            if (scanner.hasNextInt()) {
                engineChoice = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (engineChoice < 1 || (carType == 1 && engineChoice > 6) || (carType == 2 && engineChoice > 5) || (carType == 3 && engineChoice > 6)) {
                System.out.println("Invalid choice. Please choose a valid engine:");
            }
        }
        mediator.setEngine(carType, engineChoice);

        System.out.println("Choose your seat type:");
        System.out.println("1 - Standard Fabric Seats\n2 - Premium Fabric Seats\n3 - Leather Seats\n4 - Synthetic Leather Seats\n5 - Heated Seats\n6 - Ventilated Seats\n7 - Sport Seats");

        int seatChoice = -1;
        while (seatChoice < 1 || seatChoice > 7) {
            if (scanner.hasNextInt()) {
                seatChoice = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (seatChoice < 1 || seatChoice > 7) {
                System.out.println("Invalid choice. Please choose a valid seat:");
            }
        }
        mediator.setSeat(seatChoice);

        System.out.println("Choose your light type:");
        System.out.println("1 - Halogen Lights\n2 - LED\n3 - Xenon/HID\n4 - Laser Headlights");

        int lightChoice = -1;
        while (lightChoice < 1 || lightChoice > 4) {
            if (scanner.hasNextInt()) {
                lightChoice = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (lightChoice < 1 || lightChoice > 4) {
                System.out.println("Invalid choice. Please choose a valid light type:");
            }
        }

        System.out.println("Choose your light color:");
        System.out.println("1 - Blue\n2 - Red\n3 - Green\n4 - Yellow\n5 - White");

        int colorChoice = -1;
        while (colorChoice < 1 || colorChoice > 5) {
            if (scanner.hasNextInt()) {
                colorChoice = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (colorChoice < 1 || colorChoice > 5) {
                System.out.println("Invalid choice. Please choose a valid light color:");
            }
        }
        mediator.setLights(lightChoice, colorChoice);

        System.out.println("Choose your car color:");
        System.out.println("1 - Red\n2 - Blue\n3 - Black\n4 - White\n5 - Green");

        int carColorChoice = -1;
        String carColor = "";
        while (carColorChoice < 1 || carColorChoice > 5) {
            if (scanner.hasNextInt()) {
                carColorChoice = scanner.nextInt();
            } else {
                scanner.next();
            }
            if (carColorChoice < 1 || carColorChoice > 5) {
                System.out.println("Invalid choice. Please choose a valid car color:");
            }
        }
        carColor = switch (carColorChoice) {
            case 1 -> "Red";
            case 2 -> "Blue";
            case 3 -> "Black";
            case 4 -> "White";
            case 5 -> "Green";
            default -> "";
        };
        mediator.setCarColor(carColor);

        System.out.println("Configuration Summary:");
        System.out.println(mediator.getConfiguration());

        double totalCost = mediator.calculateTotalCost();
        System.out.println("Total Cost: $" + totalCost);
    }
}