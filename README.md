🛒 PDV Mercearia Boa Compra

Sistema de Ponto de Venda (PDV) desenvolvido em Java, executado via console, voltado para a gestão de uma pequena mercearia. 
O projeto foi criado para praticar Programação Orientada a Objetos, coleções, tratamento de exceções e organização de código em 
pacotes.

🚧 Status: em desenvolvimento. O módulo de estoque está funcional; Caixa e Relatórios ainda estão em andamento.

📋 Funcionalidades
✅ Implementado
Autenticação de operadores
Criação de conta (nome, idade, CPF, sexo, e-mail e senha)
Login com e-mail e senha, com mensagem de erro para credenciais inválidas
Gestão de produtos (CRUD)
Cadastro de um ou vários produtos por vez
Consulta por ID ou por nome
Edição de dados do produto
Exclusão com confirmação
Validações
Código de barras com exatamente 13 dígitos (padrão EAN-13)
Preço, estoque e peso com valores válidos
CPF com 11 dígitos
Bloqueio de ID duplicado
Tratamento de entradas inválidas (letras em campos numéricos, valores vazios)
Menus interativos de navegação pelo console
🔜 Próximos passos
 Módulo de Caixa (registro de vendas)
 Relatórios (vendas e estoque)
 Persistência de dados em arquivo ou banco de dados
 Criptografia de senhas (hash)
 Validação do dígito verificador do EAN-13 e do CPF
 Testes unitários
🧱 Estrutura do projeto
src/main/java/system/pos/
├── home/
│   └── Main.java                  # Ponto de entrada, login e menus
├── model/
│   └── Product.java               # Entidade Produto
├── service/
│   └── ProductRegistration.java   # Regras do CRUD de produtos
└── user/
    ├── Operator.java              # Operador do sistema
    └── Customer.java              # Cliente
    └── Person.java              # Classe Pessoa
Pacote	Responsabilidade
home	Interação com o usuário, autenticação e navegação
model	Classes que representam os dados do domínio
service	Lógica de negócio e operações sobre os produtos
user	Classes de usuários (operador e cliente)
🧠 Conceitos aplicados
Programação Orientada a Objetos: encapsulamento, classes de modelo e de serviço
Coleções: Map<Long, Product> / HashMap para busca por ID e prevenção de duplicidade
Expressões regulares (regex): validação de código de barras, CPF e IDs
Tratamento de exceções: NumberFormatException e entradas inválidas
Leitura de dados: Scanner único compartilhado entre as classes
Organização em pacotes por responsabilidade
⚙️ Requisitos
JDK 17 ou superior (desenvolvido com JDK 25)
IDE de sua preferência (IntelliJ IDEA recomendado) ou terminal
▶️ Como executar
Pelo IntelliJ IDEA
Clone o repositório e abra a pasta do projeto no IntelliJ.
Aguarde a indexação do projeto.
Abra system/pos/home/Main.java.
Clique na seta verde ao lado de public static void main e escolha Run 'Main.main()'.
Pelo terminal
bash
# Clonar o repositório
git clone https://github.com/SEU-USUARIO/PDV-Mercearia-Boa-Compra.git
cd PDV-Mercearia-Boa-Compra

# Compilar
javac -d out $(find src -name "*.java")

# Executar
java -cp out system.pos.home.Main

No Windows (PowerShell):

powershell
$files = Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName }
javac -d out $files
java -cp out system.pos.home.Main
💻 Exemplo de uso
=============================
Bem-vindo(a), a Mercearia boa compra!
=============================
Já tem uma conta? (s/n): n
=============================
Criando conta!
=============================
Nome: Maria
Idade: 25
CPF (11 números): 12345678901
Sexo (M/F): F
E-mail: maria@email.com
Password: ********
Conta criada com êxito
Agora faça login para continuar.

Já tem uma conta? (s/n): s
E-mail: maria@email.com
Password: ********
Bem-vindo(a) novamente MARIA

O que deseja fazer hoje?
1 - Caixa
2 - Movimentar Estoque
3 - Relatório
4 - Sair
Cadastro de produto
Campo	Regra	Exemplo
ID	Número inteiro, único	1
Código de barras	Exatamente 13 dígitos	7891234567895
Nome	Texto livre	Arroz 5kg
Preço	Maior que zero (aceita , ou .)	28,90
Estoque	Número inteiro não negativo	50
Peso	Maior que zero	5
Disponível	s ou n	s
⚠️ Limitações conhecidas
Os dados ficam apenas em memória: ao encerrar o programa, contas e produtos são perdidos.
Existe um único operador por execução.
As senhas são armazenadas em texto puro (uso didático; não use em produção).



👤 Autor

Rogério Santoss

LinkedIn: www.linkedin.com/in/rogério-santos-codebyroger
GitHub: https://github.com/code-byroger
📄 Licença

Este projeto foi desenvolvido para fins de estudo. Sinta-se livre para usar como referência.
