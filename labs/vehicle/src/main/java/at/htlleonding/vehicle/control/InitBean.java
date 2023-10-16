package at.htlleonding.vehicle.control;

import io.quarkus.logging.Log;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class InitBean {

    void startUp(@Observes StartupEvent event) {
        Log.error("it is working");
    }


}
