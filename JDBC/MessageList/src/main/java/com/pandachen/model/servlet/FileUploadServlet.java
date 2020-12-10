package com.pandachen.model.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
@WebServlet("/file-upload")
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Part username = req.getPart("username");
        InputStream usernameIS = username.getInputStream();
//        int b;
//        while((b = usernameIS.read()) != -1) {
//            System.out.println((char)b);
//        }
        /*Scanner s = new Scanner(usernameIS);
        String next = s.next();
        System.out.println(next);*/

        Reader usernameReader = new InputStreamReader(usernameIS,"utf-8");
        char[] buf = new char[(int)username.getSize()];
        int n = usernameReader.read(buf);
        String s = new String(buf,0,n);
        System.out.println(s);


        Part image = req.getPart("image");
        InputStream inputStream = image.getInputStream();
        FileOutputStream fos = new FileOutputStream("E:\\dest.img");

        byte[] buffer = new byte[1024];
        int len;
        while( (len = inputStream.read(buffer)) != -1) {
            fos.write(buffer,0,len);
        }
        fos.close();
    }
}
