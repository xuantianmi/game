package com.lotogame.math;

/**
 * Base Configure for Zhenbao game.
 * Result: 中奖面 27.77%, 返奖率 61.63%.
 */
public class ZhenbaoConf {
    protected Integer AXIS_LENGTH;
    /**
     * 第一个轴的中奖符号分布. The award symbol distribution for the no.1 axis. length is 81.
     */
    protected Integer[] AXIS1;
    /**
     * 第二个轴的中奖符号分布. The award symbol distribution for the no.2 axis. length is 81.
     */
    protected Integer[] AXIS2;

    /**
     * 第三个轴的中奖符号分布. The award symbol distribution for the no.3 axis. length is 81.
     */
    protected Integer[] AXIS3;

    /**
     * 各奖符的中奖奖金：分
     **/
    protected Integer[] AWARDS;

    public ZhenbaoConf() {
        AXIS_LENGTH = 81;
        AXIS1 = new Integer[] {
            9, 1, 3, 9, 5, 2, 9, 9, 3, 4,
            9, 9, 8, 5, 8, 9, 9, 9, 4, 4,
            5, 5, 6, 4, 6, 9, 6, 9, 6, 9,
            6, 9, 7, 8, 7, 9, 7, 8, 7, 9,
            7, 8, 9, 8, 5, 9, 8, 7, 8, 9,
            7, 9, 8, 9, 9, 9, 8, 7, 8, 9,
            7, 8, 7, 8, 9, 6, 7, 9, 9, 7,
            7, 8, 8, 9, 8, 9, 8, 6, 8, 9,
            8
        };
        AXIS2 = new Integer[] {
            6, 1, 6, 9, 5, 2, 2, 5, 3, 3,
            9, 9, 9, 5, 9, 7, 4, 5, 4, 10,
            5, 6, 7, 5, 6, 6, 7, 9, 10, 9,
            7, 9, 7, 9, 7, 8, 5, 9, 8, 7,
            8, 8, 9, 8, 5, 9, 8, 10, 8, 9,
            10, 9, 8, 9, 8, 9, 8, 3, 9, 10,
            8, 7, 7, 8, 9, 6, 10, 8, 9, 7,
            7, 8, 6, 6, 9, 9, 10, 9, 8, 7,
            8
        };
        AXIS3 = new Integer[] {
            7, 1, 9, 9, 5, 2, 9, 9, 3, 4,
            9, 9, 8, 5, 9, 9, 5, 4, 5, 4,
            5, 5, 7, 5, 9, 6, 6, 9, 9, 6,
            7, 9, 7, 8, 7, 8, 9, 8, 9, 7,
            7, 8, 7, 8, 5, 9, 8, 9, 8, 9,
            6, 8, 8, 2, 9, 9, 8, 7, 9, 7,
            9, 9, 7, 8, 9, 6, 6, 8, 9, 7,
            9, 7, 6, 9, 7, 9, 8, 6, 8, 7,
            8
        };
        AWARDS = new Integer[] {100000, 20000, 10000, 4000, 2000, 1000, 300, 100, 40};
    }


}
