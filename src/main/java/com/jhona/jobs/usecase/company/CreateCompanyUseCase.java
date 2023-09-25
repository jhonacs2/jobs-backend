package com.jhona.jobs.usecase.company;

import com.jhona.jobs.common.DtoResponse;
import com.jhona.jobs.domain.Company;
import com.jhona.jobs.dto.request.CompanyRequest;
import com.jhona.jobs.dto.response.CompanyDTO;
import com.jhona.jobs.services.company.ICompanyService;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {
    private final ICompanyService companyService;

    public CreateCompanyUseCase(ICompanyService companyService) {
        this.companyService = companyService;
    }

    public DtoResponse<CompanyDTO> execute(CompanyRequest companyRequest) {
        Company company = companyService.save(buildCompany(companyRequest));
        return buildCompanyResponse(company);
    }

    private DtoResponse<CompanyDTO> buildCompanyResponse(Company company) {
        DtoResponse<CompanyDTO> companyResponse = new DtoResponse<>();

        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());
        companyDTO.setLogo(company.getLogo());
        companyDTO.setLocation(company.getLocation());

        companyResponse.setContent(companyDTO);

        return companyResponse;
    }

    private Company buildCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setLogo(companyRequest.getLogo());
        company.setLocation(companyRequest.getLocation());
        return company;
    }
}
