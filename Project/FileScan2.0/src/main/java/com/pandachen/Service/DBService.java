//package com.pandachen.Service;
//
//import com.pandachen.Mapper.DBInitMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.InputStream;
//import java.util.Scanner;
//
//@Service
//public class DBService {
//    @Autowired
//    DBInitMapper dbInitMapper;
//
//    private String getSQL(){
//        InputStream is = getClass().getClassLoader().getResourceAsStream("init.sql");
//        Scanner sc = new Scanner(is, "UTF-8");
//        StringBuilder sb = new StringBuilder();
//        while (sc.hasNextLine()) {
//            sb.append(sc.nextLine());
//        }
//
//        return sb.toString();
//    }
//
//        public void init() {
//            dbInitMapper.init();
//        }
//}
