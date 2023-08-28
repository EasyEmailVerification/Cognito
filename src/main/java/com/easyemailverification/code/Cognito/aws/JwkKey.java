/*
 * This Java file, located in the "com.easyemailverification.code.Cognito.aws" package,
 * is a part of the Easy Email Verification system. It provides a class for representing
 * JSON Web Key (JWK) information used in authentication with Amazon Cognito services.
 * 
 * Author: Support
 * Property: Easy Email Verification
 * Package: com.easyemailverification.code.Cognito.aws
 * 
 * Description:
 * This file contains Java code that defines a class for representing JSON Web Key (JWK)
 * information. JWKs are used in authentication systems to provide cryptographic key
 * details for generating and verifying JWT tokens. The class includes fields for key
 * ID (kid), key type (kty), modulus (n), and exponent (e) necessary for RSA key pairs.
 * 
 * Contents:
 * This file includes a class named "JwkKey" that is used to represent JWK information.
 * It contains fields to store key-related details and follows the JWK format conventions.
 * The provided class can be integrated into projects that require interaction with JWKs,
 * especially those using Amazon Cognito services for authentication and token handling.
 * 
 * Usage:
 * Developers can incorporate this code into their projects to handle JWK-related tasks.
 * The "JwkKey" class can be used to parse and store JWK information retrieved from Cognito
 * or other authentication services. Developers can then use this information to generate
 * and verify JWT tokens. The class provides a convenient way to encapsulate JWK properties.
 * 
 * Disclaimer:
 * This code is provided as-is and the author holds no responsibility for its functionality
 * within external projects. It is recommended to thoroughly test and review the code before
 * deploying it to a production environment.
 * 
 */
package com.easyemailverification.code.Cognito.aws;

public class JwkKey {
    private String kid; // Key ID
    private String kty; // Key type (e.g., "RSA")
    private String n;   // Modulus
    private String e;   // Exponent

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getKty() {
        return kty;
    }

    public void setKty(String kty) {
        this.kty = kty;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }
}

