package practice.hongbao.business;

import java.util.concurrent.ThreadLocalRandom;

public class HongBaoBusiness {


    public synchronized int getHongBao(String id,int remainNumber){
        int remainAmount = getRemainAmount(id);
        if (remainNumber == 1) {
            return remainAmount;
        }
        int average2 = (remainAmount << 1) / remainNumber;
        int random = ThreadLocalRandom.current().nextInt(1, average2);
        return random;
    }

    public String get(String id, String userId){
        int remainNumber = getRemainNumber(id);
        if (remainNumber <= 0) {
            return "红包抢完了";
        }

        decrCache(id);
        int amount = getHongBao(id, remainNumber);
        int i = updateRemainAmount(id);
        if (i <= 0) {
            //回滚
        }
        //日志

        return amount + "";
    }

    public int getRemainAmount(String id){
        return 1;
    }

    public int updateRemainAmount(String id) {
        return 1;
    }

    public int getRemainNumber(String id){
        return 1;
    }

    public int decrCache(String id){
        return 1;
    }
}
