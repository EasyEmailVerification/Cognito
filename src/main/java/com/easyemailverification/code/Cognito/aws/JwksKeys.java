/*
 * This Java file, located in the "com.easyemailverification.code.Cognito.aws" package,
 * is a part of the Easy Email Verification system. It provides a class for representing
 * a collection of JSON Web Keys (JWKs) used in authentication with Amazon Cognito services.
 * 
 * Author: Support
 * Property: Easy Email Verification
 * Package: com.easyemailverification.code.Cognito.aws
 * 
 * Description:
 * This file contains Java code that defines a class for representing a collection of
 * JSON Web Keys (JWKs). JWKs are used in authentication systems to provide cryptographic
 * key details for generating and verifying JWT tokens. The "JwksKeys" class includes a
 * list of "JwkKey" instances that encapsulate key information.
 * 
 * Contents:
 * This file includes a class named "JwksKeys" that is used to represent a collection of
 * JWKs. It contains a field to store a list of "JwkKey" instances. Developers can use
 * this class to manage and interact with multiple JWKs, particularly when working with
 * Amazon Cognito services or other authentication systems.
 * 
 * Usage:
 * Developers can incorporate this code into their projects to manage and work with
 * collections of JWKs. The "JwksKeys" class can be used to represent and store multiple
 * JWKs retrieved from Cognito or other authentication services. Developers can then
 * utilize this collection to dynamically handle JWT token generation and verification
 * using different key pairs.
 * 
 * Disclaimer:
 * This code is provided as-is and the author holds no responsibility for its functionality
 * within external projects. It is recommended to thoroughly test and review the code before
 * deploying it to a production environment.
 * 
 */
package com.easyemailverification.code.Cognito.aws;

import java.util.List;

public class JwksKeys {
    private List<JwkKey> keys;

    public List<JwkKey> getKeys() {
        return keys;
    }

    public void setKeys(List<JwkKey> keys) {
        this.keys = keys;
    }
}

