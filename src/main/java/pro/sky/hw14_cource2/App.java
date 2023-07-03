package pro.sky.hw14_cource2;

public class App
{
    public static void main( String[] args ){
        IntegerArrayList integerArrayList = new IntegerArrayList();
        integerArrayList.add(22);
        integerArrayList.add(177);
        integerArrayList.add(1);
        integerArrayList.add(45);
        integerArrayList.add(99);
        integerArrayList.add(104);
        integerArrayList.add(18);
        integerArrayList.add(58);

        System.out.println(integerArrayList);

        int number = 104;
        System.out.println("Contains " + number + " : " + integerArrayList.contains(number));
        System.out.println("Index of " + number + " : " + integerArrayList.indexOf(number));
        System.out.println(integerArrayList);


    }
}