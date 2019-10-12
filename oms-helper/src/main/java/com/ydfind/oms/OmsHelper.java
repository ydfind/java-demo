package com.ydfind.oms;

import com.ydfind.util.FileUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class OmsHelper {

    private static String CONTROLLER_FILE = "ControllerConfig.java";
    private static String RESOURCE_FILE = "ResourceInit.java";
    private static String AUTHORIZATION_FILE = "AuthorizationInterceptor.java";

    private static String OMS_PUT_HTTP_FILE = "RestTemplateRequest.java";

    private static String OMS_AGENT_CACHE_TARGET = "    public static String readFile(String path, String encode) throws IOException {\n" +
            "        StringBuffer sb=new StringBuffer();\n" +
            "        String tempstr=null;\n" +
            "        try {\n" +
            "            File file=new File(path);\n" +
            "            if(!file.exists()) {\n" +
            "                throw new FileNotFoundException();\n" +
            "            }\n" +
            "            FileInputStream fis=new FileInputStream(file);\n" +
            "            BufferedReader br=new BufferedReader(new InputStreamReader(fis, encode));\n" +
            "            while((tempstr=br.readLine())!=null) {\n" +
            "                sb.append(tempstr + \"\\r\\n\");\n" +
            "            }\n" +
            "            if(sb.length() > 0){\n" +
            "                sb.delete(sb.length() - 2, sb.length());\n" +
            "            }\n" +
            "        } catch(IOException ex) {\n" +
            "            throw new IOException(\"readFile \" + path + \" error\", ex);\n" +
            "        }\n" +
            "        return sb.toString();\n" +
            "    }\n" +
            "    public static void writeFile(String path, String str) throws IOException {\n" +
            "        try {\n" +
            "            System.out.println(path);\n" +
            "            File file = new File(path);\n" +
            "            if(!file.getParentFile().exists()) {\n" +
            "                file.getParentFile().mkdirs();\n" +
            "            }\n" +
            "            if(!file.exists()){\n" +
            "                file.createNewFile();\n" +
            "            }\n" +
            "            FileOutputStream out = new FileOutputStream(file);\n" +
            "            StringBuffer sb = new StringBuffer();\n" +
            "            sb.append(str + \"\\r\\n\");\n" +
            "            out.write(sb.toString().getBytes(\"utf-8\"));\n" +
            "            out.close();\n" +
            "        } catch(IOException ex) {\n" +
            "            throw new IOException(\"writeFile \" + path + \" error\", ex);\n" +
            "        }\n" +
            "    }\n" +
            "    public static String request(String body, String url) {\n" +
            "        if(url.contains(\"http://10.254.209.46:26688\")) {\n" +
            "            try {\n" +
            "                String content = readFile(\"D:\\\\tmp\\\\temp.txt\", \"utf-8\");\n" +
            "                Map<String, String> map = new HashMap<>();\n" +
            "                if (Objects.isNull(content) || \"\".equals(content)) {\n" +
            "                } else {\n" +
            "                    map = JSONObject.parseObject(content, HashMap.class);\n" +
            "                }\n" +
            "                map.put(url, body);\n" +
            "                content = JSON.toJSONString(map);\n" +
            "                writeFile(\"D:\\\\tmp\\\\temp.txt\", content);\n" +
            "            }catch (Exception e){\n" +
            "                e.printStackTrace();\n" +
            "            }\n" +
            "\n" +
            "            url = url.replace(\"http://10.254.209.46:26688\", \"http://10.0.55.82:21102\");\n" +
            "        }\n";

    /**
     * 处理飞验-代理商系统的本地调试问题
     * @param path
     * @throws IOException
     */
    public static void processOmsAgentCache(String path) throws IOException {
        String file = FileUtils.findFirstByFilename(path, OMS_PUT_HTTP_FILE);
        List<String> list = FileUtils.readFileList(file, "utf-8");
        String source = "public static String request(String body, String url){";
        String target = OMS_AGENT_CACHE_TARGET;
        CommonHelper.findAndReplaceRow(list, source, target);


        source = "package com.baofu.oms.biz.common;";
        target = "package com.baofu.oms.biz.common;\n" +
                "\n" +
                "import com.alibaba.fastjson.JSON;\n" +
                "import com.alibaba.fastjson.JSONObject;\n" +
                "import java.io.*;\n" +
                "import java.util.*;";
        CommonHelper.findAndReplaceRow(list, source, target);

        source = "\n" +
                "import java.util.Arrays;\n" +
                "import java.util.List;";
        target = "";
        CommonHelper.findAndReplaceRow(list, source, target);
        FileUtils.writeFile(file, list);
    }

    /**
     * 处理飞验-代理商系统的本地调试问题
     * @param path
     * @throws IOException
     */
    public static void processOmsAgent(String path) throws IOException {
        String file = FileUtils.findFirstByFilename(path, OMS_PUT_HTTP_FILE);
        List<String> list = FileUtils.readFileList(file, "utf-8");
        String source = "public static String request(String body, String url){";
        String target =
                "    public static String request(String body, String url) {\n" +
                "        if(url.contains(\"http://10.254.209.46:26688\")) {\n" +
                "            url = url.replace(\"http://10.254.209.46:26688\", \"http://10.0.55.82:21102\");\n" +
                "        }\n";
        CommonHelper.findAndReplaceRow(list, source, target);


        FileUtils.writeFile(file, list);
    }

    /**
     * 处理消息推送的本地调试问题
     * @param path
     * @throws IOException
     */
    public static void processOmsFeiYanDpcDebug(String path) throws IOException {
        String file = FileUtils.findFirstByFilename(path, OMS_PUT_HTTP_FILE);
        List<String> list = FileUtils.readFileList(file, "utf-8");
        String source = "public static String request(String body, String url){";
        String target = "public static String request(String body, String url){\n" +
                "        if(url.contains(\"https://dfp-test.xinyan.com/gateway/feiyan-dpc\")) {\n" +
                "            url = url.replace(\"https://dfp-test.xinyan.com/gateway/feiyan-dpc\", \"http://10.0.55.82:21102\");\n" +
                "        }";
        CommonHelper.findAndReplaceRow(list, source, target);
        FileUtils.writeFile(file, list);
    }

    public static void processOms(String path) throws IOException {
        String controllerFile = FileUtils.findByFilename(path, CONTROLLER_FILE);
        String resourceFile = FileUtils.findByFilename(path, RESOURCE_FILE);
        String authorizationFile = FileUtils.findByFilename(path, AUTHORIZATION_FILE);
        List<String> controllers = FileUtils.readFileList(controllerFile, "utf-8");
        List<String> resources = FileUtils.readFileList(resourceFile, "utf-8");
        List<String> authorization = FileUtils.readFileList(authorizationFile, "utf-8");


        controllers = proccessController(controllers);
        FileUtils.writeFile(controllerFile, controllers);

        processResource(resources);
        FileUtils.writeFile(resourceFile, resources);

        authorization = processAuthorization(authorization);
        FileUtils.writeFile(authorizationFile, authorization);
    }

    public static List<String> proccessController(List<String> list){
        for(int i = 0; i < list.size() - 1; i++){
            String str = list.get(i);
            if(str.indexOf("session.getAttribute(\"userAccount\"));") >= 0){
                str += "\r\n userAccount = \"yu_zhong@xinyan.com\";";
                list.set(i, str);
                break;
            }
        }
        int start = -1;
        int end = -1;
        for(int i = 0; i < list.size() - 1; i++){
            String str = list.get(i);
            if(str.indexOf("JSONObject jsonObject2 = jsonObject1.getJSONObject(\"authenticationSuccess\");") >= 0){
                start = i;
            }
            if(str.indexOf("response.sendRedirect(restApiConfig.getServerUrl());") >= 0){
                end = i;
            }
        }
        List<String> newControllers = new ArrayList<>();
        for(int i = 0; i <= start; i++){
            newControllers.add(list.get(i));
        }
        newControllers.add("if (jsonObject2 != null) {\n" +
                "                String username = jsonObject2.getString(\"user\");\n" +
                "                session.setAttribute(\"userAccount\", username);\n" +
                "                cacheConfig.insertObject(ConstantUtils.SYSTEM_NAME + \":\" + username, ticket, 30L);\n" +
                "                //登录成功通知依赖应用登录成功 http://www.zhongyu123.com:21102/manager/oms/omsNoticeTicketValidate\n" +
                "                apiPostUtil = new ApiPostUtil(restApiConfig.getManagerLoginNoticeUrl(),\n" +
                "                        30000, 30000);\n" +
                "                apiPostUtil.sendHttp(username, \"POST\", \"UTF-8\");\n" +
                "                //Hbase http://www.zhongyu123.com:32102/credit-hbase-config/oms/omsNoticeTicketValidate\n" +
                "                apiPostUtil = new ApiPostUtil(restApiConfig.getHbaseLoginNoticeUrl(),30000, 30000);\n" +
                "                apiPostUtil.sendHttp(username, \"POST\", \"UTF-8\");\n" +
                "            } else {\n" +
                "                JSONObject jsonObject3 = jsonObject1.getJSONObject(\"authenticationFailure\");\n" +
                "                String description = jsonObject3.getString(\"description\");\n" +
                "            }\n" +
                "            log.info(\"企业sso认证回调结束...\");");
        for(int i = end; i < list.size(); i++){
            newControllers.add(list.get(i));
        }
        return newControllers;
    }

    public static void processResource(List<String> list){
        for(int i = 0; i < list.size() - 1; i++){
            String str = list.get(i);
            if(str.indexOf("session.getAttribute(\"userAccount\"));") >= 0){
                str += "\r\n userAccount = \"yu_zhong@xinyan.com\";";
                list.set(i, str);
                break;
            }
        }
    }

    public static List<String> processAuthorization(List<String> list){
        int start = -1;
        int end = -1;
        for(int i = 0; i < list.size() - 1; i++){
            String str = list.get(i);
            if(str.indexOf("HttpSession session = request.getSession();") >= 0){
                start = i;
            }
            if(str.indexOf("cacheConfig.insertObject(ConstantUtils.SYSTEM_NAME + \":\" + userAccount, ticket, 30L);") >= 0){
                end = i;
            }
        }
        List<String> newControllers = new ArrayList<>();
        for(int i = 0; i < start; i++){
            newControllers.add(list.get(i));
        }
        for(int i = end + 1; i < list.size(); i++){
            newControllers.add(list.get(i));
        }
        return newControllers;
    }
}
