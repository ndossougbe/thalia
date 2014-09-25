package thalia.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Media {
    private long id;

    @Length(min = 3)
    private String title;

    public Media() {
    }

    public Media(long id, String title) {
        this.id = id;
        this.title = title;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }
}
