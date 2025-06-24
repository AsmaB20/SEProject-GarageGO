package practice;

public class FixedPriceStrategy implements PricingStrategy {

	@Override
	public double calculatePrice(Service service, GarageProfile garage) {
		return service.getBasePrice();
	}
	
	

}
