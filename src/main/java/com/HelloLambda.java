package com;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloLambda implements RequestHandler<String, String> {

    public String handleRequest(String input, Context context) {
        // Log the input
        context.getLogger().log("Input: " + input);

        // Return a greeting message
        return "Hello, " + input + "!";
    }
}
