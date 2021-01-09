import java.util.Random;

public class Car implements Runnable {
    public String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        //khoi tao diem km 0
        int runDistance = 0;
        //khoi tao thoi gian bat dau
        long startTime = System.currentTimeMillis();
        while (runDistance < Main.DISTANCE) {
            try {
                int speed = (new Random().nextInt(20));
                runDistance += speed;
                String log = "|";
                int percentTravel = (runDistance * 100) / Main.DISTANCE;
                for (int i = 0; i < Main.DISTANCE; i += Main.STEP) {
                    if (percentTravel >= i + Main.STEP) {
                        log += "=";
                    } else if (percentTravel >= i && percentTravel < i + Main.STEP) {
                        log += "o";
                    } else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("Car " + this.name + ": " + log + Math.min(Main.DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car " +this.name + " Finish in " + (endTime-startTime)/1000+"s");
    }
}
