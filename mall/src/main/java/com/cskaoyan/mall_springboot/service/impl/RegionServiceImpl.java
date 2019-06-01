package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.mallmg.Region;
import com.cskaoyan.mall_springboot.bean.mallmg.ReturnMallT;
import com.cskaoyan.mall_springboot.mapper.RegionMapper;
import com.cskaoyan.mall_springboot.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionMapper regionMapper;
    @Autowired
    ReturnMallT<Region> returnMallT;

    @Override
    public ReturnMallT<Region> selectAllRegion() {
        List<Region> regions = regionMapper.selectAllRegion();
        returnMallT.setErrmsg("成功");
        returnMallT.setErrno(0);
        HashMap<Integer, ArrayList<Region>> regionMap = new HashMap<>();
        returnMallT.setData(new ArrayList<Region>());
        List<Region> data = returnMallT.getData();
        //以pid为key存入map中
        for (Region region : regions) {
            ArrayList<Region> regions1;
            Integer pid = region.getPid();
            if (!region.getPid().equals(0)) {
                region.setPid(null);
            }
            if (regionMap.containsKey(pid)) {
                regions1 = regionMap.get(pid);
            } else {
                regions1 = new ArrayList<>();
            }
            regions1.add(region);
            regionMap.put(pid, regions1);
        }
        //按照id和pid为children赋值
        for (Region region : regions) {
            if (regionMap.containsKey(region.getId())) {
                List<Region> regions1 = regionMap.get(region.getId());
                region.setChildren(regions1);
                if (region.getPid() != null && region.getPid().equals(0)) {
                    region.setPid(null);
                    data.add(region);
                }
            }
        }
        return returnMallT;
    }
}
