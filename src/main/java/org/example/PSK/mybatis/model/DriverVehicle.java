package org.example.PSK.mybatis.model;

public class DriverVehicle {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DRIVER_VEHICLE.VEHICLES_VIN
     *
     * @mbg.generated Sun Apr 28 00:59:33 EEST 2024
     */
    private String vehiclesVin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DRIVER_VEHICLE.DRIVERS_PID
     *
     * @mbg.generated Sun Apr 28 00:59:33 EEST 2024
     */
    private Long driversPid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DRIVER_VEHICLE.VEHICLES_VIN
     *
     * @return the value of PUBLIC.DRIVER_VEHICLE.VEHICLES_VIN
     *
     * @mbg.generated Sun Apr 28 00:59:33 EEST 2024
     */
    public String getVehiclesVin() {
        return vehiclesVin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DRIVER_VEHICLE.VEHICLES_VIN
     *
     * @param vehiclesVin the value for PUBLIC.DRIVER_VEHICLE.VEHICLES_VIN
     *
     * @mbg.generated Sun Apr 28 00:59:33 EEST 2024
     */
    public void setVehiclesVin(String vehiclesVin) {
        this.vehiclesVin = vehiclesVin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DRIVER_VEHICLE.DRIVERS_PID
     *
     * @return the value of PUBLIC.DRIVER_VEHICLE.DRIVERS_PID
     *
     * @mbg.generated Sun Apr 28 00:59:33 EEST 2024
     */
    public Long getDriversPid() {
        return driversPid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DRIVER_VEHICLE.DRIVERS_PID
     *
     * @param driversPid the value for PUBLIC.DRIVER_VEHICLE.DRIVERS_PID
     *
     * @mbg.generated Sun Apr 28 00:59:33 EEST 2024
     */
    public void setDriversPid(Long driversPid) {
        this.driversPid = driversPid;
    }
}