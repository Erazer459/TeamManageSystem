package com.Erazer.controller.fileUpload;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class fileUpload {
    @RequestMapping("/upload.do")
    public String upload(@RequestParam MultipartFile[] myfiles, HttpServletRequest request) throws IOException {
        for (MultipartFile file : myfiles) {
            if (file.isEmpty()) {
                System.out.println("文件未上传!");
            } else {
                // 得到上传的文件名
                String fileName = file.getOriginalFilename();
                // 得到服务器项目发布运行所在地址
                //使用File.separator代替分隔符,防止跨平台出现“No such file or diretory”异常
                String path1 = request.getSession().getServletContext().getRealPath("/web/upload") + File.separator;
                //使用UUID对文件进行命名
                String path = path1 + UUID.randomUUID().toString().replace("-", "") + fileName;
                // 查看文件上传路径,方便查找
                System.out.println(path);
                // 把文件上传至path的路径
                File localFile = new File(path);
                file.transferTo(localFile);
            }
        }
        return "uploadSuccess";
    }
}
