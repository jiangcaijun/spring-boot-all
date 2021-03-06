package com.joe.mapper;

import com.joe.model.ApiQuartz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApiQuartzMapper {

    /**
     * 获取所有数据
     * @return
     */
    List<ApiQuartz> selectAll();

}