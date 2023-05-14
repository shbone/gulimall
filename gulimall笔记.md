配置oss：

1. 加入spirngboot aliyun-oss-spring-boot-starter 模块，以及aliyun-java-sdk-core 高版本匹配springboot
2. application中配置密钥，权限和endpoint
3. 上传信息

配置校验规则JSR303：
1. Bean添加校验注解，`javax.validation.constraints`,可以自定义自己的message注解
2. 开启校验效果`@Valid`到请求的相应字段
3. 紧跟bean后给一个bindingResult，可以获得校验的结果
自定义规则bean用`@Pattern`
4. 分组校验
 - `@URL(message = "logo必须是一个合法的url地址",groups = {AddGroup.class, UpdateGroup.class})`
    在更新或者添加的时候满足URL要求，进行校验
 - `@Validated({AddGroup.class}) `选择需要校验的组别
 - 默认没有指定分组`@NotNull`的 在分组校验的情况下不会生效，只会在@Valid情况下生效
5. 自定义校验
- 自定义的校验注解
- 自定义的校验器
- 自定义的校验器校验校验注解
``` bash
@Documented
  @Constraint(
  //        自定义的校验器
  validatedBy = {ListValueConstraintValidator.class}
  )
  @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
  @Retention(RetentionPolicy.RUNTIME)
```
  `implements ConstraintValidator<ListValue,Integer>`引入校验器进行校验


统一的异常处理：
1. `@ControllerAdvice` 编写异常处理
2. 使用`@ExceptionHandler`标注方法标出可以处理的异常


## 2023-05-07 
### 前端
父子组件传递信息：
1. 事件机制：子组件给父组件发送一个事件，携带信息
2. 给父节点发送事件  this.$emit("tree-node-click",data,node,component)

### 后端
分页查询，mybatisplus 自带
IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper);  
`page`：翻页对象 `queryWrapper`：实体对象封装操作类 QueryWrapper,筛选数据

## 2023-05-14
### 配置Redis
1. 引用data-redis-starter
2. yml简单配置host等信息
3. springboot自动配置好的stringredistemplate来操作redis