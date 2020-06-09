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
@Document(collection="PartnerSources")
public class PartnerSource {
	@Id
	private ObjectId _id;
	
	private String sourceID;
	private String sourceName;
	
	public String get_id() { return _id == null ? null : _id.toHexString() ; }
}
