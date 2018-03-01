package ru.senla.bialevich.service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class TokenHandler {
    private final static Logger LOG = Logger.getLogger(TokenHandler.class);

    private volatile static TokenHandler instance;

    public static TokenHandler getInstance() {
        if (instance == null) {
            synchronized (TokenHandler.class) {
                if (instance == null)
                    instance = new TokenHandler();
            }
        }
        return instance;
    }

    public String generateAccessToken(Integer id) {
        byte[] key = new byte[32];

        try {
            JWSSigner signer = new MACSigner(key);
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .issuer("SuperWebApp")
                    .expirationTime(new Date(new Date().getTime() + 60 * 1000))
                    .claim("id", id)
                    .build();

            SignedJWT jwt = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            jwt.sign(signer);

            return jwt.serialize();
        } catch (JOSEException e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

    private Boolean checkToken(String token) {

        try {

            byte[] key = new byte[32];

            SignedJWT jwt = SignedJWT.parse(token);
            JWSVerifier jwsVerifier = new MACVerifier(key);

            jwt.verify(jwsVerifier);

            return true;

        } catch (ParseException | JOSEException e) {
            LOG.error(e.getMessage());
            return false;
        }
    }

    public Integer extractAuthId(String token) {
        if (this.checkToken(token)) {
            try {
                SignedJWT jwt = SignedJWT.parse(token);
                return (Integer) jwt.getJWTClaimsSet().getClaim("id");
            } catch (ParseException e) {
                LOG.error(e.getMessage());
            }
        }

        return null;
    }
}
