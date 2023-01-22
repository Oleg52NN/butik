package myButik.projeсt;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!QuestionAndAnswer.questionAndAnswer("Желаете отключить рекламу?", "И это правильно, но неинтересно", "Ай, маладца! Смотри, наслаждайся!")) {
            Advertisement nostalgia = new Advertisement();
            nostalgia.constAssortment();
        }
        Assortment assort = new Assortment();
        for (Product product : Arrays.asList(
                new Product("Масло сливочное. 82,5%", 177, "ИП Творогов", 1),
                new Product("Масло подсолнечное", 120, "ООО \"Маслёнок\"", 135),
                new Product("Масло кунжутное", 275, "ИП Улугбеков", 72),
                new Product("Масло льняное", 230, "ИП Орлова", 31),
                new Product("Масло сливочное. 72,5%", 160, "ИП Творогов", 170),
                new Product("Творог. 9%", 70, "ООО \"Раздолье\"", 210),
                new Product("Творог. 5%", 69, "ООО \"Лагуна\"", 70),
                new Product("Сметана. 15%", 63, "ИП Творогов", 153),
                new Product("Сметана. 20%", 72, "ООО \"Лагуна\"", 92))) {
            assort.addAssortment(product);
        }
        boolean quit = true;
        Basket basket = new Basket();
        List<String> basicMenu = Arrays.asList(
                "1. Показать всю продукцию",
                "2. Поиск ",
                "3. Перейти в корзину",
                "4. Выбрать товар",
                "5. Оценить товар",
                "6. Вернуть товар",
                "7. Выход",
                "Ваш выбор? (1-7)"
        );
        List<String> basketMenu = Arrays.asList(
                "1. Оплатить?",
                "2. Вернуться в главное меню и продолжить выбор?",
                "3. Очистить корзину?",
                "Ваш выбор? (1-3)"
        );
        CardClient card = CardClient.get();
        int key = -1;
        while (quit) {
            int choice = menu(basicMenu);
            String s;

            switch (choice) {
                case 1:
                    ViewProducts.print((ArrayList<Product>) assort.assortment);
                    break;
                case 2:
                    System.out.println("Введите ключевое слово для поиска. \n Например, наименование продукта: \"Масло\" или производителя: \"ИП Орлова\"");
                    s = scanner.nextLine();
                    ArrayList<Product> filter = filterProduct((ArrayList<Product>) assort.assortment, s);
                    if (filter.size() != 0) {
                        ViewProducts.print(filter);
                    } else {
                        System.out.println("Извините, но такого товара нет");
                    }
                    break;
                case 3:
                    if (basket.products.size() != 0) {
                        if (QuestionAndAnswer.questionAndAnswer("У Вас есть карточка покупателя", "И это прекрасно", "Печально... Но выход есть!")) {
                            System.out.println("Введите номер Вашей карты");
                            key = Integer.parseInt(scanner.nextLine());
                            if (card.buyerRating.containsKey(key)) {
                                System.out.println("Ваш рейтинг покупателя: " + card.buyerRating.get(key));
                            } else {
                                System.out.println("Такой карты нет");
                                break;
                            }

                        } else {
                            key = card.getCard();
                            System.out.println("Мы дарим Вам карту с номером " + key);
                        }

                        System.out.println("Вы выбрали следующие товары:");
                        ViewProducts.print((ArrayList<Product>) basket.products);
                        int allMoney = 0;
                        for (Product b : basket.products
                        ) {
                            allMoney += b.getPrice();
                        }
                        System.out.println("Общая сумма покупки составит: " + allMoney + "руб.");
                        switch (menu(basketMenu)) {
                            case 1:
                                System.out.println("Товар оплачен. Спасибо!");
                                card.buyerRating.put(key, card.buyerRating.get(key) + allMoney);
                                basket.products.clear();
                                break;
                            case 2:
                                break;
                            case 3:
                                for (Product k : basket.products
                                ) {
                                    for (Product t : assort.assortment) {
                                        if (t.getCode() == k.getCode()) {
                                            t.setQuantity(t.getQuantity() + 1);
                                        }
                                    }
                                }
                                basket.products.clear();
                                break;
                            default:
                                System.out.println("Такого действия системой не предусмотрено");

                        }
                    } else {
                        System.out.println("Корзина пуста");
                    }
                    break;
                case 4:
                    System.out.println("Введите код выбранного товара");
                    s = scanner.nextLine();
                    choice = Integer.parseInt(s);
                    for (Product t : assort.assortment) {
                        if (t.getCode() == choice) {
                            if (t.getQuantity() != 0) {
                                basket.addProduct(t);
                                t.setQuantity(t.getQuantity() - 1);
                            } else {
                                System.out.println("Извините, но товар закончился");
                                break;
                            }
                            System.out.println("Продукт добавлен в корзину");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Введите код товара, который хотите оценить");
                    s = scanner.nextLine();
                    choice = Integer.parseInt(s);

                    System.out.println("Введите оценку от 1 до 5");
                    s = scanner.nextLine();
                    int estimate = Integer.parseInt(s);
                    if (estimate < 1 || estimate > 5) {
                        System.out.println("Допустимы оценки только от 1 до 5");
                        break;
                    }
                    for (Product t : assort.assortment) {
                        if (t.getCode() == choice) {
                            t.ratingProduct.addEstimation(estimate);
                        }
                    }
                    System.out.println("Ваша оценка учтена");
                    break;
                case 6:
                    System.out.println("Увы, но эта опция пока в нашем магазине не предусмотрена");
                    break;
                case 7:
                    quit = false;
                    break;
                default:
                    break;
            }
        }

    }

    protected static int menu(List<String> stringMenu) {
        Scanner scanner = new Scanner(System.in);
        for (String line : stringMenu
        ) {
            System.out.println(line);
        }
        String s = scanner.nextLine();
        return Integer.parseInt(s);
    }

    protected static ArrayList filterProduct(ArrayList<Product> products, String s) {
        List<Product> p = products.stream()
                .filter(product -> product.getName().contains(s) || product.getManufacturer().contains(s))
                .collect(Collectors.toList());
        return (ArrayList) p;
    }
}