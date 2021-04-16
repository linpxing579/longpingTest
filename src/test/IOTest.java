package test;

import org.junit.Test;

import java.io.*;

public class IOTest {

    @Test
    public void testFileInput() {
        File file = new File("C:\\Users\\Lpmas\\Desktop\\端口.txt");
        int count = 0;
        InputStream streamReader = null;
        try {
            streamReader = new FileInputStream(file);
            while (streamReader.read() != -1) {
                count++;
            }
            System.out.println("长度是：" + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                streamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileOutput() {
        byte[] buff = new byte[512];
        File file = new File("C:\\Users\\Lpmas\\Desktop\\端口.txt"); //一次取出的字节数大小,缓冲区大小
        int count = 0;
        InputStream streamReader = null;
        OutputStream outputStream = null;
        int num = 0;
        try {
            streamReader = new FileInputStream(file);
            outputStream = new FileOutputStream(new File("C:\\Users\\Lpmas\\Desktop\\端口-copy.txt"));
            while ((num = streamReader.read(buff)) != -1) {//num的目的在于防止最后一次读取的字节小于buffer长度，
                outputStream.write(buff, 0, num);
            }
            System.out.println("长度是：" + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                streamReader.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testBufferStream() {
        byte[] buff = new byte[2];
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\Lpmas\\Desktop\\端口.txt"));
            int num = 0;
            while ((num = bufferedInputStream.read(buff)) != -1) {
                System.out.println(new String(buff, 0, num));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testBufferStream2() {
        byte[] buff = new byte[512];
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            inputStream = new FileInputStream("C:\\Users\\Lpmas\\Desktop\\端口.txt");
            bufferedInputStream = new BufferedInputStream(inputStream);

            outputStream = new FileOutputStream("C:\\Users\\Lpmas\\Desktop\\端口-copy.txt");
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int num = 0;
            while ((num = bufferedInputStream.read(buff, 0, buff.length)) != -1) {
                bufferedOutputStream.write(buff, 0, num);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Description: 字符流 读出字符
     *
     * @author linpxing
     * @return: void
     **/
    @Test
    public void testInputSteamRead() {
        char[] buff = new char[1];
        InputStreamReader streamReader = null;
        try {
            streamReader = new InputStreamReader((new FileInputStream("C:\\Users\\Lpmas\\Desktop\\家庭农场导入模板.xls")));
            int num = 0;
            while ((num = streamReader.read(buff)) != -1) {
                System.out.println(new String(buff, 0, num));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                streamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testBufferInputSteamRead() {
        String str = "";
        InputStreamReader inputStream = null;
        BufferedReader reader = null;
        OutputStreamWriter outputStream = null;
        BufferedWriter writer = null;

        try {
            inputStream = new InputStreamReader((new FileInputStream("C:\\Users\\Lpmas\\Desktop\\端口.txt")));
            outputStream = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Lpmas\\Desktop\\端口-copy.txt"));

            reader = new BufferedReader(inputStream);
            writer = new BufferedWriter(outputStream);
            while ((str = reader.readLine()) != null) {
                writer.newLine();
                writer.write(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileDir(){
        File dir = new File("C:\\Users\\Lpmas\\Desktop\\templates");
        printFileName(dir);
    }

    public void printFileName(File dir){
        if (dir.isDirectory()) {
            File[] listFiles = dir.listFiles();
            for (File file : listFiles) {
                System.out.println(file.getName());
                printFileName(file);
            }
        }
    }
}
