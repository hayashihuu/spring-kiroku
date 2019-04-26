package com.syun.auth.feign;

import com.syun.auth.domain.dto.IamUserDTO;
import com.syun.auth.model.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

/**
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-22 22:26
 */
@FeignClient(value = "iam")
@RequestMapping("/iam/user")
public interface IamFeignService {

    @GetMapping("/getInfoByUsername/{username}")
    ResponseEntity<IamUserDTO> getUserByUsername(@PathVariable("username") @NotNull String username);

}
