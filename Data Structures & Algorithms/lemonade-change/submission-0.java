class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> pettyCash = new HashMap<>();
        pettyCash.put(5, 0);
        pettyCash.put(10, 0);
        pettyCash.put(20, 0);
        int num = 0;
        int change = 0;

        for (int i =0; i < bills.length; i++) {

            // store cash
            pettyCash.put(bills[i], pettyCash.get(bills[i])+1);

            // now get change
            change = bills[i] - 5;

    //        System.out.println("For change " + change + " bill: " + bills[i]);
            if (change >= 10 && pettyCash.get(10) > 0){
     //           System.out.printf("Note %d, change %d, num notes %d", 10, change, pettyCash.get(10));
                num = Math.min(change/10, pettyCash.get(10));
                pettyCash.put(10, pettyCash.get(10) - num);
                change -= num*10;
      //          System.out.printf("After Note %d, change %d, num notes %d", 10, change, pettyCash.get(10));
            } 
            if (change >= 5 && pettyCash.get(5) > 0){
     //           System.out.printf("Note %d, change %d, num notes %d", 5, change, pettyCash.get(5));
                num = Math.min(change/5, pettyCash.get(5));
                pettyCash.put(5, pettyCash.get(5) - num);
                change -= num*5;
     //           System.out.printf("after Note %d, change %d, num notes %d", 5, change, pettyCash.get(5));

            }
            if (change > 0) {
                break;
            } 
        }

        if (change == 0) {
            return true;
        } else {
            return false;
        }
    }

}