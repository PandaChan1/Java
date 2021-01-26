package com.pandachen.Util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatUtil {
    public static String sizeFormat(Long size) {
        DecimalFormat df = new DecimalFormat("#.00");
        String res = "";
        if (size < 1024) {
            res = df.format((double) size) + "B";
        } else if (size < 1048576) {
            res = df.format((double) size / 1024) + "KB";
        } else if (size < 1073741824) {
            res = df.format((double) size / 1048576) + "MB";
        } else {
            res = df.format((double) size / 1073741824) + "GB";
        }
        return res;
    }

    public static String dateFormat(Long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        Date res = new Date(date);
        return sdf.format(res);
    }
}
