package com.aurora.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
* @Description:阿里云对象存储配置信息
* @Param:
* @returns:
* @Author: weh
* @Date: 2024/2/24 22:50
*/
@Data
@Configuration
@ConfigurationProperties(prefix = "upload.oss")
public class OssConfigProperties {

    private String url;

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

}
