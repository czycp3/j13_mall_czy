package com.cskaoyan.mall_springboot.util;

import com.cskaoyan.mall_springboot.bean.storage.Storage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author CZY-Y7000P
 */
public class FileUploadUtil {
    public static Storage uploadUtil(MultipartFile file, HttpServletRequest req) throws IOException {
        Storage imageInfo = new Storage();

        String fileName = file.getOriginalFilename();
        imageInfo.setName(fileName);

        String contextPath = req.getContextPath();

        // 将文件夹打散
        int i = fileName.hashCode();
        String hexString = Integer.toHexString(i);
        char[] chars = hexString.toCharArray();
        String uuid = UuidGenerator.uuid();
        //取十六进制HashCode的前两位作为文件夹路径
        fileName = chars[0] + "/" + chars[1] + "/" + uuid + fileName;
        imageInfo.setKey(fileName);
        imageInfo.setUrl("http://localhost:8080/admin/storage/fetch/" + fileName);

        String path = req.getServletContext().getRealPath("/upload/image");
        File uploadFile = new File(path + fileName);

        if (!uploadFile.getParentFile().exists()) {
            uploadFile.getParentFile().mkdirs();
        }

        file.transferTo(uploadFile);


        /*
        url: "http://localhost:8080/wx/storage/fetch/l5ncnljchclpcnb6erd0.jpg"
        setUrl(contextPath + "/file/" + fileName)
         */
        imageInfo.setSize(file.getSize());
        imageInfo.setType(file.getContentType());

        return imageInfo;
    }
}
