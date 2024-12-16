package org.example.DTO;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchScore {
    private Integer idMatch;
    private List<MatchPlayer> players;
    private Long winnerId;
    private String winner;

}
