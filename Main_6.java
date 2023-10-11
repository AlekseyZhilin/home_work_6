import java.util.*;

public class Main_6 {
    /*

    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
Работу сдать как обычно ссылкой на гит репозиторий
Частые ошибки:
1. Заставляете пользователя вводить все существующие критерии фильтрации
2. Невозможно использовать более одного критерия фильтрации одновременно
3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков или добавить еще ноутбук, то программа начинает работать некорректно
     */

    public static void main(String[] args) {
        Notebook n1 = new Notebook();
        n1.memory = 16;
        n1.HDD = 500;
        n1.OS = "Linux";
        n1.CPU = "Intel";
        n1.color = "Black";

        Notebook n2 = new Notebook();
        n2.memory = 8;
        n2.HDD = 1000;
        n2.OS = "Linux";
        n2.CPU = "Intel";
        n2.color = "Black";

        Notebook n3 = new Notebook();
        n3.memory = 16;
        n3.HDD = 1000;
        n3.OS = "Windows";
        n3.CPU = "Ryzen";
        n3.color = "White";

        Notebook n4 = new Notebook();
        n4.memory = 8;
        n4.HDD = 500;
        n4.OS = "Windows";
        n4.CPU = "Ryzen";
        n4.color = "Black";

        Notebook n5 = new Notebook();
        n5.memory = 8;
        n5.HDD = 1000;
        n5.OS = "MAC";
        n5.CPU = "Apple";
        n5.color = "Silver";

        Set<Notebook> notebooks = new HashSet<>();
        Map<Integer, Integer> filters = new HashMap<>();
        notebooks.add(n1);
        notebooks.add(n2);
        notebooks.add(n3);
        notebooks.add(n4);
        notebooks.add(n5);

        System.out.println("Все ноутбуки:");
        printNotebooks(notebooks);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        while (true){
            printMenu();
            System.out.println("Выберете пункт меню: ");
            int choise = scanner.nextInt();
            switch (choise){
                case 1:
                    System.out.println("Выберете объём памяти: ");
                    int param1 = scanner1.nextInt();
                    filters.put(choise, param1);
                    break;
                case 2:
                    System.out.println("Выберете размер диска: ");
                    int param2 = scanner1.nextInt();
                    filters.put(choise, param2);
                    break;
                case 3:
                    System.out.println("Выберете ОС: ");
                    int param3 = scanner1.nextInt();
                    filters.put(choise, param3);
                    break;
                case 4:
                    System.out.println("Выберете процессор: ");
                    int param4 = scanner1.nextInt();
                    filters.put(choise, param4);
                    break;
                case 5:
                    System.out.println("Выберете цвет: ");
                    int param5 = scanner1.nextInt();
                    filters.put(choise, param5);
                    break;
                case 6:
                    System.out.println("Результат поиска: ");
                    
                    Set<Notebook> filterNotebook = new HashSet<>(notebooks);
                    for (Map.Entry<Integer,Integer> el: filters.entrySet()) {
                        int num = el.getKey();
                        int findParam = el.getValue();
                        if(num==1){
                            filterNotebook = findMemory(notebooks, findParam);
                        }
                        if(num==2){
                            filterNotebook = findHDD(notebooks, findParam);
                        }
                        if(num==3){
                            filterNotebook = findOS(notebooks, findParam);
                        }
                        if(num==4){
                            filterNotebook = findCPU(notebooks, findParam);
                        }
                        if(num==5){
                            filterNotebook = findColor(notebooks, findParam);
                        }
                    }
                    printNotebooks(filterNotebook);
                    if(filterNotebook.isEmpty()) {
                        System.out.println("Нет ноутбуков, удовлетворяющих заданным критериям.");
                    }
                    filters.clear();
                    break;
                case 7:
                    return;
            }
        }

    }

    static public void printNotebooks(Set<Notebook> array){
        for (Notebook el: array){
            System.out.println(el);
        }
    }

    static public Set<Notebook> findMemory(Set<Notebook> notebooks, int val){
        Set<Notebook> list = new HashSet<>();
        for (Notebook el: notebooks){
            if(el.memory >= val){
                list.add(el);
            }
        }
        return list;
    }

    static public Set<Notebook> findHDD(Set<Notebook> notebooks, int val){
        Set<Notebook> list = new HashSet<>();
        for (Notebook el: notebooks){
            if(el.HDD >= val){
                list.add(el);
            }
        }
        return list;
    }

    static public Set<Notebook> findOS(Set<Notebook> notebooks, int val){
        Set<Notebook> list = new HashSet<>();
        for (Notebook el: notebooks){
            if(val == 1) {
                if (el.OS.equals("Linux")) {
                    list.add(el);
                }
            }
            else if (val == 2){
                if (el.OS.equals("Windows")) {
                    list.add(el);
                }
            }
            else if (val == 3){
                if (el.OS.equals("MAC")) {
                    list.add(el);
                }
            }
        }
        return list;
    }

    static public Set<Notebook> findCPU(Set<Notebook> notebooks, int val){
        Set<Notebook> list = new HashSet<>();
        for (Notebook el: notebooks){
            if(val == 1) {
                if (el.CPU.equals("Intel")) {
                    list.add(el);
                }
            }
            else if (val == 2){
                if (el.CPU.equals("Ryzen")) {
                    list.add(el);
                }
            }
            else if (val == 3){
                if (el.CPU.equals("Apple")) {
                    list.add(el);
                }
            }
        }
        return list;
    }

    static public Set<Notebook> findColor(Set<Notebook> notebooks, int val){
        Set<Notebook> list = new HashSet<>();
        for (Notebook el: notebooks){
            if(val == 1) {
                if (el.color.equals("Black")) {
                    list.add(el);
                }
            }
            else if (val == 2){
                if (el.color.equals("White")) {
                    list.add(el);
                }
            }
            else if (val == 3){
                if (el.color.equals("Silver")) {
                    list.add(el);
                }
            }
        }
        return list;
    }

    static public void printMenu(){
        System.out.println("Введите цифру, соответствующую необходимому критерию: \n" +
                "1 - ОЗУ\n" +
                "2 - Объем ЖД\n" +
                "3 - Операционная система (1 - Linux, 2 - Windows, 3 - MAC)\n" +
                "4 - Процессор (1 - Intel, 2 - Ryzen)\n" +
                "5 - Цвет (1 - Black, 2 - White, 3 - Silver)\n" +
                "6 - Поиск\n" +
                "7 - Выход");
    }
}


