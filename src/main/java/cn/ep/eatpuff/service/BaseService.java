package cn.ep.eatpuff.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findByMonth(int month);
    int getGiftDayByMonth(int month);
    int create(int month);
    void delete(int... month);
    void update(T t);
}
