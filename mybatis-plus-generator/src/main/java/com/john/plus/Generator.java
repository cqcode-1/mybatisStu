package com.john.plus;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class Generator {

   public static void main(String[] args) {
      final AutoGenerator autoGenerator = new AutoGenerator();

      final GlobalConfig gc = new GlobalConfig();
      //项目根目录
      gc.setOutputDir("E:/workplaces/IdeaProjects/mybatis_helloworld2/mybatis-plus-generator/src/main/java")//设置项目全路径
               .setAuthor("john")
              .setFileOverride(true)
              .setIdType(IdType.AUTO)//设置主键生产策略
              .setServiceName("%sService")//service接口的名称
              .setBaseResultMap(true)//基本结果集
              .setBaseColumnList(true)//设计基本的列
         .setOpen(false);
      autoGenerator.setGlobalConfig(gc);

      //数据源配置
      final DataSourceConfig dsc = new DataSourceConfig();
      dsc.setDriverName("com.mysql.jdbc.Driver");
      dsc.setUrl("jdbc:mysql://localhost:3306/tran?useSSL=false");
      dsc.setUsername("root");
      dsc.setPassword("123456");
      autoGenerator.setDataSource(dsc);

      //包信息配置,需要指定包名，否则生成默认baomidou， 其他名称可以不设置生成默认。
      final PackageConfig pc = new PackageConfig();
      //会在包名下在单独生成一个包来放置生成的文件（不需要）
//      pc.setModuleName("generator");
      pc.setParent("com.john.plus");//包名
      pc.setController("controller");
      pc.setEntity("entity");
      pc.setMapper("dao");
      pc.setService("service").setXml("mapper");
      autoGenerator.setPackageInfo(pc);

      //策略设置
      final StrategyConfig sc = new StrategyConfig();
      sc.setInclude("emp", "dept")
//              .setTablePrefix("")//表名前缀
              .setNaming(NamingStrategy.underline_to_camel);
      autoGenerator.setStrategy(sc);

      autoGenerator.execute();
   }
}
