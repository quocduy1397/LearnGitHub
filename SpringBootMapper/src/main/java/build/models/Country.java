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
@Document(collection="Countries")
public class Country {
	@Id
	private ObjectId _id;
	
	private String countryID;
	private String countryName;
	private String areaID;
	private String isoCode;
	
	public String get_id() { return _id == null ? null : _id.toHexString() ; }
}
