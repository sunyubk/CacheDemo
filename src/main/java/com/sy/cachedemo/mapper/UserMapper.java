package com.sy.cachedemo.mapper;

import com.sy.cachedemo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 孙宇
 * @since 2023-07-31
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
