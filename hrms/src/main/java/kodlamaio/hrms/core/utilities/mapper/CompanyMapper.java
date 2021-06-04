package kodlamaio.hrms.core.utilities.mapper;

import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.dtos.CompanyRegisterDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company dtoToModel(CompanyRegisterDto companyRegisterDto);


}
