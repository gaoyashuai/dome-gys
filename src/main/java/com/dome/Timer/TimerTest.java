package com.dome.Timer;

import com.dome.domain.TUser;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;

/**
 * CLASSNAME TimerTest
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/6/23 12:50
 * @Version 1.0
 */
public class TimerTest {
<<<<<<< HEAD
    //    public static void main(String[] args){
//
//        //timer定时  设置的时间没过期的情况下正常  设置的时间过期了就每回启动项目的时候都会执行
//        Timer timer = new Timer();
//        Calendar calendar = Calendar.getInstance();
////        calendar.set(Calendar.YEAR,2020);//控制年
////        calendar.set(Calendar.MINUTE,5);//控制月份
//        calendar.set(Calendar.DAY_OF_MONTH,23);//控制日期
//        calendar.set(Calendar.HOUR_OF_DAY, 12);//控制小时
//        calendar.set(Calendar.MINUTE, 49);//控制分钟
//        calendar.set(Calendar.SECOND, 0);//控制秒
//        Date time = calendar.getTime();//执行任务时间为12:00:00
//
//        System.out.println(time);
//        //每天定时12:00执行操作，延迟一天后再执行
//        new Timer().schedule(new TimerTaskTest(), time ,1000 * 60 * 60 * 24);
//    }
    public static void main(String[] args) {
      /*  HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("aaa","000000000000");
        stringObjectHashMap.put("bbb","000000000000");
        stringObjectHashMap.put("ccc","000000000000");
        stringObjectHashMap.put("ddd","000000000000");
        stringObjectHashMap.put("eee","000000000000");
        stringObjectHashMap.put("fff","000000000000");
        stringObjectHashMap.put("aaa","111111111111");

        Set<String> strings = stringObjectHashMap.keySet();

        for (String string : strings) {
            System.out.println(string+": "+stringObjectHashMap.get(string));
        }

        int year = LocalDateTime.now().getYear();
        Month month = LocalDateTime.now().getMonth();
        int value = month.getValue();
        System.out.println(year+":"+value);
*/
        List<TUser> integers = new ArrayList<>();
        integers.add(new TUser().setUserId("1111").setId(1l));
        integers.add(new TUser().setUserId("1111").setId(2l));
        integers.add(new TUser().setUserId("1111").setId(3l));
        integers.add(new TUser().setUserId("1111").setId(2l));
        integers.add(new TUser().setUserId("1111").setId(3l));
        integers.add(new TUser().setUserId("1111").setId(4l));
        integers.add(new TUser().setUserId("1111").setId(3l));
        integers.add(new TUser().setUserId("1111").setId(2l));

        integers.add(new TUser().setUserId("1111").setId(5l));
        integers.add(new TUser().setUserId("1111").setId(6l));
        integers.add(new TUser().setUserId("1111").setId(7l));

//        1,2,3,1,1,2,3,3,3,2

        System.out.println(integers);

        ArrayList<TUser> collect = integers.stream()
                .collect(collectingAndThen(Collectors.toCollection(() ->
                        new TreeSet<>(comparing(TUser::getId))), ArrayList::new));


        //clean(integers,2);

        System.out.println(collect);
=======
    public static void main(String[] args){
        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2020);//控制年
        calendar.set(Calendar.MINUTE,5);//控制月份
        calendar.set(Calendar.DAY_OF_MONTH,23);//控制日期
        calendar.set(Calendar.HOUR_OF_DAY, 12);//控制小时
        calendar.set(Calendar.MINUTE, 49);//控制分钟
        calendar.set(Calendar.SECOND, 0);//控制秒
        Date time = calendar.getTime();//执行任务时间为12:00:00

        //每天定时12:00执行操作，延迟一天后再执行
        new Timer().schedule(new TimerTaskTest(), time ,1000 * 60 * 60 * 24);
>>>>>>> parent of 6ba78cd... send mail
    }

    public static void clean(List<Integer> list, Integer value) {
        Collections.reverse(list);
        ThreadLocal<Boolean> first = new ThreadLocal<>();
        first.set(true);
        if (list.get(0).equals(value)) {
            list.removeIf(x -> {
                first.set(first.get() && x.equals(value));
                return x.equals(value) && !first.get();
            });
        } else {
            list.removeIf(x -> x.equals(value));
        }
        Collections.reverse(list);
    }


}
