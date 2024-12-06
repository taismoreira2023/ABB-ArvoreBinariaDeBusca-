<!DOCTYPE html>
<html>
<body>
    <h1>beecrowd | 1200</h1>
    <h2>Operações em ABP I</h2>
    <p><strong>Por:</strong> Neilor Tonin, URI Brasil</p>
    <p><strong>Timelimit:</strong> 1</p>

  <p>Marcela recebeu como trabalho de Algoritmos a tarefa de fazer um programa que implemente uma Árvore Binária de Pesquisa (ou Busca). O Programa deve aceitar os seguintes comandos:</p>
    <ul>
        <li><code>I n</code>: Insere na árvore binária de pesquisa o elemento <code>n</code>.</li>
        <li><code>INFIXA</code>: Lista os elementos já cadastrados segundo o percurso infixo.</li>
        <li><code>PREFIXA</code>: Lista os elementos já cadastrados segundo o percurso prefixo.</li>
        <li><code>POSFIXA</code>: Lista os elementos já cadastrados segundo o percurso posfixo.</li>
        <li><code>P n</code>: Pesquisa se o elemento <code>n</code> existe ou não.</li>
    </ul>
    <p>A qualquer momento, pode-se inserir um elemento, visitar os elementos previamente inseridos na ordem infixa, prefixa ou posfixa, ou ainda procurar por um elemento na árvore para saber se o elemento existe ou não.</p>

  <h3>Entrada</h3>
  <p>A entrada contém <code>N</code> operações utilizando letras (<code>A-Z</code>, <code>a-z</code>) sobre uma árvore binária de Busca, que inicialmente se encontra vazia. A primeira linha de entrada contém a inserção de algum elemento. As demais linhas de entrada podem conter quaisquer um dos comandos descritos acima, conforme exemplo abaixo. O final da entrada é determinado pelo final de arquivo (<code>EOF</code>).</p>
    <p><strong>Obs:</strong> Considere que não serão inseridos elementos repetidos na árvore.</p>

  <h3>Saída</h3>
  <p>Cada linha de entrada, com exceção das linhas que contém o comando <code>"I"</code>, deve produzir uma linha de saída. A saída deve ser de acordo com o exemplo fornecido abaixo. Não deve haver espaço em branco após o último caractere de cada linha, caso contrário, sua submissão receberá <strong>Presentation Error</strong>.</p>

  <h3>Exemplo de Entrada</h3>
  <pre>
I c
I f
I a
I h
INFIXA
PREFIXA
POSFIXA
P z
P h
I g
INFIXA
    </pre>

  <h3>Exemplo de Saída</h3>
  <pre>
a c f h
c a f h
a h f c
z nao existe
h existe
a c f g h
    </pre>
</body>
</html>
