package build.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private Integer index;
    private String addressInfo;
    private Boolean isMainAddress;
    private String note;
}
