# 项目实战
## 一、 项目介绍

### 1 夯实基础

### 2 沙场点兵

### 3 业务练兵



## 二、项目架构

## 三、工程结构

## 四、技术栈

### 1 日志系统

Log4j2完整的官方性能文档：http://logging.apache.org/log4j/2.x/performance.html

**Log4j2 + Slf4j 日志框架**

```xml
        <!-- 日志框架依赖  -->

        <!--log4j2核心包-->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>${log4j2.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>${log4j2.version}</version>
        </dependency>
        <!-- Web项目需添加日志 -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-web</artifactId>
            <version>${log4j2.version}</version>
        </dependency>
        <!--用于与slf4j保持桥接-->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-slf4j-impl</artifactId>
            <version>${log4j2.version}</version>
        </dependency>
        <!-- slf4j核心包-->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
```

项目原有日志框架转到Log4j2 + Slf4j

通过以下两种方式去除原有框架

- Maven 去掉原有依赖
- Maven exclusion

添加如下桥接依赖

```xml
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
    <version>1.7.25</version>
</dependency>
```







## 五、项目搭建