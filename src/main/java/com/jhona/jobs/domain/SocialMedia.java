package com.jhona.jobs.domain;

import constants.ConstantsTableNames;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = ConstantsTableNames.SocialMediaTable.SOCIAL_TABLE_NAME)
@Getter
@Setter
public class SocialMedia extends BaseEntity {
    @Column(name = ConstantsTableNames.SocialMediaTable.NAME, nullable = false)
    private String name;

    @Column(name = ConstantsTableNames.SocialMediaTable.URL, nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
