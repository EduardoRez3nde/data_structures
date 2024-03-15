#include <stdio.h>
#include <stdlib.h>
#include "Array.h"

int main() {

    DynamicArray* arr = allocation();

    push(arr, 10);
    push(arr, 20);

    for (int i = 0; i < arr->length; i++) {
        printf("%d ", arr->A[i]);
    }

    return 0;
}
