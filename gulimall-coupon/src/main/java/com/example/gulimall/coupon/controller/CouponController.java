package com.example.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gulimall.coupon.entity.CouponEntity;
import com.example.gulimall.coupon.service.CouponService;
import com.example.common.utils.PageUtils;
import com.example.common.utils.R;



/**
 * 优惠券信息
 *
 * @author sunhb
 * @email sunlightcs@gmail.com
 * @date 2023-04-05 01:23:24
 */

/**
 * 配置中心配置过程
 * 1. common导入nacos-discovery-maven依赖
 * 2. 配置bootstrap.properties    spring.application.name=gulimall-coupon
 *                              spring.cloud.nacos.config.server-addr=47.113.146.180:8848
 * 3. 本地或者nacos配置中心配置，DataID默认规则，模块名+properties
 * 4. 动态配置@RefreshScope，用@Value{$""}配置
 *
 * 细节
 * 1. 命名空间：配置隔离 默认public空间
 *      1.1 dev/test/prod 在application.properties中spring.cloud.nacos.config.namespace=2
 *      1.2 对每一个微服务创建命名空间
 * 2. 配置集
 * 3. 配置集ID
 * 4. 配置分组
 *  默认：DEFAULT_GROUP
 *  bootstrap.properties 里配置：spring.cloud.nacos.config.group=DEFAULT_GROUP
 *  1212 /12306/ 0406
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;
    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private String age;
    @RequestMapping("/member/list")
    public R membercoupons(){
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100减50");
        return R.ok().put("coupons",Arrays.asList(couponEntity));
    }
    @RequestMapping("/test")
    public R testnacosdiscovery(){
        return R.ok().put("name",name).put("age",age);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
