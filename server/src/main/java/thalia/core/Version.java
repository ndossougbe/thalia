package thalia.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Version {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(optional = false)
    private Format format;

    private String location;

    protected Version() {
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public Format getFormat() {
        return format;
    }

    @JsonProperty
    public String getLocation() {
        return location;
    }
}
