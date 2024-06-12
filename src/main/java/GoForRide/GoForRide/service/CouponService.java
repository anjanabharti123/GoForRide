package GoForRide.GoForRide.service;


import GoForRide.GoForRide.model.Coupon;
import GoForRide.GoForRide.repository.CouponRepository;
import GoForRide.GoForRide.transformer.CouponTransformer;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public String addCoupon(String couponCode, int discount) {
        Coupon coupon = CouponTransformer.prepareCoupon(couponCode,discount);
        couponRepository.save(coupon);
        return "Coupon added successfully!!";
    }
}
