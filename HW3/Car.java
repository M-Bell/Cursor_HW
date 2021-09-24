public class Car {
    private boolean engineOn = false;
    private double currentSpeed = 0;

    public void start() {
        engineOn = true;
        System.out.println("Engine started");
    }

    public void stop() {
        engineOn = false;
        currentSpeed = 0;
        System.out.println("Engine stopped");
    }

    public void accelerate(int value) {
        if(!engineOn){
            System.out.println("You cannot accelerate!!! Engine off");
            return;
        }
        System.out.println("You accelerated from " + currentSpeed + " to " + (currentSpeed + value) + " mph;");
        currentSpeed += value;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void drive(){
        if(!engineOn){
            System.out.println("Your engine is off, you cannot drive!");
            return;
        }
        accelerate(5);

    }

    @Override
    public String toString() {
        return "Car engine started: " + engineOn + ";\nCurrent speed: " + currentSpeed + ";\n";
    }
}

