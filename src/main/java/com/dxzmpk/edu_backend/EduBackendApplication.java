package com.dxzmpk.edu_backend;

import com.dxzmpk.edu_backend.util.fileupload.StorageProperties;
import com.dxzmpk.edu_backend.util.fileupload.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class EduBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduBackendApplication.class, args);
    }
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
//			storageService.deleteAll();
            storageService.init(); //初始化文件夹
        };
    }
}
