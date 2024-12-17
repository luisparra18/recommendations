package com.system.recommendations.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {

    private Integer id = 0;
    private String title = "";
    private String description = "";
}
