#include "SinglyLinkedList.h"
#include <stdlib.h>

Node* allocation(SinglyLinkedList* list) {
    list->head = NULL;
    list->size = 0;
}

int getSize(SinglyLinkedList* list) {
    return list->size;
}

int isEmpty(SinglyLinkedList* list) {
    return list->size == 0;
}

void display(SinglyLinkedList* list) {

    Node* current = list->head;

    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n\n");
}

void addFirst(SinglyLinkedList* list, int element) {

    Node* newest = (Node *) malloc(sizeof(Node));

    if (newest) {
        newest->data = element;
        newest->next = list->head;
        list->head = newest;
    }
    list->size++;
}

void Insert(SinglyLinkedList* list, int index, int element) {

    if (index < 0 || index > list->size)
        return;

    Node* newest = (Node *) malloc(sizeof(Node));

    if (newest) {
        newest->data = element;
        newest->next = NULL;
    }
    if (index == 0) {
        newest->next = list->head;
        list->head = newest;
    }
    else {
        Node* current = list->head;

        for (int i = 1; i < index; i++) {
            current = current->next;
        }
        newest->next = current->next;
        current->next = newest;
    }
    list->size++;
}





