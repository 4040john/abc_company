package com.company.abc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Data
@Builder
public class TeamInsertDTO {


    private String name;

    private Long companyId;
}
