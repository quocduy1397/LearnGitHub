package build.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import build.models.Partner;

@Repository
public interface PartnerInterfacesRepository extends MongoRepository<Partner, String> {
	
}
