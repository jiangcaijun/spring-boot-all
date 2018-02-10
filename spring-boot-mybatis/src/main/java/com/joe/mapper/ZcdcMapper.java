package com.joe.mapper;

import com.joe.models.PageDo;
import com.joe.models.Zcdc;
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