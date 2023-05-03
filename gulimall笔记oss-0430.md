配置oss

1. 加入spirngboot aliyun-oss-spring-boot-starter 模块，以及aliyun-java-sdk-core 高版本匹配springboot
2. application中配置密钥，权限和endpoint
3. 上传信息

配置校验规则JSR303：
1. Bean添加校验注解，`javax.validation.constraints`,可以自定义自己的message注解
2. 开启校验效果`@Valid`到请求的相应字段
3. 紧跟bean后给一个bindingResult，可以获得校验的结果
自定义规则bean用@Pattern


统一的异常处理：
1. `@ControllerAdvice`