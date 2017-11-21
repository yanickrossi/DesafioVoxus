# DesafioVoxus
projeto de aplicação web mini crud

Aqui fiz o upload do desafio proposto pela Voxus.

Não realizei todas as funcionalidades pois tenho outras tarefas para fazer paralelamente(prova e trabalho da faculdade, fim de semestre e tudo mais..)



Do que foi pedido, consegui implementar o CRUD de tarefas, coloquei o botão para fazer login com o Google+ mas não consegui captar as informações do usuário como email, a imagem do perfil etc, então criei um cadastro de usuário capturando o nome, sobrenome, email e senha, sendo email a chave para login e a primary key na tabela de autenticação.
Depois de Cadastrar ou realizar o login, o usuário é redirecionado para a página de manipulação de tarefas, onde está implementado as funções de Inserir, Editar, Deletar e Buscar Tarefas. Cada tarefa tem um Nome, uma Descrição, uma prioridade e um usuário responsável.
Realizei vários tratamentos de erros para evitar que o programa caia em alguma exception, utilizando try catchs, validações com ifs + pagina de Erro com mensagem de erro. Vai existir casos que haverão exceção. 

Subi todos os arquivos  .JSP e .java do meu projeto para o Github. A aplicação está rodando localmente no localhost e escolhi java por ter mais contato com a linguagem de programação.
Utilizei o MySQL como banco de dados e criei com clicks as duas tabelas, não fiz "create table tarefa..." etc Acabei de perceber isso.
Basicamente as tabelas são as seguintes:
CREATE TABLE tarefa (
    nome varchar(255) Primary Key,
    descricao TEXT,
    prioridade int,
    usuario varchar (255)
);

CREATE TABLE validacao (
    email varchar(255) Primary Key,
    senha varchar(255)
);


Comentei o código de uma maneira mais MACRO.

Para desenvolver, utilizei aproximadamente 16 horas. Deixo claro que fazia aproximadamente um ano que não programava em java, e que nunca tinha feito sozinho uma aplicação web desta maneira. Utilizei como material de apoio os cursos que seguem
https://www.youtube.com/watch?v=gJ-hAtqqIIM (aula 1 parte 1 e 2, aula 2  e aula 6)
https://www.youtube.com/watch?v=VKPLb2LSHOs&t=1s (bem pouco)
Nunca tinha usado o MySQL, somente havia tido experiências com o PostgreSQL, então instalei o MySQL e utilizei. Vale dizer qque 95% das vezes que programei, o fiz no Linux(Ubuntu) e dessa vez fiz no Windows 10 utilizando a IDE do NetBeans.
Realizei poucos testes e é importante modificar(se preciso) o usuário e a senha para realizar a conexão com o banco de dados no arquivo ConnectionFactory.java. O banco que criei chama-se "voxus"
Não fiz a parte de anexar arquivos às tarefas nem de integrar com o servidor AWS, mas tenho certeza que conseguiria fazer, já que meu ultimo trabalho foi exatamente com esse assunto, pode ser visto aqui no Git mesmo: https://github.com/yanickrossi/sharebox/blob/master/shareBox.java
Esse trabalho eu fiz no Ubuntu porém já não tenho mais a credencial, porque veio uma cobrança de 60 dólares no cartão de crédito no começo do ano, e então eu cancelei tudo que tinha com a AWS após estornarem o valor.
Sobre o Elastic Search, eu nunca tinha ouvido sobre.


Considerações finais:
Apesar de estar com bastante coisas para fazer e não saber o que vai rolar com esse processo seletivo, que por sinal foi o primeiro que realmente tive que implementar algo desse estilo, eu achei bem legal e desafiador. Consegui um resultado que pra mim mesmo foi satisfatório, mais por ter conseguido estudar e aprender focadamente por hora seguidas ininterruptas(8 sábado e 8 domingo aproximadamente), e fazer essas maratonas de programação é algo que eu gosto, quando há um progresso como teve nesse desafio.

É basicamente isso, espero que gostem.

Atenciosamente.: Yanick Olveira Rossi


