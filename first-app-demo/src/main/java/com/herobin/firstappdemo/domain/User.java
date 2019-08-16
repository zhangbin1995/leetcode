package com.herobin.firstappdemo.domain;

import lombok.Data;

/**
 * 用户模型
 *
 * @author binzhang
 * @date 2019-08-16
 */
@Data
public class User {

    private int id;

    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
