package com.aurora.strategy.context;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.aurora.strategy.UploadStrategy;

import java.io.InputStream;
import java.util.Map;

import static com.aurora.enums.UploadModeEnum.getStrategy;

@Service
public class UploadStrategyContext {

    @Value("${upload.mode}")
    private String uploadMode;

    @Autowired
    private Map<String, UploadStrategy> uploadStrategyMap;

    public String executeUploadStrategy(MultipartFile file, String path) {
        //   getStrategy(uploadMode)选择对象存储
        return uploadStrategyMap.get(getStrategy(uploadMode)).uploadFile(file, path);
    }

    public String executeUploadStrategy(String fileName, InputStream inputStream, String path) {
        return uploadStrategyMap.get(getStrategy(uploadMode)).uploadFile(fileName, inputStream, path);
    }

}
