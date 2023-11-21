import java.lang.reflect.Array;import java.util.*;class Dictionary {    private static class Entry {        String key;        String value;        Entry(String key, String value) {            this.key = key;            this.value = value;        }    }    private ArrayList<ArrayList<Entry>> table = new ArrayList<ArrayList<Entry>>();    public void set(String key, String value) {        String hash = getHash(key);        int index = indexOf(hash);        if(index == -1) {            ArrayList<Entry> arr = new ArrayList<Entry>();            arr.add(new Entry(hash, value));            table.add(arr);            System.out.printf("Записано значение %s по ключу %s\n", value, key);        }        else {            ArrayList<Entry> arr = table.get(index);            arr.add(new Entry(hash, value));            table.set(index, arr);            System.out.printf("Добавлено значения %s по ключу %s\n", value, key);        }    }    public ArrayList<Entry> get(String key) throws Exception {        String hash = getHash(key);        int index = indexOf(hash);        if(index != -1) return table.get(index);        System.out.printf("Ключ %s не существует\n", key);        throw new Exception("not found");    }    public void delete(String key) {        String hash = getHash(key);        int index = indexOf(hash);        if(index != -1) {            table.remove(index);            System.out.printf("Удален ключ %s\n", key);            return;        }        System.out.println("Такого ключа не существует");    }    public int indexOf(String key) {        for(int i = 0; i < table.size(); i++) {            for(Entry entry : table.get(i)) {                if(Objects.equals(entry.key, key)) return i;            }        }        return -1;    }    public void print() {        for(ArrayList<Entry> arr : table) {            System.out.printf("%s : %s, ", arr.get(0).key, arr.get(0).value);            for(int i = 1; i < arr.size(); i++) {                System.out.printf("%s, ", arr.get(i).value);            }            System.out.print("\n");        }    }    private String getHash(String s) {        int sum = 0;        for(int i = 0; i < s.length(); i++) {            sum += (int) s.charAt(i);        }        return Integer.toString(sum);    }}class HashFunction {    public HashFunction() {}    int hash(String s) {        int counter = 0;        char[] strInChars = s.toCharArray();        for(int i = 1; i <= s.length(); ++i) {            counter += strInChars[i-1] * i;        }        return counter;    }}class min {    public static void main(String[] args) {        Dictionary dict = new Dictionary();        dict.set("машина", "поехала");        dict.set("жена", "кольцо");        dict.set("ежна", "женщина");        dict.set("машина", "остановилась");        dict.print();        dict.delete("жена");        dict.print();    }}