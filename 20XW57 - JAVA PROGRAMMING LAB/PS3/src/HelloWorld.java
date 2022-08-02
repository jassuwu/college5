import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        String s = "Hello World! ";
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for(int i = 0,l = s.length(); i < l; i++) {
            char key = s.charAt(i);
            if(dict.containsKey(key)){
                dict.put(key, dict.get(key) + 1);
            }else{
                dict.put(key,1);
            }
        }
        System.out.println("+---------------------+");
        System.out.println("| Character\t|\tCount |");
        System.out.println("+---------------------+");
        dict.entrySet().forEach(entry -> {
            if(entry.getKey() != ' '){
                System.out.println("| "+entry.getKey()+ "\t\t\t|\t" + entry.getValue()+"\t\t|");
                System.out.println("+---------------------+");
            }
        });
    }
}