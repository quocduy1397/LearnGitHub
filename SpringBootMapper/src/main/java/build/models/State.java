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
@Document(collection="States")
public class State {
	@Id
	private ObjectId _id;
	
	private String stateID;
	private String stateName;
	private String countryID;

	public String get_id() { return _id == null ? null : _id.toHexString() ; }
}
