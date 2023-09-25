package com.jhona.jobs.services.company;

import com.jhona.jobs.domain.Company;
import com.jhona.jobs.repository.CompanyRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements ICompanyService {
    Pageable secondPageWithFiveElements = PageRequest.of(0, 5);
    private final CompanyRepository companyRepository;

    public CountryServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCountries() {
        return companyRepository.findAllByName("name", secondPageWithFiveElements);
    }
}
