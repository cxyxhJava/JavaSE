import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import javax.annotation.PostConstruct;
/**
 * @author franyang
 * @date 2020/11/5
 */
//@Component
//@Slf4j
public class Test {
    private long workerId = 0;//为终端ID
    private long datacenterId = 1;//数据中心ID
    private Snowflake snowflake = IdUtil.createSnowflake(workerId,datacenterId);
    @PostConstruct
    public void init(){
        workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        //log.info("当前机器的workId:{}",workerId);
        System.out.println("当前机器的workId:"+workerId);
    }
    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }
    public synchronized long snowflakeId(long workerId,long datacenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }


    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.snowflakeId());
        test.init();
        System.out.println(test.workerId);
        test.snowflake.nextId();
//        test.init();
        System.out.println(test.snowflakeId());
        System.out.println(test.snowflakeId(1,2));
    }

}

