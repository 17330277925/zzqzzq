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
     * ������
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("> ��������Ҫ����Ĺ�ʫ��");
        String text;//�����ַ���
        while (true) {
            text = scanner.nextLine();//ɨ���ַ���
            System.out.println("> ���ڷ���...");
            if (text != null && text.length() > 0) {//��������Ƿ�Ϊ��
                break;
            }
            System.out.println("> ���벻��Ϊ�գ�����������");
            System.out.println("> ��������Ҫ����Ĺ�ʫ��");
        }
        String poetry = handler(text);
        writeFile(poetry);
        statistics(poetry);
    }

    /**
     * ͳ�ƴ����ڱ����г��ֵĴ���
     * @param poetry
     */
    private static void statistics(String poetry) {
        System.out.println("> ��������Ҫ��ѯ�Ĵ��");
        String word;//�����ѯ�ĵ���
        while (true) {
            word = scanner.nextLine();//ɨ��
            if (word != null && word.length() > 0) {
                break;//��������Ƿ�Ϊ��
            }
            System.out.println("> ����Ĵ��ﲻ��Ϊ�գ�����������");
            System.out.println("> ��������Ҫ��ѯ�Ĵ��");
        }
        Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(poetry);//������ʽ
        int count = 0;
        while (matcher.find()) {//���Ҳ�ѯ�ĵ��ʣ��ҵ�һ����һ��
            count++;
        }
        System.out.println("> ��" + word + "���ڱ����г����� " + count + " �Ρ�");
    }

    /**
     * д�ļ�
     * @param poetry
     */
    private static void writeFile(String poetry) {
        System.out.println("> ��������Ҫ������ļ���(ֱ�ӻس�����Ĭ���ļ���Ϊ��ǰʱ��)��");
        String filename = scanner.nextLine();//�����ļ���
        if (filename == null || filename.length() == 0) {//����ļ����Ƿ�Ϊ��
            filename = String.valueOf(System.currentTimeMillis());
        }
        System.out.println("> ����д���ļ�...");
        String filePath = Main.class.getResource("").toString() + filename + ".txt";//¼���ַ
        filePath = filePath.replace("file:/", "");
        try {                                     //�쳣����
            File file = new File(filePath);
            if (!file.getParentFile().exists()) {//����ļ����Ƿ����
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            if (poetry != null && !"".equals(poetry)) {//�����ַ����Ƿ�Ϊ��
                FileWriter fw = new FileWriter(file, true);
                fw.write(poetry);//д���ļ�
                fw.flush();//ȷ��д��
                fw.close();
                System.out.println("> �ɹ�д���ļ����ļ�·����" + filePath);
            }
        } catch (IOException e) {//�쳣����
            e.printStackTrace();
            System.out.println("> �ļ����������쳣�������˳���");
        }
        
    }

    /**
     * ����������ַ���
     * @param text
     * @return
     */
    public static String handler(String text) {
        System.out.println("> Ԥ����...(ɾ���޹ط���:��ֻ��������)");
        text = text.replaceAll("[^\u4e00-\u9fa5]", "");//���ַ�����Ϊ����
        System.out.println("> ��ʼ����...");

        int size = 7;
        char odd = '��';//������Ӷ���
        char even = '��';//ż����Ӿ��
        String poetry = "";
        for (int i = 0; i < text.length(); i++) {
            poetry += text.charAt(i);
            if ((i + 1) % size == 0) {//ȷ��λ��
                if ((i + 1) % 2 == 1) {
                    poetry += odd;
                } else {
                    poetry += even;
                    poetry += '\n';
                }
            }
        }

        System.out.println("> ������ɡ�");
        System.out.println("> ���������£�");
        System.out.println();
        System.out.println(poetry);
        return poetry;
    }
}
