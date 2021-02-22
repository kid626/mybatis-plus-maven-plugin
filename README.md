### 安装

    安装到本地:  mvn install
    也可以安装到自己的私服 mvn deploy


### 使用方式

    <build>
        <plugins>
            <plugin>
                <groupId>com.bruce</groupId>
                <artifactId>mybatis-plus-maven-plugin</artifactId>
                <version>1.0-SNAPSHOT</version>
                <configuration>
                    <configurationFile>src/main/resources/mp-generator-config.yml</configurationFile>
                </configuration>
            </plugin>
        </plugins>
    </build>
    
### 配置文件
        src/main/resources/mp-generator-config.yml
```
    author: Bruce
    dbType: mysql
    dbUrl: "jdbc:mysql://localhost:3306/mybatis_plus?characterEncoding=utf8&serverTimezone=GMT%2B8"
    dbDriverName: "com.mysql.cj.jdbc.Driver"
    dbUsername: root
    dbPassword: root
    
    parentPackage: com.bruce.mp
    projectName: mp-test
    #prefix: demo
    includes: ["demo_mybatis_test"]
    
    #outputDir:
    #usebtl: true
    #usevm: true
    useftl: true