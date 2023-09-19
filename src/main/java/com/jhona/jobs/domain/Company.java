package com.jhona.jobs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jhona.jobs.domain.constants.ConstantsTableNames;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = ConstantsTableNames.CompanyTable.COMPANY_TABLE_NAME)
@Getter
@Setter
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Company extends BaseEntity {
    @Column(name = ConstantsTableNames.CompanyTable.NAME, nullable = false, unique = true)
    private String name;

    @Column(name = ConstantsTableNames.CompanyTable.LOCATION, nullable = false)
    private String location;

    @Column(name = ConstantsTableNames.CompanyTable.LOGO, nullable = false)
    private String logo;

    @OneToMany(mappedBy = "company")
    private Set<Job> jobs;

    @OneToMany(mappedBy = "company")
    private Set<SocialMedia> socialMediaSet;
}
