package com.oa.cis.entity;

import java.io.Serializable;

public class Form implements Serializable {
    //表单表id
    private Integer id;

    //
    private String designName;

    //
    private String vendorName;

    //
    private String vendorPN;

    //
    private String description;
    //
    private Boolean critical;

    //
    private String multipleSourceInfo;

    //
    private String comments;

    //
    private String datasheet;
    //
    private String logicalSymbol;

    //
    private String footprint;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignName() {
        return designName;
    }

    public void setDesignName(String designName) {
        this.designName = designName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorPN() {
        return vendorPN;
    }

    public void setVendorPN(String vendorPN) {
        this.vendorPN = vendorPN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCritical() {
        return critical;
    }

    public void setCritical(Boolean critical) {
        this.critical = critical;
    }

    public String getMultipleSourceInfo() {
        return multipleSourceInfo;
    }

    public void setMultipleSourceInfo(String multipleSourceInfo) {
        this.multipleSourceInfo = multipleSourceInfo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDatasheet() {
        return datasheet;
    }

    public void setDatasheet(String datasheet) {
        this.datasheet = datasheet;
    }

    public String getLogicalSymbol() {
        return logicalSymbol;
    }

    public void setLogicalSymbol(String logicalSymbol) {
        this.logicalSymbol = logicalSymbol;
    }

    public String getFootprint() {
        return footprint;
    }

    public void setFootprint(String footprint) {
        this.footprint = footprint;
    }
}
