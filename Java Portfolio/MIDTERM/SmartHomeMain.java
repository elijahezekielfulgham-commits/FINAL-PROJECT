public class SmartHomeMain {
    public static void main(String[] args) {
        LightBulb bulb1 = new LightBulb("Living Room Light", " Living Room", 75, " Cool White");
        Thermostat thermostat1 = new Thermostat(" Main Thermostat", "Hallway", 25.5, "Cooling");
        Thermostat thermostat2 = new Thermostat("Bedroom Thermostat ", "Bedroom", 27.0, "Heating");
        Device[] devices = { bulb1, thermostat1, thermostat2  };

        for (Device device : devices) {
            System.out.println("=========================");
            device.displayInfo();
        }
        System.out.println("=========================");
        Device.showDeviceCount();
        SmartHomeController controller = new SmartHomeController(devices);
        controller.turnAllOn();
        controller.turnAllOff();
    }
}
class Device {
    protected String deviceName;
    protected String status;
    protected String location;

    static int deviceCount = 0;


    Device() {
        this.deviceName = "Unknown Device";
        this.status = " OFF";
        this.location = "Unknown Location";
        deviceCount++;
    }
    
    Device(String deviceName, String status, String location) {
        this.deviceName = deviceName;
        this.status = status;
        this.location = location;
        deviceCount++;
    }
    void turnOn() {
        status = "ON";
        System.out.println(deviceName + " is now ON.");
    }
    void turnOff() {
        status = "OFF";
        System.out.println(deviceName + " is now OFF.");
    }
    void displayInfo() {
        System.out.println("Device Name: " + deviceName);
        System.out.println("Status: " + status);
        System.out.println("Location: " + location);
    }
    static void showDeviceCount() {
        System.out.println("Total Devices Created: " + deviceCount);
    }
}

class LightBulb extends Device {
    private int brightnessLevel;
    private String color;

    LightBulb(String deviceName, String location, int brightnessLevel, String color) {
        super(deviceName, "OFF", location);
        this.brightnessLevel = brightnessLevel;
        this.color = color;
    }
    LightBulb(String deviceName, String location) {
        super(deviceName, "OFF", location);
        this.brightnessLevel = 50;
        this.color = "Warm White";
    }
    void adjustBrightness(int level) {
        if (level >= 0 && level <= 100) {
            this.brightnessLevel = level;
            System.out.println(deviceName + " brightness adjusted to " + level + "%. ");
        } else {
            System.out.println("Invalid brightness level. Please set between 0 and 100.");
        }
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Brightness Level: " + brightnessLevel + "%");
        System.out.println("Color: " + color);
    }
}
class Thermostat extends Device {
    private double temperature;
    private String mode;

    Thermostat(String deviceName, String location, double temperature, String mode) {
        super(deviceName, "OFF", location);
        this.temperature = temperature;
        this.mode = mode;
    }
    void setTemperature(double temp) {
        this.temperature = temp;
        System.out.println(deviceName + " temperature set to" + temp + "°C.");
    }

    void setTemperature(double temp, String mode) {
        this.temperature = temp;
        this.mode = mode;
        System.out.println(deviceName + " temperature set to " + temp + "°C in " + mode + " mode.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Mode: " + mode);
    }
}

class SmartHomeController {
    private Device[] devices;
    SmartHomeController(Device[] devices) {
        this.devices = devices;
    }
    void turnAllOn() {
        System.out.println("\nTurning all devices ON...");
        for (Device d : devices) {
            d.turnOn();
        }
    }
    void turnAllOff() {
        System.out.println("\nTurning all devices OFF...");
        for (Device d : devices) {
            d.turnOff();
        }
    }
}
