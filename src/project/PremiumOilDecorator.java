package project;

public class PremiumOilDecorator extends ServiceDecorator{
	public PremiumOilDecorator(Service decoratedService) {
        super(decoratedService);
    }

    @Override
    public double getBasePrice() {
        return decoratedService.getBasePrice() + 20.0; // Adds extra price
    }

    @Override
    public int getDurationInMinutes() {
        return decoratedService.getDurationInMinutes();
    }

    @Override
    public String toString() {
        return decoratedService.getName() + " + Premium Oil (QAR +20)";
    }
}
