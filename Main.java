package zifu;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author
 * @date 2020/4/30 16:15
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("> 请输入您要整理的古诗：");
        String text;//输入字符串
        while (true) {
            text = scanner.nextLine();//扫描字符串
            System.out.println("> 正在分析...");
            if (text != null && text.length() > 0) {//检查输入是否为空
                break;
            }
            System.out.println("> 输入不能为空，请重新输入");
            System.out.println("> 请输入您要整理的古诗：");
        }
        String poetry = handler(text);
        writeFile(poetry);
        statistics(poetry);
    }

    /**
     * 统计词语在本文中出现的次数
     * @param poetry
     */
    private static void statistics(String poetry) {
        System.out.println("> 请输入需要查询的词语：");
        String word;//输入查询的单词
        while (true) {
            word = scanner.nextLine();//扫描
            if (word != null && word.length() > 0) {
                break;//检查输入是否为空
            }
            System.out.println("> 输入的词语不能为空，请重新输入");
            System.out.println("> 请输入需要查询的词语：");
        }
        Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(poetry);//正则表达式
        int count = 0;
        while (matcher.find()) {//查找查询的单词，找到一个加一次
            count++;
        }
        System.out.println("> “" + word + "”在本文中出现了 " + count + " 次。");
    }

    /**
     * 写文件
     * @param poetry
     */
    private static void writeFile(String poetry) {
        System.out.println("> 请输入您要保存的文件名(直接回车，则默认文件名为当前时间)：");
        String filename = scanner.nextLine();//输入文件名
        if (filename == null || filename.length() == 0) {//检查文件名是否为空
            filename = String.valueOf(System.currentTimeMillis());
        }
        System.out.println("> 正在写入文件...");
        String filePath = Main.class.getResource("").toString() + filename + ".txt";//录入地址
        filePath = filePath.replace("file:/", "");
        try {                                     //异常处理
            File file = new File(filePath);
            if (!file.getParentFile().exists()) {//检查文件夹是否存在
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            if (poetry != null && !"".equals(poetry)) {//检验字符串是否为空
                FileWriter fw = new FileWriter(file, true);
                fw.write(poetry);//写进文件
                fw.flush();//确定写入
                fw.close();
                System.out.println("> 成功写入文件。文件路径：" + filePath);
            }
        } catch (IOException e) {//异常处理
            e.printStackTrace();
            System.out.println("> 文件操作出现异常，程序退出。");
        }
        
    }

    /**
     * 处理输入的字符串
     * @param text
     * @return
     */
    public static String handler(String text) {
        System.out.println("> 预处理...(删除无关符号:，只保留汉字)");
        text = text.replaceAll("[^\u4e00-\u9fa5]", "");//将字符定义为汉字
        System.out.println("> 开始整理...");

        int size = 7;
        char odd = '，';//奇数后加逗号
        char even = '。';//偶数后加句号
        String poetry = "";
        for (int i = 0; i < text.length(); i++) {
            poetry += text.charAt(i);
            if ((i + 1) % size == 0) {//确定位置
                if ((i + 1) % 2 == 1) {
                    poetry += odd;
                } else {
                    poetry += even;
                    poetry += '\n';
                }
            }
        }

        System.out.println("> 整理完成。");
        System.out.println("> 整理结果如下：");
        System.out.println();
        System.out.println(poetry);
        return poetry;
    }
}
