package Threads;
import Threads.OperationType;
import Threads.ThreadGenerator;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws InterruptedException {


        try (Scanner scan = new Scanner(System.in)) {
			System.out.println("������� ���������� ����� �������: ");
			int countOfThreads = scan.nextInt();
			System.out.println("������ ���������� �����: ");
			int maxValue = scan.nextInt();
			System.out.println("������� �������������� �������� ('+', '-', '*') ");
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
			        System.out.println("������������ ��� ��������! �������� ���� �� ������������ ���������");
			}

			ThreadGenerator calculator;
			calculator = new ThreadGenerator(countOfThreads, op, maxValue);
			calculator.execute();
			System.out.println("\n�����: " + calculator.getResult());
		}
        
    }
}