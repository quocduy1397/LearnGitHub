package build.mappers;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import build.models.City;
import build.models.Country;
import build.models.Partner;
import build.models.PartnerDTO;
import build.models.PartnerSource;
import build.models.State;

@Mapper(componentModel = "spring")
public interface PartnerMapperSpring {
	
	@Mappings({
		@Mapping(target = "_id", source = "entity._id", qualifiedByName = "toObjectId"),
		@Mapping(target = "source", source = "source"),
		@Mapping(target = "country", source = "country"),
		@Mapping(target = "city", source = "entity.city", qualifiedByName = "getCity"),
		@Mapping(target = "state", source = "entity.state", qualifiedByName = "getState"),
		@Mapping(target = "nationality", source = "entity.nationality", qualifiedByName = "getNationality")
	})
	PartnerDTO partnerToDTO(Partner entity, PartnerSource source, Country country);
	
	@Named("getCity")
	public static City getCity(String city)
	{
		return new City();
	};
	
	@Named("getState")
	public static State getState(String state)
	{
		return new State();
	};
	
	@Named("toObjectId")
	public static ObjectId toObjectId(String IdHexString)
	{
		return IdHexString == null ? null : new ObjectId(IdHexString);
	};
	
	@Named("getNationality")
	public static Country getNationality(String nationality)
	{
		if (nationality == null)
		{
			return null;
		}
		if (nationality.equals(""))
		{
			return null;
		}
		Country newNationality = new Country();
		newNationality.setCountryID(nationality);
		return newNationality;
	};
}
