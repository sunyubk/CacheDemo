package com.sy.cachedemo.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sy.cachedemo.service.UserService;
import com.sy.cachedemo.entity.User;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 孙宇
 * @since 2023-07-31
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
    * 新增或更新
    */
    @PostMapping("/saveOrUpdata")
    public boolean save(@RequestBody User user) {
        return  userService.saveOrUpdate(user);
    }

    /**
    * 根据id删除
    */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    /**
    * 根据id集合删除
    */
    @PostMapping("/delByIds")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return userService.removeByIds(ids);
    }

    /**
    * 查询所有
    */
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.list();
    }

    /**
    * 根据id查询
    */
    @GetMapping("/{id}")
    public User findOne(@PathVariable Integer id) {
        return userService.getById(id);
    }

    /**
    * 分页查询
    */
    @GetMapping("/page")
    public Page<User> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return userService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}
