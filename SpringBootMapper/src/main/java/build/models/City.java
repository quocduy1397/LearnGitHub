package build.models;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Cities")
public class City {	
	@Id
	private ObjectId _id;
	
	private String cityID;
	private String cityName;
	private String stateID;
	private String countryID;
	private String isoCode;
	
	public String get_id() { return _id == null ? null : _id.toHexString() ; }
}
