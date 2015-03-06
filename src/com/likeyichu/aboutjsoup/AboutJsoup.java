package com.likeyichu.aboutjsoup;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AboutJsoup {
	/**根据指定的url得到网页，返回文本，第二个参数返回标题*/
	public static String getText(String url,StringBuilder out_title) throws IOException {
		Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
		System.out.println("得到一篇文档，标题：     "+doc.title());
		if(out_title.toString().length()!=0)
			out_title.delete(0,out_title.toString().length()-1);
		out_title.append(doc.title());
		String text = doc.text();
//		String[] texts = text.split("。|\\.");// 以中文句号或英文句号作为分割
//		for (String string : texts) {
//			System.out.println(string);
//		}
		return text;
	}
}