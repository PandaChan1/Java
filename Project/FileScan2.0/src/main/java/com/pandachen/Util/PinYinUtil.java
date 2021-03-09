package com.pandachen.Util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtil {
    public static String getPinYin(String name) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);

        StringBuilder sb = new StringBuilder();
        for (char c :
                name.toLowerCase().toCharArray()) {
            try {
                String[] pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);
                if (pinyin == null || pinyin.length == 0) {
                    sb.append(c);
                    continue;
                }
                sb.append(pinyin[0]);
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String getPinYinFirst (String name){
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);

        StringBuilder sb = new StringBuilder();
        for (char c :
                name.toLowerCase().toCharArray()) {
            try {
                String[] pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);
                if (pinyin == null || pinyin.length == 0) {
                    sb.append(c);
                    continue;
                }
                sb.append(pinyin[0].charAt(0));
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
