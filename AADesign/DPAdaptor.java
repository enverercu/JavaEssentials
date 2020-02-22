package Basic.AADesign;

//An Adapter wraps an existing class with a new interface so that it becomes compatible with the client’s interface
//The main motive behind using this pattern is to convert an existing interface into another interface that the client expects

interface Speeed{
	// returns speed in MPH 
    double getSpeed();
}
//concrete class
class BugattiVeyron implements Speeed {
	  
    @Override
    public double getSpeed() {
        return 268; //MPH
    }
}
interface SpeedAdapter {
    // returns speed in KM/H 
    double getSpeed();
}

class SpeedAdapterImpl implements SpeedAdapter{
	private Speeed speed;
	public SpeedAdapterImpl(Speeed speed){
		this.speed = speed;
	}
	@Override
    public double getSpeed() {
        return convertMPHtoKMPH(speed.getSpeed());
    }
	private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}
public class DPAdaptor{
	public static void main(String args[]){
		Speeed bugattiVeyron = new BugattiVeyron();
		SpeedAdapter bugattiVeyronAdapter = new SpeedAdapterImpl(bugattiVeyron);
		System.out.println(bugattiVeyronAdapter.getSpeed());
		
    }
}
