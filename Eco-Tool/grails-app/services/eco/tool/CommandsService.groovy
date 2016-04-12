package eco.tool

import grails.transaction.Transactional
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import eco.tool.Operations

import java.math.RoundingMode

@Transactional
class CommandsService {

    def BigDecimal operation1() {

        BigDecimal retval = sigmaMultiply(7,1,"IM","IMI")
        println "operation 1 retval: " + retval
        BigDecimal ret2 = sigmaMultiply(7,1,"TIM","TIMI")
        println "operation 1 reval(2): "+ret2
        retval = retval + ret2
        return retval
    }

    def BigDecimal operation2(params) {
        String country = params.lens

        switch(country.toLowerCase()){
            case "spain" :
                return multiplyInArrayInOrder(getParamsFromDBAsMap(["E1","EI1"])) +
                        multiplyInArrayInOrder(getParamsFromDBAsMap(["CA1","CAI1"]))
                break
            case "portugal" :
                return multiplyInArrayInOrder(getParamsFromDBAsMap(["E1","EI2"])) +
                        multiplyInArrayInOrder(getParamsFromDBAsMap(["CA1","CAI1"]))
                break
            case "france" :
                return multiplyInArrayInOrder(getParamsFromDBAsMap(["E1","EI3"])) +
                        multiplyInArrayInOrder(getParamsFromDBAsMap(["CA1","CAI1"]))
                break
            case "belguim" :
                return multiplyInArrayInOrder(getParamsFromDBAsMap(["E1","EI4"])) +
                        multiplyInArrayInOrder(getParamsFromDBAsMap(["CA1","CAI1"]))
                break
            case "united kingdom" :
                return multiplyInArrayInOrder(getParamsFromDBAsMap(["E1","EI5"])) +
                        multiplyInArrayInOrder(getParamsFromDBAsMap(["CA1","CAI1"]))
                break
            case "slovenia" :
                return multiplyInArrayInOrder(getParamsFromDBAsMap(["E1","EI6"])) +
                        multiplyInArrayInOrder(getParamsFromDBAsMap(["CA1","CAI1"]))
                break
            case "switzerland" :
                return multiplyInArrayInOrder(getParamsFromDBAsMap(["E1","EI7"])) +
                        multiplyInArrayInOrder(getParamsFromDBAsMap(["CA1","CAI1"]))
                break
            default:
                throw new Exception("country not recognised")
        }
    }

    def operation3(){
        return multiplyInArrayInOrder(getParamsFromDBAsMap(["W1","WI1"]))
    }

    public BigDecimal iterateEq(int end, int start, String con1, String con2)
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

    def operation4(){
        BigDecimal retval = sigmaMultiply(5,1,"WW","WWI")
        println retval
        println sigmaMultiply(5,1,"TWW","TWWI")
        retval = retval + sigmaMultiply(5,1,"TWW","TWWI")
        return retval
    }

    def operation5(){
        BigDecimal retval = sigmaMultiply(4,1,"SW","SWI")
        retval = retval + sigmaMultiply(4,1,"TSW","TSWI")
        return retval
    }

    def operation6(params){
        return operation1() + operation2(params) + operation3() + operation4() + operation5()
    }

//sigmaMultiplyWithDivideOnFirst is broke
    def operation7m(params){
        BigDecimal iv1 = new BigDecimal(params.iv1)
        BigDecimal retval = sigmaMultiplyWithDivideOnFirst(13,8,iv1,dbGet("CP1"),"IM","IMI")
        retval + sigmaMultiplyWithDivideOnFirst(13,8,iv1,dbGet("CP1"),"TIM","TIMI")
        return retval
    }

    public BigDecimal operation7(params) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal iv1 = new BigDecimal(params.iv1)
        int start = 8;
        int end = 13;
        BigDecimal CP1 = dbGet("CP1");
        String constant1 = "IM";
        String constant2 = "IMI";
        String constant3 = "TIM";
        String constant4 = "TIMI";

        BigDecimal divided = Operations.divideValues(iv1, CP1);
        BigDecimal x = iterateEq(end, start, constant1, constant2);
        BigDecimal y = iterateEq(end, start, constant3, constant4);
        x = divided.multiply(x);
        y = divided.multiply(y);
        total = x.add(y);
//        System.out.println(total.toString());
        return total;
    }

    def operation8(params){
        String country = params.frontal
        BigDecimal iv1 = new BigDecimal(params.iv1)

        switch(country.toLowerCase()){
            case "spain" :
                return multiplyDivideMultiply(dbGet("E2"),iv1,dbGet("CP1"),dbGet("EI1")) +
                        multiplyDivideMultiply(dbGet("CA2"),iv1,dbGet("CP1"),dbGet("CAI1"))

                break
            case "portugal" :
                return multiplyDivideMultiply(dbGet("E2"),iv1,dbGet("CP1"),dbGet("EI2")) +
                        multiplyDivideMultiply(dbGet("CA2"),iv1,dbGet("CP1"),dbGet("CAI1"))
                break
            case "france" :
                return multiplyDivideMultiply(dbGet("E2"),iv1,dbGet("CP1"),dbGet("EI3")) +
                        multiplyDivideMultiply(dbGet("CA2"),iv1,dbGet("CP1"),dbGet("CAI1"))
                break
            case "belguim" :
                return multiplyDivideMultiply(dbGet("E2"),iv1,dbGet("CP1"),dbGet("EI4")) +
                        multiplyDivideMultiply(dbGet("CA2"),iv1,dbGet("CP1"),dbGet("CAI1"))
                break
            case "united kingdom" :
                return multiplyDivideMultiply(dbGet("E2"),dbGet("IV1"),dbGet("CP1"),dbGet("EI5")) +
                        multiplyDivideMultiply(dbGet("CA2"),dbGet("IV1"),dbGet("CP1"),dbGet("CAI1"))
                break
            case "slovenia" :
                return multiplyDivideMultiply(dbGet("E2"),dbGet("IV1"),dbGet("CP1"),dbGet("EI6")) +
                        multiplyDivideMultiply(dbGet("CA2"),dbGet("IV1"),dbGet("CP1"),dbGet("CAI1"))
                break
            case "switzerland" :
                return multiplyDivideMultiply(dbGet("E2"),dbGet("IV1"),dbGet("CP1"),dbGet("EI7")) +
                        multiplyDivideMultiply(dbGet("CA2"),dbGet("IV1"),dbGet("CP1"),dbGet("CAI1"))
                break
            default:
                throw new Exception("country not recognised")
        }
    }
    public BigDecimal ivOverCP(BigDecimal IV, BigDecimal CP)
    {
        return IV.divide(CP, 100, RoundingMode.UP);
    }
    public BigDecimal operation9(params) {
        BigDecimal iv1 = new BigDecimal(params.iv1)
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV1CP1 = ivOverCP(iv1, dbGet("CP1"));
        for (int i = 2; i < 3; i++) {
            BigDecimal W = dbGet("W"+i);
            BigDecimal WI = dbGet("WI"+i);
            BigDecimal x = W.multiply(IV1CP1).multiply(WI);
            total = total.add(x);
        }
        return total;
    }

//    def operation9(){
//        return sigmaMultiplyDivideMultiply(3,2,"W",dbGet("IV1"),dbGet("CP1"),"WI")
//    }

//    def operation10(){
//        return sigmaMultiplyDivideMultiply(9,6,"WW",dbGet("IV1"),dbGet("CP1"),"WWI") +
//                sigmaMultiplyDivideMultiply(9,6,"TWW",dbGet("IV1"),dbGet("CP1"),"TWWI")
//    }


    public BigDecimal operation10(params) {
        BigDecimal iv1 = new BigDecimal(params.iv1)
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV1CP1 = ivOverCP(iv1, dbGet("CP1"));
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

//    def operation11(){
//        return sigmaMultiplyDivideMultiply(12,5,"SW",dbGet("IV1"),dbGet("CP1"),"SWI") +
//                sigmaMultiplyDivideMultiply(12,5,"TSW",dbGet("IV1"),dbGet("CP1"),"TSWI")
//    }

    public BigDecimal operation11(params) {
        BigDecimal iv1 = new BigDecimal(params.iv1)
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV1CP1 = ivOverCP(iv1, dbGet("CP1"));
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

    def operation12(params){
        return operation7(params)+operation8(params)+operation9(params)+operation10(params)+operation11(params)
    }

//    def operation13(){
//        return 2 * (sigmaMultiplyDivideMultiply(13,8,"IM",dbGet("IV3"),dbGet("CP3"),"IMI") +
//                sigmaMultiplyDivideMultiply(13,8,"TIM",dbGet("IV3"),dbGet("CP3"),"TIMI"))
//    }

    public BigDecimal operation13(params) {
        BigDecimal iv3 = new BigDecimal(params.iv3)
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV3CP3 = ivOverCP(iv3, dbGet("CP3"));
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

    def operation14(params){
        BigDecimal iv3 = new BigDecimal(params.iv3)
        String country = params.temple

        switch(country.toLowerCase()) {
            case "spain":
                return multiplyDivideMultiply(dbGet("E3"), iv3, dbGet("CP3"), dbGet("EI1")) +
                        multiplyDivideMultiply(dbGet("CA3"), iv3, dbGet("CP3"), dbGet("CAI1"))

                break
            case "portugal":
                return multiplyDivideMultiply(dbGet("E3"), iv3, dbGet("CP3"), dbGet("EI2")) +
                        multiplyDivideMultiply(dbGet("CA3"), iv3, dbGet("CP3"), dbGet("CAI1"))
                break
            case "france":
                return multiplyDivideMultiply(dbGet("E3"), iv3, dbGet("CP3"), dbGet("EI3")) +
                        multiplyDivideMultiply(dbGet("CA3"), iv3, dbGet("CP3"), dbGet("CAI1"))
                break
            case "belguim":
                return multiplyDivideMultiply(dbGet("E3"), iv3, dbGet("CP3"), dbGet("EI4")) +
                        multiplyDivideMultiply(dbGet("CA3"), iv3, dbGet("CP3"), dbGet("CAI1"))
                break
            case "united kingdom":
                return multiplyDivideMultiply(dbGet("E3"), iv3, dbGet("CP3"), dbGet("EI5")) +
                        multiplyDivideMultiply(dbGet("CA3"), iv3, dbGet("CP3"), dbGet("CAI1"))
                break
            case "slovenia":
                return multiplyDivideMultiply(dbGet("E3"), iv3, dbGet("CP3"), dbGet("EI6")) +
                        multiplyDivideMultiply(dbGet("CA3"), iv3, dbGet("CP3"), dbGet("CAI1"))
                break
            case "switzerland":
                return multiplyDivideMultiply(dbGet("E3"), iv3, dbGet("CP3"), dbGet("EI7")) +
                        multiplyDivideMultiply(dbGet("CA3"), iv3, dbGet("CP3"), dbGet("CAI1"))
                break
            default:
                throw new Exception("country not recognised")
        }
    }

//    def operation15(){
//        return sigmaMultiplyDivideMultiply(5,4,"W",dbGet("IV3"),dbGet("CP3"),"WI")
//    }

    public BigDecimal operation15(params) {
        BigDecimal iv3 = new BigDecimal(params.iv3)
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV3CP3 = ivOverCP(iv3, dbGet("CP3"));
        for (int i = 4; i < 5; i++) {
            BigDecimal W = dbGet("W"+i);
            BigDecimal WI = dbGet("WI"+i);
            BigDecimal x = W.multiply(new BigDecimal(2).multiply(IV3CP3).multiply(WI));
            total = total.add(x);
        }
//        System.out.println(total);
        return total;
    }


//    def operation16(){
//        return sigmaMultiplyDivideMultiply(13,10,"WW",dbGet("IV3"),dbGet("CP3"),"WWI") +
//                sigmaMultiplyDivideMultiply(13,10,"TWW",dbGet("IV3"),dbGet("CP3"),"TWWI")
//    }

    public BigDecimal operation16(params) {
        BigDecimal iv3 = new BigDecimal(params.iv3)
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV3CP3 = ivOverCP(iv3, dbGet("CP3"));
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

    public BigDecimal operation17(params) {
        BigDecimal iv3 = new BigDecimal(params.iv3)
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV3CP3 = ivOverCP(iv3, dbGet("CP3"));
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
//    def operation17(){
//        return sigmaMultiplyDivideMultiply(22,13,"SW",dbGet("IV3"),dbGet("CP3"),"SWI") +
//                sigmaMultiplyDivideMultiply(22,13,"TSW",dbGet("IV3"),dbGet("CP3"),"TSWI")
//    }

    def operation18(params){
        return operation13(params)+operation14(params)+operation15(params)+operation16(params)+operation17(params)
    }

//    def operation19(){
//        return sigmaMultiplyDivideMultiply(16,14,"IM",dbGet("IV2"),dbGet("CP2"),"IMI") +
//                sigmaMultiplyDivideMultiply(16,14,"TIM",dbGet("IV2"),dbGet("CP2"),"TIMI")
//    }

    public BigDecimal operation19(params) {
        BigDecimal iv2 = new BigDecimal(params.iv2)
        BigDecimal total = new BigDecimal(0);
        BigDecimal IV2CP2 = ivOverCP(iv2, dbGet("CP2"));
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

    def operation20(params){
        String country = params.frontal
        BigDecimal iv2 = new BigDecimal(params.iv2)
        switch(country.toLowerCase()) {
            case "spain":
                return multiplyDivideMultiply(dbGet("E4"), iv2, dbGet("CP2"), dbGet("EI1"))
                break
            case "portugal":
                return multiplyDivideMultiply(dbGet("E4"), iv2, dbGet("CP2"), dbGet("EI2"))
                break
            case "france":
                return multiplyDivideMultiply(dbGet("E4"), iv2, dbGet("CP2"), dbGet("EI3"))
            break
            case "belguim":
                return multiplyDivideMultiply(dbGet("E4"), iv2, dbGet("CP2"), dbGet("EI4"))
                break
            case "united kingdom":
                return multiplyDivideMultiply(dbGet("E4"), iv2, dbGet("CP2"), dbGet("EI5"))
                break
            case "slovenia":
                return multiplyDivideMultiply(dbGet("E4"), iv2, dbGet("CP2"), dbGet("EI6"))
                break
            case "switzerland":
                return multiplyDivideMultiply(dbGet("E4"), iv2, dbGet("CP2"), dbGet("EI7"))
                break
            default:
                throw new Exception("country not recognised")
        }
    }

//    def operation21(){
//        return sigmaMultiplyDivideMultiply(25,23,"SW",dbGet("IV2"),dbGet("CP2"),"SWI") +
//                sigmaMultiplyDivideMultiply(25,23,"TSW",dbGet("IV2"),dbGet("CP2"),"TSWI")
//    }

    public BigDecimal operation21(params){
    BigDecimal iv2 = new BigDecimal(params.iv2)

        BigDecimal total = new BigDecimal(0);
        BigDecimal IV2CP2 = ivOverCP(iv2, dbGet("CP2"));
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

    def operation22(params){
        return operation19(params) + operation20(params) + operation21(params)
    }

    public BigDecimal operation23(params)
    {
        BigDecimal iv1 = new BigDecimal(params.iv1)
        BigDecimal iv2 = new BigDecimal(params.iv2)
        if(!params.ti)
        {
            BigDecimal total = iv1.add(new BigDecimal(113)).multiply(dbGet("TIMI18")).add(iv1).multiply(new BigDecimal(1915)).multiply(dbGet("TIMI19"));
            return total;
        }
        else if(params.ti)
        {
            return iv2.add(new BigDecimal(101)).multiply(dbGet("TIMI18")).add(iv2).multiply(new BigDecimal(1328)).multiply(dbGet("TIMI19"));
        }
        else
        {
            return null;
        }
    }



//    def operation23(params){
//        String country = params.iv4
//        BigDecimal iv1 = new BigDecimal(params.iv1)
//        BigDecimal iv2 = new BigDecimal(params.iv2)
//
//        switch(country.toLowerCase()) {
//            case "spain":
//                return dbGet("E5") * bigDivide(iv1,dbGet(iv),dbGet("CP1"),dbGet("CP3")) * dbGet("EI1")
//                break
//            case "portugal":
//                return dbGet("E5") * bigDivide(dbGet("IV1"),dbGet(iv),dbGet("CP1"),dbGet("CP3")) * dbGet("EI2")
//                break
//            case "france":
//                return dbGet("E5") * bigDivide(dbGet("IV1"),dbGet(iv),dbGet("CP1"),dbGet("CP3")) * dbGet("EI3")
//                break
//            case "belguim":
//                return dbGet("E5") * bigDivide(dbGet("IV1"),dbGet(iv),dbGet("CP1"),dbGet("CP3")) * dbGet("EI4")
//                break
//            case "united kingdom":
//                return dbGet("E5") * bigDivide(dbGet("IV1"),dbGet(iv),dbGet("CP1"),dbGet("CP3")) * dbGet("EI5")
//                break
//            case "slovenia":
//                return dbGet("E5") * bigDivide(dbGet("IV1"),dbGet(iv),dbGet("CP1"),dbGet("CP3")) * dbGet("EI6")
//                break
//            case "switzerland":
//                return dbGet("E5") * bigDivide(dbGet("IV1"),dbGet(iv),dbGet("CP1"),dbGet("CP3")) * dbGet("EI7")
//                break
//            default:
//                throw new Exception("country not recognised")
//        }
//    }

    public BigDecimal operation24(params)
    {
        BigDecimal iv3 = new BigDecimal(params.iv3)
        return iv3.multiply(new BigDecimal(113)).multiply(dbGet("TIMI18")).add(iv3).multiply(new BigDecimal(1915)).multiply(dbGet("TIMI19"));
    }
//
//    def operation24(){
//        return dbGet("IV8") * dbGet("IM1") * dbGet("TIM8")
//    }

//    def operation25(params){
//        String iv = params.selectediv
//
//        switch(iv){
//            case "IV1" :
//                    return dbGet("IV9") * dbGet("IV1") * dbGet("TIM8")
//                break
//            case "IV2" :
//                    return dbGet("IV9") * dbGet("IV2") * dbGet("TIM8")
//                break
//        }
//    }


    public BigDecimal operation25(params)
    {
        BigDecimal iv1 = new BigDecimal(params.iv1)
        BigDecimal iv2 = new BigDecimal(params.iv2)
        BigDecimal iv3 = new BigDecimal(params.iv3)

        if (!params.ti)
        {
            BigDecimal IMIV1IV3 = dbGet("IM1").add(iv1).add(iv3);
            return IMIV1IV3.multiply(new BigDecimal(1089)).multiply(dbGet("TIMI19")).add(IMIV1IV3).multiply(new BigDecimal(71)).multiply(dbGet("TIMI18"));
        }
        else if (params.ti)
        {
            BigDecimal IMIV2IV3 = dbGet("IM1").add(iv2).add(iv3);
            return IMIV2IV3.multiply(new BigDecimal(1089)).multiply(dbGet("TIMI19")).add(IMIV2IV3).multiply(new BigDecimal(71)).multiply(dbGet("TIMI18"));
        }
        else
        {
            return null;
        }
    }
//    def operation26(){
//        return dbGet("IV10") * dbGet("IV3") * dbGet("TIM8")
//    }

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

//    def operation27(params){
//        String iv = params.selectediv
//
//        switch(iv){
//            case "IV1" :
//
//                break
//            case "IV2" :
//
//                break
//        }
//    }
//
//    public BigDecimal operation27(params)
//    {
//
//
//        if(IV.toUpperCase() == "IV1")
//        {
//            return
//        }
//        else if(IV.toUpperCase() == "IV2")
//        {
//            BigDecimal OUTPUTIMPACT = operation6().add(operation18(IV3)).add(operation22(IV2))
//                    .add(operation23(IV1, IV2, frontal.toUpperCase())).add(operation24(IV3))
//                    .add(operation25(IV1, IV2, IV3, frontal.toUpperCase())).add(operation26());
//            return OUTPUTIMPACT;
//        }
//        else
//        {
//            return null;
//        }
//    }

    public BigDecimal operation27(params)
    {
        BigDecimal iv1 = new BigDecimal(params.iv1)
        BigDecimal iv2 = new BigDecimal(params.iv2)
        BigDecimal iv3 = new BigDecimal(params.iv3)

        if(!params.ti)
        {
            BigDecimal OUTPUTIMPACT = operation6(params).add(operation12(params)).add(operation18(params))
                    .add(operation23(params)).add(operation24(params))
                    .add(operation25(params)).add(operation26());
            return OUTPUTIMPACT;
        }
        else if(params.ti)
        {
            BigDecimal OUTPUTIMPACT = operation6(params).add(operation18(params)).add(operation22(params))
                    .add(operation23(params)).add(operation24(params))
                    .add(operation25(params)).add(operation26());
            return OUTPUTIMPACT;
        }
        else
        {
            return null;
        }
    }

    def sigmaMultiply(int top, int bottom, String... vars){
        int i = bottom
        BigDecimal result = 0
        while(i < top){
            ArrayList<String> vs = []
            vars.each {
                vs.add(it+i)
            }
            BigDecimal vv = null;
            getParamsFromDBAsMap(vs).each {
                if (vv == null)
                    vv = it
                else if(it == null)
                    it = 0
                else
                    vv = vv * it
            }
            result = result + vv
            i++;
        }
        return result
    }

    def sigmaMultiplyWithDivideOnFirst(int top, int bottom, BigDecimal d1,BigDecimal d2, String... vars){
        int i = bottom
        BigDecimal result = null
        while(i < top){
            ArrayList<String> vs = []
            vars.each {
                vs.add(it+i)
            }
            boolean first = true
            getParamsFromDBAsMap(vs).each {
                if (first){
                    it = (d1/d2)*it
                    first =false;
                }
                if (result == null)
                    result = it
                else if(it == null)
                    result = result
                else
                    result = result * it
            }
            i++;
        }
        return result
    }


    def sigmaMultiplyDivideMultiply(int top, int bottom, String d1, BigDecimal d2, BigDecimal d3, String d4 ){
        int i = bottom
        println "top: "+top
        println "bottom: "+bottom
        BigDecimal result = null
        while(i < top){
            multiplyDivideMultiply(dbGet(d1+i),d2,d3,dbGet(d4+i))
            i++;
        }
        return result
    }

    def multiplyInArrayInOrder(ArrayList<BigDecimal> a){
        BigDecimal result = null
        a.each {
            if (result == null)
                result = it
            else if(it == null)
                result = result
            else
                result = result * it
        }
        return result
    }

    def divideInArrayInOrder(ArrayList<BigDecimal> a){
        BigDecimal result = null
        a.each {
            if (result == null)
                result = it
            else if(it == null)
                result = result
            else
                result = result / it
        }
        return result
    }

    def ArrayList getParamsFromDBAsMap(ArrayList<String> a){
        ArrayList<BigDecimal> m = []
        a.each {
            if(EcoToolValues.findByIndicator(it)) {
                String v = EcoToolValues.findByIndicator(it).getValue()
                if (v && !v.equals("N/A")) {
                   // println v
                    m.add(new BigDecimal(v))
                }
                else
                    m.add(0)
            }
        }
        return m
    }

    def BigDecimal dbGet(String s){
        try {
            BigDecimal d = null
            if (EcoToolValues.findByIndicator(s))
                d = new BigDecimal((EcoToolValues.findByIndicator(s).value.contains("/"))?"0":EcoToolValues.findByIndicator(s).value)


            return d
        }catch(Exception e){
            throw new Exception(s)
        }
    }

    def multiplyDivideMultiply(BigDecimal d1, BigDecimal d2, BigDecimal d3, BigDecimal d4){
        BigDecimal tmp =  d2.divide(d3, 100, RoundingMode.UP);
        return d1 * tmp * d4
    }

    def bigDivide(BigDecimal t1, BigDecimal t2, BigDecimal b1, BigDecimal b2){
        return t1/b1 + t1/b2 + t2/b1 + t2/b2
    }

    def init(){
        try {
            FileInputStream file = new FileInputStream(new File("/home/michael/EcoToolVariables.xlsx"));
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            Row row;

            while (rowIterator.hasNext()) {
                 row = rowIterator.next();
                if (!row.getCell(0)||row.getCell(0).getStringCellValue().equals("end"))
                    break;

                String c0 = row.getCell(0).getStringCellValue()
                    String c1 = row.getCell(1).getStringCellValue()
                    String v = null
                try {
                    row.getCell(2).setCellType(Cell.CELL_TYPE_STRING)
                     v = row.getCell(2).getStringCellValue()
                    new BigDecimal(v)
                }
                catch(Exception e)
                {
                    println "ROW: " + row.getRowNum()
                    println "CANNOT PARSE TO BIG DECIMAL: "+row.getCell(2).getStringCellValue()
                }
                    String c3 = (row.getCell(3) != null) ? row.getCell(3).getStringCellValue() : null

                    if(!EcoToolValues.findByIndicator(c0))
                        new EcoToolValues(indicator: c0,name: c1,value: v,unit: c3).save(failOnError: true, flush: true)
                }

        }
        catch(Exception e){
            e.printStackTrace()
        }
    }

}
