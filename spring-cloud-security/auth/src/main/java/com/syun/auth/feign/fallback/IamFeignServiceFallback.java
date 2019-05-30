package com.syun.auth.feign.fallback;

import com.syun.auth.domain.dto.IamUserDTO;
import com.syun.auth.error.FeignCallException;
import com.syun.auth.feign.IamFeignService;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/*
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2019-05-05 18:29
 */
@Slf4j
@Component
public class IamFeignServiceFallback implements IamFeignService {

    @Override
    public ResponseEntity<IamUserDTO> getUserByUsername(String username) {
        log.error("调用 getUserByUsername 失败 username: {}", username);
        throw new FeignCallException("调用 getUserByUsername 失败");
    }
}
