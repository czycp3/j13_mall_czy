package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.ad.Ad;
import com.cskaoyan.mall_springboot.bean.storage.Storage;
import com.cskaoyan.mall_springboot.service.AdService;
import com.cskaoyan.mall_springboot.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
    public BaseQueryVo list(int page,int limit,String sort,String order){
        return adService.queryAllAdByPage(page,limit,sort,order);
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
}
