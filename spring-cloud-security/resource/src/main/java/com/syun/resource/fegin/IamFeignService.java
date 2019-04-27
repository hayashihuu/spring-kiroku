package com.syun.resource.fegin;

import com.syun.auth.domain.dto.IamUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

/**
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-27 15:15
 */
@FeignClient(value = "iam")
@RequestMapping("/iam/user")
public interface IamFeignService {


    @GetMapping("/getInfoByUsername/{username}")
    ResponseEntity<IamUserDTO> getUserByUsername(@PathVariable("username") @NotNull String username);


}
