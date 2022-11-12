package com.jason.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jason.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
}
