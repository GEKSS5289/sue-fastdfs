package com.sue.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sue
 * @date 2020/8/14 9:45
 */

public interface FastDFSService {
    public String uploadFile(MultipartFile file,String fileExtName) throws Exception;
    public String upload(String userId,MultipartFile file) throws Exception;
}
