package us.fok.lenzenslijper.models.dto;

import us.fok.lenzenslijper.models.immutable.ProjectRecord;

import java.util.UUID;

public class MutableProjectRecord implements ProjectRecord {

    UUID id;
    String name;
    String slug;

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

}
