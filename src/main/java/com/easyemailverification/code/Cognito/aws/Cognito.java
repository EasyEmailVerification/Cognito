/*
 * This Java file, located in the "com.easyemailverification.code.Cognito.aws" package,
 * is a part of the Easy Email Verification system. It handles email verification
 * using Amazon Cognito services for user authentication and management.
 * 
 * Author: support
 * Property: Easy Email Verification
 * Package: com.easyemailverification.code.Cognito.aws
 * 
 * Description:
 * This file contains Java code that integrates with Amazon Cognito, a service provided
 * by Amazon Web Services (AWS), to facilitate easy email verification for user accounts.
 * The purpose of this code is to enhance the security and reliability of user authentication
 * by ensuring that email addresses associated with user accounts are valid and verified.
 * 
 * Contents:
 * This file might include methods and classes that interact with Amazon Cognito's APIs
 * to initiate email verification processes, manage verification codes, and handle user
 * interactions during the verification process. It may also contain utility functions,
 * constants, and configurations related to email verification and Cognito integration.
 * 
 * Usage:
 * Developers are granted free usage rights to utilize and modify this code as needed
 * within their projects.
 * Developers can adapt the code to suit their specific requirements and integrate it with
 * their existing systems seamlessly.
 * 
 * Disclaimer:
 * This code is provided as-is and the author holds no responsibility for its functionality
 * within external projects. It is recommended to thoroughly test and review the code before
 * deploying it to a production environment.
 * https://www.easyemailverification.com
 * 
 * 
 * 
 */
package com.easyemailverification.code.Cognito.aws;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class Cognito {

	private static JWTVerifier verifier;

	public Cognito() {

	}

	public static void initialize(String cognitoUserPoolId, String awsRegion) {

		String cognitoIssuer = "https://cognito-idp." + awsRegion + ".amazonaws.com/" + cognitoUserPoolId;
		String cognitoJwksUri = cognitoIssuer + "/.well-known/jwks.json";

		Algorithm algorithm = Algorithm.RSA256(new CognitoRSAKeyProvider(cognitoJwksUri));

		verifier = JWT.require(algorithm).withIssuer(cognitoIssuer).build();
	}


	/**
	 * 
	 * @param aws jwt token
	 * @return DecodedJWT
	 */
	public static DecodedJWT verify(String awsJwtToken, String cognitoUserPoolId, String awsRegion) {
		try {
			
			if (verifier==null) {
				initialize(cognitoUserPoolId, awsRegion);
			}
			DecodedJWT decodedToken = verifier.verify(awsJwtToken);
			return decodedToken;

		} catch (JWTVerificationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
