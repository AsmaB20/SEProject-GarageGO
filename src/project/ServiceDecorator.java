package project;

public abstract class ServiceDecorator extends Service{
	protected Service decoratedService;

    public ServiceDecorator(Service decoratedService) {
        super(decoratedService.getName(), decoratedService.getBasePrice(), decoratedService.getDurationInMinutes());
        this.decoratedService = decoratedService;
    }

    @Override
    public abstract double getBasePrice();

    @Override
    public abstract int getDurationInMinutes();

    @Override
    public String toString() {
        return decoratedService.toString();
    }
}
