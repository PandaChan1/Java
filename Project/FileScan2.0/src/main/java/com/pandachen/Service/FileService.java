package com.pandachen.Service;

import com.pandachen.Mapper.FileMetaMapper;
import com.pandachen.Model.FileMeta;
import com.pandachen.Util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {
    @Autowired
    private  FileMetaMapper fileMetaMapper;
//    private final QueryDAO queryDAO = new QueryDAO();
//    private final DeleteDAO deleteDAO = new DeleteDAO();
//    private final SaveDAO saveDAO = new SaveDAO();

    public List<FileMeta> query(String key) {  //查询
        return fileMetaMapper.queryByKey(key);
    }

    public void save(List<FileMeta> filelist) {  //存储
//        try {
            fileMetaMapper.saveAll(filelist);
//            saveDAO.save(filelist);
//        }catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void delete(List<FileMeta> filelist) {  //删除
        List<Integer> idList = filelist.stream().map(FileMeta::getId).collect(Collectors.toList());
//        try {
            fileMetaMapper.deleteByIdlist(idList);
//            deleteDAO.delete(idList);
//        }catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

   public void differ(String path,List<FileMeta> filelist) {
       System.out.println(path);
//        List<FileMeta> queryRes = queryDAO.queryByPath(path);
       System.out.println(fileMetaMapper);
        List<FileMeta> queryRes = fileMetaMapper.queryByPath(path);
       System.out.println(queryRes);
        List<FileMeta>  delList = ListUtil.differenceSet(queryRes,filelist);
        delete(delList);
        List<FileMeta>  saveList = ListUtil.differenceSet(filelist,queryRes);
        save(saveList);
    }

    public void scan(File root) {
        
        if (!root.isDirectory()) {
            return;
        }

        File[] files = root.listFiles();
        if (files == null) {
            return;
        }

        List<FileMeta> res = new ArrayList<>();
        for (File f :
                files) {
            scan(f);
            if (f.isFile()) {
                res.add(new FileMeta(f));
            }
        }
        differ(root.getAbsolutePath(),res);
    }
}
