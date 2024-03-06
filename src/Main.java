import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        List <String> listBarang = new LinkedList<>();

        System.out.println("Masukkan objek List:");
        while(true){
            String input = scan.nextLine();
            if (input.isEmpty()){
                break;
            }
            listBarang.add(input);
        }
        Iterator it = listBarang.iterator();

        System.out.println("LinkedList:");
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
        System.out.print("Masukkan index data barang yang ingin ditampilkan: ");
        int i = scan.nextInt();
        System.out.println("Mengambil salah satu data barang: "+ listBarang.get(i));
        System.out.println();
        System.out.println("-=Konversi ke Collection lain=-");

        List <String> arrayListBarang = new ArrayList<>();
        arrayListBarang.addAll(listBarang);
        System.out.print("ArrayList: ");
        System.out.println(arrayListBarang);

        Set <String> setBarang = new HashSet<>();
        setBarang.addAll(arrayListBarang);
        System.out.print("SetHash: ");
        System.out.println(setBarang);

        Set <String> treeSetBarang = new TreeSet<>();
        treeSetBarang.addAll(setBarang);
        System.out.print("TreeSet: ");
        System.out.println(treeSetBarang);

        ArrayDeque <String> queueBarang = new ArrayDeque<>();
        queueBarang.addAll(treeSetBarang);
        System.out.print("ArrayDeque: ");
        queueBarang.addFirst(scan.next()); //menambah data di awal
        System.out.println(queueBarang);

        TreeMap <Integer, String> treeMapBarang = CreateTreeMap(queueBarang);
        System.out.println("TreeMap: ");
        for (Map.Entry<Integer, String> x: treeMapBarang.entrySet()){
            System.out.println(x.getKey() + ". " + x.getValue());
        }
    }

    public static TreeMap <Integer, String> CreateTreeMap(ArrayDeque<String> arrayDeque){
        TreeMap <Integer, String> mapBarang = new TreeMap<>();
        int count = 1;
        for(String newMap: arrayDeque){
            mapBarang.put(count, newMap);
            count++;
        }

        return mapBarang;
    }
}