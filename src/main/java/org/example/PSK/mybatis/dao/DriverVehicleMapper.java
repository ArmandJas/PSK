package org.example.PSK.mybatis.dao;

import java.util.List;
import org.example.PSK.mybatis.model.DriverVehicle;
import org.mybatis.cdi.Mapper;

@Mapper
public interface DriverVehicleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DRIVER_VEHICLE
     *
     * @mbg.generated Sun Apr 28 00:59:33 EEST 2024
     */
    int insert(DriverVehicle row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DRIVER_VEHICLE
     *
     * @mbg.generated Sun Apr 28 00:59:33 EEST 2024
     */
    List<DriverVehicle> selectAll();
}