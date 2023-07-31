package com.sy.cachedemo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

/**
 * @ClassName Generator
 * @Description
 * @Author sunyu
 * @Date 2023/7/31 18:20
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class Generator {

    @Test
    public void generator() {
        // 创建一个代码生成器
        FastAutoGenerator.create(
                        "jdbc:mysql://123.57.45.239:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=GMT%2B8",
                        "root",
                        "root")
                .globalConfig(builder -> {
                    builder.author("孙宇")
                            // 时间类型
                            .dateType(DateType.TIME_PACK)
                            // 注释日期
                            .commentDate("yyyy-MM-dd")
                            // 指定的输出目录，一般指定到java目录
                            .outputDir("/Users/sunyu/WorkSpace/IdeaProjects/CacheDemo/src/main/java")
                            .fileOverride();
                })
                // 包配置项
                .packageConfig(builder -> {
                    // 设置父包名
                    builder.parent("com.sy.cachedemo")
                            // 模块名称，一般不设置
                            .moduleName("")
                            // 设置mapper.xml生成路径，这里是Mapper配置文件的路径，建议使用绝对路径
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/sunyu/WorkSpace/IdeaProjects/CacheDemo/src/main/resources/mapper"));
                })
                // 策略配置
                .strategyConfig(builder -> {
                    // 设置需要生成的表名，可以多个add天假
                    builder.addInclude("user")
                            // 增加过滤表前缀
                            .addTablePrefix();
                    builder.controllerBuilder()
                            // 开启生成 @RestController 控制器，不配置这个默认是 @Controller 注解，RestController是返回Json字符串的，多用于前后端分离项目。
                            .enableRestStyle()
                            // 覆盖已生成的文件
                            .enableFileOverride();
                    builder.serviceBuilder()
                            // 设置service的命名策略，如果没有这个设置，生成的service和Impl类前面会有一个 I，例如IService,IServiceImpl
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            // 覆盖已生成的文件
                            .enableFileOverride();
                    builder.mapperBuilder()
                            // 开启 @Mapper 注解，也就是在dao接口上添加一个@Mapper注解，这个注解的作用是开启注解模式，就可以在接口的抽象方法上面直接使用@Select和@Insert和@Update和@Delete注解。
                            .enableMapperAnnotation()
                            // 覆盖已生成的文件
                            .enableFileOverride();
                    builder.entityBuilder()
                            // 覆盖已生成的文件
                            .enableFileOverride();
                })
                .templateConfig(builder -> {
                    builder.controller("/templates/controller.java");
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .templateEngine(new VelocityTemplateEngine())
                .execute();
    }
}
