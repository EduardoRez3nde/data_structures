#ifndef ARRAY_H_INCLUDED
#define ARRAY_H_INCLUDED

typedef struct DynamicArray {
    int* A;
    int size;
    int length;
} DynamicArray;

DynamicArray* allocation();

void bubbleSort(DynamicArray* arr);

void insertionSort(DynamicArray* arr);

void selectionSort(DynamicArray* arr);

void resize(DynamicArray* arr);

int size(DynamicArray* arr);

int isEmpty(DynamicArray arr);

void push(DynamicArray* arr, int element);

int get(DynamicArray* arr, int index);

void insert(DynamicArray* arr, int index, int element);

void prepend(DynamicArray* arr, int element);

int pop(DynamicArray* arr);

void del(DynamicArray* arr, int index);

void removes(DynamicArray* arr, int element);

int find(DynamicArray* arr, int element);



#endif // ARRAY_H_INCLUDED
