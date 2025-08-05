package com.zhc.controller;

import com.zhc.common.properties.JwtProperties;
import com.zhc.common.result.Result;
import com.zhc.common.util.JwtUtil;
import com.zhc.entity.User;
import com.zhc.entity.vo.UserLoginVo;
import com.zhc.service.ShoppingCartService;
import com.zhc.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private UserService userService;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Transactional
    @PostMapping("/login")
    public Result<UserLoginVo> login(@RequestBody User user) {
        String username = user.getUsername();
        User returnUser = userService.findByUsername(username);
        if(returnUser != null) {
            if(returnUser.getPassword().equals(user.getPassword())) {
                UserLoginVo userLoginVo = new UserLoginVo();
                BeanUtils.copyProperties(returnUser, userLoginVo);
                Map<String, Object> claims = new HashMap<>();
                claims.put("userId",returnUser.getId());
                String token = JwtUtil.createJwt(claims, jwtProperties.getTimeMill(), jwtProperties.getSecretKey());
                userLoginVo.setToken(token);
                userLoginVo.setNumInCart(shoppingCartService.findNumByUserId(returnUser.getId()));
                return Result.success(userLoginVo);
            }else {
                return Result.error("密码错误");
            }
        }else{
            return Result.error("帐号不存在");
        }
    }

    /*@GetMapping("/checkUsername")
    public Result checkUsername(String username) {
        User returnUser = userService.findByUsername(username);
        if(returnUser == null) {
            return Result.error("");
        }else{
            return Result.success("用户已存在");//根据用户名查到该用户说明该用户已存在，返回给前端200
        }
    }*/

    @Transactional
    @PostMapping("/regist")
    public Result regist(@RequestBody User user) {
        if(userService.findByUsername(user.getUsername()) == null){
            userService.insert(user);
            User returnUser = userService.findByUsername(user.getUsername());
            if(returnUser != null) {
                return Result.success();
            }else{
                return Result.error("注册失败");
            }
        }else{
            return Result.error("用户已存在");//根据用户名查到该用户说明该用户已存在
        }

    }

}
