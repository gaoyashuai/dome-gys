package com.dome.controller.generator;

import com.alibaba.fastjson.JSON;
import com.dome.domain.TUser;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.logging.SimpleFormatter;

/**
 * CLASSNAME Test
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/7/21 16:32
 * @Version 1.0
 */

public class Test {

    public static void main(String[] args) {
        List<TUser> list = new ArrayList<>();
        list.add(new TUser().setId(0l));
        list.add(new TUser().setId(1l));
        list.add(new TUser().setId(0l));
        list.add(new TUser().setId(2l));
        list.add(new TUser().setId(2l));
        list.add(new TUser().setId(1l));
        list.add(new TUser().setId(1l));
        list.add(new TUser().setId(1l));
        list.add(new TUser().setId(2l));
        list.add(new TUser().setId(1l));
        list.add(new TUser().setId(2l));
        list.add(new TUser().setId(2l));
        list.add(new TUser().setId(2l));

        //list.sort(Comparator.comparing(TUser::getId).reversed().thenComparing(TUser::getId));

        System.out.println(JSON.toJSONString(list));

        clean(list, 2L);

        System.out.println(JSON.toJSONString(list));

    }

    private static void clean(List<TUser> list, Long value) {
        Collections.reverse(list);
        ThreadLocal<Boolean> first = new ThreadLocal<>();
        first.set(true);
        if (list.get(0).getId().equals(value)) {
            list.removeIf(x -> {
                        first.set(first.get() && x.getId().equals(value));
                        return x.getId().equals(value) && !first.get();
                    }

//            list.removeIf(new Predicate(){
//                              @Override
//                              public boolean test(Object o) {
//                                  TUser x = (TUser) o;
//                                  first.set(first.get() && x.getId().equals(value));
//                                    return x.getId().equals(value) && !first.get();
//                              }
//                          }
            );
        } else {
            list.removeIf(x -> x.getId().equals(value));
        }
        Collections.reverse(list);
    }
}
