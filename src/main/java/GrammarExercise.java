import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class GrammarExercise {
    public static void main(String[] args) throws Exception {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) throws Exception {
        //在这编写实现代码
        String[] str1 = firstWordList.toUpperCase().split(",");
        String[] str2 = secondWordList.toUpperCase().split(",");
        List<String> l1 = new ArrayList<String>(Arrays.asList(str1));
        List<String> l2 = new ArrayList<String>(Arrays.asList(str2));
        long count1 = l1.stream().filter(string -> string.isEmpty()).count();
        long count2 = l2.stream().filter(string -> string.isEmpty()).count();
        List<String> result1;
        List<String> result;
        if (count1 > 0 || count2 > 0){
            throw new RuntimeException("input not valid");
        } else{
            boolean anyletter1 = l1.stream().allMatch((s) -> s.matches("[a-zA-Z]+"));
            boolean anyletter2 = l2.stream().allMatch((s) -> s.matches("[a-zA-Z]+"));
            if (anyletter1 && anyletter2){
                Collection<String> c = l1;
                Collection<String> d = l2;
                System.out.println("d"+d);
                System.out.println("c"+c);
                d.retainAll(c);
                String[] t_result = d.toArray(new String[d.size()]);
                result1 = Arrays.asList(t_result);
                List<String> collect = result1.stream().distinct().collect(Collectors.toList());
                System.out.println(collect);
                Collections.sort(collect);
                result = collect.stream().map(item -> {
                    char[] a = item.toCharArray();
                    String b = "";
                    String daiyi = "";
                    for (char ch : a){
                        b += ch;
                        b += " ";
                    }
                    daiyi = b.substring(0,b.length() - 1);
                    return daiyi;
                }).collect(Collectors.toList());
                System.out.println(result);

            } else{
                throw new RuntimeException("input not valid");
            }

        }
        return result;
    }
}
