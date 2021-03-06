package com.nju.ee.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 克崽兽 on 2016/12/21.
 */
public class RichTextUtil {
    public static List<String> getImageUrlsFromContent(String content) {
        //<img class="fr-dib fr-draggable" src="/files/img/1482125783639.jpg" style="width: 300px;">
        Pattern pattern = Pattern.compile("<img.*?src=\"(.*?)\".*?>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        List<String> imageUrls = new ArrayList<>();
        while (matcher.find()) {
            imageUrls.add(matcher.group(1));
        }
        return imageUrls;
    }

    public static String getFirstImageFromContent(String content) {
        Pattern pattern = Pattern.compile("<img.*?src=\"(.*?)\".*?>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        Properties properties = PropertiesUtil.getProperties("file_save.properties");
        if (properties == null) {
            return null;
        }
        String contextRoot = properties.getProperty("contextRoot");

        String imageUrl = contextRoot+"/image/default.default";
        if (matcher.find()) {
            imageUrl = matcher.group(1);
        }
        return imageUrl;
    }

    public static String getBriefFromContent(String content ,int maxLength) {
        Pattern patternOfParagraphs = Pattern.compile("(<p.*?>.*?</p.*?>)", Pattern.DOTALL);
        Matcher matcher = patternOfParagraphs.matcher(content);
        ArrayList<String> paragraphs = new ArrayList<>();
        while (matcher.find()) {
            paragraphs.add(matcher.group(1));
        }
        String firstParagraphWithoutImage = "";
        for (String paragraph : paragraphs) {
            Pattern patternOfImage = Pattern.compile("<img.*?>", Pattern.DOTALL);
            Matcher m = patternOfImage.matcher(paragraph);
            if (!m.find()) {
                String simplifiedParagraph = removeHtmlTags(paragraph);
                if (simplifiedParagraph.length() > 0) {
                    firstParagraphWithoutImage = simplifiedParagraph;
                    break;
                }
            }
        }
        if(firstParagraphWithoutImage.length()>maxLength){
            firstParagraphWithoutImage = firstParagraphWithoutImage.substring(0,maxLength);
            firstParagraphWithoutImage += "...";
        }
        return firstParagraphWithoutImage;
    }

    private static String removeHtmlTags(String content) {
        Pattern patternOfTag = Pattern.compile("<.*?>", Pattern.DOTALL);
        Pattern patternOfSpace = Pattern.compile("&nbsp;", Pattern.CASE_INSENSITIVE);

        Matcher m1 = patternOfTag.matcher(content);
        content = m1.replaceAll("");

        Matcher m2 = patternOfSpace.matcher(content);
        content = m2.replaceAll("");
        return content.trim();
    }
}
