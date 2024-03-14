#include <stdlib.h>
#include <stdio.h>

typedef struct DynamicArray {
    int* A;
    int size;
    int length;
} DynamicArray;

static DynamicArray* create() {
    
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

void delete(DynamicArray* arr, int index) {

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

int main() {

    DynamicArray* array = create();

    push(array, 10);
    push(array, 20);
    push(array, 30);
    push(array, 20);
    push(array, 50);

    int index = find(array, 60);


    for (int i = 0; i < array->length; i++) {
        printf("%d ", array->A[i]);
    }
    printf("\n%d\n", index);

    return 0;
}

