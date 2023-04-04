package com.masai.DTO;

public class CustomerImpl implements Customer{
    private String id;
    private String name;
    private String username;
    private String password;
    private String mobile_no;

    

    public CustomerImpl(String id, String name, String username, String password, String mobile_no) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.mobile_no = mobile_no;
	}

	public String id() {
        return id;
    }

    public void id(String passenger_id) {
        this.id = passenger_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
}

