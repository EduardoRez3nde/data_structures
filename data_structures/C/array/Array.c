#include "Array.h"
#include <stdlib.h>
#include <stdio.h>

DynamicArray* allocation() {

    DynamicArray* arr = (DynamicArray*)malloc(16 * sizeof(DynamicArray));
    if (arr == NULL) {
        return NULL;
    }

    arr->A = (int*) malloc(16 * sizeof(int));
    if (arr->A == NULL) {
        free(arr);
        return NULL;
    }
    arr->size = 16;
    arr->length = 0;

    return arr;

    // Time = O(1)
}

void resize(DynamicArray* arr) {

    int capacity = 2 * arr->size;
    int* newArray = malloc(capacity * sizeof(int));

    for (int i = 0; i < arr->length - 1; i++) {
        newArray[i] = arr->A[i];
    }
    free(arr->A);
    arr->A = newArray;
    arr->size = capacity;

    // Time = O(n)
}

int size(DynamicArray* arr) {
    return arr->size;

    // Time = O(1)
}

int isEmpty(DynamicArray arr) {
    if (arr.length > 0)
        return 1;
    return 0;

    // Time = O(1)
}

void push(DynamicArray* arr, int element) {

    if (arr->length == arr->size)
        resize(arr);

    arr->A[arr->length++] = element;

    // Melhor Caso - O(1) - Inserindo no final
    // Pior caso - O(n) - com a chamada a resize
}

int get(DynamicArray* arr, int index) {

    if (index < 0 || index > arr->length - 1)
        return -1;

    return arr->A[index];

    // Time = O(1)
}

void insert(DynamicArray* arr, int index, int element) {

    if (index < 0 || index > arr->length)
        return;

    if (arr->length == arr->size)
        resize(arr);

    for (int i = arr->length; i > index; i--)
        arr->A[i] = arr->A[i - 1];

    arr->A[index] = element;
    arr->length++;

    // Melhor caso O(1) - Inserindo no final
    // Pior Caso O(n) - Inserindo no Começo
}

void prepend(DynamicArray* arr, int element) {

    if (arr->length == arr->size)
        resize(arr);

    insert(arr, 0, element);

    // Time = O(n) - Inserir no começo
}

int pop(DynamicArray* arr) {
    int temp = arr->A[arr->length - 1];
    arr->length--;
    return temp;

    // Time = O(1)
}

void del(DynamicArray* arr, int index) {

    if (index < 0 || index >= arr->length)
        return;

    for (int i = index; i < arr->length; i++)
        arr->A[i] = arr->A[i + 1];

    arr->length--;

    // Melhor Caso - O(1) - deletar do final
    // Pior caso - O(n) - deletar no começo
}

void removes(DynamicArray* arr, int element) {

    for (int i = arr->length - 1; i >= 0; i--) {

        if (arr->A[i] == element) {
            arr->A[i] = arr->A[arr->length - 1];
            arr->length--;
        }
    }
    // Time = O(n)
}

int find(DynamicArray* arr, int element) {

    for (int i = 0; i < arr->length; i++) {
        if (arr->A[i] == element)
            return i;
    }
    return -1;

    // Melhor caso - O(1) - se estiver no começo
    // Pior Caso - O(n) - se estiver no final
}

void swap(int *i, int *j) {
    int temp = *i;
    *i = *j;
    *j = temp;
}

void bubbleSort(DynamicArray* arr) {
    int flag = 0;
    for (int i = 0; i < arr->length - 1; i++) {
        for (int j = 0; j < arr->length - 1 - i; j++) {
            if (arr->A[j] > arr->A[j + 1]) {
                swap(&arr->A[j], &arr->A[j + 1]);
                flag = 1;
            }
        }
        if (flag == 0) break;
    }
    // Melhor Caso (ja Ordenado) = O(n);
    // Pior Caso = O(n²)
}

void insertionSort(DynamicArray* arr) {

    for (int i = 1; i < arr->length; i++) {
        int j = i - 1;
        int x = arr->A[i];

        while (j >= 0 && arr->A[j] > x) {
            arr->A[j + 1] = arr->A[j];
            j--;
        }
        arr->A[j + 1] = x;
    }
    // min = O(n)
    // max = O(n²)
}

void selectionSort(DynamicArray* arr) {

    int i, j, k;
    for (i = 0; i < arr->length - 1; i++) {

        for (j = k = i; j < arr->length; j++) {

            if (arr->A[j] < arr->A[k])
                k = j;
        }
        swap(&arr->A[i], &arr->A[k]);
    }
    // max = O(n²)
}
