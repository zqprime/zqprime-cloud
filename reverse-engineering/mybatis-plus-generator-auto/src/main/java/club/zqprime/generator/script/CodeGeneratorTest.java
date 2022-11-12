package club.zqprime.generator.script;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import java.util.Collections;

public class CodeGeneratorTest {

    @Test
    public void testGeneratorCode(){
        FastAutoGenerator.create("jdbc:mysql://162.14.97.85:3308/order_group?allowPublicKeyRetrieval=true&useSSL=False", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("zqprime") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\Users\\Administrator\\Desktop\\点餐\\code"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.qmx.order") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    "C:\\Users\\Administrator\\Desktop\\点餐\\code")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
//                    builder.addInclude("t_user");
//                    builder.addInclude("t_order");
                    builder.addInclude("ord06_table_user_relation");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }


}
