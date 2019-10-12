import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间类 试验
 * @author ydfind
 * @date 2019.10.12
 */
@Slf4j
public class DateTest {

    public static void main(String[] args) throws ParseException {
//        Date start = new Date(2009 - 1900, 11, 1, 0, 0,0);
//        Date end = new Date(2019 - 1900, 5, 20, 23, 59,59);

        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = dateFormat2.parse("2019-07-01 00:00:00");
        Date end = dateFormat2.parse("2019-07-01 23:59:59");
        JSONObject obj = new JSONObject();
        obj.put("beginCreatedAt", start);
        obj.put("endCreatedAt", end);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startStr = sdf.format(start);
        String endStr = sdf.format(end);
        log.info("startDate: {}, endDate:{}", startStr, endStr);
        log.info("json:\n{}", JSONObject.toJSONString(obj));
    }
}
