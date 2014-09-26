package thalia.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Format {
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    private String label;


    protected Format() {
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getLabel() {
        return label;
    }
}
