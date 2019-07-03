import java.util.HashMap;
import java.util.HashSet;
public class Ex4 {
    public static boolean isMinHeap(int[]arr){
        int N = arr.length;
        for (int i = (N - 2) / 2; i > -1; --i) { // start from the first internal node who has children;
            int j = 2 * i + 1; // the left child;
            if (j < N - 1 && arr[i] < arr[j+1]) j++; // select the bigger child;
            if (arr[i] > arr[j]) return false; // if parent is bigger than the child;
        }
        return true;
    }// 1.D
    public static boolean isSubset(int a1[], int a2[]){//Question 4
        HashSet<Integer> mainArray = new HashSet<>();
        /***
         * O(size of a1) because at most they will be equal in size so 2*O(size of a1) = O(size of a1)
         * it will be a constant time which is the size of a1
         * it should work with duplicated numbers because they are in the hash set already so they count(tested)
         */
        for(int i =0;i<a1.length;i++)//O(size of a1) [a1.size >= a2.size]
            mainArray.add(a1[i]);//O(1)
        for(int i =0;i<a2.length;i++){//O(size of a2)
            if(mainArray.contains(a2[i]))//O(1)
                continue;
            else
                return false;
        }
        return true;
    }//4
    public static void convert(int[] A){
        int floor = (A.length - 2) / 2;
        while (floor >= 0) {
            Heapify(A, floor--);
        }
    }//1.C
    public static void swap(int[] A,int i ,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void Heapify(int[] A, int i){
        int size = A.length;
        // get left and right child of node at index i
        int left = (2*i+1);
        int right = (2*i+2);

        int smallest = i;

        // compare A[i] with its left and right child
        // and find smallest value
        if (left < size && A[left] < A[i]) {
            smallest = left;
        }

        if (right < size && A[right] < A[smallest]) {
            smallest = right;
        }

        // swap with child having lesser value and
        // call heapify -down on the child
        if (smallest != i) {
            swap(A, i, smallest);
            Heapify(A, smallest);
        }

    }
    public static void statistics(String s){
        HashMap<String,Integer> words = new HashMap<>();
        int afterCommaIndex=0;
        int countWords;
        int howManyWordsTotal=0;
        int howManyWordsDifferent=0;
        int WordsRepeated=0;
        for(int index=0;index<s.length();index++){
            countWords=1;
            if(s.charAt(index)==','){
                String temp = s.substring(afterCommaIndex,index);
                if(words.containsKey(temp)){
                    countWords = words.get(temp)+1;
                    if(words.get(temp)==1)
                        WordsRepeated++;
                    words.remove(temp);
                    words.put(temp,countWords);
                }else{
                    howManyWordsDifferent++;
                    words.put(temp,countWords);
                }
                howManyWordsTotal++;
                afterCommaIndex=index+1;
            }else if(index+1==s.length()) {
                String temp = s.substring(afterCommaIndex);
                if(words.containsKey(temp)){
                    countWords = words.get(temp)+1;
                    if(words.get(temp)==1)
                        WordsRepeated++;
                    words.remove(temp);
                    words.put(temp,countWords);
                }else{
                    howManyWordsDifferent++;
                    words.put(temp,countWords);
                }
                howManyWordsTotal++;
            }
        }
        String maxInLenghtWord="";
        String wordShowUpAlot="";
        int howManyTimes=0;
        for (String key : words.keySet()) {
            if(key.length() > maxInLenghtWord.length()){
                maxInLenghtWord = key;
            }
            if(words.get(key) > howManyTimes){
                howManyTimes = words.get(key);
                wordShowUpAlot = key;
            }
        }
        System.out.println("Number of Total words is: " +howManyWordsTotal);
        System.out.println("Number of Different words is: " +howManyWordsDifferent);
        System.out.println("Number of Repeated words is: " +WordsRepeated);
        System.out.println("The word \""+wordShowUpAlot+"\" Showed up "+howManyTimes+" times!");
        System.out.println("The word \""+maxInLenghtWord+"\" is the longest word in the size of "+maxInLenghtWord.length()+"!");
    }//3
    public static void main(String args[]){
    }
}
