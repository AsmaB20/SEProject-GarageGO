package practice;

import java.util.ArrayList;

public class ReviewService {
	/**
     * Adds a review to the given garage
     */
    public static void addReview(GarageProfile garage, Review review) {
        garage.getReviews().add(review);
    }

    /**
     * Shows all reviews for a garage
     */
    public static void showReviews(GarageProfile garage) {
    	System.out.println("");
        ArrayList<Review> reviews = garage.getReviews();
        if (reviews.isEmpty()) {
            System.out.println("No reviews available for " + garage.getName());
        } else {
            System.out.println("Reviews for " + garage.getName() + ":\n");
            for (Review review : reviews) {
                System.out.println("- " + review);
            }
        }
    }
}
