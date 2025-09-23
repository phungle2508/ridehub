package com.ridehub.route.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A FileRoute.
 */
@Entity
@Table(name = "file_route")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class FileRoute implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "bucket", nullable = false)
    private String bucket;

    @NotNull
    @Column(name = "object_key", nullable = false)
    private String objectKey;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "size")
    private Long size;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "deleted_by", length = 36)
    private UUID deletedBy;

    @JsonIgnoreProperties(value = { "address", "stationImg" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "stationImg")
    private Station station;

    @JsonIgnoreProperties(value = { "seatMap", "vehicleImg" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "vehicleImg")
    private Vehicle vehicle;

    @JsonIgnoreProperties(value = { "seatMapImg", "vehicle" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "seatMapImg")
    private SeatMap seatMap;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public FileRoute id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBucket() {
        return this.bucket;
    }

    public FileRoute bucket(String bucket) {
        this.setBucket(bucket);
        return this;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public FileRoute objectKey(String objectKey) {
        this.setObjectKey(objectKey);
        return this;
    }

    public void setObjectKey(String objectKey) {
        this.objectKey = objectKey;
    }

    public String getContentType() {
        return this.contentType;
    }

    public FileRoute contentType(String contentType) {
        this.setContentType(contentType);
        return this;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getSize() {
        return this.size;
    }

    public FileRoute size(Long size) {
        this.setSize(size);
        return this;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public FileRoute createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public FileRoute updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public FileRoute isDeleted(Boolean isDeleted) {
        this.setIsDeleted(isDeleted);
        return this;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Instant getDeletedAt() {
        return this.deletedAt;
    }

    public FileRoute deletedAt(Instant deletedAt) {
        this.setDeletedAt(deletedAt);
        return this;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public UUID getDeletedBy() {
        return this.deletedBy;
    }

    public FileRoute deletedBy(UUID deletedBy) {
        this.setDeletedBy(deletedBy);
        return this;
    }

    public void setDeletedBy(UUID deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Station getStation() {
        return this.station;
    }

    public void setStation(Station station) {
        if (this.station != null) {
            this.station.setStationImg(null);
        }
        if (station != null) {
            station.setStationImg(this);
        }
        this.station = station;
    }

    public FileRoute station(Station station) {
        this.setStation(station);
        return this;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        if (this.vehicle != null) {
            this.vehicle.setVehicleImg(null);
        }
        if (vehicle != null) {
            vehicle.setVehicleImg(this);
        }
        this.vehicle = vehicle;
    }

    public FileRoute vehicle(Vehicle vehicle) {
        this.setVehicle(vehicle);
        return this;
    }

    public SeatMap getSeatMap() {
        return this.seatMap;
    }

    public void setSeatMap(SeatMap seatMap) {
        if (this.seatMap != null) {
            this.seatMap.setSeatMapImg(null);
        }
        if (seatMap != null) {
            seatMap.setSeatMapImg(this);
        }
        this.seatMap = seatMap;
    }

    public FileRoute seatMap(SeatMap seatMap) {
        this.setSeatMap(seatMap);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FileRoute)) {
            return false;
        }
        return getId() != null && getId().equals(((FileRoute) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FileRoute{" +
            "id=" + getId() +
            ", bucket='" + getBucket() + "'" +
            ", objectKey='" + getObjectKey() + "'" +
            ", contentType='" + getContentType() + "'" +
            ", size=" + getSize() +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", isDeleted='" + getIsDeleted() + "'" +
            ", deletedAt='" + getDeletedAt() + "'" +
            ", deletedBy='" + getDeletedBy() + "'" +
            "}";
    }
}
