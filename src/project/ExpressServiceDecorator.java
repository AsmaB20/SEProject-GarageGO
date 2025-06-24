package project;

public class ExpressServiceDecorator extends ServiceDecorator{
	public ExpressServiceDecorator(Service decoratedService) {
        super(decoratedService);
    }

    @Override
    public double getBasePrice() {
        return decoratedService.getBasePrice();
    }

    @Override
    public int getDurationInMinutes() {
        return decoratedService.getDurationInMinutes() - 10; // Saves 10 mins
    }

    @Override
    public String toString() {
        return decoratedService.getName() + " + Express Service (-10 mins)";
    }
}
