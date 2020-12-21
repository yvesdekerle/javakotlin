package com.ydekerle.javakotlin;

import java.time.OffsetDateTime;
import java.util.Objects;

public class Launch {

    private String id;
    private String name;
    private OffsetDateTime dateUtc;
    private Boolean success;

    public Launch() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getDateUtc() {
        return dateUtc;
    }

    public void setDateUtc(OffsetDateTime dateUtc) {
        this.dateUtc = dateUtc;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Launch launch = (Launch) o;
        return Objects.equals(id, launch.id) && Objects.equals(name, launch.name) && Objects.equals(dateUtc, launch.dateUtc) && Objects.equals(success, launch.success);
    }
}
