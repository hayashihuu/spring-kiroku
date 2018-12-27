package com.syun.resource.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-27 15:15
 */
@FeignClient(value = "iam")
@RequestMapping("/iam/user")
public interface IamFeignService {

    @PostMapping("/getPermission/username")
    List<String> getUserPermissionByUsername(@RequestParam("username") String username);


}
