package com.syun.auth.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IamPermission {
    private Integer id;

    private String name;

    private String url;

    private String description;

    public IamPermission(Integer id, String name, String url, String description) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
    }
}