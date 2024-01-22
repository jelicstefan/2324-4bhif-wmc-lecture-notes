package at.htlleonding.vehicle.boundary;

import at.htlleonding.vehicle.control.VehicleRepository;
import at.htlleonding.vehicle.entity.Vehicle;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;


@Path("/vehicle")
public class VehicleResource {

    @Inject
    VehicleRepository vehicleRepository;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance vehicle(Vehicle vehicle);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    @Blocking
    public TemplateInstance get(@PathParam("id") Long id) {
        return Templates.vehicle(vehicleRepository.findById(id));
    }



//    @GET
//    @Path("{id}")
//    @Produces({
//            MediaType.APPLICATION_JSON
//            , MediaType.APPLICATION_XML
//    })
//    public Vehicle find(@PathParam("id") long id) {
//        return vehicleRepository.findById(id);
//    }

    @GET
    @Produces({
            MediaType.APPLICATION_JSON
    })
    public List<Vehicle> findAll() {
        return vehicleRepository.listAll();
    }

    @GET
    @Path("myjson")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject myCustomJsonObject() {
        JsonObject myObject = Json.createObjectBuilder()
                .add("first-name", "Bertl")
                .add("last-name", "Balazs")
                .build();
        return myObject;
    }

    @GET
    @Path("myresponse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response myCustomResponse(@QueryParam("no") Integer no) {
        if(no == 1) {
            return Response.ok(
                            new Vehicle("Opel", "Karl")
                    )
                    .header("MY_HEADER_ENTRY", "java is cool")
                    .build();
        } else {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

}
