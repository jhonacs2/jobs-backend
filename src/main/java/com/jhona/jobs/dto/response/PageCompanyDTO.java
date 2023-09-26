package com.jhona.jobs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageCompanyDTO {
    private List<CompanyDTO> companies;
    private Long totalItems;
    private Integer totalPages;
}
