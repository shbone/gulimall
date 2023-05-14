package com.example.gulimall.product;



import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
class GulimallProductApplicationTests {
//    @Autowired
//    OSSClient ossClient;
//    @Test
//    public void TestOss() throws FileNotFoundException {
////        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
////        String endpoint = "oss-cn-zhangjiakou.aliyuncs.com";
////        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
////        String accessKeyId = "LTAI5tAK93gtTvxB8fb7Qsp4";
////        String accessKeySecret = "qfqciGWxG7zfnguX3UcLzlLvg4NBCJ";
////        // 填写Bucket名称，例如examplebucket。
//        String bucketName = "gulimallsunhb";
////        // 填写Object完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
//        String objectName = "架构示意图3.png";
//
//        // 创建OSSClient实例。
////        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//        InputStream inputStream = new FileInputStream("/home/root1/图片/架构示意图3.png");
//
//        try {
//            String content = "Hello OSS";
////            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
//            ossClient.putObject(bucketName, objectName, inputStream);
//        } catch (OSSException oe) {
//            System.out.println("Caught an OSSException, which means your request made it to OSS, "
//                    + "but was rejected with an error response for some reason.");
//            System.out.println("Error Message:" + oe.getErrorMessage());
//            System.out.println("Error Code:" + oe.getErrorCode());
//            System.out.println("Request ID:" + oe.getRequestId());
//            System.out.println("Host ID:" + oe.getHostId());
//        } catch (ClientException ce) {
//            System.out.println("Caught an ClientException, which means the client encountered "
//                    + "a serious internal problem while trying to communicate with OSS, "
//                    + "such as not being able to access the network.");
//            System.out.println("Error Message:" + ce.getMessage());
//        } finally {
//            if (ossClient != null) {
//                ossClient.shutdown();
//                System.out.println("完成上传...");
//            }
//        }
//    }
    @Test
    void contextLoads() {
    }
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void testStringRedis(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
//       生成
        ops.set("first", "sunhb_"+ UUID.randomUUID().toString());
//        查询
        String msg =ops.get("first");
        System.out.println("msg："+ msg);
    }



}
