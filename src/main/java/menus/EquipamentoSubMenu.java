/*******************************************************************************
 * Copyright (c) 2024. @author: Breno Vambaster
 ******************************************************************************/

package menus;


import entidades.equipamento.Equipamento;
import models.EquipamentoModel;

import java.util.Scanner;
public class EquipamentoSubMenu {

    String nomeEquipamento;
    String patrimonio;
    String opcao;
    EquipamentoModel equipamentoModel = new EquipamentoModel();
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
            try {
                switch (opcao) {
                    case "1":
                        cadastrarEquipamento();
                        break;
                    case "2":
                        listarEquipamentos();
                        break;
                    case "3":
                        atualizarEquipamentos();
                        break;
                    case "4":
                        deletaEquipamentos();
                        break;
                    case "5":
                        return;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public void clearAtributos(){
        this.nomeEquipamento = null;
        this.patrimonio = null;
        this.opcao =null;
    }

    public void cadastrarEquipamento(){
        try {
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
            this.equipamentoModel.create(equipamento);
            clearAtributos();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array fora do limite");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("String fora do limite");
        }catch (NullPointerException e){
            System.out.println("Valores nulos nao sao validos");
        }catch (NumberFormatException e){
            System.out.println("Número inválido");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarEquipamentos(){
        System.out.println("Listando equipamentos:");
        for(Equipamento equipamento : this.equipamentoModel.getAll()){
            System.out.println(equipamento);
        }
        clearAtributos();
    }

    public void atualizarEquipamentos(){
        try{
            Equipamento equipamento = new Equipamento();
            String nomeEquipamento;
            String patrimonio;
            Scanner scanner = new Scanner(System.in);
            String input;
            Integer idEquipamento;

            listarEquipamentos();

            System.out.println("Digite o id do Equipamento a ser atualizado: ");
            input = scanner.nextLine();
            idEquipamento = Integer.parseInt(input);
            equipamento = this.equipamentoModel.get(idEquipamento);
            if(equipamento == null){
                throw new RuntimeException("Equipamento não encontrado");
            }
            System.out.println("Digite o nome do Equipamento: ");
            nomeEquipamento = scanner.nextLine();
            equipamento.setNome(nomeEquipamento);

            System.out.println("Digite o patrimonio do Equipamento: ");
            patrimonio = scanner.nextLine();
            equipamento.setPatrimonio(patrimonio);

            this.equipamentoModel.update(equipamento);
            clearAtributos();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array fora do limite");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("String fora do limite");
        }catch (NullPointerException e){
            System.out.println("Valores nulos nao sao validos");
        }catch (NumberFormatException e){
            System.out.println("Número inválido");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deletaEquipamentos(){
        try{
            Equipamento equipamento = new Equipamento();
            Scanner scanner = new Scanner(System.in);
            String input;
            Integer idEquipamento;

            listarEquipamentos();

            System.out.println("Digite o id do Equipamento a ser deletado: ");
            input = scanner.nextLine();
            idEquipamento = Integer.parseInt(input);
            equipamento = this.equipamentoModel.get(idEquipamento);
            if(equipamento == null){
                throw new RuntimeException("Equipamento não encontrado");
            }
            this.equipamentoModel.remove(equipamento);
            clearAtributos();
            System.out.println("Equipamento deletado com sucesso!");

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array fora do limite");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("String fora do limite");
        }catch (NullPointerException e){
            System.out.println("Valores nulos nao sao validos");
        }catch (NumberFormatException e){
            System.out.println("Número inválido");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
