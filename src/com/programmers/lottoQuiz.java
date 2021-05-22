 import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        answer= new int[2];
        
        /*
            당첨 가능했던 최고순위와 최저순위 알고싶음
            식별불가능 번호는 0 
        */
        int correct = 0; 
        int incorrect = 0;
        HashMap<Integer,Integer> scoreMap = new HashMap<>();
        scoreMap.put(6,1);
        scoreMap.put(5,2);
        scoreMap.put(4,3);
        scoreMap.put(3,4);
        scoreMap.put(2,5);
        scoreMap.put(1,6);
        scoreMap.put(0,6);

       for(int i= 0; i<6; i++) {
            int temp = 0; 
           for(int j = 0; j<6; j++) {
               if(lottos[i] == win_nums[j]) {
                   correct ++;
                   break;
               }
               if(lottos[i] != 0  && lottos[i] != win_nums[j]) {
                   temp ++;
               }
               if(temp == 6) {incorrect ++;}
           }
       }
        answer[0] = scoreMap.get(6-incorrect);
        answer[1] = scoreMap.get(correct);
     //   System.out.println("correct : "+ correct);
    //    System.out.println("incorrect : "+ incorrect);
        return answer;
    }
}
