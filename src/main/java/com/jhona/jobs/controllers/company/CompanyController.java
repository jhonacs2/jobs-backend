package com.jhona.jobs.controllers.company;

import com.jhona.jobs.common.DtoResponse;
import com.jhona.jobs.dto.request.CompanyRequest;
import com.jhona.jobs.dto.response.CompanyDTO;
import com.jhona.jobs.dto.response.PageCompanyDTO;
import com.jhona.jobs.usecase.company.CreateCompanyUseCase;
import com.jhona.jobs.usecase.company.GetCompaniesUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private final CreateCompanyUseCase createCompanyUseCase;
    private final GetCompaniesUseCase getCompaniesUseCase;

    public CompanyController(CreateCompanyUseCase createCompanyUseCase,
                             GetCompaniesUseCase getCompaniesUseCase) {
        this.createCompanyUseCase = createCompanyUseCase;
        this.getCompaniesUseCase = getCompaniesUseCase;
    }

    @PostMapping
    public ResponseEntity<DtoResponse<CompanyDTO>> saveCompany(@RequestBody CompanyRequest companyRequest) {
        DtoResponse<CompanyDTO> dtoResponse = createCompanyUseCase.execute(companyRequest);
        return ResponseEntity.ok(dtoResponse);
    }

    @GetMapping
    public ResponseEntity<DtoResponse<PageCompanyDTO>> getCountries() {
        DtoResponse<PageCompanyDTO> listDtoResponse = getCompaniesUseCase.execute();
        return ResponseEntity.ok(listDtoResponse);
    }
}
