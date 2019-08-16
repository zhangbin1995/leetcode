package com.herobin.firstappdemo.repository;

import com.herobin.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author binzhang
 * @date 2019-08-16
 */
@Repository
public class UserRepository {

    /**
     * 采用内存型的存储方式 -> Map
     */
    private final ConcurrentHashMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户对象
     * @param user
     * @return
     */
    public boolean save(User user) {
        // ID 从 1 开始
        Integer id = idGenerator.incrementAndGet();
        // 设置ID
        user.setId(id);
        return repository.put(id, user) == null;
    }

    /**
     * 返回所有用户列表
     * @return
     */
    public Collection<User> findAll() {
        return repository.values();
    }
}
