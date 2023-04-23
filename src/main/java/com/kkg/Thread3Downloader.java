package com.kkg;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
//开启线程的第一种方法,不推荐使用
public class Thread3Downloader extends Thread {
    private String url;
    private String name;

    public Thread3Downloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("图片"+name+"下载成功");
    }

    public static void main(String[] args) {
      Thread3Downloader t1 = new Thread3Downloader("https://mywowo.net/media/images/cache/pechino_citta_proibita_01_introduzione_prima_parte_jpg_1200_630_cover_85.jpg","故宫.jpg");
      Thread3Downloader t2 = new Thread3Downloader("https://pic.baike.soso.com/ugc/baikepic2/0/ori-20201218181812-470943077_png_929_828_713587.jpg/800","恶魔小熊,jpg");
      Thread3Downloader t3 = new Thread3Downloader("https://bkimg.cdn.bcebos.com/pic/bf096b63f6246b6081202b74e4f81a4c510fa280\n","汉武帝.jpg");
       t1.start();
       t2.start();
       t3.start();
    }

    class WebDownloader{
        public void downloader(String url, String name){
            try {
                FileUtils.copyURLToFile(new URL(url),new File(name));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("出现异常");
            }
        }
    }

}
