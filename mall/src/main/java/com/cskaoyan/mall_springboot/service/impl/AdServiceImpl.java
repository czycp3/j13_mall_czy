package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.ad.Ad;
import com.cskaoyan.mall_springboot.bean.storage.Storage;
import com.cskaoyan.mall_springboot.bean.storage.StorageExample;
import com.cskaoyan.mall_springboot.mapper.AdMapper;
import com.cskaoyan.mall_springboot.mapper.StorageMapper;
import com.cskaoyan.mall_springboot.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
@Service
public class AdServiceImpl implements AdService {

    private AdMapper adMapper;
    private StorageMapper storageMapper;

    @Autowired
    public AdServiceImpl(AdMapper adMapper, StorageMapper storageMapper) {
        this.adMapper = adMapper;
        this.storageMapper = storageMapper;
    }

    /**
     * 分页查询广告
     * @param page
     * @param limit
     * @param sort
     * @param order
     * @return BaseQueryVo
     */
    @Override
    public BaseQueryVo queryAllAdByPage(int page, int limit, String sort, String order,String name,String content) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<Ad> resultVo = new ResultVo<>();

        if(name != null){
            name = "%" + name + "%";
        }
        if(content != null) {
            content = "%" + content + "%";
        }

        //查询custom总记录数
        int total = adMapper.selectCountAd(name,content);
        int offset = (page - 1) * limit;


        List<Ad> adList =  adMapper.queryAllAdByPage(limit,offset,sort,order,name,content);

        resultVo.setItems(adList);
        resultVo.setTotal(total);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");

        baseQueryVo.setData(resultVo);
        return baseQueryVo;
    }

    /**
     * 更新广告
     * @param ad
     * @return SingleQueryVo
     */
    @Override
    public SingleQueryVo updateAd(Ad ad) {
       SingleQueryVo<Ad> singleQueryVo = new SingleQueryVo<>();
       try {
           int ret =  adMapper.updateByPrimaryKeySelective(ad);
           if(ret != 0){
               Ad ad1 = adMapper.selectByPrimaryKey(ad.getId());
               singleQueryVo.setData(ad1);
               singleQueryVo.setErrmsg("成功");
               singleQueryVo.setErrno(0);
           }
       }catch (Exception e){
            singleQueryVo.setErrmsg("更新失败");
            throw new RuntimeException(e);
       }
        return singleQueryVo;
    }

    /**
     * 删除广告
     * @param ad
     * @return SingleQueryVo
     */
    @Override
    public SingleQueryVo deleteAd(Ad ad) {
        SingleQueryVo<Ad> singleQueryVo = new SingleQueryVo<>();

        try {
            ad.setDeleted(1);
            int ret = adMapper.updateByPrimaryKeySelective(ad);
            if(ret == 1) {
                singleQueryVo.setErrmsg("成功");
                singleQueryVo.setErrno(0);
            }
        }catch (Exception e){
            singleQueryVo.setErrmsg("删除失败");
            throw new RuntimeException(e);
        }
        return singleQueryVo;
    }

    /**
     * 插入广告
     * @param ad
     * @return SingleQueryVo
     */
    @Override
    public SingleQueryVo create(Ad ad){
        SingleQueryVo<Ad> singleQueryVo = new SingleQueryVo<>();
        try {
            int ret = adMapper.insertSelective(ad);
            if(ret == 1) {
                singleQueryVo.setErrmsg("成功");
                singleQueryVo.setErrno(0);
                singleQueryVo.setData(ad);
            }
        }catch (Exception e){
            singleQueryVo.setErrmsg("增加失败");
            throw new RuntimeException(e);
        }
        return singleQueryVo;
    }

    /**
     * 插入上传图片信息
     * @param storage
     * @return SingleQueryVo
     */
    @Override
    public SingleQueryVo uploadImage(Storage storage) {
        SingleQueryVo<Storage> singleQueryVo = new SingleQueryVo<>();
        try {
            int ret = storageMapper.insertStorage(storage);
            if(ret == 1) {
                Storage storage1 = storageMapper.selectByKey(storage);
                singleQueryVo.setErrmsg("成功");
                singleQueryVo.setErrno(0);
                singleQueryVo.setData(storage1);
            }
        }catch (Exception e){
            singleQueryVo.setErrmsg("增加失败");
            throw new RuntimeException(e);
        }
        return singleQueryVo;
    }


}
