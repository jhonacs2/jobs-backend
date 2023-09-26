package com.jhona.jobs.services.company;

import com.jhona.jobs.domain.Company;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ICompanyService {
    Optional<Company> findById(Long id);

    Company save(Company company);

    Page<Company> getAllCompanies();
}
