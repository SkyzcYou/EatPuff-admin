package cn.ep.eatpuff.service.impl;

import cn.ep.eatpuff.entity.GiftDayEntity;
import cn.ep.eatpuff.mapper.GiftDayMapper;
import cn.ep.eatpuff.service.GiftDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/10/1
 * Time: 19:46
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class GiftDayServiceImpl implements GiftDayService {

    @Autowired
    private GiftDayMapper giftDayMapper;

    @Override
    public List<GiftDayEntity> findAll() {
        return giftDayMapper.findAll();
    }

    @Override
    public GiftDayEntity findByMonth(int month) {
        GiftDayEntity giftDayEntity = giftDayMapper.findByMonth(month);
        // 判断有无这个 month
        if (giftDayEntity == null){
            System.out.println("该月无数据");
        }
        if (giftDayEntity.isIs_lock()){
            giftDayEntity.setDay(00);
        }
        return giftDayEntity;
    }

    @Override
    public int getGiftDayByMonth(int month) {
        int day =0 ;
        try {
            day = giftDayMapper.getGiftDayByMonth(month);
        }catch (Exception e){
            System.out.println("服务器错误："+ e);
        }
        return day;
    }


    @Override
    public int create(int month) {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        int randomDay=new Random().nextInt(maxDate)+1;
        int day = randomDay;
        System.out.println(month +"中国" + day);
        giftDayMapper.createGiftDay(month,day);
        return day;
    }

    @Override
    public void delete(int... month) {

    }

    @Override
    public void update(GiftDayEntity giftDayEntity) {

    }

}