package com.masai.DAO;

import com.masai.Exception.UnableToEditProfile;

public interface ProfileDAO {
public void changeName(String name) throws UnableToEditProfile;
public void changeUserName(String username) throws UnableToEditProfile;
public void changeMobile(String mobile) throws UnableToEditProfile;
public void changePassword(String oldPassword, String newPassword) throws UnableToEditProfile;
}
