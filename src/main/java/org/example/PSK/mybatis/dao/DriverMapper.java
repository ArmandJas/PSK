package org.example.PSK.mybatis.dao;

import java.util.List;

import org.example.PSK.mybatis.model.Vehicle;
import org.example.PSK.mybatis.model.Driver;
import org.example.PSK.mybatis.model.Fare;
import org.mybatis.cdi.Mapper;

@Mapper
public interface DriverMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DRIVER
     *
     * @mbg.generated Sat Apr 27 19:47:12 EEST 2024
     */
    int deleteByPrimaryKey(Long pid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DRIVER
     *
     * @mbg.generated Sat Apr 27 19:47:12 EEST 2024
     */
    int insert(Driver row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DRIVER
     *
     * @mbg.generated Sat Apr 27 19:47:12 EEST 2024
     */
    Driver selectByPrimaryKey(Long pid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DRIVER
     *
     * @mbg.generated Sat Apr 27 19:47:12 EEST 2024
     */
    List<Driver> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DRIVER
     *
     * @mbg.generated Sat Apr 27 19:47:12 EEST 2024
     */
    int updateByPrimaryKey(Driver row);

    List<Vehicle> selectVehiclesAssignedToDriver(Long pid);
    List<Fare> selectAllOrdersForDriver(Long pid);
}