package com.example.util;

import com.example.dbhelper.DBHelper;
import com.example.pojo.Info;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.*;

public class ConsumerUtil {

    private static final Logger logger = Logger.getLogger(ConsumerUtil.class);

    private static final String TOPIC = "topic-demo";
    private static Properties properties = null;

    private static ConsumerConfig conf = null;

    private static ConsumerConnector connector = null;

    private static Map<String, Integer> topicCountMap = null;

    private static KafkaStream<byte[], byte[]> stream = null;

    private static Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = null;

    static {
        properties = new Properties();
        properties.put("zookeeper.connect", "localhost:2181");//声明zk
        properties.put("group.id", "test1909151620");// 必须要使用别的组名称， 如果生产者和消费者都在同一组，则不能访问同一组内的topic数据

        // 将属性添加到ConsumerConfig配置中
        conf = new ConsumerConfig(properties);

        // 创建连接
        connector = Consumer.createJavaConsumerConnector(conf);

        topicCountMap = new HashMap<String, Integer>();

    }

    public static void consumer() {
        topicCountMap.put(TOPIC, 1); // 一次从主题中获取一个数据
        messageStreams = connector.createMessageStreams(topicCountMap);
        stream = messageStreams.get(TOPIC).get(0);// 获取每次接收到的这个数据
        ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
        while (iterator.hasNext()) {
            String message = new String(iterator.next().message());
            String topic = new String(iterator.next().topic());

            logger.info("************************************************************************************************************");
            logger.info("接收到: " + message);
            logger.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString() + "消费者消费了一条消息------------");
            logger.info("************************************************************************************************************\n");

            Info i = new Info();
            i.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            i.setMessage(message);
            i.setTopic(topic);
            insertInfo(i);

        }
    }

    private static void insertInfo(Info i) {
        String sql = "insert into t_info(id,topic, message,insert_date) values(?,?,?,now());";
        Object[] values = {i.getId(), i.getTopic(), i.getMessage()};
        DBHelper.insert(sql, values);
    }

    public static void main(String[] args) {
        consumer();
    }


}
