package build.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonContact {
	private String fullName;
	private String cellPhone;
	private String address;
	private String email;
	private String directLine;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date birthday;
	
	private String note;
	private String position;
	private String group;
}
