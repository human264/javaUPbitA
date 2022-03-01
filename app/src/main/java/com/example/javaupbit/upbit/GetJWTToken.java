package com.example.javaupbit.upbit;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.UUID;

public class GetJWTToken {

        public String getToken() {

            String accessKey = "gEPWFVrYKcuNyNbfIkcZpVokEqQVeS4qqqxVR20j";
            String secretKey = "HY1KdbxOJSlVH8xIt3AE4uNB6jgBD9CQJ8xaxWFB";


            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            String jwtToken = JWT.create()
                    .withClaim("access_key", accessKey)
                    .withClaim("nonce", UUID.randomUUID().toString())
                    .sign(algorithm);

            String authenticationToken = "Bearer " + jwtToken;

            return authenticationToken;
        }
}
