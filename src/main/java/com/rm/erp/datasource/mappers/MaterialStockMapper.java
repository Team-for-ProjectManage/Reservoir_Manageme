package com.rm.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import com.rm.erp.datasource.entities.MaterialStock;
import com.rm.erp.datasource.entities.MaterialStockExample;

import java.util.List;

public interface MaterialStockMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material_stock
     *
     * @mbggenerated
     */
    int countByExample(MaterialStockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material_stock
     *
     * @mbggenerated
     */
    int deleteByExample(MaterialStockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material_stock
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material_stock
     *
     * @mbggenerated
     */
    int insert(MaterialStock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material_stock
     *
     * @mbggenerated
     */
    int insertSelective(MaterialStock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material_stock
     *
     * @mbggenerated
     */
    List<MaterialStock> selectByExample(MaterialStockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material_stock
     *
     * @mbggenerated
     */
    MaterialStock selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material_stock
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MaterialStock record, @Param("example") MaterialStockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material_stock
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MaterialStock record, @Param("example") MaterialStockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material_stock
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MaterialStock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material_stock
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MaterialStock record);
}