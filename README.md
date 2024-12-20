# Running Java Code in AWS Lambda

This guide walks you through the process of running Java code in AWS Lambda. We will cover setting up your AWS Lambda function, creating the Java application, and deploying it to AWS Lambda.

## Prerequisites

Before you begin, ensure you have the following installed:

- **AWS CLI**: Command Line Interface for interacting with AWS services.
- **AWS Account**: You need an AWS account to access Lambda and other AWS services.
- **Java JDK (8 or later)**: To compile and run Java applications.
- **Maven**: A build tool for Java projects.
- **AWS SDK**: For managing Lambda functions.

## Step 1: Create a Java Project

Create a new Java project using your preferred IDE or command line.

1. Create a Maven project with the following directory structure:

    ```
    /java-lambda
    ├── src/
    └── pom.xml
    ```

2. In `pom.xml`, add the necessary dependencies for AWS Lambda and logging. Here’s an example:

    ```xml
    <dependencies>
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-lambda-java-core</artifactId>
            <version>1.2.1</version>
        </dependency>
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-lambda-java-events</artifactId>
            <version>3.11.0</version>
        </dependency>
    </dependencies>
    ```

3. In `src/`, create a class with a handler method. The handler method is the entry point for your Lambda function. Example:

    ```java
    package com.example;

    import com.amazonaws.services.lambda.runtime.Context;
    import com.amazonaws.services.lambda.runtime.RequestHandler;

    public class HelloWorldLambda implements RequestHandler<Object, String> {

        @Override
        public String handleRequest(Object input, Context context) {
            return "Hello from AWS Lambda!";
        }
    }
    ```

## Step 2: Package the Java Code

1. In your project directory, run the following Maven command to compile and package your code:

    ```bash
    mvn clean package
    ```

   This will generate a `.jar` file in the `target/` directory.

## Step 3: Create a Lambda Function in AWS Console

1. Go to the **AWS Management Console** and navigate to **Lambda**.
2. Click on **Create function**.
3. Choose **Author from Scratch**.
4. Enter a name for your function (e.g., `HelloWorldLambda`).
5. Under **Runtime**, select **Java 11** (or Java 8, depending on your Java version).
6. Under **Function code**, select **Upload a .zip or .jar file**.
7. Upload the `.jar` file generated from the `target/` directory.
8. Set the **Handler** to the fully qualified class name of your handler method. For the above example, the handler is:

    ```
    com.example.HelloWorldLambda::handleRequest
    ```

9. Configure your Lambda function as needed (e.g., memory, timeout).

## Step 4: Test the Lambda Function

1. In the **AWS Lambda Console**, click on the **Test** button.
2. You can use the default event template or create a custom event. For this example, the input is not required since the function doesn't use any event data.
3. Click **Save changes** and **Test**.

You should see the output `Hello from AWS Lambda!`.

## Step 5: Set Up AWS API Gateway (Optional)

To invoke your Lambda function via HTTP requests, set up an API Gateway.

1. Go to **API Gateway** in the AWS Console.
2. Create a new API and define a method (e.g., `GET` or `POST`).
3. Integrate the method with your Lambda function.
4. Deploy the API and note the **Invoke URL**.

## Conclusion

You have successfully created and deployed a Java application on AWS Lambda. You can now invoke it via the Lambda console or API Gateway.

---

For more information on using AWS Lambda with Java, check out the [AWS Lambda Documentation](https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html).
