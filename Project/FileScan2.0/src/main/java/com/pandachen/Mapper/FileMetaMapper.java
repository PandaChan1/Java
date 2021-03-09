package com.pandachen.Mapper;

import com.pandachen.Model.FileMeta;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileMetaMapper {
    void deleteByIdlist(@Param("idList") List<Integer> idList);
    void saveAll(@Param("fileLists") List<FileMeta> fileLists);

    List<FileMeta> queryByKey(String key);

    List<FileMeta> queryByPath(String path);
}
