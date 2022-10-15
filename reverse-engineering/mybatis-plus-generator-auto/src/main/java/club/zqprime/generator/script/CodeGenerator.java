package club.zqprime.generator.script;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://162.14.97.85:3308/spring-transaction?allowPublicKeyRetrieval=true&useSSL=False", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("baomidou") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\idea-projects\\zqprime-cloud\\spring-transaction\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("club.zqprime.app") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    "C:\\idea-projects\\zqprime-cloud\\spring-transaction\\src\\main\\java\\club\\zqprime\\app\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
//                    builder.addInclude("t_user");
//                    builder.addInclude("t_order");
                    builder.addInclude("prd01_car");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
