package com.adtiming.om.ds.model;

public class OmInstanceChangeKey {
    private Integer id;

    private String placementKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlacementKey() {
        return placementKey;
    }

    public void setPlacementKey(String placementKey) {
        this.placementKey = placementKey == null ? null : placementKey.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OmInstanceChangeKey other = (OmInstanceChangeKey) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPlacementKey() == null ? other.getPlacementKey() == null : this.getPlacementKey().equals(other.getPlacementKey()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlacementKey() == null) ? 0 : getPlacementKey().hashCode());
        return result;
    }
}