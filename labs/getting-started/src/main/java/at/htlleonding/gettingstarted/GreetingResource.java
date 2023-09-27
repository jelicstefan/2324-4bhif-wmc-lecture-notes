package at.htlleonding.gettingstarted;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name="test", defaultValue = "hello")
    String test;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return String.format("%s 4bhif", test);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String helloHtml() {
        return String.format("<h1>%s 4bhif</h1>", test);
    }


//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Vehicle getVehicleJson() {
//        return new Vehicle("Opel", "Kadett");
//    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Vehicle getVehicleXml() {
        return new Vehicle("Opel", "Kadett");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVehicleAsResponse() {
        var vehicle = new Vehicle("Opel", "Kadett");
        return Response.ok(vehicle).build();
    }

}
