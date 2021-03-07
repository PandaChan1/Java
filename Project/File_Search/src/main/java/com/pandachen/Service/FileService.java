package com.pandachen.Service;

import com.pandachen.DAO.DeleteDAO;
import com.pandachen.DAO.QueryDAO;
import com.pandachen.DAO.SaveDAO;
import com.pandachen.Model.FileMeta;
import com.pandachen.Util.ListUtil;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class FileService {
    private final QueryDAO queryDAO = new QueryDAO();
    //解决sqlite is blocked，方法二，改成私有静态对象，提供统一的get方法，单例模式
    //测试可行＜（＾－＾）＞,不能完全解决问题，扫描文件大时仍会死锁
    private final DeleteDAO deleteDAO = new DeleteDAO();
//    private static DeleteDAO deleteDAO;
    private final SaveDAO saveDAO = new SaveDAO();

    //database is blocked解决方法三,信号量机制，扫e盘不会报错，但速度慢
    private static final Semaphore semp = new Semaphore(1);

//    private static SaveDAO saveDAO;


/*    public static DeleteDAO getDeleteDAO() {
        if (deleteDAO == null) {
                    deleteDAO = new DeleteDAO();
        }
        return deleteDAO;
    }

    public static SaveDAO getSaveDAO() {
        if (saveDAO == null) {
            saveDAO = new SaveDAO();
        }
        return saveDAO;
    }*/

    public List<FileMeta> query(String key) {  //查询
        return queryDAO.query(key);
    }

    public  void save(List<FileMeta> filelist) throws InterruptedException {  //存储
                semp.acquire();
                saveDAO.save(filelist);
                semp.release();

//        getSaveDAO().save(filelist);
    }

    public  void delete(List<FileMeta> filelist) throws InterruptedException {  //删除
        List<Integer> idList = filelist.stream().map(FileMeta::getId).collect(Collectors.toList());
                semp.acquire();
                deleteDAO.delete(idList);
                semp.release();

//        getDeleteDAO().delete(idList);
    }

   public  void differ(String path, List<FileMeta> filelist) throws InterruptedException {
       System.out.println(path);
       semp.acquire();
       List<FileMeta> queryRes = queryDAO.queryByPath(path);
       semp.release();
        List<FileMeta>  delList = ListUtil.differenceSet(queryRes,filelist);
        delete(delList);
        List<FileMeta>  saveList = ListUtil.differenceSet(filelist,queryRes);
        save(saveList);
    }

}
