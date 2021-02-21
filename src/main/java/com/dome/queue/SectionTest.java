package com.dome.queue;

import com.dome.param.ActiveExtendDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * CLASSNAME SectionTest
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/8/22 21:54
 * @Version 1.0
 */
public class SectionTest {

    public static void main(String[] args) {

        String concat1 = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println("拼接1的值为："+concat1);



        ArrayList<ActiveExtendDTO> activeExtendDTOS = new ArrayList<>();

        ActiveExtendDTO activeExtendDTO = new ActiveExtendDTO();
        activeExtendDTO.setCommodityMinNum(0L);
        activeExtendDTO.setCommodityMaxNum(5L);
        activeExtendDTOS.add(activeExtendDTO);

        ActiveExtendDTO activeExtendDTO1 = new ActiveExtendDTO();
        activeExtendDTO1.setCommodityMinNum(5L);
        activeExtendDTO1.setCommodityMaxNum(10L);
        activeExtendDTOS.add(activeExtendDTO1);

        ActiveExtendDTO activeExtendDTO2 = new ActiveExtendDTO();
        activeExtendDTO2.setCommodityMinNum(10L);
        activeExtendDTO2.setCommodityMaxNum(15L);
        activeExtendDTOS.add(activeExtendDTO2);

        ActiveExtendDTO activeExtendDTO3 = new ActiveExtendDTO();
        activeExtendDTO3.setCommodityMinNum(15L);
        activeExtendDTO3.setCommodityMaxNum(20L);
        activeExtendDTOS.add(activeExtendDTO3);

        ActiveExtendDTO activeExtendDTO4 = new ActiveExtendDTO();
        activeExtendDTO4.setCommodityMinNum(3L);
        activeExtendDTO4.setCommodityMaxNum(25L);
        activeExtendDTOS.add(activeExtendDTO4);


        // checkOverlap2(activeExtendDTOS);

    }

    private static void checkOverlap2(List<ActiveExtendDTO> list) {
        // 根据区间最小值进行排序
        List<ActiveExtendDTO> sortList = list.stream().sorted(Comparator.comparing(ActiveExtendDTO::getCommodityMinNum)).collect(Collectors.toList());
        //  a的最大区间 和 b的最小区间进行比较   如果 a max 比 b min 大  那么 a b 的区间重叠
        sortList.stream().reduce((a, b) -> {
            if (a.getCommodityMaxNum() > b.getCommodityMinNum()) {
                System.out.println("区间有重叠");
            }
            return b;
        });

        /**
         * @methodName: checkOverlap2
         * @Author: gaoyashuai 2020/8/22 22:16
         * 前面两句可以合成一句实现  如下
         **/
        list.stream().sorted(Comparator.comparing(ActiveExtendDTO::getCommodityMinNum))
                .reduce((a, b) -> {
                    if (a.getCommodityMaxNum() > b.getCommodityMinNum()) {
                        System.out.println("区间有重叠");
                    } else {
                        System.out.println("没有重叠");
                    }
                    return b;
                });
    }
}
