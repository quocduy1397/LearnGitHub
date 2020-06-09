package build.mappers;

import build.models.Address;
import build.models.Country;
import build.models.Partner;
import build.models.PartnerDTO;
import build.models.PartnerSource;
import build.models.PersonContact;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-29T16:28:00+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class PartnerMapperSpringImpl implements PartnerMapperSpring {

    @Override
    public PartnerDTO partnerToDTO(Partner entity, PartnerSource source, Country country) {
        if ( entity == null && source == null && country == null ) {
            return null;
        }

        PartnerDTO partnerDTO = new PartnerDTO();

        if ( entity != null ) {
            partnerDTO.setNationality( PartnerMapperSpring.getNationality( entity.getNationality() ) );
            partnerDTO.setCity( PartnerMapperSpring.getCity( entity.getCity() ) );
            partnerDTO.set_id( PartnerMapperSpring.toObjectId( entity.get_id() ) );
            partnerDTO.setState( PartnerMapperSpring.getState( entity.getState() ) );
            partnerDTO.setPartnerID( entity.getPartnerID() );
            partnerDTO.setCreator( entity.getCreator() );
            partnerDTO.setDateCreate( entity.getDateCreate() );
            partnerDTO.setDateModify( entity.getDateModify() );
            partnerDTO.setEdiCode( entity.getEdiCode() );
            partnerDTO.setPartnerNameAbbr( entity.getPartnerNameAbbr() );
            partnerDTO.setPartnerNameFullEN( entity.getPartnerNameFullEN() );
            partnerDTO.setPartnerNameFullVN( entity.getPartnerNameFullVN() );
            List<Address> list = entity.getAddress();
            if ( list != null ) {
                partnerDTO.setAddress( new ArrayList<Address>( list ) );
            }
            partnerDTO.setZipCode( entity.getZipCode() );
            List<PersonContact> list1 = entity.getPersonContact();
            if ( list1 != null ) {
                partnerDTO.setPersonContact( new ArrayList<PersonContact>( list1 ) );
            }
            partnerDTO.setHomePhone( entity.getHomePhone() );
            partnerDTO.setWorkPhone( entity.getWorkPhone() );
            partnerDTO.setFaxNumber( entity.getFaxNumber() );
            partnerDTO.setTaxCode( entity.getTaxCode() );
            partnerDTO.setSaleManage( entity.getSaleManage() );
            List<String> list2 = entity.getSaleAuthorised();
            if ( list2 != null ) {
                partnerDTO.setSaleAuthorised( new ArrayList<String>( list2 ) );
            }
            partnerDTO.setGroup( entity.getGroup() );
            partnerDTO.setLocation( entity.getLocation() );
            partnerDTO.setCategory( entity.getCategory() );
            partnerDTO.setWebsite( entity.getWebsite() );
            partnerDTO.setEmail( entity.getEmail() );
            partnerDTO.setIsPublic( entity.getIsPublic() );
            partnerDTO.setLock( entity.getLock() );
            partnerDTO.setWarning( entity.getWarning() );
            partnerDTO.setWarningMessage( entity.getWarningMessage() );
            partnerDTO.setPersonAccountNumber( entity.getPersonAccountNumber() );
            partnerDTO.setPersonAccountName( entity.getPersonAccountName() );
            partnerDTO.setBankName( entity.getBankName() );
            partnerDTO.setBankAddress( entity.getBankAddress() );
            partnerDTO.setBankBranch( entity.getBankBranch() );
            partnerDTO.setSwiftCode( entity.getSwiftCode() );
            partnerDTO.setTermDaysETDETA( entity.getTermDaysETDETA() );
            partnerDTO.setTermDaysInvoiceDate( entity.getTermDaysInvoiceDate() );
            partnerDTO.setTermDaysMonthlyDate( entity.getTermDaysMonthlyDate() );
            partnerDTO.setTermAmountForCredit( entity.getTermAmountForCredit() );
            partnerDTO.setNotes( entity.getNotes() );
            partnerDTO.setIsRefund( entity.getIsRefund() );
            partnerDTO.setBeneficiarysAddress( entity.getBeneficiarysAddress() );
            partnerDTO.setBeneficiarysName( entity.getBeneficiarysName() );
            partnerDTO.setCurrency( entity.getCurrency() );
            partnerDTO.setTermCurrencyForCredit( entity.getTermCurrencyForCredit() );
            partnerDTO.setProfileID( entity.getProfileID() );
            partnerDTO.setTermNotes( entity.getTermNotes() );
            partnerDTO.setPreferredCollectionDate( entity.getPreferredCollectionDate() );
        }
        if ( source != null ) {
            partnerDTO.setSource( source );
        }
        if ( country != null ) {
            partnerDTO.setCountry( country );
            partnerDTO.setCountryName( country.getCountryName() );
        }

        return partnerDTO;
    }
}
