package com.syun.auth.model;

import java.util.List;

public class UserDO {
    private Integer id;

    private String username;

    private String password;

    private Boolean status;

    private Boolean isDel;



    private List<PermissionDO> permissions;

    public UserDO(Integer id, String username, String password, Boolean status, Boolean isDel, List<PermissionDO> permissions) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.isDel = isDel;
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", isDel=" + isDel +
                ", permissions=" + permissions +
                '}';
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }

    public List<PermissionDO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDO> permissions) {
        this.permissions = permissions;
    }

    public UserDO(Integer id, String username, String password, Boolean status, Boolean isDel) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.isDel = isDel;
    }

    public UserDO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}