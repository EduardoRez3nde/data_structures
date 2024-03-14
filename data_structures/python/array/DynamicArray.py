import ctypes


class DynamicArray:

    def __init__(self):
        self._size = 0
        self._capacity = 16
        self._array = self._make_array(self._capacity)

    def size(self):
        # retorna o total de elementos no array
        return self._size

    def capacity(self):
        # Retorna o total de posições no array
        return self._capacity

    def is_empty(self):
        # Retorna True se o array estiver vazio
        return self._size == 0

    def get(self, index):
        # Retorna o elemento no indice especificado
        if index < 0 or index >= self._size:
            raise IndexError("Index Invalid")
        return self._array[index]

    def push(self, element):
        # Adiciona o elemento no final do array
        if self._size == self._capacity:
            self._resize(2 * self._capacity)

        self._array[self._size] = element
        self._size += 1

    def insert(self, index, element):
        # Inseri o elemento no indice especificado
        if index < 0 or index > self._size:
            raise IndexError("Index Invalid")

        if self._size == self._capacity:
            self._resize(2 * self._capacity)

        for i in range(self._size, index, -1):
            self._array[i] = self._array[i - 1]

        self._array[index] = element
        self._size += 1

    def prepend(self, element):
        if self._size == self._capacity:
            self._resize(2 * self._capacity)
        self.insert(0, element)

    def pop(self):
        if self.is_empty():
            raise Exception("Array is empty")
        value = array.get(self._size - 1)
        self._size -= 1
        return value

    def remove(self, element):
        for i in range(self._size - 1, -1, -1):
            if self._array[i] == element:
                self._array[i] = self._array[self._size - 1]
                self._size -= 1

    def find(self, element):
        for i in range(self._size):
            if self._array[i] == element:
                return i
        return - 1

    def _make_array(self, capacity):
        # Retorna um novo array com a capacidade especificada
        return (capacity * ctypes.py_object)()

    def _resize(self, new_capacity):
        # Redimensiona apos atingir a capacidade
        new_array = self._make_array(new_capacity)
        for e in range(self._size):
            new_array[e] = self._array[e]

        self._array = new_array
        self._capacity = new_capacity


if __name__ == "__main__":

    array = DynamicArray()

    array.push(10)
    array.push(20)
    array.push(30)
    array.push(10)
    array.push(60)

    array.remove(10)
    
    for e in range(array.size()):
        print(f"{array.get(e)} ", end="")

