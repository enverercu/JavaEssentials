package Basic.AADesign;

//Here we have made Currency as interface and all currency would be concrete implementation of Currency interface. 
//Factory Class will create Currency based upon country and return concrete implementation which will be stored in interface type

interface Currrency{
	public String getSymbol();
}

class USDollar implements Currrency{
	
	@Override
	public String getSymbol(){
		return "USD";
	}
}

class EuroMoney implements Currrency{
	
	@Override
	public String getSymbol(){
		return "EUR";
	}
}

class CurrencyFactory{
	//MUST BE STATIC
	public static Currrency createCurrency(String country){ 
		
		if (country.equalsIgnoreCase("USA")){
			return new USDollar();
		}
		else if (country.equalsIgnoreCase("Europa"))
		{
			return new EuroMoney();
		}
		
		return null;
	}
}

public class DPFactory {

	public static void main(String[] args) {
		
		Currrency c = CurrencyFactory.createCurrency("USA"); //WITHOUT NEW OPERATOR
		
		System.out.println(c.getSymbol());

	}

}
