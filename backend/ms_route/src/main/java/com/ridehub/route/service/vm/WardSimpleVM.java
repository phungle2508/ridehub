package com.ridehub.route.service.vm;

import java.io.Serializable;

/**
 * A simple DTO for the {@link com.ridehub.route.domain.Ward} entity containing only ID and name.
 */
public class WardSimpleVM implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public WardSimpleVM() {
        // Empty constructor needed for Jackson.
    }

    public WardSimpleVM(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WardSimpleVM)) {
            return false;
        }

        WardSimpleVM wardSimpleDTO = (WardSimpleVM) o;
        if (this.id == null) {
            return false;
        }
        return this.id.equals(wardSimpleDTO.id);
    }

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WardSimpleVM{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
