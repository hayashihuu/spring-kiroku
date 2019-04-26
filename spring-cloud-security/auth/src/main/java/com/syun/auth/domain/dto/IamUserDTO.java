package com.syun.auth.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @description:
 * @program: iam-service
 * @author: syun
 * @create: 2019-04-24 23:20
 */
@Data
@NoArgsConstructor
public class IamUserDTO {

    private Integer id;

    private String username;

    private Boolean status;

    private String password;

    private Boolean isDel;

    @NotNull
    private Set<IamRoleDTO> roles;


}
