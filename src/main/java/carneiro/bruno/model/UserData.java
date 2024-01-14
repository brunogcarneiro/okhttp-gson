package carneiro.bruno.model;

import java.time.Instant;

public class UserData {
    private String company;
    private Instant createdAt;
    private String name;

    public String getCompany() {
        return company;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }
}
