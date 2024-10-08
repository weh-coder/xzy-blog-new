package com.aurora.strategy.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aurora.config.properties.OssConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service("ossUploadStrategyImpl")
public class OssUploadStrategyImpl extends AbstractUploadStrategyImpl {

    @Autowired
    private OssConfigProperties ossConfigProperties;

    // 创建OSSClient实例
    private OSS getOssClient() {
        return new OSSClientBuilder()
                .build(ossConfigProperties.getEndpoint()
                        , ossConfigProperties.getAccessKeyId()
                        , ossConfigProperties.getAccessKeySecret());
    }

    @Override
    public Boolean exists(String filePath) {
        System.out.println("---------++++++++");
        return getOssClient().doesObjectExist(ossConfigProperties.getBucketName(), filePath);
    }
    @Override
    public void upload(String path, String fileName, InputStream inputStream) {
        // 创建PutObject请求
        getOssClient().putObject(ossConfigProperties.getBucketName(), path + fileName, inputStream);
    }

    @Override
    public String getFileAccessUrl(String filePath) {
        return ossConfigProperties.getUrl() + filePath;
    }

}
