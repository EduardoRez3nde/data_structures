#ifndef SINGLYLINKEDLIST_H_INCLUDED
#define SINGLYLINKEDLIST_H_INCLUDED

#include <stdlib.h>
#include <stdio.h>

typedef struct Node {
    int data;
    struct Node* next;
} Node;

typedef struct SinglyLinkedList {
    int size;
    Node* head;
} SinglyLinkedList;

Node* allocation();

void addFirst(SinglyLinkedList* list, int element);

void display(SinglyLinkedList* list);

int isEmpty(SinglyLinkedList* list);

void Insert(SinglyLinkedList* list, int index, int element);

#endif // SINGLYLINKEDLIST_H_INCLUDED
