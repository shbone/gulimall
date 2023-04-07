package com.example.gulimall.member.feign;

import com.example.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimall-coupon")
public interface couponfeign {
    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();

}
