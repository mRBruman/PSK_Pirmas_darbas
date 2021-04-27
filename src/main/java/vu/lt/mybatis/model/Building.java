package vu.lt.mybatis.model;

public class Building {

    private Manufacturer manufacturer;

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BUILDING.ID
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BUILDING.ADDRESS
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BUILDING.BUILD_YEAR
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    private Integer buildYear;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BUILDING.MANUFACTURER_ID
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    private Integer manufacturerId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BUILDING.ID
     *
     * @return the value of PUBLIC.BUILDING.ID
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BUILDING.ID
     *
     * @param id the value for PUBLIC.BUILDING.ID
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BUILDING.ADDRESS
     *
     * @return the value of PUBLIC.BUILDING.ADDRESS
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BUILDING.ADDRESS
     *
     * @param address the value for PUBLIC.BUILDING.ADDRESS
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BUILDING.BUILD_YEAR
     *
     * @return the value of PUBLIC.BUILDING.BUILD_YEAR
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    public Integer getBuildYear() {
        return buildYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BUILDING.BUILD_YEAR
     *
     * @param buildYear the value for PUBLIC.BUILDING.BUILD_YEAR
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    public void setBuildYear(Integer buildYear) {
        this.buildYear = buildYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BUILDING.MANUFACTURER_ID
     *
     * @return the value of PUBLIC.BUILDING.MANUFACTURER_ID
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    public Integer getManufacturerId() {
        return manufacturerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BUILDING.MANUFACTURER_ID
     *
     * @param manufacturerId the value for PUBLIC.BUILDING.MANUFACTURER_ID
     *
     * @mbg.generated Mon Apr 26 23:26:16 EEST 2021
     */
    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}
