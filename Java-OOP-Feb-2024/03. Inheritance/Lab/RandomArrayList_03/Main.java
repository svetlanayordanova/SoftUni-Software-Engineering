package inheritance.RandomArrayList_03;

import inheritance.RandomArrayList_03.RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add(5);
        randomArrayList.add(8);
        randomArrayList.add(7);
        randomArrayList.add(10);

        System.out.println(randomArrayList.getRandomElement());
    }
}