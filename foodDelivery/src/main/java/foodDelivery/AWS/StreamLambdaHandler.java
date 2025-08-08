package foodDelivery.AWS;

import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import foodDelivery.FoodDeliveryApplication;

//public class StreamLambdaHandler implements RequestHandler<AwsProxyRequest, AwsProxyResponse> {
//
//    private static final SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
//
//    static {
//        try {
//            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(FoodDeliveryApplication.class);
//        } catch (Exception e) {
//            throw new RuntimeException("Erro ao inicializar o handler", e);
//        }
//    }
//
//    @Override
//    public AwsProxyResponse handleRequest(AwsProxyRequest awsProxyRequest, Context context) {
//        return handler.proxy(awsProxyRequest, context);
//    }
//}

public class StreamLambdaHandler implements RequestHandler<AwsProxyRequest, AwsProxyResponse> {
    private static final SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    static {
        try {
            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(FoodDeliveryApplication.class);
            handler.initialize();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Spring Boot handler", e);
        }
    }

    @Override
    public AwsProxyResponse handleRequest(AwsProxyRequest request, Context context) {
        return handler.proxy(request, context);
    }
}