package build.customs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalFilterModel {
	private String colId;
	private String filterType;
	private String type;
	private Object filter;
	private String dateFrom;
	private String dateTo;
	private String refenrenceField;
	private Boolean isForeignKey;
	private String originField;
}
