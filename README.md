# Navegação/Navigation

|[Português](#portugues)|[English](#english)|[Português](#português)|[English](#english)|[Português](#português)|[English](#english)|
|:-|:-|:-|:-|:-|:-|
|[Visão Geral](#visao-geral)|[Overview](#overview)|[Algoritmos de Organização](#organizacao)||[Estruturas de Dados](#estruturas-de-dados)||
|[Algoritmos de Procura](#procura)|[Algorithms](#algorithms)|[BubbleSort](#bubblesort-pt)||[Stack](#stack-pt)||
|[Linear Search](#linearsearch-pt)||[SelectionSort](#selectionsort-pt)||[Static Stack](#static-stack-pt)||
|[Binary Search](#binarysearch-pt)||[InsertionSort](#insertionsort-pt)||[Dynamic Stack](#dynamic-stack-pt)||
|||[QuickSort](#quicksort-pt)||[Linked List](#linked-list-pt)||
|||[MergeSort](#mergesort-pt)||[Queue](#queue-pt)||
|||||[Binary Tree](#binary-tree-pt)||

<a id="portugues"></a>
# Português
<a id="visao-geral"></a>
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

<a id="procura"></a>
### Algoritmos de Procura/Search

No arquivo [Searching.java](./src/main/java/com/eduardo/Searching.java) temos 3 métodos referentes a algorimos de procura, onde 2 são referentes a **Binary Search** enquanto o outro faz referência à **Linear Search**. Abaixo estão as características dos métodos:

```.java
public static int linearSearch(int[] nums, int target)
public static int binarySort(int[] nums, int target)
public static int binarySortRecursive(int[] nums, int target, int left, int right)
//Acabei de perceber que esse último método está como "sort", não como search que é o que deveria estar escrito, mas pelo motivo de no arquivo original estar da mesma forma eu deixarei assim
```
<a id="linearsearch-pt"></a>
### LinearSearch

```.java
public static int linearSearch(int[] nums, int target){
  int step = 0;
  for (int i = 0; i < nums.length; i++) {
    step++;
    if (nums[i] == target) {
      System.out.println("Amount of operations: " + step);
      return i;
    }
  }
  System.out.println("Amount of operations: " + step);
  return -1;
}
```

O algoritmo de **busca linear** percorre sequencialmente cada elemento de uma estrutura de dados (como um array ou lista), comparando um a um com o valor desejado. Ele é simples e funciona para qualquer tipo de dado, ordenado ou não, mas pode ser ineficiente em listas grandes.

Importante dizer que no código existe uma variável **step**, onde ela conta a quantidade de iterações para encontrar o *target*.

A complexidade temporal desse método é O(n)

<a id="binarysearch-pt"></a>
### BinarySearch

```.java
public static int binarySort(int[] nums, int target) {
  int left = 0;
  int right = nums.length -1;
  int step = 0;

  while (left <= right) {
    step++;
    int mid = (left + right) / 2;

    if (nums[mid] == target) {
      System.out.println("Amount of operations: " + step);
      return mid;
    } else if (target > nums[mid])
      left = mid+1;
    else
      right = mid-1;


  }
  System.out.println("Amount of operations: " + step);
  return -1;
}

public static int binarySortRecursive(int[] nums, int target, int left, int right) {
  if (left <= right) {
    int mid = (left + right) /2;

    if (nums[mid] == target)
      return mid;
    else if (target > nums[mid])
      return binarySortRecursive(nums, target, mid+1, right);
    else
      return binarySortRecursive(nums, target, left, mid-1);
  }
  return -1;
}
```

Busca binária é um algoritmo eficiente para encontrar elementos em listas ordenadas. A ideia é dividir o array ao meio a cada iteração, descartando metade do espaço de busca. Isso o torna muito mais rápido que a busca linear para grandes volumes de dados.

Novamente, temos a variável step marcando a quantidade de iterações até que seja encontrado o *target*.

Existe também o método BinarySearchRecursive, onde, ao invés de iterações temos recurções, mas na sua base os métodos funcionam da mesma forma.

A complexidade temporal desse método é O(log2 n)

<a id="organizacao"></a>
### Algoritmos de Organização/Sort

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
<a id="bubblesort-pt"></a>
### BubbleSort

```.java
public static void bubbleSort(int[] nums) {
  int size = nums.length;

  for (int i = 0; i < size; i++) {
    for (int j = 0; j < size-1-i; j++) {
      if (nums[j] > nums[j+1]) {
        int temp = nums[j];
        nums[j] = nums[j+1];
        nums[j+1] = temp;
      }
    }
  }
}
```

O algoritmo percorre o array diversas vezes, comparando pares de elementos adjacentes e trocando-os se estiverem fora de ordem. O processo se repete até que nenhuma troca seja necessária. É um dos algoritmos mais simples, mas também um dos menos eficientes.

A complexidade temporal desse método é O(n²)

<a id="selectionsort-pt"></a>
### SelectionSort

```.java
public static void selectionSort(int[] nums) {
  final int size = nums.length;
  int index = 0;
  int temp = 0;

  for (int i = 0; i < size-1; i++) {
    for (int j = 0; j < size-i; j++) {
      if (nums[j] > nums[index])
        index = j;
    }

    temp = nums[size-1-i];
    nums[size-1-i] = nums[index];
    nums[index] = temp;
    index = 0;
  }
}
```

O **Selection Sort** encontra o último elemento da lista e o coloca na última posição, depois repete o processo com os elementos restantes não organizados. Embora seja mais eficiente que o Bubble Sort em certos casos, ainda é considerado ineficiente para grandes volumes de dados.

A complexidade temporal desse método é O(n²)

<a id="insertionsort-pt"></a>
### InsertionSort

```.java
public static void insertionSort(int[] nums) {
  final int size = nums.length;

  for (int i = 1; i < size; i++) {
    int value = nums[i];

    int j = i-1;
    while (j>=0 && nums[j] > value) {
      nums[j+1] = nums[j];
      j--;
    }
    nums[j+1] = value;
  }
}
```

O **Insertion Sort** constrói a lista ordenada gradualmente, inserindo cada novo elemento na posição correta em relação aos já ordenados. É bastante eficiente para listas pequenas ou parcialmente ordenadas.

A complexidade temporal desse método é O(n²), mas no melhor dos casos (caso a lista aleatoriamente seja criada em ordem crescente) pode chegar à O(n).

<a id="quicksort-pt"></a>
### QuickSort

```.java
public static void quickSort(int[] nums, int low, int high) {

  if (low < high) {
    int pi = partition(nums, low, high);

    quickSort(nums, low, pi -1);
    quickSort(nums, pi +1, high);
  }
}

private static int partition(int[] nums, int low, int high) {
  int pivot = nums[high];
  int i = low -1;

  for (int j = low; j < high; j++) {
    if (nums[j] < pivot) {
      i++;

      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }
  nums[high] = nums[i+1];
  nums[i+1] = pivot;

  return i+1;
}
```

Divide e conquista. O **Quick Sort** escolhe um elemento chamado "pivô" e o usa para dividir a lista em duas partes: uma com elementos menores e outra com maiores. Depois, ordena cada parte recursivamente. É muito eficiente na prática.

A complexidade temporal desse método é O(n • log2 n) na maioria dos casos, e O(n²) no pior dos casos (onde a array ocasionalmente já esteja organizada).

<a id="mergesort-pt"></a>
### MergeSort

```.java
public static void mergeSort(int[] nums, int left, int right) {
  int mid = (left + right) /2;

  if (left < right){
    mergeSort(nums, left, mid);
    mergeSort(nums, mid +1, right);
    merge(nums, left, mid, right);
  }
}

private static void merge(int[] nums, int left, int mid, int right) {
  int[] leftArr = new int[mid - left +1];
  int[] rightArr = new int[right - mid];

  for (int i = 0; i < leftArr.length; i++)
    leftArr[i] = nums[left+i];

  for (int i = 0; i < rightArr.length; i++)
    rightArr[i] = nums[mid+1+i];

  int i = 0;
  int j = 0;
  int k = left;

  while (i < leftArr.length && j < rightArr.length) {

    if (leftArr[i] <= rightArr[j]) {
      nums[k] = leftArr[i];
      i++;
    } else {
      nums[k] = rightArr[j];
      j++;
    }

    k++;
  }

  while (i<leftArr.length) {
    nums[k] = leftArr[i];
    i++;
    k++;
  }

  while (j<rightArr.length) {
    nums[k] = rightArr[j];
    j++;
    k++;
  }
}
```

Outro algoritmo baseado em dividir e conquistar. Ele divide a lista até restarem listas unitárias, e então começa a mesclá-las de forma ordenada. É estável, excelente desempenho mesmo em grandes volumes.

A complexidade temporal desse método é O(n • log2 n).
<a id="estruturas-de-dados"></a>
## Estruturas de Dados

No diretório [dataStructures](./src/main/java/com/eduardo/dataStructures) se encontram todas as classes de estruturas de dados, onde existem 8 classes diferentes, dentre elas existem 5 estruturas de dados, essas são: **Static Stack**, **Dynamic Stack**, **Linked List**, **Queue** e **Binary Tree**. Enquanto o restante das classes são complementares para essas estruturas.

<a id="stack-pt"></a>
### Stack

```.java
public abstract sealed class Stack<T> permits StaticStack, DynamicStack {
    protected int top = 0;
    protected Object[] stack;
    protected int currentSize = 0;
    public static final int DEFAULT_SIZE = 5;

    public Stack(int size) {
        if (size <= 0)
            this.stack = new Object[DEFAULT_SIZE];

        else
            this.stack = new Object[size];
    }

    public Stack() {
        this.stack = new Object[DEFAULT_SIZE];
    }

    public abstract void push(T t);

    public abstract T pop();

    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) this.stack[top];
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    @Override
    public String toString() {
        return "";
    }

    public void clear() {
        this.top = 0;
        this.currentSize = 0;

        Arrays.fill(this.stack, null);

    }

    public void show() {
        System.out.println(toList().toString());
    }

    //For test purposes
    @SuppressWarnings("unchecked")
    public List<T> toList() {
        return (List<T>) Arrays.stream(this.stack)
                .filter(Objects::nonNull)
                .toList();
    }

    public int getStackCapacity() {
        return this.stack.length;
    }

}
```

Superclasse de todos os tipos de stack no pacote.

<a id="static-stack-pt"></a>
### Static Stack

```.java
public non-sealed class StaticStack<T> extends Stack<T> {

    public StaticStack(int size) {
        super(size);
    }

    public StaticStack() {
        super();
    }

    @Override
    public void push(T t) {
        if (top+1 > stack.length)
            throw new ArrayIndexOutOfBoundsException("Current size:" + currentSize + " Capacity:" + stack.length);

        if (stack[top] != null)
            top++;

        stack[top] = t;
        currentSize++;

    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (currentSize -1 <= -1)
            throw new ArrayIndexOutOfBoundsException("Current size:" + currentSize);

        T lastTop = (T) stack[top];
        stack[top] = null;

        if (top -1 <= -1)
            top = 0;
        else
            top--;

        currentSize--;

        return lastTop;
    }

}
```

Pilha com tamanho fixo, baseada em um array. Suporta operações LIFO (Last In, First Out), como push (inserir) e pop (remover). Boa para quando o tamanho da pilha pode ser previamente conhecido.

<a id="dynamic-stack-pt"></a>
### Dynamic Stack

```.java
public non-sealed class DynamicStack<T> extends Stack<T> {

    public DynamicStack(int size) {
        super(size);
    }

    public DynamicStack() {
        super();
    }

    @Override
    public void push(T t) {
        if (top +1 >= stack.length)
            grow();

        if (stack[top] != null)
            top++;

        stack[top] = t;
        currentSize++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (currentSize -1 <= -1)
            throw new ArrayIndexOutOfBoundsException("Current size:" + currentSize);

        T lastTop = (T) stack[top];
        stack[top] = null;

        if (top <= stack.length /4)
            shrink();

        if (top -1 <= -1)
            top = 0;
        else
            top--;
        currentSize--;

        return lastTop;
    }

    //doubles the stack's capacity
    protected void grow() {
        Object[] newStack = new Object[stack.length *2];

        System.arraycopy(stack, 0, newStack, 0, stack.length);

        stack = newStack;
    }

    //halves the stack's capacity
    protected void shrink() {
        Object[] newStack = new Object[stack.length /2];

        if (top + 1 >= 0) System.arraycopy(stack, 0, newStack, 0, top + 1);

        stack = newStack;
    }

}
```

Pilha dinâmica baseada em lista encadeada. Não possui limite de tamanho pré-definido, sendo alocada conforme a necessidade. Também segue o padrão LIFO.

<a id="linked-list-pt"></a>
### Linked List

```.java
public class LinkedList<T> {
    private Node<T> head;
    private Integer size = 0;

    public LinkedList() {}

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (this.head == null)
            this.head = newNode;

        else {
            Node<T> lastNode = this.head;
            while (lastNode.next != null)
                lastNode = lastNode.next;

            lastNode.next = newNode;
        }

        this.size++;
    }

    public void add(int index, T value) {

        if (index <= 0)
            this.addFirst(value);

        else if (index >= this.size) {
            this.add(value);

        } else {
            Node<T> indexNode = new Node<>(value);

            Node<T> n = this.head;
            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            indexNode.next = n.next;
            n.next = indexNode;
            this.size++;
        }
    }

    public void addFirst(T value) {
        Node<T> temp = this.head;
        this.head = new Node<>(value);
        this.head.next = temp;
        this.size++;
    }

    public T get(int index) {
        if (this.head == null)
            return null;

        Node<T> n = this.head;

        if (index <= 0)
            return this.head.value;

        else if (index >= this.size) {
            while (n.next != null) {
                n = n.next;
            }
        } else {
            for (int i = 0; i < index; i++)
                n = n.next;
        }

        return n.value;
    }

    public void remove() {
        if (this.head == null)
            return ;

        Node<T> n = this.head;
        while (n.next.next != null)
            n = n.next;

        n.next = null;

        this.size--;
    }

    public void remove(int index) {

        if (this.head == null)
            return ;

        if (index <= 0)
            this.removeFirst();

        else if (index >= size)
            this.remove();

        else {
            Node<T> n = this.head;

            for (int i = 0; i < index-1; i++)
                n = n.next;

            n.next = n.next.next;

            this.size--;
        }
    }

    public void removeFirst() {

        if (this.head == null)
            return ;

        this.head = this.head.next;

        this.size--;
    }

    public void show() {
        if (this.head == null) {
            System.out.println("null");
            return ;
        }

        StringBuilder sb = new StringBuilder("[ ");

        Node<T> n = this.head;
        do {
            sb.append(n.value).append(" ");
            n = n.next;
        } while (n != null && n.next != null);

        if (n != null)
            sb.append(n.value).append(" ");

        sb.append("]");
        System.out.println(sb);
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        if (this.head == null)
            return null;

        return this.head.toString();
    }

}
```

Estrutura linear onde cada elemento (node) contém um valor e uma referência para o próximo. Permite inserções e remoções eficientes em qualquer posição da lista.

<a id="queue-pt"></a>
### Queue

```.java
public class Queue<T> {
    protected int end = 0;
    protected int start = 0;
    protected Object[] queue;
    protected int currentSize = 0;
    public static final int DEFAULT_SIZE = 5;

    public Queue() {
        this.queue = new Object[DEFAULT_SIZE];
    }

    public Queue(int size) {
        this.queue = new Object[size];
    }

    public void enqueue(T t) {
        if (currentSize +1 > getQueueCapacity())
            throw new ArrayIndexOutOfBoundsException("Capacity exceeded\ncurrent size: " + currentSize + "\ncapacity:" + getQueueCapacity());


        if (queue[end] == null)
            queue[end] = t;

        else
            queue[start] = t;

        start = (start+1) % getQueueCapacity();
        currentSize++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (currentSize -1 <= -1)
            throw new ArrayIndexOutOfBoundsException("index -1");

        T t = (T) queue[end];
        queue[end] = null;

        end = (end+1) % getQueueCapacity();
        currentSize--;

        return t;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) this.queue[end];
    }

    public void clear() {
        this.end = 0;
        this.currentSize = 0;

        Arrays.fill(queue, null);
    }

    public void show() {
        System.out.println(toList().toString());
    }

    @SuppressWarnings("unchecked")
    public List<T> toList() {
        List<T> l = new ArrayList<>();

        for (int i = 0; i < currentSize; i++) {
            l.add((T) queue[(end+i) % getQueueCapacity()]);
        }

        return l;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getQueueCapacity() {
        return this.queue.length;
    }

}
```

Estrutura de dados que segue o princípio FIFO (First In, First Out). Elementos são inseridos no final da fila e removidos do início. Ideal para processamento sequencial.

<a id="binary-tree-pt"></a>
### Binary Tree

```.java
public class BinaryTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BinaryTree() {}

    public void insert(T data) {
        root = insertRec(root, data);
    }

    private TreeNode<T> insertRec(TreeNode<T> newRoot, T data) {

        if (newRoot == null)
            newRoot = new TreeNode<>(data);

        else if (data.compareTo(newRoot.value) < 0)
            newRoot.left = insertRec(newRoot.left, data);

        else
            newRoot.right = insertRec(newRoot.right, data);

        return newRoot;
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(TreeNode<T> node) {

        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.value + " ");
            inOrderRec(node.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(TreeNode<T> node) {

        if (node != null) {
            System.out.print(node.value + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }
}
```

Estrutura hierárquica onde cada node possui até dois filhos. Utilizada em diversas aplicações como busca, ordenação e expressões matemáticas. Permite variações como árvores balanceadas, binárias de busca, entre outras.

# English

## Overview

My goal with this project was to understand and practice using **data structures** and **algorithms**, here I utilize different data structures, **searching and sorting algorithms**.

Although the project's directory organization isn't the best, I at least tried to make it the most intuitive as possible.

Here you can find the algorithms:
- [Searching](./src/main/java/com/eduardo/Searching.java)
- [Sorting](./src/main/java/com/eduardo/Sorting.java)

Here you can find the data structures:
- [Data Structures](./src/main/java/com/eduardo/dataStructures/)
  - [Stack](./src/main/java/com/eduardo/dataStructures/Stack.java)
  - [Static Stack](./src/main/java/com/eduardo/dataStructures/StaticStack.java)
  - [Dynamic Stack](./src/main/java/com/eduardo/dataStructures/DynamicStack.java)
  - [Linked List](./src/main/java/com/eduardo/dataStructures/LinkedList.java)
  - [Queue](./src/main/java/com/eduardo/dataStructures/Queue.java)
  - [Binary Tree](./src/main/java/com/eduardo/dataStructures/BinaryTree.java)

