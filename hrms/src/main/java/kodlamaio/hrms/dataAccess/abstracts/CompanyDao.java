package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Company;

public interface CompanyDao extends UserDao<kodlamaio.hrms.entities.concretes.Company> {
    Company findAllByEmail(String email);
    Company findAllById(int id);

}
