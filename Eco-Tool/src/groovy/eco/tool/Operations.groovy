package eco.tool

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by jacob on 08/03/16.
 */
public class Operations {

    Arrays constants = new Arrays();

    public BigDecimal operation1() {
        BigDecimal total = new BigDecimal(0);
        int start = 1;
        int end = 7;
        String constant1 = "IM";
        String constant2 = "IMI";
        String constant3 = "TIM";
        String constant4 = "TIMI";
        BigDecimal x = iterateEq(end, start, constant1, constant2);
        BigDecimal y = iterateEq(end, start, constant3, constant4);
        total = x.add(y);
//        System.out.println(total.toString());
        return total;
    }

    public BigDecimal operation2() {
        BigDecimal total = new BigDecimal(0);
        BigDecimal E = dbGet("E1");
        BigDecimal EI = dbGet("EI1");
        BigDecimal CA = dbGet("CA1");
        BigDecimal CAI = dbGet("CAI1");
        BigDecimal x = multiplyValues(E, EI);
        BigDecimal y = multiplyValues(CA, CAI);
        total = total.add(addValues(x, y));
//        System.out.println("\n" + total.toString());
        return total;
    }

    public BigDecimal operation3() {
        BigDecimal total = new BigDecimal(0);
        BigDecimal W = dbGet("W1");
        BigDecimal WI = dbGet("WI1");
        total = total.add(multiplyValues(W, WI));
//        System.out.println("\n" + total.toString());
        return total;
    }

    public BigDecimal operation4() {
        BigDecimal total = new BigDecimal(0);
        int start = 1;
        int end = 5;
        String constant1 = "WW";
        String constant2 = "WWI";
        String constant3 = "TWW";
        String constant4 = "TWWI";
        BigDecimal x = iterateEq(end, start, constant1, constant2);
        BigDecimal y = iterateEq(end, start, constant3, constant4);
        total = x.add(y);
//        System.out.println("\nTotal: " + total.toString());
        return total;
    }

    public BigDecimal operation5() {
        BigDecimal total = new BigDecimal(0);
        int start = 1;
        int end = 4;
        String constant1 = "SW";
        String constant2 = "SWI";
        String constant3 = "TSW";
        String constant4 = "TSWI";
        BigDecimal x = iterateEq(end, start, constant1, constant2);
        BigDecimal y = iterateEq(end, start, constant3, constant4);
        total = x.add(y);
//        System.out.println(total.toString());
        return total;
    }


    public BigDecimal operation6() {
        BigDecimal total = new BigDecimal(0);
        BigDecimal op1 = operation1();
        BigDecimal op2 = operation2();
        BigDecimal op3 = operation3();
        BigDecimal op4 = operation4();
        BigDecimal op5 = operation5();
        return total = op1.add(op2.add(op3.add(op4.add(op5))));
    }

    public BigDecimal operation7(BigDecimal IV1) {
        BigDecimal total = new BigDecimal(0);
        int start = 8;
        int end = 13;
        BigDecimal CP1 = dbGet("CP1");
        String constant1 = "IM";
        String constant2 = "IMI";
        String constant3 = "TIM";
        String constant4 = "TIMI";

        BigDecimal divided = divideValues(IV1, CP1);
        BigDecimal x = iterateEq(end, start, constant1, constant2);
        BigDecimal y = iterateEq(end, start, constant3, constant4);
        x = divided.multiply(x);
        y = divided.multiply(y);
        total = x.add(y);
//        System.out.println(total.toString());
        return total;
    }

    public BigDecimal operation8(BigDecimal IV1) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV1CP1 = ivOverCP(IV1, dbGet("CP1"));
        BigDecimal E = dbGet("E2");
        BigDecimal EI = dbGet("EI5");
        BigDecimal CA = dbGet("CA2");
        BigDecimal CAI = dbGet("CAI1");

        BigDecimal x = E.multiply(IV1CP1).multiply(EI);
        BigDecimal y = CA.multiply(IV1CP1).multiply(CAI);
        total = x.add(y);
        return total;
    }

    public BigDecimal operation9(BigDecimal IV1) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV1CP1 = ivOverCP(IV1, dbGet("CP1"));
        for (int i = 2; i < 3; i++) {
            BigDecimal W = dbGet("W"+i);
            BigDecimal WI = dbGet("WI"+i);
            BigDecimal x = W.multiply(IV1CP1).multiply(WI);
            total = total.add(x);
        }
        return total;
    }

    public BigDecimal operation10(BigDecimal IV1) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV1CP1 = ivOverCP(IV1, dbGet("CP1"));
        for (int i = 6; i < 9; i++) {
            BigDecimal WW = dbGet("WW"+i);
            BigDecimal WWI = dbGet("WWI"+i);
            BigDecimal TWW = dbGet("TWW"+i);
            BigDecimal TWWI = dbGet("TWWI"+i);

            BigDecimal x = WW.multiply(IV1CP1).multiply(WWI);
            BigDecimal y = TWW.multiply(IV1CP1).multiply(TWWI);
            total = total.add(x.add(y));
        }
        return total;
    }

    public BigDecimal operation11(BigDecimal IV1) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV1CP1 = ivOverCP(IV1, dbGet("CP1"));
        for (int i = 5; i < 13; i++) {
            BigDecimal SW = dbGet("SW"+i);
            BigDecimal SWI = dbGet("SWI"+i);
            BigDecimal TSW = dbGet("TSW"+i);
            BigDecimal TSWI = dbGet("TSWI"+i);

            BigDecimal x = SW.multiply(IV1CP1).multiply(SWI);
            BigDecimal y = TSW.multiply(IV1CP1).multiply(TSWI);
            total = total.add(x.add(y));
        }
        return total;
    }

    public BigDecimal operation12(BigDecimal IV1) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal op7 = operation7(IV1);
        BigDecimal op8 = operation8(IV1);
        BigDecimal op9 = operation9(IV1);
        BigDecimal op10 = operation10(IV1);
        BigDecimal op11 = operation11(IV1);
        return total = op7.add(op8.add(op9.add(op10.add(op11))));
    }

    public BigDecimal operation13(BigDecimal IV3) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV3CP3 = ivOverCP(IV3, dbGet("CP3"));
        for (int i = 8; i < 13; i++) {
            BigDecimal IM = dbGet("IM"+i);
            BigDecimal IMI = dbGet("IMI"+i);
            BigDecimal TIM = dbGet("TIM"+i);
            BigDecimal TIMI = dbGet("TIMI"+i);
            BigDecimal x = IM.multiply(new BigDecimal(2).multiply(IV3CP3).multiply(IMI));
            BigDecimal y = TIM.multiply(new BigDecimal(2).multiply(IV3CP3).multiply(TIMI));
            total = total.add(x.add(y));
        }
        return total;
    }

    public BigDecimal operation14(BigDecimal IV3) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV3CP3 = ivOverCP(IV3, dbGet("CP3"));
        BigDecimal E = dbGet("E3");
        BigDecimal EI = dbGet("EI5");
        BigDecimal CA = dbGet("CA3");
        BigDecimal CAI = dbGet("CAI1");
        BigDecimal x = E.multiply(new BigDecimal(2).multiply(IV3CP3).multiply(EI));
        BigDecimal y = CA.multiply(new BigDecimal(2).multiply(IV3CP3).multiply(CAI));
        total = total.add(x.add(y));
        return total;
    }

    public BigDecimal operation15(BigDecimal IV3) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV3CP3 = ivOverCP(IV3, dbGet("CP3"));
        for (int i = 4; i < 5; i++) {
            BigDecimal W = dbGet("W"+i);
            BigDecimal WI = dbGet("WI"+i);
            BigDecimal x = W.multiply(new BigDecimal(2).multiply(IV3CP3).multiply(WI));
            total = total.add(x);
        }
//        System.out.println(total);
        return total;
    }

    public BigDecimal operation16(BigDecimal IV3) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV3CP3 = ivOverCP(IV3, dbGet("CP3"));
        for (int i = 10; i < 13; i++) {
            BigDecimal WW = dbGet("WW"+i);
            BigDecimal WWI = dbGet("WWI"+i);
            BigDecimal TWW = dbGet("TWW"+i);
            BigDecimal TWWI = dbGet("TWWI"+i);
            BigDecimal x = WW.multiply(new BigDecimal(2).multiply(IV3CP3).multiply(WWI));
            BigDecimal y = TWW.multiply(new BigDecimal(2).multiply(IV3CP3).multiply(TWWI));
            total = total.add(x.add(y));
        }
//        System.out.println(total);
        return total;
    }

    public BigDecimal operation17(BigDecimal IV3) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV3CP3 = ivOverCP(IV3, dbGet("CP3"));
        for (int i = 14; i < 22; i++) {
            BigDecimal SW = dbGet("SW"+i);
            BigDecimal SWI = dbGet("SWI"+i);
            BigDecimal TSW = dbGet("TSW"+i);
            BigDecimal TSWI = dbGet("TSWI"+i);

            BigDecimal x = SW.multiply(new BigDecimal(2).multiply(IV3CP3).multiply(SWI));
            BigDecimal y = TSW.multiply(new BigDecimal(2).multiply(IV3CP3).multiply(TSWI));
            total = total.add(x.add(y));
        }
        return total;
    }

    public BigDecimal operation18(BigDecimal IV3) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal op13 = operation13(IV3);
        BigDecimal op14 = operation14(IV3);
        BigDecimal op15 = operation15(IV3);
        BigDecimal op16 = operation16(IV3);
        BigDecimal op17 = operation17(IV3);
        return total = op13.add(op14.add(op15.add(op16.add(op17))));
    }

    public BigDecimal operation19(BigDecimal IV2) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV2CP2 = ivOverCP(IV2, dbGet("CP2"));
        for (int i = 14; i < 17; i++) {
            BigDecimal IM = dbGet("IM"+i);
            BigDecimal IMI = dbGet("IMI"+i);
            BigDecimal TIM = dbGet("TIM"+i);
            BigDecimal TIMI = dbGet("TIMI"+i);

            BigDecimal x = IM.multiply(IV2CP2).multiply(IMI);
            BigDecimal y = TIM.multiply(IV2CP2).multiply(TIMI);
            total = total.add(x.add(y));
        }
        return total;
    }

    public BigDecimal operation20(BigDecimal IV2)
    {
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV2CP2 = ivOverCP(IV2, dbGet("CP2"));
        total = dbGet("E4").multiply(IV2CP2).multiply(dbGet("EI4"));
        return total;
    }

    public BigDecimal operation21(BigDecimal IV2)
    {
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV2CP2 = ivOverCP(IV2, dbGet("CP2"));
        for (int i = 23; i < 28 ; i++) {
            BigDecimal SW = dbGet("SW"+i);
            BigDecimal SWI = dbGet("SWI"+i);
            BigDecimal TSW = dbGet("TSW"+i);
            BigDecimal TSWI = dbGet("TSWI"+i);

            BigDecimal x = SW.multiply(IV2CP2).multiply(SWI);
            BigDecimal y = TSW.multiply(IV2CP2).multiply(TSWI);
            total = total.add(x.add(y));
        }
        return total;
    }

    public BigDecimal operation22(BigDecimal IV2)
    {
        BigDecimal total = new BigDecimal(0);
        BigDecimal op19 = operation19(IV2);
        BigDecimal op20 = operation20(IV2);
        BigDecimal op21 = operation21(IV2);
        return total = op19.add(op20.add(op21));
    }

    public BigDecimal operation23(BigDecimal IV1, BigDecimal IV2, String frontal)
    {
        if(frontal == "PA")
        {
            BigDecimal total = IV1.add(new BigDecimal(113)).multiply(dbGet("TIMI18")).add(IV1).multiply(new BigDecimal(1915)).multiply(dbGet("TIMI19"));
            return total;
        }
        else if(frontal == "TI")
        {
            return IV2.add(new BigDecimal(101)).multiply(dbGet("TIMI18")).add(IV2).multiply(new BigDecimal(1328)).multiply(dbGet("TIMI19"));
        }
        else
        {
            return null;
        }
    }

    public BigDecimal operation24(BigDecimal IV3)
    {
        return IV3.multiply(new BigDecimal(113)).multiply(dbGet("TIMI18")).add(IV3).multiply(new BigDecimal(1915)).multiply(dbGet("TIMI19"));
    }

    public BigDecimal operation25(BigDecimal IV1, BigDecimal IV2, BigDecimal IV3, String frontal)
    {
        if (frontal.toUpperCase() == "PA")
        {
            BigDecimal IMIV1IV3 = dbGet("IM1").add(IV1).add(IV3);
            return IMIV1IV3.multiply(new BigDecimal(1089)).multiply(dbGet("TIMI19")).add(IMIV1IV3).multiply(new BigDecimal(71)).multiply(dbGet("TIMI18"));
        }
        else if (frontal.toUpperCase() == "TI")
        {
            BigDecimal IMIV2IV3 = dbGet("IM1").add(IV2).add(IV3);
            return IMIV2IV3.multiply(new BigDecimal(1089)).multiply(dbGet("TIMI19")).add(IMIV2IV3).multiply(new BigDecimal(71)).multiply(dbGet("TIMI18"));
        }
        else
        {
            return null;
        }
    }

    public BigDecimal operation26()
    {
        BigDecimal total = new BigDecimal(0);
        BigDecimal val2 = dbGet("IM18").multiply(dbGet("IMI1"));
        BigDecimal val3 = dbGet("IM19").multiply(dbGet("IMI19"));
        BigDecimal val4 = dbGet("IM20").multiply(dbGet("IMI20"));
        BigDecimal val5 = dbGet("IM21").multiply(dbGet("IMI1"));
        BigDecimal val6 = dbGet("IM22").multiply(dbGet("IMI21"));
        BigDecimal val7 = dbGet("IM23").multiply(dbGet("IMI19"));
        for (int i = 18; i < 23 ; i++) {
            BigDecimal val1 = dbGet("IM"+i).multiply(dbGet("IMI"+i));
            total = total.add(val1.add(val2.add(val3.add(val4.add(val5.add(val6.add(val7)))))));
        }
        return total;
    }

    public BigDecimal operation27(String IV, String frontal, BigDecimal IV1, BigDecimal IV2, BigDecimal IV3)
    {
        if(IV.toUpperCase() == "IV1")
        {
            BigDecimal OUTPUTIMPACT = operation6().add(operation12(IV1)).add(operation18(IV3))
                    .add(operation23(IV1, IV2, frontal.toUpperCase())).add(operation24(IV3))
                    .add(operation25(IV1, IV2, IV3, frontal.toUpperCase())).add(operation26());
            return OUTPUTIMPACT;
        }
        else if(IV.toUpperCase() == "IV2")
        {
            BigDecimal OUTPUTIMPACT = operation6().add(operation18(IV3)).add(operation22(IV2))
                    .add(operation23(IV1, IV2, frontal.toUpperCase())).add(operation24(IV3))
                    .add(operation25(IV1, IV2, IV3, frontal.toUpperCase())).add(operation26());
            return OUTPUTIMPACT;
        }
        else
        {
            return null;
        }
    }

    public static BigDecimal iterateEq(int end, int start, String con1, String con2)
    {
        BigDecimal total = new BigDecimal(0);
//        end = end-1;
//        start = start-1;
        for (int i = start; i < end; i++) {
//            System.out.println(i);
            BigDecimal x = dbGet(con1+i);
            BigDecimal y = dbGet(con2+i);
            BigDecimal result = x.multiply(y);
            total = total.add(result);
        }
        return total;
    }

    public static BigDecimal multiplyValues(BigDecimal val1, BigDecimal val2)
    {
         return val1.multiply(val2);
    }

    public static BigDecimal addValues(BigDecimal val1, BigDecimal val2)
    {
        return val1.add(val2);
    }

    public static BigDecimal divideValues(BigDecimal val1, BigDecimal val2)
    {
        return val1.divide(val2, 10, RoundingMode.UP);
    }

    public static BigDecimal ivOverCP(BigDecimal IV, BigDecimal CP)
    {
        return IV.divide(CP, 10, RoundingMode.UP);
    }

//    public BigDecimal test(BigDecimal IV)
//    {
//        BigDecimal x = IV.divide(dbGet("CP(2), 10, RoundingMode.UP); // IV3/CP3
////        System.out.println(x);
//        BigDecimal y = dbGet("E(2).multiply(new BigDecimal(2)); //2xE3
////        System.out.println(y);
////        System.out.println(y.multiply(x));
//        BigDecimal a = y.multiply(x);
//        BigDecimal xy = (a.multiply(dbGet("EI(4))); //2xE3xIV3/CP3xEI5
//        BigDecimal z = dbGet("CA(2).multiply(new BigDecimal(2)); //CA3 x 2
//        z = z.multiply(x); //CA3x2xIV3/CP3
//        BigDecimal xx = z.multiply(dbGet("CAI(0)); //CA3x2xIV3/CP3xCAI1
//        System.out.println(xx);
//        System.out.println(xy);
//        BigDecimal q = xx.add(xy);
//        return q;
//    }
}
