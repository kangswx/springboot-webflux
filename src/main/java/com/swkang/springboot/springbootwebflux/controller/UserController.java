package com.swkang.springboot.springbootwebflux.controller;

import com.swkang.springboot.springbootwebflux.domain.User;
import com.swkang.springboot.springbootwebflux.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    /**
     * 根据类型注入
     * @return
     */
   /* @Autowired
    private UserService userService;*/

    /**
     * 通过构造方法进行注入
     * @param userService
     */
    private final UserService userService;
    public UserController(final UserService userService){
        this.userService = userService;
    }

    @GetMapping("find")
    public Mono<User> findById(final String id){
        return userService.getById(id);
    }

    @GetMapping("list")
    public Flux<User> list(){
        return userService.list();
    }

    @GetMapping("delete")
    public Mono<User> delete(final String id){
        return userService.delete(id);
    }

    @GetMapping("test")
    public Mono<String> test(){
        return Mono.just("hello swkang");
    }


}
