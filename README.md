# Navegação/Navigation

|[Português](#português)|[English](#english)|
|:-|:-|
|[Visão Geral](#visão-geral)|[Overview](#overview)|
|[Algoritmos](#algoritmos)|[Algorithms](#algorithms)|
|[Linear Search](#linearsearch)||
|[Binary Search](#binarysearch)||

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

### Procura (Search)

No arquivo [Searching.java](./src/main/java/com/eduardo/Searching.java) temos 3 métodos referentes a algorimos de procura, onde 2 são referentes a **Binary Search** enquanto o outro faz referência à **Linear Search**. Abaixo estão as características dos métodos:

```.java
public static int linearSearch(int[] nums, int target)
public static int binarySort(int[] nums, int target)
public static int binarySortRecursive(int[] nums, int target, int left, int right)
```

### LinearSearch

```.java
public static int linearSearch(int[] nums, int target)
```

O algoritmo **Linear Search** passa por cada um dos itens de uma array com o objetivo de encontrar o valor *target*, o que estamos procurando. Ele retornará o index desse valor na array caso o valor estiver presente na array, e retornará -1 caso o valor que estamos procurando não esteja presente dentro da array.

Importante dizer que no código existe uma variável **step**, onde ela conta a quantidade de iterações para encontrar o *target*.

A complexidade desse método é O(n)

### BinarySearch

```.java
public static int binarySort(int[] nums, int target)
public static int binarySortRecursive(int[] nums, int target, int left, int right)
```

O algoritmo **Binary Search** procura um valor *target* em uma **lista já organizada**, esse algoritmo funciona da seguinte forma, ele utiliza de ponteiros para delimitar a região de procura, tornando ela cada vez menor até encontrá-la. A princípio ele encontra o índice do meio, que estamos chamando de **mid**, com base nos ponteiros que atualmente estão no começo e no final da array, e verifica se o valor que estamos procurando é maior ou menor que o valor do índice **mid**, caso seja maior, o ponteiro da esquerda move **mid + 1**. Caso o valor seja menor que o valor de **mid** o ponteiro da direita move **mid - 1**. Depois da primeira alteração dos ponteiros, é encontrado novamente o meio e o processo se repete até encontrar o valor. Quando o valor é encontrado é retornado o índice dele na array, caso não seja encontrado, retorna -1.

Novamente, temos a variável step marcando a quantidade de iterações até que seja encontrado o *target*.

Existe também o método BinarySearchRecursive, onde, ao invés de iterações temos recurções, mas na sua base os métodos funcionam da mesma forma.

A complexidade desse método é O(log2 n)

### Organização (Sort)

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

### BubbleSort

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
