package com.jhona.jobs.usecase.company;

import com.jhona.jobs.common.DtoResponse;
import com.jhona.jobs.domain.Company;
import com.jhona.jobs.dto.response.CompanyDTO;
import com.jhona.jobs.dto.response.PageCompanyDTO;
import com.jhona.jobs.services.company.ICompanyService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetCompaniesUseCase {
    private final ICompanyService companyService;

    public GetCompaniesUseCase(ICompanyService companyService) {
        this.companyService = companyService;
    }

    public DtoResponse<PageCompanyDTO> execute() {
        PageCompanyDTO pageCompanyDTO = new PageCompanyDTO();
        Page<Company> companyPage = companyService.getAllCompanies();
        System.out.println(companyPage.getNumber());
        List<CompanyDTO> companyDTOList = buildCompanyDtoList(companyPage.getContent());
        pageCompanyDTO.setCompanies(companyDTOList);
        pageCompanyDTO.setTotalPages(companyPage.getTotalPages());
        pageCompanyDTO.setTotalItems(companyPage.getTotalElements());
        return buildDtoResponsePage(pageCompanyDTO);
    }

    private DtoResponse<PageCompanyDTO> buildDtoResponsePage(PageCompanyDTO pageCompanyDTO) {
        DtoResponse<PageCompanyDTO> pageCompanyResponse = new DtoResponse<>();
        pageCompanyResponse.setContent(pageCompanyDTO);
        return pageCompanyResponse;
    }

    private List<CompanyDTO> buildCompanyDtoList(List<Company> companyList) {
        List<CompanyDTO> dtoList = new ArrayList<>();
        companyList.forEach(company -> {
            CompanyDTO companyDTO = new CompanyDTO();
            companyDTO.setId(company.getId());
            companyDTO.setName(company.getName());
            companyDTO.setLogo(company.getLogo());
            companyDTO.setLocation(company.getLocation());
            dtoList.add(companyDTO);
        });
        return dtoList;
    }
}
