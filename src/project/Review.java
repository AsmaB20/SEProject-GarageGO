package project;

//page to create the review

public class Review {
	private VehicleOwner reviewer;
    private GarageProfile garage;
    private String comment;
    private int rating; // From 1 to 5

    public Review(VehicleOwner reviewer, GarageProfile garage, String comment, int rating) {
        this.reviewer = reviewer;
        this.garage = garage;
        this.comment = comment;
        this.rating = Math.max(1, Math.min(5, rating)); // Ensures 1-5 range
    }

    public VehicleOwner getReviewer() {
        return reviewer;
    }

    public GarageProfile getGarage() {
        return garage;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Review by " + reviewer.getUsername() + " (" + rating + " stars): " + comment;
    }
}
