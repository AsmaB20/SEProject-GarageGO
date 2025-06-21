package project;

public class DynamicDemandStrategy implements PricingStrategy {

	@Override
	public double calculatePrice(Service service, GarageProfile garage) {
		double base = service.getBasePrice();
        double demandFactor = garage.getCurrentDemandLevel(); // 1.0 - 1.5
        return base * demandFactor;
	}

}
