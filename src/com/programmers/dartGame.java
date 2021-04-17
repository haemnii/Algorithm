import java.util.*;
import java.math.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        char [] list= {};
        list = dartResult.toCharArray();
        int a = list.length;
      
        int [] numlist = new int[a];
        Arrays.fill(numlist,5000);
        
      /*   1D0S3S*  
         1 + 0 + 3*2 = 7
        1 2 3
        S D T */
        String temp = "";
        for(int i = 0; i<a; i++) {
            if(list[i] == 'D') {
                
                if(i > 1 &&list[i-2] == '1' && list[i-1] == '0') {
                    temp = "10";
                } else {
                    temp = list[i-1] + "";
                }
                numlist[i-1] = (int)Math.pow(Integer.parseInt(temp),2);
            } else if(list[i] == 'T') {
                 if(i > 1 && list[i-2] == '1' && list[i-1] == '0') {
                    temp = "10";
                } else {
                    temp = list[i-1] + "";
                }
                numlist[i-1] = (int)Math.pow(Integer.parseInt(temp),3);
            } else if(list[i] == 'S' ) {
                 if(i > 1 &&list[i-2] == '1' && list[i-1] == '0') {
                    temp = "10";
                } else {
                    temp = list[i-1] + "";
                }
                numlist[i-1] = Integer.parseInt(temp); 
               
            } else if(list[i] == '*' ) {
                int cnt = 0;
               for(int j = i; j>=0; j--) {
                   if(numlist[j] != 5000) {
                       numlist[j] *=2;
                       cnt++;
                   }
                   if(cnt == 2 ) {
                       break;
                   }
               }      
            }else if(list[i] == '#') {
        
               for(int j = i-1; j>=0; j--) {
                   if(numlist[j] != 5000) {
                       numlist[j] *= -1;
                       break;
                   }
                  
               }      
            }
        }
        
       for(int i =0; i<a; i++) {
           if(numlist[i] != 5000) {
           answer += numlist[i];
           }
       } 
        return answer;
    }
}
