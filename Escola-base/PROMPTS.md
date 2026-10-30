# PROMPTS: Grupo ____

**Integrantes:**

1.Allyson de santana almeida
2.Lucas fernandes da silva
3.

**Prova:** API em MVC (Reserva de Salas)

**Usamos IA?** (/) Sim  ( ) Não

**Qual ferramenta e modelo (se usaram):**
chatgpt-sol

> Quem não usou IA: troque "prompt" por "passo". Em cada bloco abaixo, descreva o que vocês fizeram naquele passo, na ordem em que aconteceu, e preencha os outros campos do mesmo jeito.

## Registro, na ordem

Copie o bloco abaixo para cada prompt. Escreva o prompt exatamente como foi enviado.

### Prompt 1

**O prompt (cópia exata):**

> crie um prompt, estou fazendo uma prova de api em mvc com o auxilio de ia liberado, a API deve ser organizada em camadas (Model, Repository, Service e Controller), com as regras de negócio na Service, e responder cada situação com o status HTTP certo, a nota é dividida em duas partes o produto (6,0) a api, e o processo (4,0), o caminho que a gente seguiu, devera ser enviado ao professor um .zip com a pasta Escola-base sem a pasta target, o README.md com os nomes dos integrantes e o roteiro de conferência preenchido, e o PROMPTS.md , oque deve ser a api escola quer uma API para controlar a reserva de suas salas: laboratórios, auditório, salas de aula. Cada sala tem um código, um nome e uma capacidade, e a escola precisa saber quais estão reservadas e quais estão livres, a api deve fazer cadastrar uma sala, listar todas, buscar uma pelo id e excluir, reservar uma sala e liberar uma sala, responder cada situação com o status HTTP certo: sucesso, criado, sem conteúdo, não encontrado, conflito e dados inválidos; as regras da escola sao Toda sala cadastrada começa livre. código é único não pode haver duas salas com o mesmo código. Código e nome são obrigatórios e a capacidade precisa ser maior que zero, uma sala que já está reservada não pode ser reservada de novo, só pode ser liberada uma sala que está reservada. uma sala reservada não pode ser excluída. pedir, reservar, liberar ou excluir uma sala que não existe é um caso de "não encontrado"; oque o projeto precisa ter - O projeto Escola-base, que o professor entrega, e que vocês usam como ponto de partida. Ele já traz Spring Web, Spring Data JPA, validação e banco H2 em memória, e já sobe sem nenhuma classe de vocês. Não precisa criar projeto. O arquivo `README.md` dele explica como rodar. Organização em camadas, cada uma no seu pacote, criado por vocês dentro de `src/main/java/escola`: `model`, `repository`, `service` e `controller`. O projeto base não traz essas pastas prontas. as regras da escola ficam na Service. O Controller só recebe a requisição, chama a Service e devolve a resposta HTTP. O Controller não conversa direto com o Repository. As rotas seguem o padrão REST. voce escolhem os nomes.
ESTRUTURA DE PASTAS
Escola-base/
├── src/
│   └── main/
│       └── java/
│           └── escola/
│               ├── model/
│               │   └── Sala.java
│               │
│               ├── repository/
│               │   └── SalaRepository.java
│               │
│               ├── service/
|               |   └── SalaNaoEncontradaException.java
│               │   └── SalaService.java
│               │
│               └── controller/
|                   └── GlobalExceptionHandler.java
│                   └── SalaController.java
│
├── README.md (a gente preenche)
├── PROMPTS.md (a gente preenche)


**O que a IA devolveu (uma ou duas linhas):**
ela devolveu um propt para a gente usar e criar o sistema

**O que fizemos com a resposta:** (/) usamos como veio  ( ) alteramos  ( ) descartamos

**Por quê (o que conferimos, o que mudamos):**
adicionamos algumas arquivos extra

### Prompt 2

**O prompt (cópia exata):**

> PROMPT — DESENVOLVIMENTO DA API ESCOLA (SPRING BOOT MVC)

Atue como um desenvolvedor Java especialista em Spring Boot, Spring MVC, Spring Data JPA, arquitetura em camadas e APIs REST. Você também deve atuar como um tutor, explicando as decisões técnicas de maneira clara e objetiva.

Estou realizando uma prova prática de desenvolvimento de API com auxílio de inteligência artificial permitido. Preciso desenvolver uma API para gerenciamento de reservas de salas de uma escola, seguindo rigorosamente os requisitos apresentados pelo professor.

IMPORTANTE: Não quero apenas um código que funcione. Quero desenvolver uma solução organizada, compreender o que está sendo feito e documentar o processo, pois minha avaliação também considera o caminho utilizado para desenvolver o projeto.

1. CONTEXTO DO PROJETO

O projeto inicial se chama Escola-base e foi fornecido pelo professor.

Ele já possui:

Spring Web;
Spring Data JPA;
Validação;
Banco de dados H2 em memória;
Configurações necessárias para iniciar a aplicação.

Não crie outro projeto Spring Boot. Trabalhe exclusivamente sobre o projeto Escola-base fornecido pelo professor.

O projeto já inicia sem a necessidade de criar classes adicionais.

2. OBJETIVO DA API

Desenvolver uma API REST para controlar as reservas das salas de uma escola.

A escola possui diferentes tipos de ambientes:

Laboratórios;
Auditório;
Salas de aula.

Cada sala deve possuir:

ID;
Código;
Nome;
Capacidade;
Situação de reserva (livre ou reservada).
3. ARQUITETURA OBRIGATÓRIA

O projeto deve seguir arquitetura em camadas, com cada camada em seu próprio pacote dentro de src/main/java/escola.

Estrutura esperada:

Escola-base/ ├── src/ │ └── main/ │ └── java/ │ └── escola/ │ ├── model/ │ │ └── Sala.java │ ├── repository/ │ │ └── SalaRepository.java │ ├── service/ │ │ └── SalaService.java │ └── controller/ │ └── SalaController.java ├── README.md └── PROMPTS.md

Responsabilidades de cada camada:

MODEL

Representar a entidade Sala.
Definir seus atributos.
Configurar as anotações JPA necessárias.
Representar o estado de reserva da sala.

REPOSITORY

Estender a interface apropriada do Spring Data JPA.
Realizar operações de persistência e consultas ao banco.
Disponibilizar consultas necessárias, como busca por código.

SERVICE

Concentrar TODAS as regras de negócio.
Verificar se uma sala existe.
Impedir códigos duplicados.
Validar as operações de reserva e liberação.
Impedir a exclusão de salas reservadas.
Lançar exceções apropriadas para cada situação.

CONTROLLER

Receber as requisições HTTP.
Chamar os métodos da Service.
Retornar as respostas HTTP e seus respectivos status.
Não acessar o Repository diretamente.
Não implementar regras de negócio.
4. FUNCIONALIDADES OBRIGATÓRIAS

A API precisa permitir:

Cadastrar uma sala.
Listar todas as salas.
Buscar uma sala pelo ID.
Excluir uma sala.
Reservar uma sala.
Liberar uma sala.

Sugira rotas REST padronizadas, explicando brevemente a finalidade de cada uma.

5. REGRAS DE NEGÓCIO OBRIGATÓRIAS

Implemente e respeite todas as regras:

Toda sala cadastrada começa livre.
O código da sala é único.
Não pode existir mais de uma sala com o mesmo código.
Código é obrigatório.
Nome é obrigatório.
Capacidade deve ser maior que zero.
Uma sala já reservada não pode ser reservada novamente.
Só pode ser liberada uma sala que esteja reservada.
Uma sala reservada não pode ser excluída.
Reservar, liberar, excluir ou buscar uma sala inexistente deve retornar não encontrado.
Dados inválidos devem ser tratados adequadamente.
Tentativas de operações incompatíveis com o estado atual da sala devem retornar conflito.

Não deixe regras de negócio no Controller.

6. STATUS HTTP OBRIGATÓRIOS

A API deve utilizar corretamente:

200 OK: Operação realizada com sucesso, como listar ou buscar uma sala.
201 CREATED: Sala cadastrada com sucesso.
204 NO CONTENT: Operação realizada com sucesso sem conteúdo de retorno, como exclusão ou liberação.
404 NOT FOUND: Sala não encontrada.
409 CONFLICT: Código duplicado, sala já reservada, sala livre sendo liberada ou tentativa de excluir sala reservada.
400 BAD REQUEST: Dados inválidos, campos obrigatórios ausentes ou capacidade menor ou igual a zero.

Explique quando cada status deve ser utilizado e implemente o tratamento adequado de exceções.

7. FORMA DE DESENVOLVIMENTO

Trabalhe por etapas, sem gerar todo o projeto de uma vez.

Siga esta ordem:

Analisar a estrutura do projeto Escola-base.
Explicar o que será desenvolvido.
Criar a entidade Sala.java.
Criar o SalaRepository.java.
Criar o SalaService.java com todas as regras de negócio.
Criar o SalaController.java com as rotas REST.
Implementar o tratamento de exceções e os status HTTP.
Executar e testar todas as funcionalidades.
Conferir se todas as regras do professor foram atendidas.
Preparar a documentação e os arquivos para entrega.

Em cada etapa:

Explique o objetivo da classe.
Informe o caminho exato do arquivo.
Apresente o código completo.
Explique as principais anotações utilizadas.
Explique como a classe se comunica com as outras camadas.
Não utilize bibliotecas que não estejam disponíveis no projeto sem justificar e solicitar autorização.
Não altere arquivos de configuração desnecessariamente.
Não crie funcionalidades que não foram solicitadas pelo professor.

Se houver alguma informação faltando, pergunte antes de tomar decisões que possam comprometer o projeto.

8. TESTES OBRIGATÓRIOS

Depois de desenvolver a API, crie um roteiro de testes para verificar:

Cadastro de sala com dados válidos.
Cadastro sem código.
Cadastro sem nome.
Cadastro com capacidade zero ou negativa.
Cadastro com código duplicado.
Listagem de salas.
Busca de sala existente.
Busca de sala inexistente.
Reserva de sala livre.
Reserva de sala já reservada.
Liberação de sala reservada.
Liberação de sala que já está livre.
Exclusão de sala livre.
Exclusão de sala reservada.
Reserva de sala inexistente.
Liberação de sala inexistente.
Exclusão de sala inexistente.

Para cada teste, informe:

Método HTTP;
Endpoint;
Dados enviados, quando necessários;
Resultado esperado;
Status HTTP esperado.
9. DOCUMENTAÇÃO PARA ENTREGA

A entrega deve conter:

README.md

Nome do projeto.
Nomes dos integrantes.
Descrição da API.
Tecnologias utilizadas.
Instruções para executar o projeto.
Rotas disponíveis.
Informações necessárias para testar a API.

PROMPTS.md

Registrar os prompts utilizados durante o desenvolvimento.
Registrar as solicitações feitas à IA.
Documentar como a IA auxiliou na construção de cada camada.
Registrar as correções e melhorias solicitadas.
Mostrar o processo de desenvolvimento, não apenas o resultado final.

ROTEIRO DE CONFERÊNCIA

Preencher todos os itens solicitados pelo professor.
Conferir cada funcionalidade e regra de negócio.
Não marcar como concluído algo que não tenha sido realmente testado.
10. CONFERÊNCIA FINAL

Antes de finalizar, faça uma revisão completa:

A arquitetura está organizada em quatro camadas?
As regras de negócio estão exclusivamente na Service?
O Controller não acessa diretamente o Repository?
Todos os endpoints funcionam?
Todos os status HTTP estão corretos?
Todas as regras de negócio foram implementadas?
O banco H2 está funcionando?
O projeto inicia corretamente?
O README.md está preenchido?
O PROMPTS.md registra o processo?
O roteiro de conferência foi preenchido?

A entrega final deve ser um arquivo .zip contendo:

A pasta Escola-base, sem a pasta target;
O README.md preenchido com os nomes dos integrantes;
O roteiro de conferência preenchido;
O PROMPTS.md preenchido.
REGRA MAIS IMPORTANTE

Seja meu assistente durante toda a prova. Priorize código simples, correto, organizado e compatível com o projeto inicial.

Não pule etapas, não invente requisitos e não esconda erros.

Quando encontrar um problema, explique a causa e apresente a correção.

Quando terminar cada etapa, aguarde minha confirmação antes de avançar para a próxima.

O objetivo é entregar uma API funcional e demonstrar que compreendemos o processo de desenvolvimento.

**O que a IA devolveu (uma ou duas linhas):**

**O que fizemos com a resposta:** ( ) usamos como veio  (/) alteramos  ( ) descartamos

**Por quê (o que conferimos, o que mudamos):**
Instruimos ele a fazer o sistema corretamente, conversando com ele.


(continuem com quantos blocos precisarem)

## Como conferimos

Descrevam como vocês testaram o que ficou pronto. Colem aqui a saída do programa (POO) ou o resultado do roteiro (API) e digam se bateu com a tabela da prova. Se não bateu, digam o que fizeram.

instalamos o java e rodamos o projeto

## Onde a IA errou, ou onde nós erramos

Contem pelo menos um erro que apareceu durante a prova: o que era, como perceberam e como resolveram. Se não apareceu nenhum, expliquem como vocês têm certeza disso.

Esquecemos de logar a conta no chatgpt e por isso perdemos o historico de mensagens, para resolvermos isso copiamos tudas as mensagens e mandamos em um documento para o professor
## Respostas finais, sem consultar a IA

Respondam com as suas palavras, nos últimos 5 minutos. Não copiem de lugar nenhum.

**Pergunta 1:**
 Quando chega um pedido,o controller recebe uma  requisição, a Service verifica se a sala existe e tambem se esta livre, o repository busca e salva os dados no banco, e o model representa a sala e seu estado de reserva.


**Pergunta 2:**
A regra fica na Service porque ela é responsável pelas regras de negócio. O controller deve apenas receber as requisições e retornar.


**Pergunta 3:**
 Se trocar o banco H2 por outro, principalmente as configurações de conexão e as dependências precisarão mudar. As demais camadas geralmente permanecem iguais.