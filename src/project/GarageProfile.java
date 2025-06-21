package project;

public class GarageProfile {
	private PricingStrategy pricingStrategy;
    private double currentDemandLevel = 1.0; // Default level


    public void setPricingStrategy(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
    }

	public double getCurrentDemandLevel() {
		return currentDemandLevel;
	}

	public void setCurrentDemandLevel(double currentDemandLevel) {
		this.currentDemandLevel = currentDemandLevel;
	}

	public PricingStrategy getPricingStrategy() {
		return pricingStrategy;
	}
	
}
