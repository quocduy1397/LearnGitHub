package build.interfaces;

import build.models.City;
import build.models.Country;
import build.models.Partner;
import build.models.PartnerSource;
import build.models.State;

public interface DataInterfacesRepository {
	<T> T getForeignObject(Class<T> entityClass, String idField, String value);
	Country getCountry(String countryID);
	City getCity(String cityID);
	State getState(String stateID);
	PartnerSource getPartnerSource(String sourceID);
	Partner getPartner(String partnerID);
}
