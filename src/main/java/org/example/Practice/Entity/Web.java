package org.example.Practice.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Web {
    private int id;
    private String title;
    private String id_coocies;
}
