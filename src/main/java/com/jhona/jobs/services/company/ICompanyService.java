package com.jhona.jobs.services.company;

import com.jhona.jobs.domain.Company;

import java.util.List;
import java.util.Optional;

public interface ICompanyService {
    Optional<Company> findById(Long id);

    Company save(Company company);

    List<Company> getAllCountries();
}
