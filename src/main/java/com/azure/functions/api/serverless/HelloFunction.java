package com.azure.functions.api.serverless;

import java.util.Optional;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

public class HelloFunction {

	@FunctionName("hello")
	public HttpResponseMessage run(@HttpTrigger(name = "req", methods = {
			HttpMethod.GET }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
			final ExecutionContext context) {

		context.getLogger().info("Java HTTP trigger processed a request.");

		String name = request.getQueryParameters().get("name");
		if (name == null) {
			name = request.getBody().orElse("World");
		}

		return request.createResponseBuilder(HttpStatus.OK).body("Hello, " + name + "!").build();
	}
}
