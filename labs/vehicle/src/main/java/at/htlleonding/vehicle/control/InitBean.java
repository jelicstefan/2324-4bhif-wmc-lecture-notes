package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Vehicle;
import io.quarkus.logging.Log;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    EntityManager em;

    @Transactional
    void startUp(@Observes StartupEvent event) {
        Log.info("it is working");

        Vehicle vehicle = new Vehicle("Opel", "Kadett");
        em.persist(vehicle);

    }


}
