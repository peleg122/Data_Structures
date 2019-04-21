import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Ex2 {

    public static int maxsum(Stack<Integer> s){
        Queue<Integer> temp = new LinkedList<Integer>();
        int max=0;
        ((LinkedList<Integer>) temp).push(s.pop());
        while (!s.isEmpty()){
            if((s.peek()+temp.peek()) > max){
                max = s.peek()+temp.peek();
                ((LinkedList<Integer>) temp).push(s.pop());
            }else{
                ((LinkedList<Integer>) temp).push(s.pop());
            }
        }
        while (!temp.isEmpty()){
            s.push(((LinkedList<Integer>) temp).pop());
        }
        return max;
    }

    public static int topbig(Stack<Integer> s1, Stack<Integer> s2){
        int maxS2=maxsum(s2);
        int topS1=s1.pop();
        while (!s1.isEmpty()){
            if(maxS2 > topS1+s1.peek() ){
                topS1=s1.pop();
            }else{
                return topS1+s1.peek();
            }
        }
        return 0;
    }


    public static void func2(Queue<Integer> q, Stack<Integer> s){
        Stack<Integer> temp =new Stack<Integer>();
        while (!s.isEmpty()){
            temp.push(s.pop());
        }
        while (!q.isEmpty() && !temp.isEmpty()){
            if(temp.peek()<q.peek()){
                s.push(temp.pop());
            }else if(q.peek()<temp.peek()){
                s.push(q.poll());
            }else{
                s.push(temp.pop());
                q.poll();//eliminating equal numbers no duplicates
            }
        }
        if(temp.size()>0){
            while(!temp.isEmpty())
                s.push(temp.pop());
        }else if(q.size()>0){
            while(!q.isEmpty())
                s.push(q.poll());
        }
    }

    public static void main(String[] args){}
}
