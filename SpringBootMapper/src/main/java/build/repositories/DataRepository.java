package build.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import build.interfaces.DataInterfacesRepository;
import build.models.City;
import build.models.Country;
import build.models.Partner;
import build.models.PartnerSource;
import build.models.State;

@Repository
public class DataRepository implements DataInterfacesRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public <T> T getForeignObject(Class<T> entityClass, String idField, String value) {
		return mongoTemplate.findOne(new Query().addCriteria(Criteria.where(idField).is(value)), entityClass);
	}

	@Override
	public Country getCountry(String countryID) {
		return getForeignObject(Country.class, "countryID", countryID);
	}

	@Override
	public City getCity(String cityID) {
		return getForeignObject(City.class, "cityID", cityID);
	}

	@Override
	public State getState(String stateID) {
		return getForeignObject(State.class, "stateID", stateID);
	}

	@Override
	public PartnerSource getPartnerSource(String sourceID) {
		return getForeignObject(PartnerSource.class, "sourceID", sourceID);
	}

	@Override
	public Partner getPartner(String partnerID) {
		return getForeignObject(Partner.class, "partnerID", partnerID);
	}

}
