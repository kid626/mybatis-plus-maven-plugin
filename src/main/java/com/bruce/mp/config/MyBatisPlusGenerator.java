package com.bruce.mp.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName mybatis-plus-maven-plugin
 * @Date 2021/2/13 20:40
 * @Author Bruce
 */
public class MyBatisPlusGenerator {

    /**
     * 自定义配置映射的 key
     */
    private final String PROJECT_NAME_KEY = "project_name";

    private MpConfig mpConfig;

    public MyBatisPlusGenerator(MpConfig mpConfig) {
        this.mpConfig = mpConfig;
        if (mpConfig.getGlobalConfig() == null) {
            mpConfig.setGlobalConfig(initGlobalConfig());
        }
        if (mpConfig.getDataSourceConfig() == null) {
            mpConfig.setDataSourceConfig(initDataSourceConfig());
        }
        if (mpConfig.getStrategyConfig() == null) {
            mpConfig.setStrategyConfig(initStrategyConfig());
        }
        if (mpConfig.getPackageConfig() == null) {
            mpConfig.setPackageConfig(initPackageConfig());
        }
        if (mpConfig.getTemplateConfig() == null) {
            mpConfig.setTemplateConfig(initTemplateConfig());
        }
    }

    public GlobalConfig initGlobalConfig() {
        // 2 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // 设置作者
        globalConfig.setAuthor(mpConfig.getAuthor());
        // 是否打开生成目录
        globalConfig.setOpen(false);
        // 设置数据库映射的时间类型
        globalConfig.setDateType(DateType.ONLY_DATE);
        // 设置文件覆盖
        globalConfig.setFileOverride(true);
        // 设置开启 swagger
        globalConfig.setSwagger2(true);
        // 是否支持 AR 模式
        globalConfig.setActiveRecord(false);
        // 方便自定义 sql
        // 设置是否生成 ResultMap
        globalConfig.setBaseResultMap(true);
        // 设置基本 sql 片段
        globalConfig.setBaseColumnList(true);
        // 设置生成路径
        globalConfig.setOutputDir(mpConfig.getOutputDir());
        // 设置生产的类及类名
        globalConfig.setEntityName("%s");
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        return globalConfig;
    }

    public DataSourceConfig initDataSourceConfig() {
        // 3 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.getDbType(mpConfig.getDbType()));
        dataSourceConfig.setUrl(mpConfig.getDbUrl());
        dataSourceConfig.setDriverName(mpConfig.getDbDriverName());
        dataSourceConfig.setUsername(mpConfig.getDbUsername());
        dataSourceConfig.setPassword(mpConfig.getDbPassword());
        return dataSourceConfig;
    }

    public StrategyConfig initStrategyConfig() {
        // 4 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        // restful api
        strategyConfig.setRestControllerStyle(true);
        // 设置开启 sql 过滤
        strategyConfig.setEnableSqlFilter(true);
        // 设置为 lombok 模型
        strategyConfig.setEntityLombokModel(true);
        // 表名驼峰原则
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 字段名驼峰原则
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 设置表名前缀
        strategyConfig.setTablePrefix(mpConfig.getPrefix());
        if (!CollectionUtils.isEmpty(mpConfig.getIncludes())) {
            // 需要生成的数据库表
            strategyConfig.setInclude(mpConfig.getIncludes().toArray(new String[0]));
        }
        if (!CollectionUtils.isEmpty(mpConfig.getExcludes())) {
            // 需要排除的数据库表
            strategyConfig.setInclude(mpConfig.getExcludes ().toArray(new String[0]));
        }
        strategyConfig.setLogicDeleteFieldName("is_delete");
        return strategyConfig;
    }

    public PackageConfig initPackageConfig() {
        // 5 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(mpConfig.getParentPackage());
        packageConfig.setEntity("model.po");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setController("controller");
        packageConfig.setXml("sqlmap.auto");
        return packageConfig;
    }

    public TemplateConfig initTemplateConfig() {
        // 5 模板设置
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity("/templates/custom.entity.java");
        templateConfig.setController("/templates/custom.controller.java");
        templateConfig.setService("/templates/custom.service.java");
        templateConfig.setServiceImpl("/templates/custom.serviceImpl.java");
        templateConfig.setMapper("/templates/custom.mapper.java");
        templateConfig.setXml("/templates/custom.mapper.xml");
        return templateConfig;
    }

    public AutoGenerator autoGenerator() {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(mpConfig.getGlobalConfig());
        mpg.setDataSource(mpConfig.getDataSourceConfig());
        mpg.setPackageInfo(mpConfig.getPackageConfig());
        mpg.setTemplate(mpConfig.getTemplateConfig());
        mpg.setStrategy(mpConfig.getStrategyConfig());
        mpg.setCfg(initInjectionConfig());
        return mpg;
    }

    public InjectionConfig initInjectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>(2);
                map.put(PROJECT_NAME_KEY, mpConfig.getProjectName());
                this.setMap(map);
            }
        };
    }
}
