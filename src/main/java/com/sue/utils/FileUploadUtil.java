package com.sue.utils;

import com.sue.core.fileupload.FileUpload;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sue
 * @date 2020/8/14 10:04
 */

@Data
public class FileUploadUtil {
    private FileUpload fileUpload;

    private String fileUpload(MultipartFile file){
        return null;
    }
}
