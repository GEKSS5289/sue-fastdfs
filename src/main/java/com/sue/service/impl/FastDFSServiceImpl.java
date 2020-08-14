package com.sue.service.impl;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

import com.sue.service.FastDFSService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



/**
 * @author sue
 * @date 2020/8/14 9:46
 */

@Service
public class FastDFSServiceImpl implements FastDFSService {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Override
    public String upload(String userId,MultipartFile file) throws Exception {
        String path = "";
        // 开始文件上传
        if (file != null) {
            // 获得文件上传的文件名称
            String fileName = file.getOriginalFilename();
            if (StringUtils.isNotBlank(fileName)) {

                // 文件重命名  imooc-face.png -> ["imooc-face", "png"]
                String fileNameArr[] = fileName.split("\\.");

                // 获取文件的后缀名
                String suffix = fileNameArr[fileNameArr.length - 1];

                if (!suffix.equalsIgnoreCase("png") &&
                        !suffix.equalsIgnoreCase("jpg") &&
                        !suffix.equalsIgnoreCase("jpeg") ) {
                    return null;
                }

                path = this.uploadFile(file,suffix);
                System.out.println(path);

            }
        } else {
           return null;
        }

        return path;

    }

    @Override
    public String uploadFile(MultipartFile file, String fileExtName) throws Exception {
        StorePath storePath = fastFileStorageClient.uploadFile(
                file.getInputStream(),
                file.getSize(), fileExtName,
                null);
        String fullPath = storePath.getFullPath();
        return fullPath;
    }
}
