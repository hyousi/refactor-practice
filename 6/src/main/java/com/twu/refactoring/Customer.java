package com.twu.refactoring;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Rental> rentalList = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentalList.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String title = String.format("Rental Record for %s\n", getName());
        StringBuilder detail = new StringBuilder();
        for (Rental rental : rentalList) {
            double amount = calcAmount(rental);
            totalAmount += amount;

            Movie movie = rental.getMovie();
            frequentRenterPoints += 1;
            if (movie.getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1) {
                frequentRenterPoints += 1;
            }
            detail.append(String.format("\t%s\t%.1f\n", movie.getTitle(), amount));
        }

        String footer = String
            .format("Amount owed is %.1f\nYou earned %d frequent renter points", totalAmount,
                frequentRenterPoints);

        return (title + detail.toString() + footer);
    }

    private double calcAmount(Rental rental) {
        double amount = 0;

        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (rental.getDaysRented() > 2) {
                    amount += (rental.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                amount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                amount += 1.5;
                if (rental.getDaysRented() > 3) {
                    amount += (rental.getDaysRented() - 3) * 1.5;
                }
                break;
        }

        return amount;
    }
}
