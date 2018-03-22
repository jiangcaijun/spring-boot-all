package com.joe.mybatis.mapper;

import com.joe.mybatis.model.PageDo;
import com.joe.mybatis.model.Zcdc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ZcdcMapper {
    int deleteByPrimaryKey(String zxUuid);

    int deleteByPrimaryKeyList(List<String> zxUuid);

    int insert(Zcdc record);

    int insertSelective(Zcdc record);

    Zcdc selectByPrimaryKey(String zxUuid);

    int updateByPrimaryKeySelective(Zcdc record);

    int updateByPrimaryKey(Zcdc record);

    List<Object> findPageDo(PageDo pageDo);

    int findPageDoCount(PageDo pageDo);

    /**
     * 获取最大的zxCode
     * @return
     */
    String queryMaxZxCode();

    int updateStatusu2Stop(@Param(value = "list") List<String> idList);
}