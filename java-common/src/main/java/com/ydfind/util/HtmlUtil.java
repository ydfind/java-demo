package com.ydfind.util;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Objects;
/**
 * Html类 试验
 * @author ydfind
 * @date 2019.10.12
 */
public class HtmlUtil {

    /**
     * 获取第一个标签的text
     * @param elements
     * @return
     */
    public static String getFirstText(Elements elements){
        String text = null;
        if (Objects.nonNull(elements) && elements.size() > 0) {
            return getEleText(elements.get(0));
        }
        if(Objects.isNull(text)){
            text = "";
        }else{
            text = text.trim();
        }
        return text;
    }

    /**
     * 获取标签的text
     * @param element
     * @return
     */
    public static String getEleText(Element element){
        String text = null;
        if (!Objects.isNull(element)) {
            text = element.text();
        }
        if(Objects.isNull(text)){
            text = "";
        }else{
            text = text.trim();
        }
        return text;
    }



    /**
     * 查找root下tags路径的element
     * @param root
     * @return
     */
    public static Element getElementByTags(Element root, String[] tags){
        Element curElem = root;
        for(String tag: tags){
            Elements subItems = curElem.getElementsByTag(tag);
            if(Objects.nonNull(subItems) && subItems.size() > 0){
                return null;
            }
            curElem = subItems.get(0);
        }
        return curElem;
    }
}
