package js8ri.ch06.ex10;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScrapeURL {

	public static CompletableFuture<String> readPage(String strUrl){
		return CompletableFuture.supplyAsync(() -> {
			// https://www.tutorialspoint.com/how-to-read-the-contents-of-a-webpage-into-a-string-in-java
			URL url = null;
			try {
				url = new URL(strUrl);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}

			StringBuffer sb = new StringBuffer();
			try (Scanner sc = new Scanner(url.openStream());){
			    while(sc.hasNext()) {
			       sb.append(sc.nextLine()).append("\n");
			    }
			} catch (IOException e) {
				e.printStackTrace();
			}
			return sb.toString();
		});
	}

	public static List<URL> getLinks(String content){
		// http://www.groovy-number.com/java/sample/UrlCollector.html
		String linkPattern = "<a href=\\\"([^\\\"]+)\\\">";
        Matcher matcher = Pattern.compile(linkPattern, Pattern.CASE_INSENSITIVE).matcher(content);
        List<URL> urls = new ArrayList<>();
        while (matcher.find()) {
        	String matchedUrl = matcher.group(1);
            try {
                urls.add(new URL(matchedUrl)); // todo: パターンにマッチした url を encode をする
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return urls;
	}

	public static void main(String[] args) {
		String url = "https://www.google.com/";
		CompletableFuture<String> contents = readPage(url);
		CompletableFuture<List<URL>> links = contents.thenApply(ScrapeURL::getLinks);
		links.thenAccept(urls -> {
			urls.forEach(System.out::println);
		});
		ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
	}

}
