import api.ApiRequest;
import api.NewResponse;
import classes.ApplicationCurrencies;

import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
// fazer verificaco da moeda
        String  base_code = "";
        String  target_code = "";
        int     amount = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("********************************************************");
        System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
        System.out.println();
        System.out.println(ApplicationCurrencies.allApplicationCurrenciesString);
        System.out.println();
        System.out.println("Escolha uma opção válida como moeda base:");
        System.out.println("********************************************************");
        base_code = sc.nextLine();

        System.out.println("********************************************************");
        System.out.println("Agora selecione a moeda que deseja converter");
        System.out.println();
        System.out.println(ApplicationCurrencies.allApplicationCurrenciesString);
        System.out.println();
        System.out.println("********************************************************");
        target_code = sc.nextLine();

        System.out.println("********************************************************");
        System.out.println();
        System.out.println("Agora digite o valor que deseja converter");
        System.out.println();
        System.out.println("********************************************************");
        amount = sc.nextInt();

        NewResponse dataObj = ApiRequest.connect(base_code, target_code, amount);

        System.out.println("********************************************************");
        System.out.println("Moeda Base: "+ dataObj.base_code());
        System.out.println("Moeda de Convertida: "+ dataObj.target_code());
        System.out.println("Taxa de conversão: "+ dataObj.conversion_rate());
        System.out.println("Valor final: "+ dataObj.conversion_result());
        System.out.println("********************************************************");


    }
}
