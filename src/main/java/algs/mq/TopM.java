package algs.mq;

import edu.princeton.cs.algs4.*;

public class TopM {
    public static void main(String[] args) {
        int m= Integer.parseInt(args[0]);
        MinPQ<Transaction> pa=new MinPQ<>(m+1);
        while(StdIn.hasNextLine())
        {
            pa.insert(new Transaction(StdIn.readLine()));
            if(pa.size()>m)
                pa.delMin();
        }
        Stack<Transaction> stack=new Stack<>();
        while(!pa.isEmpty()) stack.push(pa.delMin());
        for(Transaction t:stack) StdOut.println(t);
    }
}
