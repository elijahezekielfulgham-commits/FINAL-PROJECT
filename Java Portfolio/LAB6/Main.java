public class Main {
    static class SmartDevice {
        private boolean poweredOn;
        public SmartDevice() {
            this.poweredOn = false;
        }
        public void turnOn() {
            poweredOn = true;
            System.out.println(getClass().getSimpleName() + " is now ON.");
            showStatus();
        }
        public void turnOff() {
            poweredOn = false;
            System.out.println(getClass().getSimpleName() + " is now OFF.");
        }
        public boolean isPoweredOn() {
            return poweredOn;
        }
        public void showStatus() {
            System.out.println(getClass().getSimpleName() + " status: Powered On = " + poweredOn);
        }
    }
    static class AirConditioner extends SmartDevice {
        private int fanSpeed;
        private int temperature;

        public AirConditioner(int fanSpeed, int temperature) {
            this.fanSpeed = fanSpeed;
            this.temperature = temperature;
        }
        public void setFanSpeed(int fanSpeed) {
            this.fanSpeed = fanSpeed;
            System.out.println("Fan speed set to " + fanSpeed);
            showStatus();
        }
        public void setTemperature(int temperature) {
            this.temperature = temperature;
            System.out.println("Temperature set to " + temperature);
            showStatus();
        }
        @Override
        public void showStatus() {
            if (isPoweredOn()) {
                System.out.println("AirConditioner Status → Fan Speed: " + fanSpeed + ", Temperature: " + temperature);
            } else {
                System.out.println("AirConditioner is OFF.");
            }
        }
    }

    static class LampShade extends SmartDevice {
        private int brightness;
        private String lightColor;

        public LampShade(int brightness, String lightColor) {
            this.brightness = brightness;
            this.lightColor = lightColor;
        }

        public LampShade(LampShade copy) {
            this.brightness = copy.brightness;
            this.lightColor = copy.lightColor;
        }

        public void setBrightness(int brightness) {
            this.brightness = brightness;
            System.out.println("Brightness set to " + brightness);
            showStatus();
        }

        public void setLightColor(String lightColor) {
            this.lightColor = lightColor;
            System.out.println("Light color set to " + lightColor);
            showStatus();
        }

        @Override
        public void showStatus() {
            if (isPoweredOn()) {
                System.out.println("Lamp Shade Status → Brightness: " + brightness + "%, Color: " + lightColor);
            } else {
                System.out.println("Lamp Shade is OFF.");
            }
        }
    }

    static class Television extends SmartDevice {
        private int channel;
        private int volume;

        public Television(int channel, int volume) {
            this.channel = channel;
            this.volume = volume;
        }

        public void setChannel(int channel) {
            this.channel = channel;
            System.out.println("Channel set to " + channel);
            showStatus();
        }

        public void setVolume(int volume) {
            this.volume = volume;
            System.out.println("Volume set to " + volume + "%");
            showStatus();
        }

        @Override
        public void showStatus() {
            if (isPoweredOn()) {
                System.out.println("Television Status → Channel: " + channel + ", Volume: " + volume + "%");
            } else {
                System.out.println("Television is OFF.");
            }
        }
    }

    static class MicrowaveOven extends SmartDevice {
        private int timer;
        private int temperature;

        public MicrowaveOven(int timer, int temperature) {
            this.timer = timer;
            this.temperature = temperature;
        }

        public void setTimer(int timer) {
            this.timer = timer;
            System.out.println("Timer set to " + timer + " seconds");
            showStatus();
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
            System.out.println("Temperature set to " + temperature);
            showStatus();
        }

        @Override
        public void showStatus() {
            if (isPoweredOn()) {
                System.out.println("Microwave Status → Timer: " + timer + " sec, Temperature: " + temperature);
            } else {
                System.out.println("Microwave is OFF.");
            }
        }
    }

    public static void toggleDevices(SmartDevice[] devices, boolean turnOn) {
        for (SmartDevice d : devices) {
            if (turnOn) d.turnOn();
            else d.turnOff();
        }
    }

    public static void countPoweredDevices(SmartDevice[] devices) {
        int count = 0;
        for (SmartDevice d : devices) {
            if (d.isPoweredOn()) count++;
        }
        System.out.println("Number of devices currently powered ON: " + count);
    }

    public static void main(String[] args) {

        AirConditioner ac = new AirConditioner(3, 24);

        LampShade lamp1 = new LampShade(100, "Yellow Light");
        LampShade lamp2 = new LampShade(lamp1);
        Television tv = new Television(1, 10);
        MicrowaveOven microwave = new MicrowaveOven(0, 0);
        SmartDevice[] devices = { ac, lamp1, lamp2, tv, microwave };

        System.out.println("\n--- Turning all devices ON ---");
        toggleDevices(devices, true);
        System.out.println("\n--- Checking Powered Devices ---");
        countPoweredDevices(devices);
        System.out.println("\n--- Turning all devices OFF ---");
        toggleDevices(devices, false);
        System.out.println("\n--- Checking Powered Devices ---");
        countPoweredDevices(devices);
    }
}
