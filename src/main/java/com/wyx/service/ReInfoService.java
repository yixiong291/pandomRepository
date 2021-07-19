package com.wyx.service;

import com.wyx.entity.ReaderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReInfoService {

    void insertInfo(ReaderInfo readerInfo);

    List<ReaderInfo> queryAllInfo();

    ReaderInfo queryByName(@Param("name")String name);

    void updateInfo(ReaderInfo readerInfo);
}
