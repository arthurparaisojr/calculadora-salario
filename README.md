# Cálculo de Salário

## Situação Problema: Cálculo de Salário

### Uma empresa possui diferentes tipos de funcionários, cada um com regras específicas para o cálculo do salário. Sua tarefa é desenvolver um endpoint REST único que calcule o salário de qualquer funcionário, recebendo um JSON específico para cada tipo de funcionário como entrada. O sistema deve ser projetado para que novos tipos de funcionários possam ser adicionados futuramente sem alterar a lógica existente.

### Tipos de Funcionários e Regras

#### Funcionário CLT:

Regras:
Recebe um salário base.
Recebe um bônus mensal de 10% do salário base.
Sofre um desconto de 8% do INSS sobre o salário base.
Exemplo de JSON de Entrada:{
  "nome": "João Silva",
  "tipo": "CLT",
  "salarioBase": 5000
}

#### Funcionário PJ (Pessoa Jurídica):

Regras:
Recebe um valor fixo referente ao contrato mensal.
Não possui descontos ou benefícios.
Exemplo de JSON de Entrada:{
  "nome": "Ana Santos",
  "tipo": "PJ",
  "valorContrato": 12000
}

#### Funcionário Freelancer:

Regras:
Recebe por hora trabalhada.
O número de horas trabalhadas e o valor por hora são informados no JSON.
Paga uma taxa de administração de 5% sobre o total recebido.
Exemplo de JSON de Entrada:
{
  "nome": "Carlos Almeida",
  "tipo": "Freelancer",
  "horasTrabalhadas": 80,
  "valorHora": 50
}

#### Funcionário Estagiário:

Regras:
Recebe um salário fixo mensal.
Recebe um auxílio transporte de R$ 150,00.
Não possui descontos.
Exemplo de JSON de Entrada:
{
  "nome": "Mariana Lima",
  "tipo": "Estagiário",
  "salarioFixo": 1500
}


#### Requisitos da API
Endpoint:
Um único endpoint REST será utilizado:
POST /calcular-salario
A entrada será um JSON com os dados do funcionário.
O tipo do funcionário será usado para determinar o formato do JSON e a lógica de cálculo.
Entrada:
O JSON de entrada varia de acordo com o tipo de funcionário.
Todos os JSONs devem incluir:
nome: Nome do funcionário.
tipo: Tipo do funcionário (CLT, PJ, Freelancer, ou Estagiário).
Os demais campos serão específicos para cada tipo.
Saída:
O endpoint retornará um JSON contendo:
nome: Nome do funcionário.
tipo: Tipo do funcionário.
detalhes: Detalhes do cálculo (ex.: bônus, descontos, etc.).
salarioFinal: Valor final do salário.


Exemplo de Saída
Funcionário CLT:
Entrada:
{
  "nome": "João Silva",
  "tipo": "CLT",
  "salarioBase": 5000
}

Resposta:
{
  "nome": "João Silva",
  "tipo": "CLT",
  "detalhes": {
    "salarioBase": 5000,
    "bonus": 500,
    "descontoINSS": 400
  },
  "salarioFinal": 5400
}


Funcionário PJ:
Entrada:
{
  "nome": "Ana Santos",
  "tipo": "PJ",
  "valorContrato": 12000
}

Resposta:
{
  "nome": "Ana Santos",
  "tipo": "PJ",
  "detalhes": {
    "valorContrato": 12000
  },
  "salarioFinal": 12000
}


Funcionário Freelancer:
Entrada:
{
  "nome": "Carlos Almeida",
  "tipo": "Freelancer",
  "horasTrabalhadas": 80,
  "valorHora": 50
}

Resposta:
{
  "nome": "Carlos Almeida",
  "tipo": "Freelancer",
  "detalhes": {
    "horasTrabalhadas": 80,
    "valorHora": 50,
    "taxaAdministracao": 200
  },
  "salarioFinal": 3800
}


Funcionário Estagiário:
Entrada:
{
  "nome": "Mariana Lima",
  "tipo": "Estagiário",
  "salarioFixo": 1500
}

Resposta:
{
  "nome": "Mariana Lima",
  "tipo": "Estagiário",
  "detalhes": {
    "salarioFixo": 1500,
    "auxilioTransporte": 150
  },
  "salarioFinal": 1650
}


Validação dos Dados de Entrada
A API deve validar os dados recebidos para garantir que:
Todos os campos obrigatórios estão presentes de acordo com o tipo especificado.
O tipo seja válido (CLT, PJ, Freelancer, ou Estagiário).
Campos adicionais sejam rejeitados, caso não sejam esperados para o tipo de funcionário informado.
