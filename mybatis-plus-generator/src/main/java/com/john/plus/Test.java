package com.john.plus;

import java.util.Arrays;
import java.util.List;

public class Test {

   public static void main(String[] args) {
      List<Long> list = Arrays.asList(44L, 66L);
      list.forEach(System.out::println);

      IFunction<Long> function = li->{
         Long sum = 0L;
         for (Long integer : li) {
            sum += integer;
         }
         return sum;
      };
      function.sum(list);

      final Number sum = new TT().sum(Arrays.asList(4, 4, 5));
      System.out.println(sum);
   }

   @FunctionalInterface
   public interface IFunction<T extends Number>{
      Number sum(List<T> t);
   }

   public static class TT implements IFunction<Integer>{

      @Override
      public Number sum(List<Integer> t) {
         Integer sum = 0;
         for (Integer integer : t) {
            sum += integer;
         }
         return sum;
      }
   }

}
