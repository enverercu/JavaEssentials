package Basic.Aautil;

public class Car {
	 
    public enum Brand {
        MERCEDES, BMW, TESLA;
    }
 
    private double stored_fuel = 0;
 
    private boolean unlocked = false;
 
    public Brand brand;
    public int fuelCapacity;
 
    public Car(final Brand brand, final int fuelCapacity) {
        this.brand=brand;
        this.fuelCapacity=fuelCapacity;
    }
 
    public void setUnlocked(final boolean unlocked) {
        this.unlocked = unlocked;
    }
 
    /**
     * You need to unlock the car before you can drive.
     */
    public void unlock() {
        this.unlocked = true;
    }
 
    public double getStored_fuel() {
        return stored_fuel;
    }
 
    public boolean is_unlocked() {
        return unlocked;
    }
 
    private boolean driving;
 
    /**
     * When you drive you'll reduce the stored fuel depending on your speed and duration (how you drive with given speed).
     *
     * @param speed    in km/h
     * @param duration in h
     */
    public void drive(final double speed, final double duration)
    {
        if (is_unlocked()) {
            driving = true;
            stored_fuel -= speed * duration * 0.01;
        }
    }
 
    public boolean isDriving()
    {
        return driving;
    }
 
}
