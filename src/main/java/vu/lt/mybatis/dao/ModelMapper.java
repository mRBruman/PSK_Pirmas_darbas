package vu.lt.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import vu.lt.mybatis.model.Model;
@Mapper
public interface ModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    int insert(Model record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    Model selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    List<Model> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    int updateByPrimaryKey(Model record);
}
