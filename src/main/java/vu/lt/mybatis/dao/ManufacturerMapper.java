package vu.lt.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import vu.lt.mybatis.model.Manufacturer;
@Mapper
public interface ManufacturerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    int insert(Manufacturer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    Manufacturer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    List<Manufacturer> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    int updateByPrimaryKey(Manufacturer record);
}
