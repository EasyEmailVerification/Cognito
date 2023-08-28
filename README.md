# Cognito JWT Token Verification for Java

This project provides a Java library that allows you to easily validate JWT tokens provided by Amazon Cognito User Pools. The library is structured as a POM project and can be seamlessly integrated into your Java applications to ensure the authenticity of JWT tokens.

## Table of Contents

- [Introduction](#introduction)
- [Usage](#usage)
- [Installation](#installation)
- [Example](#example)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Amazon Cognito User Pools provide a secure way to manage user identities and authentication in your applications. However, it's essential to verify the JWT tokens provided by Cognito to ensure that they haven't been tampered with and come from a legitimate source. This Java library simplifies the process of token validation by abstracting away the complex verification steps.

This library is developed by [EasyEmailVerification](https://www.easyemailverification.com/), a company dedicated to providing robust email verification and authentication solutions for businesses.

## Usage

The heart of this library is the `verify` method, which takes the AWS JWT token, Cognito User Pool ID, and AWS region as parameters. It returns the decoded JWT token if verification is successful, or `null` if verification fails. The library handles initialization and token verification using the provided parameters.

```java
package com.easyemailverification.code.Cognito.aws;

import com.auth0.jwt.interfaces.DecodedJWT;

public class TokenVerifier {

    public static DecodedJWT verify(String awsJwtToken, String cognitoUserPoolId, String awsRegion) {
        try {
            // Initialize verifier if not already initialized
            if (verifier == null) {
                initialize(cognitoUserPoolId, awsRegion);
            }
            
            // Verify the JWT token
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
```

## Installation

To use this library in your project, you can include it as a dependency in your Maven project's `pom.xml` file:

```xml
It's not available yet.
<dependencies>
    <dependency>
        <groupId>com.easyemailverification.code</groupId>
        <artifactId>cognito-jwt-validator</artifactId>
        <version>1.0.0</version> <!-- Replace with the actual version -->
    </dependency>
</dependencies>
```

Please replace `1.0.0` with the appropriate version number.

## Example

Here's an example of how you can use the library to verify a JWT token provided by Amazon Cognito:

```java
package com.easyemailverification.code.Cognito.aws;

import com.auth0.jwt.interfaces.DecodedJWT;

public class Main {

    public static void main(String[] args) {
        String awsJwtToken = "your-aws-jwt-token";
        String cognitoUserPoolId = "your-cognito-user-pool-id";
        String awsRegion = "your-aws-region";

        DecodedJWT decodedToken = TokenVerifier.verify(awsJwtToken, cognitoUserPoolId, awsRegion);

        if (decodedToken != null) {
            System.out.println("Token verification successful!");
            System.out.println("Subject: " + decodedToken.getSubject());
            // Add more token information extraction as needed
        } else {
            System.out.println("Token verification failed.");
        }
    }
}
```

## Contributing

Contributions to this project are welcome! Feel free to open issues for any bugs or feature requests you come across.

## License

This project is licensed under the MIT License.

---

**Created by [EasyEmailVerification](https://www.easyemailverification.com/)**
