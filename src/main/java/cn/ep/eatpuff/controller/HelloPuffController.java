package cn.ep.eatpuff.controller;

import cn.ep.eatpuff.entity.GiftDayEntity;
import cn.ep.eatpuff.mapper.GiftDayMapper;
import cn.ep.eatpuff.service.GiftDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/9/22
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 * Description:
 */
//跨域请求
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class HelloPuffController {
    @Autowired GiftDayService giftDayService;
    @Autowired GiftDayMapper giftDayMapper;

    @RequestMapping("/AllGiftDay")
    public List<GiftDayEntity> findAll(){
        return giftDayService.findAll();
    }

    @RequestMapping(value = "/nowGiftDay",method = RequestMethod.GET)
    public GiftDayEntity nowGiftDay(@RequestParam("month") int month) throws Exception{
        GiftDayEntity giftDaysEntity = giftDayService.findByMonth(month);
        return giftDaysEntity;
    }
    @RequestMapping(value = "/giftDay/{month}")
    public int getGiftDayByMonth(@PathVariable Integer month) throws Exception{
        return giftDayService.getGiftDayByMonth(month);
    }

    @RequestMapping(value = "/giftDay/add")
    public int addGiftDay(@RequestParam("month") Integer month){
        return giftDayService.create(month);
    }
}