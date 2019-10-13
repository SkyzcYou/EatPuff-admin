package cn.ep.eatpuff.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/9/30
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class GiftDayEntity implements Serializable {
    private int month;
    private int day;
    private Date create_time;
    private boolean is_lock;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public boolean isIs_lock() {
        return is_lock;
    }

    public void setIs_lock(boolean is_lock) {
        this.is_lock = is_lock;
    }
}