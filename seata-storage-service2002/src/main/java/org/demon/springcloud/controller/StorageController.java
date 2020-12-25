package org.demon.springcloud.controller;

import org.demon.springcloud.domain.CommonResult;
import org.demon.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author demon
 * @create 2020-12-24 14:29
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count")Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功", storageService.getByProductId(productId));
    }
}
