import java.util.*;

import Property.Imobiliaria;
import Exception.ForeignException;
import Enum.Type;
import Property.Service.Property.Service;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Service imb = new Service();
        Map<Integer, Imobiliaria> imobList = new TreeMap<>();
        imobList.put(190, new Imobiliaria(190, 800.0, Type.RESIDENCIAL));
        imobList.put(191, new Imobiliaria(191, 700.0, Type.RESIDENCIAL));

        int opcao;
        try {
            do {
                    do {
                        System.out.printf("MENU %n1 -> Adicionar Imóvel %n2 -> Remover Imóvel %n3 -> Mostrar ordenado pelo codigo %n4 -> Procurar por Código %n5 -> Sair%n");
                        opcao = sc.nextInt();
                        if ((opcao != 1) && (opcao != 2) && (opcao != 3) && (opcao != 4) && (opcao != 5)) {
                            System.out.println("type a value that respond to an option");
                        }
                    } while ((opcao != 1) && (opcao != 2) && (opcao != 3) && (opcao != 4) && (opcao != 5));

                switch (opcao) {
                    case 1:
                        try {
                            System.out.print("digite o código do imóvel: ");
                            int codigoImovel = sc.nextInt();
                            int tipo;
                            Type type;
                            do {
                                System.out.printf("%ndigite o tipo: 1 -> Residencial 2 -> Comercial 3 -> Galpão %n");
                                tipo = sc.nextInt();

                                type = switch (tipo) {
                                    case 1 -> Type.RESIDENCIAL;
                                    case 2 -> Type.COMERCIAL;
                                    case 3 -> Type.GALPAO;
                                    default -> null;
                                };
                            } while ((tipo != 3) && (tipo != 2) && (tipo != 1));
                            System.out.print("digite o valor do aluguel base: ");
                            double valorAluguel = sc.nextDouble();
                            imb.insertProperty(codigoImovel, valorAluguel, type, imobList);
                        } catch (ForeignException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Digite o código do imóvel a remover: ");
                            int codeRemove = sc.nextInt();
                            imb.removeProperty(codeRemove, imobList);
                        } catch (ForeignException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3:
                        if (!imobList.isEmpty()) {
                            System.out.println("Código    Valor Aluguel    Tipo");
                            imb.findAll(imobList);
                        }
                        break;
                    case 4:
                        System.out.print("Digite o código do imóvel a ser pesquisado: ");
                        int searchCode = sc.nextInt();
                        imb.findById(searchCode, imobList);
                        break;
                }
            } while (opcao != 5);
        }catch (InputMismatchException e){
            throw new ForeignException("invalid value");
        }


    }

    }
