package build.models;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Partners")
public class PartnerDTO {
	@Id
	private ObjectId _id;
	
	private String partnerID;
	private String creator;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateCreate;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateModify;
	
	private PartnerSource source;
	private String ediCode;
	private String partnerNameAbbr;
	private String partnerNameFullEN;
	private String partnerNameFullVN;
	private List<Address> address;
	private Country country;
	private City city;
	private State state;
	private String zipCode;
	private List<PersonContact> personContact;
	private String homePhone;
	private String workPhone;
	private String faxNumber;
	private String taxCode;
	private String saleManage;
	private List<String> saleAuthorised;
	private String group;
	private String location;
	private String category;
	private String website;
	private String email;
	private Boolean isPublic;
	private Boolean lock;
	private Boolean warning;
	private String warningMessage;
//	private Partner accountReference;
	private String personAccountNumber;
	private String personAccountName;
	private String bankName;
	private String bankAddress;
	private String bankBranch;
	private String swiftCode;
	private Integer termDaysETDETA;
	private Integer termDaysInvoiceDate;
	private Double termDaysMonthlyDate;
	private Double termAmountForCredit;
	private String notes;
	private Boolean isRefund;
//	private Partner officeAgent;
	private String beneficiarysAddress;
	private String beneficiarysName;
	private String currency;
	private String termCurrencyForCredit;
	private String profileID;
	private String termNotes;
	private Country nationality;
	private String preferredCollectionDate;
	private String cityName;
	private String countryName;
	private String stateName;
	
	public String get_id() { return _id == null ? null : _id.toHexString() ; }
	
}
