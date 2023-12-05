package com.bruce.mp.config;

import com.baomidou.mybatisplus.generator.config.*;
import lombok.Data;

import java.io.File;
import java.text.MessageFormat;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName mybatis-plus-maven-plugin
 * @Date 2021/2/13 20:54
 * @Author Bruce
 */
@Data
public class MpConfig {

    private String author = "Bruce";
    private String dbType = "mysql";
    private String dbUrl = "jdbc:mysql://localhost:3306/mybatis_plus?characterEncoding=utf8&serverTimezone=GMT%2B8";
    private String dbDriverName = "com.mysql.cj.jdbc.Driver";
    private String dbUsername = "root";
    private String dbPassword = "root";
    /**
     * 父包名，mapper,entity,service,controller 等都是基于该目录
     */
    private String parentPackage = "com.bruce.mybatisplus";
    /**
     * 项目名称，用于注释生成
     */
    private String projectName = "MP";

    /**
     * 模块名称
     */
    private String moduleName = "";

    /**
     * 版本
     */
    private String version = "v1";
    /**
     * 表名前缀
     */
    private String prefix = "";
    /**
     * 包含的表名
     */
    private List<String> includes;

    /**
     * 需要排除的表名
     */
    private List<String> excludes;

    /**
     * 输出路径
     */
    private String outputDir = System.getProperty("user.dir") + File.separator + "{0}" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;

    private GlobalConfig globalConfig;
    private DataSourceConfig dataSourceConfig;
    private PackageConfig packageConfig;
    private StrategyConfig strategyConfig;
    private TemplateConfig templateConfig;

    private boolean usebtl = false;
    private boolean usevm = false;
    private boolean useftl = false;
    private boolean custom = false;

    public String getOutputDir(String moduleName) {
        return MessageFormat.format(outputDir, moduleName);
    }

}
