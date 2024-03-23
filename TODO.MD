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

    - [x] Reserva
    - [x] ReservaModel
    - [x] ReservaModelTest

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
    - [x] FuncionarioModelTest

8. Usuario
    * Adicionado o atributo id.

## Anotações:

#### Para a próxima iteração:

0. Olhar todos os TO-DO's do código
1. Criar construtores padrões para todas as classes (model e afins)
1. Revisar todos os models e verificar se `` private Integer id = 0;``
2. Refatorar métodos do Model na próxima iteração
3. Todas as classes Model devem implementar a interface IMetodos
4. A sala deve conhecer sua reservas ?? discutir para a próxima iteração
5. Impedir que reservas aconteçam em salas que estão ocupadas.
6. 