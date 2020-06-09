package build.mappers;

import org.bson.types.ObjectId;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import build.models.City;
import build.models.Country;
import build.models.Partner;
import build.models.PartnerDTO;
import build.models.PartnerSource;
import build.models.State;

@Mapper( imports = City.class )
public interface PartnerMapper {
	
	PartnerMapper INSTANCE = Mappers.getMapper(PartnerMapper.class);
	
	@Mappings({
		@Mapping(target = "_id", source = "entity._id", qualifiedByName = "toObjectId"),
		@Mapping(target = "source", source = "source"),
		@Mapping(target = "country", qualifiedByName = "getCountry"),
		@Mapping(target = "city", expression = "java( new City() )"),
		@Mapping(target = "state", source = "entity.state", qualifiedByName = "getState"),
		@Mapping(target = "nationality", source = "entity.nationality", qualifiedByName = "getNationality")
	})
	PartnerDTO partnerToDTO(Partner entity, PartnerSource source, @Context Country country);
	
	@Named("getCountry")
	public static Country getCountry(String countryID, @Context Country country)
	{
		return country;
	};
	
	@Named("getState")
	public static State getState(String state)
	{
		return new State();
	};
	
	@Named("toObjectId")
	public default ObjectId toObjectId(String IdHexString)
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
