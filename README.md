# Navegação/Navigation

|[Português](#português)|[English](#english)|[Português](#português)|[English](#english)|
|:-|:-|:-|:-|
|[Visão Geral](#visão-geral)|[Overview](#overview)|[InsertionSort](#insertionsort-pt)||
|[Algoritmos](#algoritmos)|[Algorithms](#algorithms)|||
|[Procura](#procura/Search)||||
|[Linear Search](#linearsearch-pt)||||
|[Binary Search](#binarysearch-pt)||||
|[Organização](#organização-(sort))||||
|[BubbleSort](#bubblesort-pt)||||
|[SelectionSort](#selectionsort-pt)||||


# Português

## Visão Geral

O objetivo desse projeto foi entender e praticar o uso de **estruturas de dados** e **algoritmos**, aqui eu utilizo diferentes estruturas de dados e **algoritmos de organização e procura**.

Por mais que a organização dos diretórios não seja a melhor, eu pelo menos tentei deixar o mais intuitivo possível.

Os algoritmos se encontram em:
- [Searching](./src/main/java/com/eduardo/Searching.java)
- [Sorting](./src/main/java/com/eduardo/Sorting.java)

Enquanto as estruturas de dados se encontram em:
- [Estruturas de dados](./src/main/java/com/eduardo/dataStructures/)
  - [Stack](./src/main/java/com/eduardo/dataStructures/Stack.java)
  - [Static Stack](./src/main/java/com/eduardo/dataStructures/StaticStack.java)
  - [Dynamic Stack](./src/main/java/com/eduardo/dataStructures/DynamicStack.java)
  - [Linked List](./src/main/java/com/eduardo/dataStructures/LinkedList.java)
  - [Queue](./src/main/java/com/eduardo/dataStructures/Queue.java)
  - [Binary Tree](./src/main/java/com/eduardo/dataStructures/BinaryTree.java)

## Algoritmos

### Procura/Search

No arquivo [Searching.java](./src/main/java/com/eduardo/Searching.java) temos 3 métodos referentes a algorimos de procura, onde 2 são referentes a **Binary Search** enquanto o outro faz referência à **Linear Search**. Abaixo estão as características dos métodos:

```.java
public static int linearSearch(int[] nums, int target)
public static int binarySort(int[] nums, int target)
public static int binarySortRecursive(int[] nums, int target, int left, int right)
```

### LinearSearch pt

```.java
public static int linearSearch(int[] nums, int target)
```

O algoritmo **Linear Search** passa por cada um dos itens de uma array com o objetivo de encontrar o valor *target*, o que estamos procurando. Ele retornará o index desse valor na array caso o valor estiver presente na array, e retornará -1 caso o valor que estamos procurando não esteja presente dentro da array.

Importante dizer que no código existe uma variável **step**, onde ela conta a quantidade de iterações para encontrar o *target*.

A complexidade temporal desse método é O(n)

### BinarySearch (português)

```.java
public static int binarySort(int[] nums, int target)
public static int binarySortRecursive(int[] nums, int target, int left, int right)
```

O algoritmo **Binary Search** procura um valor *target* em uma **lista já organizada**, esse algoritmo funciona da seguinte forma, ele utiliza de ponteiros para delimitar a região de procura, tornando ela cada vez menor até encontrá-la. A princípio ele encontra o índice do meio, que estamos chamando de **mid**, com base nos ponteiros que atualmente estão no começo e no final da array, e verifica se o valor que estamos procurando é maior ou menor que o valor do índice **mid**, caso seja maior, o ponteiro da esquerda move **mid + 1**. Caso o valor seja menor que o valor de **mid** o ponteiro da direita move **mid - 1**. Depois da primeira alteração dos ponteiros, é encontrado novamente o meio e o processo se repete até encontrar o valor. Quando o valor é encontrado é retornado o índice dele na array, caso não seja encontrado, retorna -1.

Novamente, temos a variável step marcando a quantidade de iterações até que seja encontrado o *target*.

Existe também o método BinarySearchRecursive, onde, ao invés de iterações temos recurções, mas na sua base os métodos funcionam da mesma forma.

A complexidade temporal desse método é O(log2 n)

### Organização/Sort

No arquivo [Sorting.java](./src/main/java/com/eduardo/Sorting.java) estão reunidos 5 métodos de organização diferentes, dentre eles: **BubbleSort**, **SelectionSort**, **InsertSort**, **QuickSort** e **MergeSort**. Abaixo estão as características de cada método.

```.java
public static void bubbleSort(int[] nums)
public static void selectionSort(int[] nums)
public static void insertionSort(int[] nums)

public static void quickSort(int[] nums, int low, int high)
private static int partition(int[] nums, int low, int high)

public static void mergeSort(int[] nums, int left, int right)
private static void merge(int[] nums, int left, int mid, int right)
```

### BubbleSort pt

```.java
public static void bubbleSort(int[] nums)
```

O algoritmo **Bubble Sort** é um dos mais simples de se executar, a forma que ele funciona consiste em 2 loops, o primeiro tem o objetivo de passar pela array pela mesma quantidade de valores que ela possui, conferindo assim, que ela não esteja organizada pela metade. Já o segundo loop é onde é realizada as comparações que vão organizar a array. A princípio esse algoritmo compara os valores **índice** e **índice+1**, caso o valor de **índice** seja maior que seu sucessor, os valores trocam, caso não seja nada acontece. Isso ocorre até a última iteração do segundo loop, onde é comparado os valores do penúltimo e último índices, e ao fim da primeira iteração do primeiro loop, o último item será sempre o maior. Esse processo de colocar o maior número da parte não organizada da lista ao final se repete até a lista estar completamente organizada.

A complexidade temporal desse método é O(n²)

### SelectionSort pt

```.java
public static void selectionSort(int[] nums)
```

O algoritmo **Selection Sort** também consiste em 2 loops, onde o primeiro tem o mesmo objetivo do **Bubble Sort**, que é de percorrer a array pela mesma quantidade de itens que ela possui, enquanto o segundo é onde são feitas as comparações para organizar. Fundamentalmente, esse algoritmo tem a função de identificar o maior número na array referente a parte não organizada, e colocar esse número na última posição não organizada, a forma que é feita é *selecionando* um index referente ao maior valor e comparando com cada valor da lista, caso algum valor seja maior, o index *selecionado* é trocado pelo index do valor maior, e depois de passar por toda a parte não organizada insere o valor do índice selecionado ao final.

A complexidade temporal desse método é O(n²)

### InsertionSort pt

```.java
public static void insertionSort(int[] nums)
```

O algoritmo **Insertion Sort** também consiste em 2 loops como os anteriores, o primeiro loop serve para percorrer a array e também para *selecionar* o valor a ser *inserido*. E então, no segundo loop, ele percorre a array de trás pra frente desde o índice do valor selecionado até encontrar um valor menor que o valor selecionado e inseri-lo 1 índice a mais que o valor menor que ele. Uma coisa interessante sobre esse algoritmo é que ele não precisa percorrer toda a array de novo para conseguir organizar caso um novo valor entre no final, ele seleciona o valor final (que não faz parte da parcela da array que está já organizada) e *insere* ele 1 posição após o número que seja menor que ele.

A complexidade temporal desse método é O(n²), mas no melhor dos casos (caso a lista aleatoriamente seja criada em ordem crescente) pode chegar à O(n).

# English

## Overview

My goal with this project was to understand and practice using **data structures** and **algorithms**, here I utilize different data structures, **searching and sorting algorithms**.

Although the project's directory organization isn't the best, I at least tried to make it the most intuitive as possible.

Here you can find the algorithms:
- [Searching](./src/main/java/com/eduardo/Searching.java)
- [Sorting](./src/main/java/com/eduardo/Sorting.java)

Here you can find the data structures:
- [Estruturas de dados](./src/main/java/com/eduardo/dataStructures/)
  - [Stack](./src/main/java/com/eduardo/dataStructures/Stack.java)
  - [Static Stack](./src/main/java/com/eduardo/dataStructures/StaticStack.java)
  - [Dynamic Stack](./src/main/java/com/eduardo/dataStructures/DynamicStack.java)
  - [Linked List](./src/main/java/com/eduardo/dataStructures/LinkedList.java)
  - [Queue](./src/main/java/com/eduardo/dataStructures/Queue.java)
  - [Binary Tree](./src/main/java/com/eduardo/dataStructures/BinaryTree.java)

## Algorithms
