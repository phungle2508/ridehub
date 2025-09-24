package com.ridehub.route.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for filtering station list requests.
 */
public class StationFilterDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String searchQuery; // Tìm kiếm theo tên trạm, địa chỉ
    private List<String> stationTypes; // Lọc theo loại trạm (Dón/Trả, Pickup, Drop-off)
    private List<String> routes; // Lọc theo tuyến đường
    private List<String> statuses; // Lọc theo trạng thái (Hoạt động, Đã ngưng)
    private String sortBy; // Sắp xếp theo: stationName, routeName, orderInRoute, etc.
    private String sortDirection; // ASC hoặc DESC

    // Default constructor
    public StationFilterDTO() {}

    // Getters and Setters
    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public List<String> getStationTypes() {
        return stationTypes;
    }

    public void setStationTypes(List<String> stationTypes) {
        this.stationTypes = stationTypes;
    }

    public List<String> getRoutes() {
        return routes;
    }

    public void setRoutes(List<String> routes) {
        this.routes = routes;
    }

    public List<String> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<String> statuses) {
        this.statuses = statuses;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    @Override
    public String toString() {
        return "StationFilterDTO{" +
            "searchQuery='" + searchQuery + '\'' +
            ", stationTypes=" + stationTypes +
            ", routes=" + routes +
            ", statuses=" + statuses +
            ", sortBy='" + sortBy + '\'' +
            ", sortDirection='" + sortDirection + '\'' +
            '}';
    }
}
