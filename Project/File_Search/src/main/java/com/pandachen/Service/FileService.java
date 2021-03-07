package com.pandachen.Service;

import com.pandachen.DAO.DeleteDAO;
import com.pandachen.DAO.QueryDAO;
import com.pandachen.DAO.SaveDAO;
import com.pandachen.Model.FileMeta;
import com.pandachen.Util.ListUtil;

import java.util.List;
import java.util.stream.Collectors;

public class FileService {
    private final QueryDAO queryDAO = new QueryDAO();
    //解决sqlite is blocked，方法二，改成私有静态对象，提供统一的get方法，单例模式
    //测试可行＜（＾－＾）＞,不能完全解决问题，扫描文件大时仍会死锁
    private final DeleteDAO deleteDAO = new DeleteDAO();
//    private static DeleteDAO deleteDAO;
    private final SaveDAO saveDAO = new SaveDAO();
//    private static SaveDAO saveDAO;


//    public static DeleteDAO getDeleteDAO() {
//        if (deleteDAO == null) {
//                    deleteDAO = new DeleteDAO();
//        }
//        return deleteDAO;
//    }

//    public static SaveDAO getSaveDAO() {
//        if (saveDAO == null) {
//            saveDAO = new SaveDAO();
//        }
//        return saveDAO;
//    }

    public List<FileMeta> query(String key) {  //查询
        return queryDAO.query(key);
    }

    public  void save(List<FileMeta> filelist) {  //存储
        saveDAO.save(filelist);
//        getSaveDAO().save(filelist);
    }

    public  void delete(List<FileMeta> filelist) {  //删除
        List<Integer> idList = filelist.stream().map(FileMeta::getId).collect(Collectors.toList());
        deleteDAO.delete(idList);
//        getDeleteDAO().delete(idList);
    }

   public  void differ(String path,List<FileMeta> filelist) {
       System.out.println(path);
        List<FileMeta> queryRes = queryDAO.queryByPath(path);
        List<FileMeta>  delList = ListUtil.differenceSet(queryRes,filelist);
        delete(delList);
        List<FileMeta>  saveList = ListUtil.differenceSet(filelist,queryRes);
        save(saveList);
    }

//    public void scan(File root) {
//
//        if (!root.isDirectory()) {
//            return;
//        }
//
//        File[] files = root.listFiles();
//        if (files == null) {
//            return;
//        }
//
//        List<FileMeta> res = new ArrayList<>();
//        for (File f :
//                files) {
//            scan(f);
//            if (f.isFile()) {
//                res.add(new FileMeta(f));
//            }
//        }
//        differ(root.getAbsolutePath(),res);
//    }
}
