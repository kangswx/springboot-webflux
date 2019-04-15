package com.swkang.springboot.springbootwebflux.service;

import com.swkang.springboot.springbootwebflux.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> dataMap = new HashMap<>();

    static {
        dataMap.put("1", new User("1", "name1"));
        dataMap.put("2", new User("2", "name2"));
        dataMap.put("3", new User("3", "name3"));
        dataMap.put("4", new User("4", "name4"));
    }

    /**
     * 返回用户列表
     * @return
     */
    public Flux<User> list(){
        Collection<User> list = UserService.dataMap.values();
        return Flux.fromIterable(list);
    }

    /**
     * 根据id一个对象,返回一个对象或空
     * @param id
     * @return
     */
    public Mono<User> getById(final String id){
        return Mono.justOrEmpty(UserService.dataMap.get(id));
    }

    /**
     * 删除一个对象
     * @param id
     * @return
     */
    public Mono<User> delete(final String id){
        return Mono.justOrEmpty(UserService.dataMap.remove(id));
    }

}
