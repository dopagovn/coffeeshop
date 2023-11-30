package com.luckygroup.webapi.services;

import org.mindrot.jbcrypt.BCrypt;

public class HashPassword {

  public static String hashPassword(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt());
  }

  public static boolean comparePassword(
    String password,
    String hashedPassword
  ) {
    return BCrypt.checkpw(password, hashedPassword);
  }
}
