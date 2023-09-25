package com.jhona.jobs.controllers.company;

import com.jhona.jobs.common.DtoResponse;
import com.jhona.jobs.dto.request.CompanyRequest;
import com.jhona.jobs.dto.response.CompanyDTO;
import com.jhona.jobs.usecase.company.CreateCompanyUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private final CreateCompanyUseCase createCompanyUseCase;

    public CompanyController(CreateCompanyUseCase createCompanyUseCase) {
        this.createCompanyUseCase = createCompanyUseCase;
    }

    @PostMapping
    public ResponseEntity<DtoResponse<CompanyDTO>> saveCompany(@RequestBody CompanyRequest companyRequest) {
        DtoResponse<CompanyDTO> dtoResponse = createCompanyUseCase.execute(companyRequest);
        return ResponseEntity.ok(dtoResponse);
    }
}
