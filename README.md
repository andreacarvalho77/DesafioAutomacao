# DesafioAutomacao
Desafio de Automação de QA

# Proposta
API JSONPlaceholder
 A JsonPlaceholder é uma API REST falsa online para testes e prototipagem:
 https://jsonplaceholder.typicode.com/
 
 Para este desafio, vamos utilizar apenas o recurso /posts, que mantém uma lista de 100  postagens. Você pode obter a lista das postagens atuais usando o método GET e pode
 adicionar uma nova postagem usando o método POST. A URL do recurso /posts é a  seguinte:  http://jsonplaceholder.typicode.com/posts
 
 # Desafio API
 Por favor, implemente as seguintes tarefas usando o recurso /posts da API JsonPlaceholder:
 
 1. Teste de API com Rest Assured:
 ○ Crieumcenário de teste para validar o código de resposta e o corpo da resposta da API /posts utilizando a biblioteca Rest Assured. O teste deve incluir verificações básicas, como a validação do status HTTP e a
 comparação de dados no corpo da resposta.

 Demo automation Testing- Web  https://demo.automationtesting.in/Index.html
 
 Definir o plano de testes para os cenários possíveis de cadastros e na sua visão de produto, qual seria o mais importante ser automatizado e realizar sua implementação.
 Para esse desafio, realizar o login com email, efetuar um novo cadastro realizando as validações necessárias onde possa garantir o seu cenário de teste.
 
 # 2. Teste Web usando Selenium:

○ Crieumcenário de teste que abra um navegador, acesse o site de sua escolha, e valide algum comportamento da interface de usuário, como verificar a presença de um botão ou um campo de formulário.

 App Strada Log https://play.google.com/store/apps/details?id=net.nuvem.mobile.carguero.release&hl =pt_BR
 
 Nesse desafio, realizar dentro do App Strada Log onde deve chegar até o envio do SMSpara seu celular.
 
# 3. Teste Mobile Android usando Appium:

○ Crie um cenário de teste que automatize a abertura de um aplicativo Android (pode ser um app de sua escolha ou um app básico), interaja com um elemento da interface (como clicar em um botão ou preencher um campo de
 texto) e valide um resultado esperado.
 
 # Teste de Desempenho
 
 https://reqres.in/
 
 O Reqres é uma API gratuita excelente para praticar automação e testes de desempenho

 
 Objetivo
 O objetivo deste desafio é avaliar o desempenho da API Reqres sob diferentes cenários de carga, estresse e volume. Você realizará testes nos endpoints de criação, consulta e deleção de usuários. A meta é identificar o comportamento da API sob pressão e analisar métricas de desempenho.
 
 Endpoints
 
 ● GET/api/users?page=2: Retorna uma lista de usuários.
 
 ● POST/api/users: Cria um novo usuário.
 
 ● DELETE/api/users/2: Deleta um usuário.
 
Desafios
 1. Teste de Carga:
 ○ Cenário: Simule 100 usuários simultâneos fazendo requisições ao endpoint de GET /api/users?page=2.

 ○ Objetivo: Meça o tempo médio de resposta, throughput e a taxa de erro.
 
 ○ Critério de Sucesso: O tempo médio de resposta deve permanecer abaixo de 2 segundos para 95% das requisições, com uma taxa de erro inferior a 1%.

 3. Teste de Estresse:
 ○ Cenário: Inicie com 10 usuários simultâneos e aumente gradualmente até 500 usuários no endpoint de GET /api/users?page=2.

 ○ Objetivo: Identifique o ponto em que o tempo de resposta começa a se deteriorar ou ocorrem erros frequentes.
 
 ○ Critério de Sucesso: A API deve suportar até 300 usuários simultâneos com umtempo de resposta abaixo de 3 segundos e taxa de erro inferior a 5%. Ferramenta Utilizada
 
 ● JMeter: Para criar e executar cenários de teste de carga, estresse e volume. Ele permite configurar requisições simultâneas e analisar métricas de desempenho.

 Entrega
 1. Relatórios de Desempenho:
    
 ○ Envie os relatórios de desempenho gerados pelos testes, incluindo gráficos e métricas relevantes (tempo de resposta, throughput, taxa de erro, etc.).

 2. Análise dos Resultados:
    
 ○ Inclua uma análise dos resultados, identificando possíveis gargalos ou problemas de desempenho encontrados.
 
 ○ Sugira possíveis melhorias para a API, se aplicável.

 3. Configuração do Teste:
    
 ○ Forneça detalhes sobre como os testes foram configurados, incluindo número de usuários, duração dos testes, e parâmetros de requisição.

 
