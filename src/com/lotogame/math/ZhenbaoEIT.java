package com.lotogame.math;

import java.text.NumberFormat;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ZhenbaoEIT {
    private Integer[] axis1;
    private Integer[] axis2;
    private Integer[] axis3;
    /**
     * 每个轴的长度
     */
    private Integer axisLen;
    /**
     * 总窗口，即奖组大小
     */
    private Integer totalWindows;
    /**
     * 各奖符的中奖奖金：分
     **/
    private Integer[] awards;


    public ZhenbaoEIT() {
        ZhenboConf conf = new ZhenboConf();
        conf = new ZhenbaoConf1();
        this.axisLen = conf.AXIS_LENGTH;
        this.totalWindows = this.axisLen * this.axisLen * this.axisLen;
        axis1 = conf.AXIS1;
        axis2 = conf.AXIS2;
        axis3 = conf.AXIS3;
        this.awards = conf.AWARDS;
    }

    public static void main(String[] args) {
        ZhenbaoEIT game = new ZhenbaoEIT();
        game.checkAllAxis();
        game.calAwards();
    }

    /**
     * 比较线上的三个数是否中奖，即三个数是否一致
     * 注意：no2有10通配符
     *
     * @param no1
     * @param no2
     * @param no3
     * @return
     */
    private boolean checkLine(Integer no1, Integer no2, Integer no3) {
        // 中间数字遇到通配符，则替换成第一个数字的值
        if (no2.equals(10)) {
            no2 = no1;
        }
        if (no1.equals(no2) && no2.equals(no3)) {
            return true;
        } else {
            return false;
        }
    }

    public void calAwards() {
        if (axis1.length != axis2.length || axis2.length != axis3.length) {
            System.err.println("三轴数量不一致，请检查！");
            return;
        }
        int LENGTH = axis1.length;
        // <单注奖金, 窗口数量>
        TreeMap<Integer, Integer> result = new TreeMap<>();
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                for (int k = 0; k < LENGTH; k++) {
                    int award = 0;
                    //// 检查5条线是否一致，并记录一致线的符号和数量
                    // 第一条线横线
                    if (checkLine(axis1[i], axis2[j], axis3[k])) {
                        award += awards[axis1[i] - 1];
                    }
                    // the No.2 row line.
                    if (checkLine(axis1[(i + 1) % LENGTH], axis2[(j + 1) % LENGTH], axis3[(k + 1) % LENGTH])) {
                        award += awards[axis1[(i + 1) % LENGTH] - 1];
                    }
                    // the No.3 row line.
                    if (checkLine(axis1[(i + 2) % LENGTH], axis2[(j + 2) % LENGTH], axis3[(k + 2) % LENGTH])) {
                        award += awards[axis1[(i + 2) % LENGTH] - 1];
                    }
                    // the '\' line.
                    if (checkLine(axis1[i], axis2[(j + 1) % LENGTH], axis3[(k + 2) % LENGTH])) {
                        award += awards[axis1[i] - 1];
                    }
                    // the '/' line.
                    if (checkLine(axis1[(i + 2) % LENGTH], axis2[(j + 1) % LENGTH], axis3[k])) {
                        award += awards[axis1[(i + 2) % LENGTH] - 1];
                    }

                    // 累加同一种单注奖金的窗口数
                    if (result.containsKey(award)) {
                        Integer curWindows = result.get(award) + 1;
                        result.put(award, curWindows);
                    } else {
                        result.put(award, 1);
                    }
                }
            }
        }

        double awardWindows = 0;
        double award = 0;
        System.out.println("不同单注奖金的数量（包括不中奖类型） " + result.size());
        for (Entry<Integer, Integer> item : result.entrySet()) {
            float key = item.getKey().intValue();

            if(key != 0) {
                awardWindows += item.getValue();
                award += key * item.getValue() / 100;
            }

            if (key % 100 == 0) {
                System.out.printf("单注中奖奖金 %.0f,\t中奖窗口 %d", key / 100, item.getValue());
            } else {
                System.out.printf("单注中奖奖金 %.1f,\t中奖窗口 %d", key / 100, item.getValue());

            }
            System.out.println();
        }

        NumberFormat format = NumberFormat.getPercentInstance();
        // 设置保留几位小数
        format.setMaximumFractionDigits(2);

        double tmp1 = awardWindows/this.totalWindows;
        double tmp2 = award / this.totalWindows;
        System.out.printf("中奖面 %s, 返奖率 %s", format.format(tmp1), format.format(tmp2));

    }

    /**
     * 检查各轴的符号数量是否正确
     */
    public void checkAllAxis() {
        this.checkAxis(axis1);
        this.checkAxis(axis2);
        this.checkAxis(axis3);
    }

    private void checkAxis(Integer[] axis) {
        int[] counts = new int[10];
        for (Integer item : axis) {
            counts[item - 1]++;
        }
        for (int x : counts) {
            System.out.print(x);
            System.out.print(' ');
        }
        System.out.println(axis.length);
    }
}
