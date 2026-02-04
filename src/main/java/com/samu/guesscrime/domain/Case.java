package com.samu.guesscrime.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

// domain/Case.java
@Document("cases")
@Data
public class Case {
    @Id
    private String id;
    private String title;
    private List<String> suspects;
    private List<String> locations;
    private List<String> weapons;
    private Solution solution;
    private List<Hint> hints;
    private String difficulty;
    private Instant createdAt = Instant.now();

    @Data
    public static class Solution {
        private String suspect;
        private String location;
        private String weapon;
    }

    @Data
    public static class Hint {
        private String id;
        private HintType type; // ELIMINATION | CONFIRMATION | RELATIONAL
        private Target target; // para ELIM/CONF
        private String text;

        @Data
        public static class Target {
            private String category; // suspect | location | weapon
            private String value;
        }
    }

    public enum HintType { ELIMINATION, CONFIRMATION, RELATIONAL }
}
