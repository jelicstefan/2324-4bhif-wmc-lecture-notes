package at.htlleonding.restclient;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.util.Set;

@Path("/extensions")
@RegisterRestClient
public interface ExtensionsService {

    @GET
    Set<Extension> getById(@QueryParam("id") String id);
}