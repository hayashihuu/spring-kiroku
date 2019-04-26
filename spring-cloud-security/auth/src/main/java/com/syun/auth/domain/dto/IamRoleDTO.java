package com.syun.auth.domain.dto;

import com.syun.auth.model.IamPermission;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @description:
 * @program: iam-service
 * @author: syun
 * @create: 2019-04-24 23:25
 */
@Data
@NoArgsConstructor
public class IamRoleDTO {
    private Integer id;

    private String name;

    private String description;

    private Set<IamPermission> permissions;


}
