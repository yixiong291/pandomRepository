package com.wyx.dao;

import com.wyx.entity.ReaderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReInfoDao {

    void insertInfo( ReaderInfo readerInfo);

    List<ReaderInfo> queryAllInfo();

    ReaderInfo queryByName(@Param("name")String name);

    void updateInfo(ReaderInfo readerInfo);
}
