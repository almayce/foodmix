package appwork.almayce.foodmix.model.ingredients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import appwork.almayce.foodmix.R;

/**
 * Created by almayce on 30.05.17.
 */

public class IngredientsDataBase {

    private static Map<String, Ingredient> all;
    public static IngredientsObservableList<Ingredient> changedIngredients;

    static {
        all = new HashMap<>();
        changedIngredients = new IngredientsObservableList<>();
        initDB();
    }

    public static Map<String, Ingredient> getAll() {
        return all;
    }

    public static ArrayList<String> getAllNames() {
        return new ArrayList<>(getAll().keySet());
    }

    private static void initDB() {

        // яйца
        all.put("яйца куриные", new Ingredient("яйца куриные", "яйца", "яйц", "яйца", R.drawable.eggs, 10, 6, 0, 0, 0));
        all.put("яйца перепелиные", new Ingredient("яйца перепелиные", "яйца", "яйц", "яйца", R.drawable.eggs, 5, 6, 0, 0, 0));

        // крупы
        all.put("рис", new Ingredient("рис", "рис", "рис", "крупы", R.drawable.groat, 20, 0, 0, 20, 180));
        all.put("гречневая крупа", new Ingredient("гречневая крупа", "гречка", "гречн", "крупы", R.drawable.groat, 20, 0, 0, 25, 180));
        all.put("перловая крупа", new Ingredient("перловая крупа", "перловка", "перл", "крупы", R.drawable.groat, 60, 0, 0, 60, 180));
        all.put("чечевица", new Ingredient("чечевица", "чечевица", "чечевиц", "крупы", R.drawable.groat, 25, 0, 0, 0, 0));
        all.put("горох", new Ingredient("горох", "горох", "горох", "крупы", R.drawable.groat, 60, 0, 0, 80, 220));
        all.put("нут", new Ingredient("нут", "нут", "нут", "крупы", R.drawable.groat, 50, 0, 0, 0, 0));
        all.put("манная крупа", new Ingredient("манная крупа", "манка", "манн", "крупы", R.drawable.groat, 7, 0, 0, 0, 0));
        all.put("кукурузная крупа", new Ingredient("кукурузная крупа", "крупа", "кукуруз", "крупы", R.drawable.groat, 30, 0, 0, 40, 180));
        all.put("овсянная крупа", new Ingredient("овсянная крупа", "овсянка", "овсян", "крупы", R.drawable.groat, 30, 0, 0, 0, 0));
        all.put("ячменная крупа", new Ingredient("ячменная крупа", "крупа", "ячмен", "крупы", R.drawable.groat, 40, 0, 0, 0, 0));
        all.put("пшеничная крупа", new Ingredient("пшеничная крупа", "крупа", "пшенич", "крупы", R.drawable.groat, 30, 0, 0, 40, 180));

        // паста
        all.put("спагетти", new Ingredient("спагетти", "спагетти", "спагетти", "паста", R.drawable.pasta, 9, 0, 0, 0, 0));
        all.put("лапша", new Ingredient("лапша", "лапша", "лапш", "паста", R.drawable.pasta, 7, 0, 0, 0, 0));
        all.put("вермишель", new Ingredient("вермишель", "вермишель", "вермиш", "паста", R.drawable.pasta, 5, 0, 0, 0, 0));

        // мясо
        all.put("баранина", new Ingredient("баранина", "баранина", "баран", "мясо", R.drawable.meat, 90, 60, 120, 50, 180));
        all.put("говядина", new Ingredient("говядина", "говядина", "говя", "мясо", R.drawable.meat, 60, 20, 0, 90, 180));
        all.put("свинина", new Ingredient("свинина", "свинина", "свин", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиная шея", new Ingredient("свиная шея", "шея", "свиная шея", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиная лопатка", new Ingredient("свиная лопатка", "лопатка", "свиная лопатка", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиной окорок", new Ingredient("свиной окорок", "окорок", "свиной окорок", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиной толстый край", new Ingredient("свиной толстый край", "край", "свиной толстый край", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиной тонкий край", new Ingredient("свиной тонкий край", "край", "свиной тонкий край", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиное сердце", new Ingredient("свиное сердце", "сердце", "свиное сердце", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиная печень", new Ingredient("свиная печень", "печень", "свиная печень", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиной язык", new Ingredient("свиной язык", "язык", "свиной язык", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиные ноги", new Ingredient("свиные ноги", "ноги", "свиные ноги", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиные ребрышки", new Ingredient("свиные ребрышки", "ребрышки", "свиные ребрышки", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиная корейка", new Ingredient("свиная корейка", "корейка", "свиная корейка", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиной карбонат", new Ingredient("свиной карбонат", "карбонат", "свиной карбонат", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("свиная вырезка", new Ingredient("свиная вырезка", "вырезка", "свиная вырезка", "мясо", R.drawable.meat, 120, 25, 0, 60, 180));
        all.put("мясо кролика", new Ingredient("мясо кролика", "кролик", "крол", "мясо", R.drawable.meat, 40, 25, 60, 120, 180));
        all.put("мясо зайца", new Ingredient("мясо зайца", "заяц", "зай", "мясо", R.drawable.meat, 60, 0, 0, 120, 180));
        all.put("телятина", new Ingredient("телятина", "телятина", "телятин", "мясо", R.drawable.meat, 60, 0, 0, 0, 0));

        // птица
        all.put("курица", new Ingredient("курица", "курица", "курин", "птица", R.drawable.chicken, 60, 30, 30, 40, 180));
        all.put("куриная грудка", new Ingredient("куриная грудка", "грудка", "куриная грудка", "птица", R.drawable.chicken, 60, 30, 30, 40, 180));
        all.put("куриное филе", new Ingredient("куриное филе", "филе", "куриное филе", "птица", R.drawable.chicken, 60, 30, 30, 40, 180));
        all.put("куриные крылышки", new Ingredient("куриные крылышки", "крылышки", "куриные крылышки", "птица", R.drawable.chicken, 60, 30, 30, 40, 180));
        all.put("куриная голень", new Ingredient("куриная голень", "голень", "куриная голень", "птица", R.drawable.chicken, 60, 30, 30, 40, 180));
        all.put("куриный окорочок", new Ingredient("куриный окорочок", "окорочок", "куриный окорочок", "птица", R.drawable.chicken, 60, 30, 30, 40, 180));
        all.put("куриное бедро", new Ingredient("куриное бедро", "бедро", "куриное бедро", "птица", R.drawable.chicken, 60, 30, 30, 40, 180));
        all.put("куриные сердечки", new Ingredient("куриные сердечки", "сердечки", "куриные сердечки", "птица", R.drawable.chicken, 60, 30, 30, 40, 180));
        all.put("куриная печень", new Ingredient("куриная печень", "печень", "куриная печень", "птица", R.drawable.chicken, 60, 30, 30, 40, 180));
        all.put("куриный суповой набор", new Ingredient("куриный суповой набор", "набор", "куриный суповой набор", "птица", R.drawable.chicken, 60, 30, 30, 40, 180));
        all.put("индейка", new Ingredient("индейка", "индейка", "индейк", "птица", R.drawable.chicken, 60, 0, 0, 0, 0));
        all.put("утка", new Ingredient("утка", "утка", "утк", "птица", R.drawable.chicken, 40, 35, 0, 130, 200));
        all.put("гусь", new Ingredient("гусь", "гусь", "гус", "птица", R.drawable.chicken, 120, 0, 0, 100, 190));

        // рыба
        all.put("треска", new Ingredient("треска", "треска", "треск", "рыба", R.drawable.fish, 15, 8, 0, 30, 180));
        all.put("семга", new Ingredient("семга", "семга", "семг", "рыба", R.drawable.fish, 25, 6, 15, 30, 180));
        all.put("форель", new Ingredient("форель", "форель", "форел", "рыба", R.drawable.fish, 15, 15, 20, 30, 180));
        all.put("судак", new Ingredient("судак", "судак", "судак", "рыба", R.drawable.fish, 10, 7, 0, 15, 180));
        all.put("щука", new Ingredient("щука", "щука", "щук", "рыба", R.drawable.fish, 25, 20, 0, 30, 180));
        all.put("осетр", new Ingredient("осетр", "осетр", "осетр", "рыба", R.drawable.fish, 10, 0, 0, 30, 180));
        all.put("скумбрия", new Ingredient("скумбрия", "скумбрия", "скумбр", "рыба", R.drawable.fish, 10, 12, 0, 40, 190));
        all.put("горбуша", new Ingredient("горбуша", "горбуша", "горбуш", "рыба", R.drawable.fish, 15, 18, 0, 30, 180));
        all.put("камбала", new Ingredient("камбала", "камбала", "камбал", "рыба", R.drawable.fish, 20, 14, 0, 30, 160));
        all.put("сельдь", new Ingredient("сельдь", "сельдь", "сельдь", "рыба", R.drawable.fish, 15, 0, 0, 30, 200));
        all.put("мойва", new Ingredient("мойва", "мойва", "мойв", "рыба", R.drawable.fish, 10, 5, 0, 30, 180));
        all.put("корюшка", new Ingredient("корюшка", "корюшка", "корюшк", "рыба", R.drawable.fish, 5, 15, 0, 30, 180));
        all.put("окунь", new Ingredient("окунь", "окунь", "окун", "рыба", R.drawable.fish, 10, 0, 0, 20, 180));
        all.put("карп", new Ingredient("карп", "карп", "карп", "рыба", R.drawable.fish, 30, 12, 0, 70, 180));
        all.put("толстолобик", new Ingredient("толстолобик", "рыба", "толстолобик", "рыба", R.drawable.fish, 25, 10, 0, 30, 180));
        all.put("карась", new Ingredient("карась", "карась", "карас", "рыба", R.drawable.fish, 15, 10, 0, 50, 180));
        all.put("кета", new Ingredient("кета", "кета", "кета", "рыба", R.drawable.fish, 30, 8, 0, 25, 180));
        all.put("тунец", new Ingredient("тунец", "тунец", "тун", "рыба", R.drawable.fish, 7, 8, 0, 0, 0));
        all.put("лещ", new Ingredient("лещ", "лещ", "лещ", "рыба", R.drawable.fish, 10, 12, 0, 40, 200));
        all.put("минтай", new Ingredient("минтай", "минтай", "минтай", "рыба", R.drawable.fish, 10, 8, 0, 25, 180));
        all.put("хариус", new Ingredient("хариус", "хариус", "хариус", "рыба", R.drawable.fish, 10, 8, 0, 30, 170));
        all.put("зубатка", new Ingredient("зубатка", "зубатка", "зубатк", "рыба", R.drawable.fish, 20, 20, 0, 25, 200));

        // морепродукты
        all.put("кальмар", new Ingredient("кальмар", "кальмар", "кальмар", "морепродукты", R.drawable.squid, 5, 0, 0, 0, 0));
        all.put("креветки", new Ingredient("креветки", "креветки", "креветки", "морепродукты", R.drawable.shrimp, 5, 0, 0, 0, 0));

        // овощи
        all.put("морковь", new Ingredient("морковь", "морковь", "морков", "овощи", R.drawable.carrot, 25, 10, 0, 0, 0));
        all.put("картофель", new Ingredient("картофель", "картофель", "картофел", "овощи", R.drawable.potato, 25, 25, 0, 0, 0));
        all.put("лук парей", new Ingredient("лук парей", "лук", "парей", "овощи", R.drawable.parei, 0, 0, 0, 0, 0));
        all.put("лук", new Ingredient("лук", "лук", "лук", "овощи", R.drawable.onion, 10, 5, 0, 0, 0));
        all.put("перец болгарский", new Ingredient("перец болгарский", "перец", "болгарский", "овощи", R.drawable.papper_veg, 7, 12, 0, 15, 200));
        all.put("баклажан", new Ingredient("баклажан", "баклажан", "баклажан", "овощи", R.drawable.eggplant, 15, 15, 0, 20, 180));
        all.put("горох", new Ingredient("горох", "горох", "горох", "овощи", R.drawable.peas, 15, 15, 0, 20, 180));
        all.put("кабачок", new Ingredient("кабачок", "кабачок", "кабачок", "овощи", R.drawable.marrow, 15, 15, 0, 20, 180));
        all.put("капуста", new Ingredient("капуста", "капуста", "капуст", "овощи", R.drawable.cabbage, 15, 15, 0, 20, 180));
        all.put("кукуруза", new Ingredient("кукуруза", "кукуруза", "кукуруз", "овощи", R.drawable.corn, 15, 15, 0, 20, 180));
        all.put("огурец", new Ingredient("огурец", "огурец", "огур", "овощи", R.drawable.cucumber, 15, 15, 0, 20, 180));
        all.put("репа", new Ingredient("репа", "репа", "реп", "овощи", R.drawable.turnip, 15, 15, 0, 20, 180));
        all.put("свекла", new Ingredient("свекла", "свекла", "свек", "овощи", R.drawable.beet, 15, 15, 0, 20, 180));
        all.put("спаржа", new Ingredient("спаржа", "спаржа", "спарж", "овощи", R.drawable.asparagus, 15, 15, 0, 20, 180));
        all.put("томат", new Ingredient("томат", "томат", "томат", "овощи", R.drawable.tomato, 15, 15, 0, 20, 180));
        all.put("помидор", new Ingredient("помидор", "помидор", "помидор", "овощи", R.drawable.tomato, 15, 15, 0, 20, 180));
        all.put("тыква", new Ingredient("тыква", "тыква", "тыкв", "овощи", R.drawable.pumpkin, 15, 15, 0, 20, 180));
        all.put("фасоль", new Ingredient("фасоль", "фасоль", "фасоль", "овощи", R.drawable.bean, 15, 15, 0, 20, 180));
        all.put("щавель", new Ingredient("щавель", "щавель", "щавель", "овощи", R.drawable.sorrel, 15, 15, 0, 20, 180));

        // фрукты
        all.put("банан", new Ingredient("банан", "банан", "банан", "фрукт", R.drawable.banana, 0, 0, 0, 0, 0));
        all.put("вишня", new Ingredient("вишня", "вишня", "вишн", "фрукт", R.drawable.cherry, 0, 0, 0, 0, 0));
        all.put("черешня", new Ingredient("черешня", "черешня", "черешн", "фрукт", R.drawable.cherry, 0, 0, 0, 0, 0));
        all.put("киви", new Ingredient("киви", "киви", "киви", "фрукт", R.drawable.kivi, 0, 0, 0, 0, 0));
        all.put("лимон", new Ingredient("лимон", "лимон", "лимон", "фрукт", R.drawable.lemon, 0, 0, 0, 0, 0));
        all.put("апельсин", new Ingredient("апельсин", "апельсин", "апельсин", "фрукт", R.drawable.orange, 0, 0, 0, 0, 0));
        all.put("грейпфрут", new Ingredient("грейпфрут", "грейпфрут", "грейпфрут", "фрукт", R.drawable.orange, 0, 0, 0, 0, 0));
        all.put("персик", new Ingredient("персик", "персик", "персик", "фрукт", R.drawable.peach, 0, 0, 0, 0, 0));
        all.put("абрикос", new Ingredient("абрикос", "абрикос", "абрикос", "фрукт", R.drawable.peach, 0, 0, 0, 0, 0));
        all.put("яблоко", new Ingredient("яблоко", "яблоко", "яблок", "фрукт", R.drawable.peach, 0, 0, 0, 0, 0));
        all.put("груша", new Ingredient("груша", "груша", "груш", "фрукт", R.drawable.peach, 0, 0, 0, 0, 0));

        // грибы
        all.put("грибы", new Ingredient("грибы", "грибы", "гриб", "грибы", R.drawable.shroom2, 40, 20, 0, 10, 150));
        all.put("грибы лисички", new Ingredient("грибы лисички", "лисички", "лисички", "грибы", R.drawable.shroom1, 20, 30, 0, 20, 150));
        all.put("грибы консервированные", new Ingredient("грибы консервированные", "грибы", "грибы консервированные", "грибы", R.drawable.tin, 20, 30, 0, 20, 150));

        // соусы
        all.put("кетчуп", new Ingredient("кетчуп", "кетчуп", "кетчуп", "соусы", R.drawable.ketchup, 0, 0, 0, 0, 0));
        all.put("майонез", new Ingredient("майонез", "майонез", "майонез", "соусы", R.drawable.sauce, 0, 0, 0, 0, 0));
        all.put("сметана", new Ingredient("сметана", "сметана", "сметан", "соусы", R.drawable.sauce, 0, 0, 0, 0, 0));
        all.put("чилли соус", new Ingredient("чилли соус", "чилли", "чилли", "соусы", R.drawable.chilli, 0, 0, 0, 0, 0));
        all.put("соус", new Ingredient("соус", "соус", "соус", "соусы", R.drawable.sauce, 0, 0, 0, 0, 0));

        // специи
        all.put("перец черный", new Ingredient("черный перец", "перец", "черный перец", "специи", R.drawable.papper, 0, 0, 0, 0, 0));
        all.put("соль", new Ingredient("соль", "соль", "соль", "специи", R.drawable.salt, 0, 0, 0, 0, 0));
        all.put("специи", new Ingredient("специи", "специи", "специи", "специи", R.drawable.spice, 0, 0, 0, 0, 0));

        // другое
        all.put("молоко", new Ingredient("молоко", "молоко", "моло", "другое", R.drawable.milk, 0, 0, 0, 0, 0));
        all.put("сыр", new Ingredient("сыр", "сыр", "сыр", "другое", R.drawable.cheese, 0, 0, 0, 0, 0));
        all.put("масло", new Ingredient("масло", "масло", "масло", "другое", R.drawable.butter, 0, 0, 0, 0, 0));
        all.put("зелень", new Ingredient("зелень", "зелень", "зелень", "другое", R.drawable.green, 0, 0, 0, 0, 0));
        all.put("хлеб", new Ingredient("хлеб", "хлеб", "хлеб", "другое", R.drawable.bread, 0, 0, 0, 0, 0));
    }
}
