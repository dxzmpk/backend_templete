# backend_templete 基于SpringBoot + Mybatis的后端模版
## StartUp 
1. 克隆项目
2. 运行SpringBootApplication类
3. application.yml中对应的端口为port，则后端服务接口界面位于localhost:port/swagger-ui.html。打开即可访问，可以看到文件服务接口。

## 架构-自顶向下
1. controller 负责http请求的接收与回复
2. service 利用mapper中提供的接口对数据库进行操作，完成http请求需要的任务。
3. mapper 包含两部分，接口，其中每个方法对应一个xml中的sql语句
4. dto data transfer object, 大约每个对应一个数据库表
5. mysql 目前仅支持对mysql数据库进行配置
