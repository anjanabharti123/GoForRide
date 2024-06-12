package GoForRide.GoForRide.transformer;


import GoForRide.GoForRide.model.Coupon;

public class CouponTransformer {

    public static Coupon prepareCoupon(String couponCode, int discount) {
        return Coupon.builder()
                .couponCode(couponCode)
                .percentageDiscount(discount)
                .build();
    }
}
