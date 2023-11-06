package at.htlleonding.postdemo.boundary;

import at.htlleonding.postdemo.control.PersonRepository;
import at.htlleonding.postdemo.entity.Person;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
import java.util.List;

@Path("person")
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    public List<Person> findAll() {
        for (var person : personRepository.getPersons()) {
            System.out.println(person);
        }
        return personRepository.getPersons();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person, @Context UriInfo uriInfo) {
        personRepository.add(person);
        URI uri = uriInfo
                .getAbsolutePathBuilder()
                .path("42")
                .build();


        return Response
                .created(uri)
                .header("X-HEAD", "xy")
                .build();
    }

}
