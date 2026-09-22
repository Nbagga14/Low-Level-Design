package Proxy.WithProxy;

import java.util.HashMap;

interface videoDownloader{
    String downloadVideo(String videoURL);
}

class RealVideoDownloader implements videoDownloader{

    @Override
    public String downloadVideo(String videoURL) {
        System.out.println("Downloading video from Real Video Downloader "+ videoURL);
        return videoURL;
    }
}

class CacheVideoDownloader implements videoDownloader{
    RealVideoDownloader realVideoDownloader;
    HashMap<String,String> cache;

    public CacheVideoDownloader()
    {
        this.realVideoDownloader = new RealVideoDownloader();
        this.cache = new HashMap<>();
    }
    @Override
    public String downloadVideo(String videoURL) {
     if(cache.containsKey(videoURL))
     {
         System.out.println("Downloading Video from cache "+videoURL);
         return cache.get(videoURL);
     }
     String video = realVideoDownloader.downloadVideo(videoURL);
     cache.put(videoURL,video);
     return video;
    }
}

public class WithProxy {
    public static void main(String[] args) {
        CacheVideoDownloader cacheVideoDownloader = new CacheVideoDownloader();
        String videoURL = "https://Netflix.movies.abc";
        cacheVideoDownloader.downloadVideo(videoURL);

        cacheVideoDownloader.downloadVideo(videoURL);
    }

}
