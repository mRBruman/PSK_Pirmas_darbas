package vu.lt.mybatis.model;

import java.util.List;

public class Manufacturer {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.MANUFACTURER.ID
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.MANUFACTURER.NAME
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.MANUFACTURER.ID
     *
     * @return the value of PUBLIC.MANUFACTURER.ID
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.MANUFACTURER.ID
     *
     * @param id the value for PUBLIC.MANUFACTURER.ID
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.MANUFACTURER.NAME
     *
     * @return the value of PUBLIC.MANUFACTURER.NAME
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.MANUFACTURER.NAME
     *
     * @param name the value for PUBLIC.MANUFACTURER.NAME
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    public void setName(String name) {
        this.name = name;
    }

    private List<Model> models;

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
