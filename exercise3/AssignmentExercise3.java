package assignment.exercise3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignmentExercise3 {

    public static void main(String[] args) {
        ArrayList<List<Integer>> lists = new ArrayList();
        List<Integer> list1 = new ArrayList(Arrays.asList(4,10,15,24,26));
        List<Integer> list2 = new ArrayList(Arrays.asList(0,9,12,20));
        List<Integer> list3 = new ArrayList(Arrays.asList(5,18,22,30));
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        
        ArrayList<Integer> list = new ArrayList();
        
        list = order(list, lists);
    }
    
    public static ArrayList<Integer> order(ArrayList<Integer> list, ArrayList<List<Integer>> lists){
        ArrayList<Integer> mergedList = new ArrayList();

        for(List<Integer> l : lists){
            mergedList.addAll(l);
        }

        list = mergeSort(mergedList);
        return list;
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> mergedList){
        ArrayList<Integer> left = new ArrayList();
        ArrayList<Integer> right = new ArrayList();
        int middle;

        if(mergedList.size() == 1){
            return mergedList;
        } else{
            middle = mergedList.size() / 2;

            for(int i = 0; i < middle; i++){
                left.add(mergedList.get(i));
            }

            for(int i = middle; i < mergedList.size(); i++){
                right.add(mergedList.get(i));
            }

            left = mergeSort(left);
            right = mergeSort(right);

            merge(mergedList, left, right);
        }
        return mergedList;
    }

    public static void merge(ArrayList<Integer> mergedList, ArrayList<Integer> left, ArrayList<Integer> right){
        int leftPos = 0;
        int rightPos = 0;
        int mergedListPos = 0;

        while(leftPos < left.size() && rightPos < right.size()){
            if((left.get(leftPos) - right.get(rightPos)) < 0){
                mergedList.set(mergedListPos, left.get(leftPos++));
            } else{
                mergedList.set(mergedListPos, right.get(rightPos++));
            }
            mergedListPos++;
        }

        ArrayList<Integer> rest;
        int restPos;

        if(leftPos >= left.size()){
            rest = right;
            restPos = rightPos;
        } else{
            rest = left;
            restPos = leftPos;
        }

        for(int i = restPos; i < rest.size(); i++){
            mergedList.set(mergedListPos++, rest.get(i));
        }
    }
}
