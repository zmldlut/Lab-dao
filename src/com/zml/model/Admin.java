package com.zml.model;

public class Admin extends BaseModel {

    private static final long serialVersionUID = 2180243944113374734L;
    private String name;
	private String password;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
