# Refatoracao: 1.1

### Mapeamento de classes refatoradas:

1. Campus :white_check_mark:

    - [x] Campus
    - [x] CampusModel
    - [x] CampusModelTest

2. Predio :white_check_mark:

    - [x] Predio
    - [x] PredioModel
    - [x] PredioModelTest

3. Sala :white_check_mark:

    - [x] Sala
    - [x] SalaModel
    - [x] SalaModelTest

4. Reserva

    - [ ] Reserva
    - [ ] ReservaModel
    - [ ] ReservaModelTest

5. Professor

    - [x] Professor
    - [x] ProfessorModel
    - [x] ProfessorModelTest

6. Equipameno

    - [x] Equipamento
    - [x] EquipamentoModel
    - [x] EquipamentoModelTest

7. Funcionario

    - [x] Funcionario
    - [x] FuncionarioModel
    - [ ] FuncionarioModelTest

8. Usuario
    * Adicionado o atributo id.

## Anotações:

#### Para a próxima iteração:

1. Revisar todos os models e verificar se `` private Integer id = 0;``
2. Refatorar métodos do Model na próxima iteração
3. Todas as classes Model devem implementar a interface IMetodos