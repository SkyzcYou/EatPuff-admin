package cn.ep.eatpuff.mapper;

import cn.ep.eatpuff.entity.GiftDayEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/9/30
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Repository
@Mapper
public interface GiftDayMapper {
//    @Select("select * from gift_day")
    // 查询所有礼物日
    List<GiftDayEntity> findAll();

//    @Select("select * from gift_day where month='8'")
    // 查询当前月份的礼物日
    GiftDayEntity findByMonth(int month);

    // 创建礼物日
    void createGiftDay(@Param("month") int month, @Param("day") int day);

    //上锁
//    void setLock(int month);
    int getGiftDayByMonth(int month);
}