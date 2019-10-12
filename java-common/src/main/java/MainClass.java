import com.ydfind.util.FileUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
/**
 * 消除重复类 试验
 * @author ydfind
 * @date 2019.10.12
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        String file = "D:\\应用分类表导出1561001517264.csv";
        List<String> list = FileUtils.readFileList(file, "utf-8");
        int i = 0;
        while (i < list.size()){
            String temp = list.get(i);
            String temp1 = temp;
            if(Objects.nonNull(temp)){
                int id = temp.substring(0, temp1.length() - 1).lastIndexOf(",");
                temp1 = temp.substring(0, id).trim();
                boolean tempb = !temp1.endsWith(",,");
                temp = temp.trim();
                int j = i + 1;
                while (j < list.size()){
                    String next = list.get(j);
                    if(Objects.nonNull(next)){
                        next = next.trim();
                    }
                    if(temp.equals(next)){
                        list.remove(j);
                        j--;
                    }
                    else if(tempb || !next.endsWith(",,")){
                        String next1 = next;
                        id = next.substring(0,next.length() - 1).lastIndexOf(",");
                        next1 = next.substring(0, id).trim();
                        if(temp1.equals(next1)){
                            list.remove(j);
                            j--;
                        }
                    }
                    j++;
                }
            }
            i++;
        }
        StringBuffer sb = new StringBuffer();
//        for (i = 0; i < list.size(); i++){

        for (i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i) + "\r\n");

        }
        FileUtils.writeFile("D:\\应用分类表导出1560931034498-消除重复5.csv", sb.toString());
    }
//public static void main(String[] args) throws IOException {
//    String file = "D:\\应用分类表导出1560931034498----1.csv";
//    List<String> list = FileUtil.readFileList(file, "utf-8");
//    int i = list.size() - 1;
//    while (i >= 0){
//        String temp = list.get(i);
//        if(Objects.nonNull(temp) && temp.indexOf(",") > 0){
//            String[] fields = temp.split(",");
//            if(fields.length > 11 && fields[11].trim().length() > 0){
//                i--;
//                continue;
//            }
//        }
//        list.remove(i);
//        i--;
//    }
//    StringBuffer sb=new StringBuffer();
//    for (i = 0; i < list.size(); i++){
//        sb.append(list.get(i) + "\r\n");
//    }
//    FileUtil.writeFile("D:\\应用分类表导出1560931034498-消除重复4.csv", sb.toString());
//}
}
