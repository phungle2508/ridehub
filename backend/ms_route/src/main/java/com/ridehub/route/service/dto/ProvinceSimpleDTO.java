package com.ridehub.route.service.dto;

import java.io.Serializable;

/**
 * A simple DTO for the {@link com.ridehub.route.domain.Province} entity containing only ID and name.
 */
public class ProvinceSimpleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public ProvinceSimpleDTO() {
        // Empty constructor needed for Jackson.
    }

    public ProvinceSimpleDTO(Long id, String name) {
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
        if (!(o instanceof ProvinceSimpleDTO)) {
            return false;
        }

        ProvinceSimpleDTO provinceSimpleDTO = (ProvinceSimpleDTO) o;
        if (this.id == null) {
            return false;
        }
        return this.id.equals(provinceSimpleDTO.id);
    }

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ProvinceSimpleDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
