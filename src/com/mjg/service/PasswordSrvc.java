package com.mjg.service;

import java.security.NoSuchAlgorithmException;

public interface PasswordSrvc {
	public String hashPassword(String password) throws NoSuchAlgorithmException;
}
