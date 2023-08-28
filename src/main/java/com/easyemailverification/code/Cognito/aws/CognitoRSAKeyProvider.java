/*
 * This Java file, located in the "com.easyemailverification.code.Cognito.aws" package,
 * is a part of the Easy Email Verification system. It provides an RSA Key Provider
 * implementation for handling authentication using Amazon Cognito services.
 * 
 * Author: Support
 * Property: Easy Email Verification
 * Package: com.easyemailverification.code.Cognito.aws
 * 
 * Description:
 * This file contains Java code that implements an RSA Key Provider for use with
 * Amazon Cognito services. The RSA Key Provider facilitates authentication by
 * providing the necessary RSA public and private keys used in JWT token generation
 * and verification. These keys are retrieved from a specified URL and loaded into
 * the system.
 * 
 * Contents:
 * This file includes methods and classes required to retrieve, load, and provide
 * RSA public and private keys to the authentication system. It also utilizes external
 * libraries such as Auth0's JWT library and Gson for JSON parsing. The code handles
 * the process of fetching keys from a URL, parsing them, and creating instances of
 * RSAPublicKey and RSAPrivateKey.
 * 
 * Usage:
 * Developers can freely utilize this code to implement RSA Key Provider functionality
 * for their projects, particularly those requiring Amazon Cognito integration for
 * user authentication. The provided class, "CognitoRSAKeyProvider," can be integrated
 * into the project's authentication flow to handle JWT token generation and validation.
 * Developers should ensure that the external libraries and dependencies are properly
 * included in their project.
 * 
 * Disclaimer:
 * This code is provided as-is and the author holds no responsibility for its
 * functionality within external projects. It is recommended to thoroughly test and
 * review the code before deploying it to a production environment.
 * 
 */
package com.easyemailverification.code.Cognito.aws;


import java.math.BigInteger;
import java.net.URL;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.auth0.jwt.interfaces.RSAKeyProvider;
import com.google.gson.Gson;

public class CognitoRSAKeyProvider implements RSAKeyProvider {

    private final Map<String, RSAPublicKey> rsaPublicKeyMap = new HashMap<String, RSAPublicKey>();
    private final String jwksUri;

    public CognitoRSAKeyProvider(String jwksUri) {
        this.jwksUri = jwksUri;
        fetchKeysFromJwks();
    }

    private void fetchKeysFromJwks() {
        try {
            URL url = new URL(jwksUri);
            Scanner scanner = new Scanner(url.openStream());
            String jwksJson = scanner.useDelimiter("\\A").next();
            scanner.close();

            // Parse the JWKS JSON and populate the rsaPublicKeyMap
            Gson gson = new Gson();
            JwksKeys keys = gson.fromJson(jwksJson, JwksKeys.class); // Replace with your JwksKeys class
            for (JwkKey key : keys.getKeys()) {
                RSAPublicKey publicKey = extractPublicKeyFromJwk(key); // Implement this method
                rsaPublicKeyMap.put(key.getKid(), publicKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private RSAPublicKey extractPublicKeyFromJwk(JwkKey key) {
        try {
            // Decode the base64-encoded modulus and exponent from the JWK
            byte[] modulusBytes = Base64.getUrlDecoder().decode(key.getN());
            byte[] exponentBytes = Base64.getUrlDecoder().decode(key.getE());

            // Create BigInteger instances from the modulus and exponent
            BigInteger modulus = new BigInteger(1, modulusBytes);
            BigInteger exponent = new BigInteger(1, exponentBytes);

            // Create an RSA public key using the modulus and exponent
            RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPublicKey) keyFactory.generatePublic(rsaPublicKeySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public RSAPublicKey getPublicKeyById(String keyId) {
        return rsaPublicKeyMap.get(keyId);
    }

	public RSAPrivateKey getPrivateKey() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrivateKeyId() {
		// TODO Auto-generated method stub
		return null;
	}
}