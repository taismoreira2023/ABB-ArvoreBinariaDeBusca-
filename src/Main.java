import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        class ArvoreBinariaBusca<T extends Comparable<T>> {

            class Nodo {

                public T elemento;
                public Nodo esquerdo;
                public Nodo direito;

                public Nodo(T elemento) {
                    this.elemento = elemento;
                    this.esquerdo = null;
                    this.direito = null;
                }
            }

            public Nodo raiz;
            public int nElementos;

            public ArvoreBinariaBusca() {
                this.raiz = null;
                this.nElementos = 0;
            }

            public int tamanho() {
                return this.nElementos;
            }

            public boolean estaVazia() {
                return this.raiz == null;
            }

            //A lógica da impressão é Imprimir espaço antes do elemento, com excessão do primeiro
            public void imprimePreOrdem() {
                this.preOrdem(this.raiz, true);
                System.out.println();
            }

            public void imprimePosOrdem() {
                this.posOrdem(this.raiz, true);
                System.out.println();
            }

            public void imprimeEmOrdem() {
                this.emOrdem(this.raiz, true);
                System.out.println(); // Para garantir que a linha termina com uma nova linha
            }


            public void preOrdem(Nodo nodo, boolean primeiraLetra) {
                if (nodo == null)
                    return;

                if (!primeiraLetra) System.out.print(" ");
                System.out.print(nodo.elemento);
                this.preOrdem(nodo.esquerdo, false);
                this.preOrdem(nodo.direito, false);
            }

            public void posOrdem(Nodo nodo, boolean primeiraLetra) {
                if (nodo == null)
                    return;

                this.posOrdem(nodo.esquerdo, false);
                this.posOrdem(nodo.direito, false);
                if (!primeiraLetra) System.out.print(" ");
                System.out.print(nodo.elemento);
            }

            public void emOrdem(Nodo nodo, boolean primeiraLetra) {
                if (nodo == null) return;

                this.emOrdem(nodo.esquerdo, false);
                if (!primeiraLetra) System.out.print(" ");
                System.out.print(nodo.elemento);
                this.emOrdem(nodo.direito, false);
            }


            public void insere(T elemento) {
                this.insere(elemento, this.raiz);
            }

            public void insere(T elemento, Nodo nodo) {
                Nodo novo = new Nodo(elemento);

                if (nodo == null) {
                    this.raiz = novo;
                    this.nElementos++;
                    return;
                }

                if (elemento.compareTo(nodo.elemento) < 0) {
                    if (nodo.esquerdo == null) {
                        nodo.esquerdo = novo;
                        this.nElementos++;
                        return;
                    } else {
                        this.insere(elemento, nodo.esquerdo);
                    }
                }

                if (elemento.compareTo(nodo.elemento) > 0) {
                    if (nodo.direito == null) {
                        nodo.direito = novo;
                        this.nElementos++;
                        return;
                    } else {
                        this.insere(elemento, nodo.direito);
                    }
                }
            }

            private Nodo maiorElemento(Nodo nodo) {
                while (nodo.direito != null) {
                    nodo = nodo.direito;
                }
                return nodo;
            }

            private Nodo menorElemento(Nodo nodo) {
                while (nodo.esquerdo != null) {
                    nodo = nodo.esquerdo;
                }
                return nodo;
            }

            public boolean remove(T elemento) {
                return this.remove(elemento, this.raiz) != null;
            }

            private Nodo remove(T elemento, Nodo nodo) {
                if (nodo == null) {
                    System.out.println("Valor não encontrado");
                    return null;
                }

                if (elemento.compareTo(nodo.elemento) < 0) {
                    nodo.esquerdo = this.remove(elemento, nodo.esquerdo);
                } else if (elemento.compareTo(nodo.elemento) > 0) {
                    nodo.direito = this.remove(elemento, nodo.direito);
                } else {
                    if (nodo.esquerdo == null) {
                        this.nElementos--;
                        return nodo.direito;
                    } else if (nodo.direito == null) {
                        this.nElementos--;
                        return nodo.esquerdo;
                    } else {
                        Nodo substituto = this.menorElemento(nodo.direito);
                        nodo.elemento = substituto.elemento;
                        this.remove(substituto.elemento, nodo.direito);
                    }
                }

                return nodo;
            }

            public boolean busca(T elemento) {
                return this.busca(elemento, this.raiz);
            }

            public boolean busca(T elemento, Nodo nodo) {
                if (nodo == null) {
                    return false;
                }

                if (elemento.compareTo(nodo.elemento) < 0) {
                    return this.busca(elemento, nodo.esquerdo);
                } else if (elemento.compareTo(nodo.elemento) > 0) {
                    return this.busca(elemento, nodo.direito);
                } else {
                    return true;
                }
            }

            private int altura(Nodo nodo) {
                if (nodo == null) {
                    return -1;
                }

                int alturaEsquerda = this.altura(nodo.esquerdo) + 1;
                int alturaDireita = this.altura(nodo.direito) + 1;

                int altura = alturaEsquerda > alturaDireita ? alturaEsquerda : alturaDireita;

                return altura;
            }

            public int altura() {
                return this.altura(this.raiz);
            }
        }


        // Prefixa: Visitar a raiz, sub-árvore esquerda e sub-árvore direita
        // Infixa: Visitar a sub-árvore esquerda, a raiz e a sub-árvore direita
        // Posfixa: Visitar a sub-árvore esquerda, a sub-árvore direita e a raiz

        Scanner s = new Scanner(System.in);

        ArvoreBinariaBusca<String> abb = new ArvoreBinariaBusca<>();

        while (s.hasNext()) {
            String n = s.next();
            if (n.equals("I")) {
                String elemento = s.next();
                abb.insere(elemento);
            } else if (n.equals("INFIXA")) {
                abb.imprimeEmOrdem();
            } else if (n.equals("PREFIXA")) {
                abb.imprimePreOrdem();
            } else if (n.equals("POSFIXA")) {
                abb.imprimePosOrdem();
            } else if (n.equals("P")) {
                String letra = s.next();
                if (abb.busca(letra)){
                    System.out.println(letra + " existe");
                }else{
                    System.out.println(letra + " nao existe");
                }
            }
        }
    }
}
