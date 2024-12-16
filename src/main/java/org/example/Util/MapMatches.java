package org.example.Util;

import lombok.experimental.UtilityClass;
import org.example.DTO.MatchScore;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@UtilityClass
public class MapMatches {
    public static final Map<UUID, MatchScore> matchMap = new ConcurrentHashMap<>();
}
