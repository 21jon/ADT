package lsit;

/*
 * Challenge 1: Abstrakte Datentypen => Nur Schnittstelle (die öffentlichen Methoden, die er bietet) muss bekannt sein,
 * nicht die
 * Implementation (wie es programmiert
 * ist)
 *    (Verkettete Liste vs. Array)
 *
 * Challenge 2: Haben Sie eine Idee, wie Sie auf die Überprüfungen auf head == null verzichten können?
 *
 * Challenge 3: DVK
 */

/*
 * Desiderata:
 * 1) concat(Liste<T> otherList) => void | Mehrere Elemente gleichzeitig anhängen 
 * 2) get(int index) => T | Element an einer bestimmten Stelle zurückgeben
 * 3) deleteAt(int index) => T | void
 *    // T data = list.deleteAt(5)
 *    // list.deleteAt(5) => Rückgabewert wird verworfen
 * 4) move(int from, int to)
 * 5) set(int index, T data) überschreiben
 * 6) insert(int index, T data)
 * 7) size() => Größe der Liste
 * 8) filter() => Auswählen nach Kriterien
 * 9) get(T data) => Suche nach Daten
 * 10) indexOf(T data) => Suche nach Index von Daten
 *
 * Nice to have:
 * 1) maxSize()
 */

public class es<T> {
    private ItemG<T> head;

    public es() {
        clear();
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        ItemG<T> runner = head;
        int size = 0;

        while (runner != null) {
            runner = runner.getNext();
            size += 1;
        }

        return size;
    }

    public void concat(es<T> b) {

        while (!b.isEmpty()) {

            this.enqueue(b.dequeue());

        }

    }

    public T get(int index) {

        if (isEmpty()) {
            return null;
        }

        if (index > size())
            throw new IndexOutOfBoundsException("To big");

        ItemG<T> runner = head;

        for (int i = 0; i < index; i++) {
            runner = runner.getNext();
        }

        return runner.getData();

    }

    public void enqueue(T data) {
        ItemG<T> newItemG = new ItemG<T>(data);

        if (head == null) {
            head = newItemG;
        } else {
            ItemG runner = head;

            while (runner.getNext() != null) {
                runner = runner.getNext();
            }

            runner.setNext(newItemG);
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else {
            var data = head.getData();
            head = head.getNext();
            return data;
        }
    }

    public T deleteAt(int index) {

        if (isEmpty()) {
            return null;
        }
        if (index == 0) {

            T data = head.getData();
            head = head.getNext();
            return data;

        }

        ItemG<T> runner = head;
        ItemG<T> next = null;
        for (int i = 1; i < index - 1; i++) {

            runner = runner.getNext();
        }

        next = runner.getNext();

        runner.setNext(runner.getNext().getNext());

        return next.getData();

    }

    public void move(int from, int to) {

        if (isEmpty())
            throw new RuntimeException("");

        if (to > size() || from > size())
            throw new RuntimeException("");

    }

    public void insert(int index, T data) {

        ItemG<T> f;

        ItemG<T> pre = getPreG(index);

        f = pre.getNext();

        ItemG<T> neu = new ItemG<T>(data);

        pre.setNext(neu);
        neu.setNext(f);

    }

    private ItemG<T> getPreG(int index) {
        index--;

        if (isEmpty()) {
            return null;
        }

        if (index > size())
            throw new IndexOutOfBoundsException("To big");

        ItemG<T> runner = head;

        for (int i = 0; i < index; i++) {

            runner = runner.getNext();

        }

        return runner;

    }

    /**
     * 
     * @return
     */
    public T head() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else {
            return head.getData();
        }
    }

    public void debugString() {

        if (isEmpty()) {
            return;
        }

        ItemG<T> runner = head;
        String sb = "";
        int i = 0;
        while (runner != null) {

            sb += i + ": " + runner.getData().toString() + "\n";
            runner = runner.getNext();
            i++;

        }
        System.out.println(sb);

    }
}

class ItemG<T> {
    private T data;
    private ItemG<T> next;

    public ItemG(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ItemG<T> getNext() {
        return next;
    }

    public void setNext(ItemG<T> next) {
        this.next = next;
    }
}

/*
 * 
 * get element anstelle index -1
 * 
 * create new element
 * 
 * get temp set it element.next()
 * 
 * set element next to element
 * 
 * element next is temp
 * 
 */