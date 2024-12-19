package org.example.Practice.Servlets;

import lombok.*;

@Data
@AllArgsConstructor(staticName = "of")
@Builder
@RequiredArgsConstructor(staticName = "of2")
public class User {
    @NonNull
    private  Long id;
    private String name;
    private String secondName;
    private int age;
}
