# Thymeleaf + Bootstrap Pagination (翻页组件)

### 开发环境
- JDK 1.8
- IDEA
- Gradle

### 使用框架
- Spring Boot 2.6.7
- Thymeleaf 3
- BootStrap 5

### 运行步骤
- 在 IDEA 里导入 Gradle 项目，等待下载依赖，编译完成
- 右击运行 DemoApplication
- 访问 http://localhost:8080/user/list

### 注意事项
- 需要注意服务器 pageList.number 是从0开始的，前端显示给用户的都是从1开始的，这里比较绕，计算容易出错