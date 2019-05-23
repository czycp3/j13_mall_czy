package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.ad.Ad;
import com.cskaoyan.mall_springboot.bean.storage.Storage;
import com.cskaoyan.mall_springboot.service.AdService;
import com.cskaoyan.mall_springboot.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author CZY-Y7000P
 */
@Controller
public class AdController {
    private AdService adService;

    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @RequestMapping("/ad/list")
    @ResponseBody
    public BaseQueryVo list(int page,int limit,String sort,String order,String name,String content){
        return adService.queryAllAdByPage(page,limit,sort,order,name,content);
    }

    @RequestMapping("/ad/update")
    @ResponseBody
    public SingleQueryVo update(@RequestBody Ad ad){
        return adService.updateAd(ad);
    }

    @RequestMapping("/ad/delete")
    @ResponseBody
    public SingleQueryVo delete(@RequestBody Ad ad){
        return adService.deleteAd(ad);
    }

    @RequestMapping("/ad/create")
    @ResponseBody
    public SingleQueryVo create(@RequestBody Ad ad) {
        return adService.create(ad);
    }

    @RequestMapping("/storage/create")
    @ResponseBody
    public SingleQueryVo uploadImage(MultipartFile file, HttpServletRequest req) throws IOException {
        Storage storage = FileUploadUtil.uploadUtil(file, req);
        return adService.uploadImage(storage);
    }

    @RequestMapping("/storage/fetch/{path}")
    public void fetch(@PathVariable("path") String path, HttpServletResponse response){
        File file = new File("/upload/image/" + path);

        try (FileInputStream inputStream = new FileInputStream(file);
              ServletOutputStream outputStream = response.getOutputStream()){
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0){
                outputStream.write(b,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
