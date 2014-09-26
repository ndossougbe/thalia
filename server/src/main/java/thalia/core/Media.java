package thalia.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries(
        @NamedQuery(name = "thalia.core.Media.findAll", query = "select m from Media m")
)
public class Media {
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    private String title;

    @Transient
    private MediaType type;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Version> versions = new HashSet<>();

    @Column(columnDefinition = "LONG VARCHAR")
    private String description;

    protected Media() {
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

    public MediaType getType() {
        return type;
    }

    @JsonProperty
    public Set<Genre> getGenres() {
        return genres;
    }

    @JsonProperty
    public Set<Version> getVersions() {
        return versions;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }
}
