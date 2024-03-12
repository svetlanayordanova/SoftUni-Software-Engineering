package working_with_abstraction.HotelReservation_04;

import working_with_abstraction.HotelReservation_04.Discount;

public class PriceCalculator {
    public static double calculatePrice(double pricePerDay,
                                        int numberOfDays,
                                        Season season,
                                        Discount discount) {
        int multiplier = season.getValue();
        double discountMultiplier = discount.getValue() / 100.0;
        double priceBeforeDiscount = numberOfDays * pricePerDay * multiplier;
        double discountedAmount = priceBeforeDiscount * discountMultiplier;
        return priceBeforeDiscount - discountedAmount;
    }
}