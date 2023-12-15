package com.luckygroup.webapi.utils;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.jose4j.jwa.Algorithm;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;

public class JwtUtils {

  public JwtUtils() {
    super();
  }

  public String generatorToken(String email) {
    try {
      RsaJsonWebKey rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
      rsaJsonWebKey.setKeyId("BestSecretKey");
      JwtClaims claims = new JwtClaims();

      claims.setSubject(email);
      claims.setIssuedAtToNow();
      claims.setExpirationTimeMinutesInTheFuture(10080);

      JsonWebSignature jws = new JsonWebSignature();

      jws.setPayload(claims.toJson());
      jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());

      jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_PSS_USING_SHA256);

      String jwt = jws.getCompactSerialization();

      return jwt;
    } catch (Exception e) {
      throw new ResourceNotFoundException(e);
    }
  }
}
