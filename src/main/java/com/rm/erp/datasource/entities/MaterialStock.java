package com.rm.erp.datasource.entities;

import java.math.BigDecimal;

public class MaterialStock {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_material_stock.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_material_stock.material_id
     *
     * @mbggenerated
     */
    private Long materialId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_material_stock.depot_id
     *
     * @mbggenerated
     */
    private Long depotId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_material_stock.number
     *
     * @mbggenerated
     */
    private BigDecimal number;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_material_stock.tenant_id
     *
     * @mbggenerated
     */
    private Long tenantId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_material_stock.delete_fag
     *
     * @mbggenerated
     */
    private String deleteFag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_material_stock.id
     *
     * @return the value of jsh_material_stock.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_material_stock.id
     *
     * @param id the value for jsh_material_stock.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_material_stock.material_id
     *
     * @return the value of jsh_material_stock.material_id
     *
     * @mbggenerated
     */
    public Long getMaterialId() {
        return materialId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_material_stock.material_id
     *
     * @param materialId the value for jsh_material_stock.material_id
     *
     * @mbggenerated
     */
    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_material_stock.depot_id
     *
     * @return the value of jsh_material_stock.depot_id
     *
     * @mbggenerated
     */
    public Long getDepotId() {
        return depotId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_material_stock.depot_id
     *
     * @param depotId the value for jsh_material_stock.depot_id
     *
     * @mbggenerated
     */
    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_material_stock.number
     *
     * @return the value of jsh_material_stock.number
     *
     * @mbggenerated
     */
    public BigDecimal getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_material_stock.number
     *
     * @param number the value for jsh_material_stock.number
     *
     * @mbggenerated
     */
    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_material_stock.tenant_id
     *
     * @return the value of jsh_material_stock.tenant_id
     *
     * @mbggenerated
     */
    public Long getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_material_stock.tenant_id
     *
     * @param tenantId the value for jsh_material_stock.tenant_id
     *
     * @mbggenerated
     */
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_material_stock.delete_fag
     *
     * @return the value of jsh_material_stock.delete_fag
     *
     * @mbggenerated
     */
    public String getDeleteFag() {
        return deleteFag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_material_stock.delete_fag
     *
     * @param deleteFag the value for jsh_material_stock.delete_fag
     *
     * @mbggenerated
     */
    public void setDeleteFag(String deleteFag) {
        this.deleteFag = deleteFag == null ? null : deleteFag.trim();
    }
}