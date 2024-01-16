package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Vehicle;
import at.htlleonding.vehicle.entity.dto.VehicleDto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped
public class VehicleRepository implements PanacheRepository<Vehicle> {

    public Vehicle save(Vehicle v) {
        return getEntityManager().merge(v);
    }

}
