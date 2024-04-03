#include <stdio.h>
#include <stdlib.h>

#include <stdlib.h>

#include "SinglyLinkedList.h"

int main() {

    SinglyLinkedList* list;
    allocation(list);

    addFirst(list, 10);
    addFirst(list, 20);
    Insert(list, 2, 50);
    display(list);
    printf("Size: %d\n", getSize(list));


    return 0;
}
