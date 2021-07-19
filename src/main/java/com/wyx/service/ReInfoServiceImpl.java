package com.wyx.service;

import com.wyx.dao.ReInfoDao;
import com.wyx.entity.ReaderInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ReInfoServiceImpl")
public class ReInfoServiceImpl implements ReInfoService{
    @Resource
    private ReInfoDao reInfoDao;

    @Override
    public void insertInfo(ReaderInfo readerInfo) {
        reInfoDao.insertInfo(readerInfo);
    }

    @Override
    public List<ReaderInfo> queryAllInfo() {
        return reInfoDao.queryAllInfo();
    }

    @Override
    public ReaderInfo queryByName(String name) {
        return reInfoDao.queryByName(name);
    }

    @Override
    public void updateInfo(ReaderInfo readerInfo) {
        reInfoDao.updateInfo(readerInfo);
    }


}
