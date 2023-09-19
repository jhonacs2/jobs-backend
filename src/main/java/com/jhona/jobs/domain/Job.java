package com.jhona.jobs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jhona.jobs.domain.constants.ConstantsTableNames;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = ConstantsTableNames.JobTable.JOB_TABLE_NAME)
@Getter
@Setter
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Job extends BaseEntity {
    @Column(name = ConstantsTableNames.JobTable.DESCRIPTION)
    private String description;

    @Column(name = ConstantsTableNames.JobTable.TYPE)
    private String type;

    @Column(name = ConstantsTableNames.JobTable.REQUIREMENTS)
    private String requirements;

    @Column(name = ConstantsTableNames.JobTable.CREATED_AT)
    private String created_at;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

}
