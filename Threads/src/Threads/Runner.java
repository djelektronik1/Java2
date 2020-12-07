package Threads;
import Threads.OperationType;
import Threads.ThreadGenerator;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws InterruptedException {


        try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Введите пожалуйста число потоков: ");
			int countOfThreads = scan.nextInt();
			System.out.println("Введие пожалуйста число: ");
			int maxValue = scan.nextInt();
			System.out.println("Введите арифметическую операцию ('+', '-', '*') ");
			String operationType = scan.next();

			OperationType op = OperationType.ADDITION;

			switch (operationType) {
			    case "+":
			        op = OperationType.ADDITION;
			        break;
			    case "-":
			        op = OperationType.SUBTRACTION;
			        break;
			    case "*":
			        op = OperationType.MULTIPLICATION;
			        break;
			    default:
			        System.out.println("Некорректный тип операции! Выберите один из предложенных вариантов");
			}

			ThreadGenerator calculator;
			calculator = new ThreadGenerator(countOfThreads, op, maxValue);
			calculator.execute();
			System.out.println("\nОтвет: " + calculator.getResult());
		}
        
    }
}