package at.htlleonding.restclient;

import io.quarkus.rest.client.reactive.ClientQueryParam;
import jakarta.ws.rs.GET;

@ClientQueryParam(name = "my-param", value = "${my.property-value}")
public interface Client {
    @GET
    String getWithParam();

    @GET
    @ClientQueryParam(name = "some-other-param", value = "other")
    String getWithOtherParam();

    @GET
    @ClientQueryParam(name = "param-from-method", value = "{with-param}")
    String getFromMethod();

    default String withParam(String name) {
        if ("param-from-method".equals(name)) {
            return "test";
        }
        throw new IllegalArgumentException();
    }
}