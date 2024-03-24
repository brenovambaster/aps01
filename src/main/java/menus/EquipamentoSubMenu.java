/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;


import entidades.campus.Campus;
import entidades.equipamento.Equipamento;
import models.EquipamentoModel;
import java.util.Scanner;
public class EquipamentoSubMenu {

    String nomeEquipamento;
    String patrimonio;

    String opcao;

    EquipamentoModel equipamentoModel;
    public EquipamentoSubMenu() {
        this.nomeEquipamento = "";
        this.patrimonio = "";
    }

    public void equipamentoMenu() {

        while(true){

            System.out.println("Menu Equipamento");
            System.out.println("1 - Cadastrar Equipamento");
            System.out.println("2 - Listar Equipamentos");
            System.out.println("3 - Atualizar Equipamento");
            System.out.println("4 - Deletar Equipamento");
            System.out.println("5 - Voltar");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextLine();

            switch(opcao) {
                case "1":
                    //cadastrarEquipamento();
                    break;
                case "2":
                   // listarEquipamentos();
                    break;
                case "3":
                  //  atualizarEquipamentos();
                    break;
                case "4":
                   // deletaEquipamentos();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public void clearAtributos(){
        this.nomeEquipamento = null;
        this.patrimonio = null;
        this.opcao =null;
    }

    public void cadastrarCampus(){
        Equipamento equipamento = new Equipamento();
        String nomeEquipamento;
        String patrimonio;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do Equipamento: ");
        nomeEquipamento = scanner.nextLine();
        equipamento.setNome(nomeEquipamento);

        System.out.println("Digite o patrimonio do Equipamento: ");
        patrimonio = scanner.nextLine();
        equipamento.setPatrimonio(patrimonio);
        equipamentoModel.create(equipamento);
        clearAtributos();
    }

}
