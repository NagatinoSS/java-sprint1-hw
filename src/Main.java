import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	public static void printMenu() {//метод списка команд
		System.out.println("1 - Ввести количество шагов за определённый день;");
		System.out.println("2 - Напечатать статистику за определённый месяц;");
		System.out.println("3 - Изменить цель по количеству шагов в день;");
		System.out.println("0 - Выйти из приложения.");
	}
	static void printAllMounth(){
		System.out.println("Введите порядковый номер месяца из списка:\n" +
				"1-\"январь\", 2-\"февраль\", 3-\"март\", 4-\"апрель\", 5-\"май\", 6-\"июнь\"," +
				"\n7-\"июль\", 8-\"август\", 9-\"сентябрь\", 10-\"октябрь\", " +
				"11-\"ноябрь\", 12-\"декабрь\".");
	}
	public static void main(String[] args) {
		StepTracker stepTrackerUser = new StepTracker();
		Scanner scanner = new Scanner(System.in);//работа с консолью
		System.out.println("Прототип приложения «Счётчик калорий».");
		while (true) {// бесконечный цикл
			System.out.println("------------------------------------");
			System.out.println("Введите номер нужной Вам опции, из списка действий");//Выберите нужный вариант действия!
			System.out.println("------------------------------------");
			printMenu();// вызов метода меню
			int command;
			while (true) {
				if (scanner.hasNextInt()) {
					command = scanner.nextInt();
					break;
				} else {
					System.out.println("\"Некорректный ввод. Ожидается ввод числа по номеру опций из списка\".");
					scanner.next();
				}
			}
			if (command == 1) {//Команда - Ввести количество шагов за определённый день;
				printAllMounth();
				int keyMounth;//переменная ключ ввода месяца через консоль
				while (true) {
					if (scanner.hasNextInt()) {
						keyMounth = scanner.nextInt();
						if (keyMounth > 0 && keyMounth <= 12) {
							break;
						} else if (keyMounth < 0) {
							System.out.println("Порядковый номер месяца не может быть отрицательным");
						} else if (keyMounth > 12) {
							System.out.println("Порядковый номер месяца в году, должен быть не больше 12");
						}
					} else {
						System.out.println("\"Некорректный ввод. Ожидается ввод чисел\".");
						scanner.next();
					}
				}//Проверка количества месяцев в году и Некорректный ввод
				System.out.println("Введите день:");
				int dayIn;//переменная для ввода дня
				while (true) {
					if (scanner.hasNextInt()) {
						dayIn = scanner.nextInt();
						if (dayIn > 0 && dayIn <= 30) {
							break;
						} else if (dayIn < 0) {
							System.out.println("Количество дней должно быть неотрицательным");
						} else if (dayIn > 30) {
							System.out.println("Количество дней должно быть не больше 30");
						}
					} else {
						System.out.println("\"Некорректный ввод. Ожидается ввод чисел\".");
						scanner.next();
					}
				}//Проверка количества дней в месяце и Некорректный ввод
				System.out.println("Введите количество пройденных шагов:");
				int steps; //= scanner.nextInt();//переменная для ввода дня
				while (true) {
					try {
						steps = scanner.nextInt();
					} catch (InputMismatchException e) {
						scanner.next();
						System.out.println("\"Некорректный ввод. Ожидается ввод числа\".");
						continue;
					}
					if (steps >= 0) {
						break;
					} else {
						System.out.println("Количество шагов должно быть неотрицательным");
					}
				}//Проверка для ввода дня и Некорректный ввод
				stepTrackerUser.getStepsHashMap(keyMounth, dayIn, steps);
				System.out.println("Вы добавили в: " + keyMounth + "-й месяц; " + dayIn + "-го дня; " + steps + " шагов; ");
			} else if (command == 2) {//Напечатать статистику за определённый месяц;
				printAllMounth();
				int keyMounth;//переменная ввода месяца через консоль
				while (true) {
					if (scanner.hasNextInt()) {
						keyMounth = scanner.nextInt();
						if (keyMounth > 0 && keyMounth <= 12) {
							break;
						} else if (keyMounth < 0) {
							System.out.println("Порядковый номер месяца не может быть отрицательным");
						} else if (keyMounth > 12) {
							System.out.println("Порядковый номер месяца в году, должен быть не больше 12");
						}
					} else {
						System.out.println("\"Некорректный ввод. Ожидается ввод чисел\".");
						scanner.next();
					}
				}//Проверка количества месяцев в году и Некорректный ввод
				stepTrackerUser.printStepsMounth(keyMounth);
				stepTrackerUser.sumStepsMounth(keyMounth);
				stepTrackerUser.averStepsMount(keyMounth);
				stepTrackerUser.distanceKm(keyMounth);
				stepTrackerUser.minusCalories(keyMounth);
				stepTrackerUser.bestSeries(keyMounth);
				System.out.println();
			} else if (command == 3) {//Изменить цель по количеству шагов в день;
				System.out.println("Введите новое значение целевого количества шагов:");
				int value;
				while (true) {
					if (scanner.hasNextInt()) {
						value = scanner.nextInt();
						if (value > 0) {
							break;
						} else if (value < 0) {
							System.out.println("Количество шагов должно быть неотрицательным");
						}
					} else {
						System.out.println("\"Некорректный ввод. Ожидается ввод чисел\".");
						scanner.next();
					}
				}//Проверка на отрицательные числа и Некорректный ввод
				int change = stepTrackerUser.changeTargetSteps(value);
				System.out.println("Новое значение целевого количества шагов: " + change + ";");
			} else if (command == 0) {
				System.out.println("Выход из приложения");
				break;
			} else {
				System.out.println("Извините, такой команды пока нет.");
			}
		}
	}
}