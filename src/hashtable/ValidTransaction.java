package hashtable;

import java.util.ArrayList;
import java.util.List;

public class ValidTransaction {
    public static void main(String[] args) {
        String[] transactions = {"alice,20,1220,mtv","alice,20,1220,mtv"};
        System.out.println(invalidTransactions(transactions));
    }

    public static List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        List<String> res = new ArrayList<>();
        Transaction[] trans = new Transaction[n];

        for (int i=0; i<n; i++) {
            trans[i] = getInfo(transactions[i]);
        }

        for (int i=0; i<n; i++) {
            if (trans[i].amount > 1000) {
                res.add(transactions[i]);
                continue;
            }
            boolean find = false;
            for (int j=0; j<n; j++) {
                if (i == j) continue;
                int diff = Math.abs(trans[i].time - trans[j].time);
                if (diff <= 60 && trans[i].name.equals(trans[j].name) && !trans[i].city.equals(trans[j].city)) {
                    find = true; break; // break here to avoid duplication
                }
            }
            if (find) res.add(transactions[i]);
        }

        return res;
    }

    public static Transaction getInfo(String transaction) {
        String name = "";
        String time = "";
        String amount = "";
        String city = "";

        int comma = 0;
        for (int j=0; j<transaction.length(); j++) {
            char cur = transaction.charAt(j);
            boolean valid = true;
            if (comma == 0) {
                if (cur != ',') name += cur;
                else comma++;
            } else if (comma == 1) {
                if (cur != ',') time += cur;
                else comma++;
            } else if (comma == 2) {
                if (cur != ',') amount += cur;
                else comma++;
            } else {
                city += cur;
            }
        }

        Transaction trans = new Transaction(name, Integer.parseInt(time), Integer.parseInt(amount), city);
        return trans;
    }

    static class Transaction {
        String name;
        int time;
        int amount;
        String city;

        public Transaction(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
    }
}
