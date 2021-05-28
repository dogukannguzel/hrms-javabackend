package kodlamaio.hrms.core.adapters.concretes;

import kodlamaio.hrms.core.adapters.abstracts.UserRealCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.mernis.EQQKPSPublicSoap;
import org.springframework.stereotype.Component;




@Component
public class UserRealCheckManager implements UserRealCheckService {
    @Override
    public boolean checkIfRealPerson(Candidate user)  {

      /*  long identityNumber = Long.parseLong(user.getIdentificationNumber());
        String firstName=user.getFirstName();
        String lastName = user.getLastName();
        int dateOfBirth = user.getBirthDate().getYear();

        EQQKPSPublicSoap soap = new EQQKPSPublicSoap();

        boolean result = false;
        try {
            result = soap.TCKimlikNoDogrula(identityNumber,firstName,lastName,dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        return true;
    }
}
